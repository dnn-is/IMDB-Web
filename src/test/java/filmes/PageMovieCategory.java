package filmes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class PageMovieCategory extends BasePage {
	
	@FindBy(xpath = "//div[text()='Menu']")
	private WebElement menu;
	
	@FindBy(xpath = "//a[@href='/feature/genre/?ref_=nv_ch_gr']//span")
	private WebElement gender;
	
	public void url(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void categorySelector (String category) {
		
		click(menu);
		click(gender);
		
//		waitToBeClickable(driver.findElement(By.xpath("//img[@alt = '"+category+"']")));
//		driver.findElement(By.xpath("//img[@alt = '"+category+"']")).click();
		
		List<WebElement> movieCategories = driver.findElements(By.xpath("//img[@class='pri_image']"));
		for(WebElement cat: movieCategories) {
			if(cat.getAttribute("alt").contains(category)) {
				cat.click();
				break;
			}
		}	
	}

}
