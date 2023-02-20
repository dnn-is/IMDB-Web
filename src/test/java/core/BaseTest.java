package core;

import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Before;

public class BaseTest implements Constants {
	BasePage basePage = new BasePage();
	
	@Before
	public void openInitialPage() {
		basePage.openPage(url);
	}
	
	@After
	public void terminateSession() {
		killDriver();
	}
	

	

}
