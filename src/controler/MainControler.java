package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ManageDB;
import exceptions.BadDateFormatException;
import exceptions.WrongNameFormatException;
import model.Admin;
import model.Cas;
import model.TestPcr;

/**
 * Servlet implementation class MainControler
 */
@WebServlet("/")
public class MainControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MainControler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManageDB m = ManageDB.instance();
		if (! isAuth(request)) {
			request.getRequestDispatcher("WEB-INF/pages/auth.jsp").forward(request, response);
		} else {
			if (request.getParameter("page") == null) {
				request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
			} else {
				switch (request.getParameter("page")) {
				case "gestion":
					request.setAttribute("listCas", m.selectAllCas());
					request.getRequestDispatcher("WEB-INF/pages/gestion.jsp").forward(request, response);
					break;
				case "addcas":
					request.getRequestDispatcher("WEB-INF/pages/addCas.jsp").forward(request, response);
					break;
				case "addtest":
					request.getRequestDispatcher("WEB-INF/pages/addTest.jsp").forward(request, response);
					break;
				case "detail":
					if(request.getParameter("id") != null) {
						Cas c = m.selectCas(request.getParameter("id"));
						request.setAttribute("cas", c);
						request.getRequestDispatcher("WEB-INF/pages/detail.jsp").forward(request, response);
					} else {
						request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
					}
					break;
				default:
					request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
				break;
				}
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManageDB m = ManageDB.instance();
		if(request.getParameter("form") != null) {
			switch (request.getParameter("form")) {
			case "addcas":
				if(isAuth(request)) {
					try {
						Cas c = new Cas(0, request.getParameter("nom"));
						c.setTel(request.getParameter("tel"));
						c.setAdresse(request.getParameter("adresse"));
						c.setCodePostale(request.getParameter("codepostal"));
						m.insertCas(c);
					} catch (WrongNameFormatException | SQLException e) {
						request.setAttribute("err", e);
						e.printStackTrace();
						request.getRequestDispatcher("WEB-INF/pages/addCas.jsp").forward(request, response);
						return;
					}
				}
				break;
			case "addtest":
				if(isAuth(request)) {
					try {
						TestPcr t = new TestPcr(Integer.parseInt(request.getParameter("id_teste")), Integer.parseInt(request.getParameter("jour")), Integer.parseInt(request.getParameter("mois")), Integer.parseInt(request.getParameter("annee")), Integer.parseInt(request.getParameter("resultat")));
						m.insertTest(t);
					} catch (SQLException | BadDateFormatException | NumberFormatException e) {
						request.setAttribute("err", e);
						e.printStackTrace();
						request.getRequestDispatcher("WEB-INF/pages/addTest.jsp").forward(request, response);
						return;
					}
				}
				break;
			case "auth":
				if (request.getParameter("login") != null && request.getParameter("pwd") != null) {
					Admin a;
					try {
						a = m.selectAdmin(request.getParameter("login"), request.getParameter("pwd"));
					} catch (SQLException e) {
						request.setAttribute("err", e);
						e.printStackTrace();
						request.getRequestDispatcher("WEB-INF/pages/auth.jsp").forward(request, response);
						return;
					}
					if (a != null) {
						HttpSession session = request.getSession(true);
						session.setAttribute("auth", "true");
						session.setAttribute("admin", a);
					} else {
						request.setAttribute("err", "Couldn't login");
						request.getRequestDispatcher("WEB-INF/pages/auth.jsp").forward(request, response);
						return;
					}
				}
				break;
			}
		}
		doGet(request, response);
	}
	
	private boolean isAuth(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("auth") == "true";
	}

}
