package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.BadCredentialException;
import exceptions.BadDateFormatException;
import exceptions.WrongNameFormatException;
import model.Admin;
import model.Cas;
import model.TestPcr;

public class ManageDB {
	private static Connection conn;
	private static ManageDB m;
	
	private ManageDB () {
		if (conn == null) conn = Connecteur.instance().getConnection();
	}
	
	public static ManageDB instance() {
		if (ManageDB.m == null)
			ManageDB.m = new ManageDB();
		return ManageDB.m;
	}

	public List<Cas> selectAllCas() {
		List<Cas> list = new ArrayList<>();
		System.out.println("called select all cas");
		try {
			PreparedStatement prst = conn.prepareStatement("select * from cas");
			ResultSet rs = prst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Cas c;
					try {
						c = new Cas(rs.getInt("id_cas"), rs.getString("nom"));
						c.setAdresse(rs.getString("adresse"));
						c.setCodePostale(rs.getString("code_postale"));
						c.setTel(rs.getString("telephone"));
						c.setEtat(rs.getInt("etat"));
						c.setListTest(selectTestPcr(c));
						System.out.println(c);
						list.add(c);
					} catch (WrongNameFormatException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<TestPcr> selectAllTestPcr() {
		List<TestPcr> list = new ArrayList<>();
		System.out.println("called select all tests");
		try {
			PreparedStatement prst;
			prst = conn.prepareStatement("select * from test_pcr");
			ResultSet rs = prst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					TestPcr t;
					try {
						t = new TestPcr(rs.getInt("id_teste"), rs.getInt("jour"), rs.getInt("mois"), rs.getInt("annee"),
								rs.getInt("resultat"));
						list.add(t);
					} catch (BadDateFormatException e) {
						e.printStackTrace();
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<TestPcr> selectTestPcr(Cas c) {
		List<TestPcr> list = new ArrayList<>();
		try {
			PreparedStatement prst;
			prst = conn.prepareStatement("select * from test_pcr where id_teste = ?");
			prst.setInt(1, c.getId());
			ResultSet rs = prst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					TestPcr t;
					try {
						t = new TestPcr(rs.getInt("id_teste"), rs.getInt("jour"), rs.getInt("mois"), rs.getInt("annee"),
								rs.getInt("resultat"));
						list.add(t);
					} catch (BadDateFormatException e) {
						e.printStackTrace();
					}

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void insertCas(Cas c) throws SQLException {
		PreparedStatement prst;
		prst = conn.prepareStatement("INSERT INTO cas (nom, telephone, adresse, code_postale) VALUES (?, ?, ?, ?)");
		prst.setString(1, c.getNom());
		prst.setString(2, c.getTel());
		prst.setString(3, c.getAdresse());
		prst.setString(4, c.getCodePostale());
		prst.execute();
	}

	public void insertTest(TestPcr t) throws SQLException {

		PreparedStatement prst;
		prst = conn.prepareStatement(
				"INSERT INTO test_pcr (jour, mois, annee, id_teste, resultat) VALUES (?, ?, ?, ?, ?)");
		prst.setInt(1, t.getJour());
		prst.setInt(2, t.getMois());
		prst.setInt(3, t.getAnnee());
		prst.setInt(4, t.getIdTest());
		prst.setInt(5, t.getResultat());
		prst.execute();

	}

	public Admin selectAdmin(String login, String password) throws SQLException {
		PreparedStatement prst;
		Admin a = null;

		prst = conn.prepareStatement("select * from admin where login = ? and password = ?");
		prst.setString(1, login);
		prst.setString(2, password);
		ResultSet rs = prst.executeQuery();

		if (rs != null) {
			while (rs.next()) {
				try {
					a = new Admin(rs.getString("login"), rs.getString("password"));
				} catch (BadCredentialException | SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return a;
	}

	public Cas selectCas(String id) {
		Cas c = null;
		try {
			PreparedStatement prst;
			prst = conn.prepareStatement("select * from cas where id_cas = ?");
			prst.setInt(1, Integer.parseInt(id));
			ResultSet rs = prst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					try {
						c = new Cas(rs.getInt("id_cas"), rs.getString("nom"));
						c.setAdresse(rs.getString("adresse"));
						c.setCodePostale(rs.getString("code_postale"));
						c.setTel(rs.getString("telephone"));
						c.setEtat(rs.getInt("etat"));
						c.setListTest(selectTestPcr(c));
						System.out.println(c);
					} catch (WrongNameFormatException e) {
						e.printStackTrace();
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
