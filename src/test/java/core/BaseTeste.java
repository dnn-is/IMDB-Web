package core;

import org.junit.Test;

import filmes.PageMovieCategory;
import filmes.PageMovieRating;

public class BaseTeste implements Constantes {
	
	PageMovieCategory pageMovieCategory = new PageMovieCategory();
	PageMovieRating pageMovieRating = new PageMovieRating();
	
	@Test
	public void test() {	
		pageMovieCategory.url(url);
		pageMovieCategory.categorySelector(Action);
		pageMovieRating.movieRating(Rating,NumberOfMovies);
	}
	

}
