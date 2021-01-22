package dao;

import org.junit.Before;
import org.junit.Test;

public class DaoTest {
	@Before public void setup () {
		Connecteur.instance().getConnection();
		ManageDB.instance();
	}
	
	@Test
	public void test() {
		assert(true);
	}

}
