package filmes;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import core.BasePage;

public class PageMovieRating extends BasePage {
	@FindBy(xpath = "//a[@class='compact']")
	private WebElement compact;

	@FindBy(xpath = "(//a[@class='lister-page-next next-page'])[1]")
	private WebElement next;

	private int movieQuantity = 0;
	private double movieRating = 0;

	public void movieRating(double rating, int numberOfMovies) {
		List<String> moviesSelected = new ArrayList<String>();
		click(compact);

		do {
			List<WebElement> movies = driver.findElements(By.xpath("//div[@class='lister-item-content']"));

			int i = 0;

			for (WebElement movie : movies) {

				if (!movie.findElements(By.xpath("//div[@class='col-imdb-rating']")).get(i).getText()
						.equalsIgnoreCase("-")) {
					movieRating = Double.parseDouble(movie.findElements(By.xpath("//div[@class='col-imdb-rating']"))
							.get(i).getText().replace(',', '.'));
				}

				if (!movie.findElements(By.xpath("//div[@class='col-imdb-rating']")).get(i).getText()
						.equalsIgnoreCase("-") && movieRating >= rating) {

					moviesSelected.add(
							movie.findElements(By.xpath("//div[@class='col-title']")).get(i).getText().split("\\.")[1]
									.trim());
				}
				i++;
			}
			movieQuantity += movies.size();
			if(!(movieQuantity==numberOfMovies)) {
				click(next);
			}
			
			
		} while (movieQuantity < numberOfMovies);

		System.out.println("Number of movies verified by the script: " + movieQuantity);
		for (String movie : moviesSelected) {
			System.out.println(movie);
		}
	}

}
