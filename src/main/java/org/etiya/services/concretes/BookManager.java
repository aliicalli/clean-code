package org.etiya.services.concretes;


import org.etiya.entities.concretes.Book;
import org.etiya.repositories.abstracts.BookRepository;
import org.etiya.services.abstracts.AuthorService;
import org.etiya.services.abstracts.BookService;

import java.util.List;

public class BookManager implements BookService {

    private BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void add(Book entity) {

        bookRepository.add(entity);
        System.out.println("Author eklendi.");

    }

    @Override
    public void update(Book entity) {

    }

    @Override
    public List<Book> getAll() {

        return bookRepository.getAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.getById(id);
    }

    @Override
    public Book getByName(String name) {
        return bookRepository.getByBookName(name);
    }
}
