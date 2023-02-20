package filmes;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;
import core.Constants;

public class PageMovieRating extends BasePage implements Constants {
	@FindBy(xpath = "//a[@class='compact']")
	private WebElement compact;

	@FindBy(xpath = "(//a[@class='lister-page-next next-page'])[1]")
	private WebElement nextPage;

	private int movieQuantity = 0;
	private double movieRating = 0;

	public void clickCompact() {
		click(compact);
	}

	public void movieRating() {
		List<String> moviesSelected = new ArrayList<String>();

		do {
			List<WebElement> movies = getDriver().findElements(By.xpath("//div[@class='lister-item-content']"));

			int i = 0;

			for (WebElement movie : movies) {

				if (!movie.findElements(By.xpath("//div[@class='col-imdb-rating']")).get(i).getText()
						.equalsIgnoreCase("-")) {
					movieRating = Double.parseDouble(movie.findElements(By.xpath("//div[@class='col-imdb-rating']"))
							.get(i).getText().replace(',', '.'));
				}

				if (!movie.findElements(By.xpath("//div[@class='col-imdb-rating']")).get(i).getText()
						.equalsIgnoreCase("-") && movieRating >= Rating) {

					moviesSelected.add(
							movie.findElements(By.xpath("//div[@class='col-title']")).get(i).getText().split("\\.")[1]
									.trim());
				}
				i++;
			}
			movieQuantity += movies.size();
			if (!(movieQuantity == NumberOfMovies)) {
				click(nextPage);
			}

		} while (movieQuantity < NumberOfMovies);

		System.out.println(
				"Number of objects verified by the script: " + movieQuantity + " with the rating above " + Rating);
		for (String movie : moviesSelected) {
			System.out.println(movie);
		}
	}

}
