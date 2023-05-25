package filmes;

// import static core.DriverFactory.getDriver;

// import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;
import core.Constants;


public class PageMovieCategory extends BasePage implements Constants {

@FindBy(id = "imdbHeader-navDrawerOpen")
private WebElement menu;

@FindBy(xpath = "//a[@href='/feature/genre/?ref_=nv_ch_gr']//span")
private WebElement movieGender;

@FindBy(xpath = "(//section[@class='ipc-page-section ipc-page-section--base']//a[@class='ipc-chip ipc-chip--on-base-accent2'])[13]")
private WebElement movieCategory;

@FindBy(xpath = "//span[@id='movie']")
private WebElement movieSection;

public void clickMenu() {
click(menu);
}

public void clickMovieGender() {
click(movieGender);
}

public void categorySelector() {

//		waitToBeClickable(driver.findElement(By.xpath("//img[@alt = '"+category+"']")));
//		driver.findElement(By.xpath("//img[@alt = '"+category+"']")).click();
waitToBeVisible(movieCategory);
click(movieCategory);

// List<WebElement> movieCategories = getDriver().findElements(By.xpath("//img[@class='pri_image']"));
// for (WebElement cat : movieCategories) {
// 	if (cat.getAttribute("alt").contains(Action)) {
// 		cat.click();
// 		break;
// 	}
// }
}

}
