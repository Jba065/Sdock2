package searchModule;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import searchmodule.pages.SearchPage;
import tests.BaseTest;

public class SearchTest extends BaseTest{
//private WebDriver driver;
	
	
	
	@Parameters({"keyword"})
	@Test
	public void search(String keyword) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.goTo();
		searchPage.search(keyword);
		searchPage.goToVideos();
		int result =searchPage.getResult();
		Assert.assertTrue(result>0);
	}
}
