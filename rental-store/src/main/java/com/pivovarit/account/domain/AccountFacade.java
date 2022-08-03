package com.pivovarit.account.domain;

import com.pivovarit.movies.domain.MovieFacade;

public class AccountFacade {
    private final MovieFacade movieFacade;

    public AccountFacade(MovieFacade movieFacade) {
        this.movieFacade = movieFacade;
    }

}
