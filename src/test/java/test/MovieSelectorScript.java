package test;


import org.junit.Test;

import core.BaseTeste;
import core.Constants;
import filmes.PageMovieCategory;
import filmes.PageMovieRating;

public class MovieSelectorScript extends BaseTeste implements Constants {

	PageMovieCategory pageMovieCategory = new PageMovieCategory();
	PageMovieRating pageMovieRating = new PageMovieRating();
	
	@Test
	public void moviesSelector() {	
		pageMovieCategory.categorySelector(Action);
		pageMovieRating.movieRating(Rating,NumberOfMovies);
	}
}
