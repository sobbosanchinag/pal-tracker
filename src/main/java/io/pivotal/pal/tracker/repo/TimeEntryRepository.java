package io.pivotal.pal.tracker.repo;

import java.util.List;
import java.util.Optional;

public interface TimeEntryRepository <T> {

    T create(T t);

    T find(long id);

    List<T> list();

    T update(long id, T t);

    void delete(long id);
}