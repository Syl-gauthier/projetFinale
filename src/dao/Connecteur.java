package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connecteur {
  private static final String URL = "jdbc:mysql://localhost/";
  private static final String LOGIN = "root";
  private static final String PASSWORD = "";
  private static final String DBNAME = "covid";
  private static Connecteur connecteur;
  private Connection connection;

  public Connection getConnection() {
    return connection;
  }
  
  private Connecteur() {
    super();
    Connection c = null;
    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    try {
      c = DriverManager.getConnection(URL + DBNAME, LOGIN, PASSWORD);     
    } catch (SQLException e) {
      System.out.println("Connexion impossible :'(");
      e.printStackTrace();
    }
    connection = c;
    System.out.println("connexion établie =)");
  }
  
  public static Connecteur instance() {
    if(Connecteur.connecteur == null) Connecteur.connecteur = new Connecteur();
    return Connecteur.connecteur;
  };

}
