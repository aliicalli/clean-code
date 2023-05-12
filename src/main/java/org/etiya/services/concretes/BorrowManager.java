package org.etiya.services.concretes;

import org.etiya.entities.concretes.Borrow;
import org.etiya.repositories.abstracts.BorrowRepository;
import org.etiya.services.abstracts.BorrowService;

import java.util.List;

public class BorrowManager implements BorrowService {

    private final BorrowRepository borrowRepository;

    public BorrowManager(BorrowRepository borrowRepository) {
        this.borrowRepository = borrowRepository;
    }

    @Override
    public void add(Borrow entity) {
        borrowRepository.add(entity);
        System.out.println("Borrow Eklendi.");
    }

    @Override
    public void update(Borrow entity) {

    }

    @Override
    public List<Borrow> getAll() {
        return borrowRepository.getAll();
    }

    @Override
    public Borrow getById(int id) {
        return null;
    }

    @Override
    public Borrow getByName(String name) {
        return null;
    }
}
