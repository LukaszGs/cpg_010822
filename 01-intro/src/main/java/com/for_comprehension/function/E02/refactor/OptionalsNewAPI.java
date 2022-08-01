package com.for_comprehension.function.E02.refactor;

import java.util.Optional;

public class OptionalsNewAPI {

    private final OptionalsLegacy delegate;

    public OptionalsNewAPI(OptionalsLegacy delegate) {
        this.delegate = delegate;
    }

    public Optional<OptionalsLegacy.Person> findPerson(int id) {
        return Optional.ofNullable(delegate.findPerson(id));
    }

    public Optional<String> findAddress(OptionalsLegacy.Person person) {
        return Optional.ofNullable(delegate.findAddress(person));
    }

    public Optional<String> findAddressById(int id) {
        return Optional.ofNullable(delegate.findAddressById(id));
    }

}
