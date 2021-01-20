package dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class DaoTest {
	@Before public void setup () {
		Connection c = Connecteur.instance().getConnection();
		ManageDB m = ManageDB.instance();
	}
	
	@Test
	public void test() {
		assert(true);
	}

}
