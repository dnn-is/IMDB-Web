package test;


import org.junit.Test;

import core.BaseTest;
import core.Constants;
import filmes.PageMovieCategory;
import filmes.PageMovieRating;

public class MovieSelectorScript extends BaseTest implements Constants {

	PageMovieCategory pageMovieCategory = new PageMovieCategory();
	PageMovieRating pageMovieRating = new PageMovieRating();
	
	@Test
	public void objectsSelector() {	
		pageMovieCategory.clickMenu();
		pageMovieCategory.clickMovieGender();
		pageMovieCategory.categorySelector();
		pageMovieRating.clickCompact();
		pageMovieRating.movieRating();
	}
}
