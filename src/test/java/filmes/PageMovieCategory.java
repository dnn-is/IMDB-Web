package filmes;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class PageMovieCategory extends BasePage {
	
	@FindBy(id = "imdbHeader-navDrawerOpen")
	private WebElement menu;
	
	@FindBy(xpath = "//a[@href='/feature/genre/?ref_=nv_ch_gr']//span")
	private WebElement gender;
	
	
	
	public void categorySelector (String category) {
		
		click(menu);
		click(gender);
		
//		waitToBeClickable(driver.findElement(By.xpath("//img[@alt = '"+category+"']")));
//		driver.findElement(By.xpath("//img[@alt = '"+category+"']")).click();
		
		List<WebElement> movieCategories = getDriver().findElements(By.xpath("//img[@class='pri_image']"));
		for(WebElement cat: movieCategories) {
			if(cat.getAttribute("alt").contains(category)) {
				cat.click();
				break;
			}
		}	
	}

}
