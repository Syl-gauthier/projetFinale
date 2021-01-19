package dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class DaoTest {

	@Test
	public void test() {
		Connection c = Connecteur.instance().getConnection();
	}

}
