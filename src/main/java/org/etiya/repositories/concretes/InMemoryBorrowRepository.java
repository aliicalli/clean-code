package org.etiya.repositories.concretes;

import org.etiya.entities.concretes.Borrow;
import org.etiya.repositories.abstracts.BorrowRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBorrowRepository implements BorrowRepository {

    List<Borrow> borrowList = new ArrayList<>();

    @Override
    public void add(Borrow entity) {

    }

    @Override
    public void update(Borrow entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Borrow getById(int id) {
        return null;
    }

    @Override
    public List<Borrow> getAll() {
        return null;
    }
}
