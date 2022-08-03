package com.pivovarit.movies.domain;

import com.pivovarit.movies.domain.api.MovieAddRequest;
import com.pivovarit.movies.domain.api.MovieDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovieServiceTest {

    @Test
    void should_add_movie() {
        MovieFacade service = inMemoryInstance();
        MovieAddRequest newMovie = new MovieAddRequest(1, "Spiderman", "REGULAR");
        service.addMovie(newMovie);

        MovieDto movie = service.findById(1).get();

        TestUtils.equals(newMovie, movie);
        assertThat(movie.getDescription()).isEqualTo("foo");
    }

    private static MovieFacade inMemoryInstance() {
        return new MovieFacade(new InMemoryMovieRepository(), new MoviePriceCalculator(10, 8, 5), id -> "foo");
    }
}
