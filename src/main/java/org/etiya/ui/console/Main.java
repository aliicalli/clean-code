package org.etiya.ui.console;

import org.etiya.entities.concretes.Author;
import org.etiya.entities.concretes.Book;
import org.etiya.repositories.concretes.InMemoryAuthorRepository;
import org.etiya.repositories.concretes.InMemoryBookRepository;
import org.etiya.services.abstracts.AuthorService;
import org.etiya.services.abstracts.BookService;
import org.etiya.services.concretes.AuthorManager;
import org.etiya.services.concretes.BookManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // SOLID

        // Single Responsibility Principle => Metot ve class bir sorumluluk sahibi olmalıdır.
        // Open-Closed Principle => Kodların geliştirmeye açık değişime kapalı olması.
        // Liskov Substitution Principle => Miras aldığım classın yerine onun tüm özelliklerini sağlayabilecek bir alternatif olmalıyım.
        // Interface Segregation Principle =>
        // Dependency Inversion Principle => Bağımlılıklar ters yüklenmelidir.
        // ( Bağımlı olduğu bir classı (interface) farklı nesnelerini kabul etmelidir. )
        // TDD => Test Driven Development, Unit Test
        // Consistent Style


        // İsimlendirme
        // Mimariyi
        // DRY Principle



        // Exception Handling
        // Documentation
        // Yorum satırları
        // Classic N-Layer Arch
        // Circular Dependency
        // Core, Veri Erişim (DataAccess,Repositories, DAL), İş Katmanı (Services,Business), Entities (Models), UI Layers
        List<Book> bookList = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        Author author = new Author(1,"Halit",
                "Kalaycı",25,"12345678901", null);
        Author author1 = new Author(2,"Ozan Boran","Polat",25,
                "12345678902", null);


        BookService bookService = new BookManager(new InMemoryBookRepository());
        AuthorService authorService = new AuthorManager(new InMemoryAuthorRepository());
        authorService.add(author);
        authorService.add(author1);
        Book book = new Book(1,"Kitap 1", 100,author);
        bookService.add(book);
        bookList.add(book);
        author.setBooks(bookList);
        authorService.update(author);


        Book book1 = new Book(2,"Kitap 2", 100,author1);
        bookService.add(book1);
        books.add(book1);
        author1.setBooks(books);
        authorService.update(author1);


        for(Author authorInDb: authorService.getAll()){
            System.out.println(authorInDb.getName());
        }

        System.out.println("Author Listeleme");
        for(Author authorInDb: authorService.getAll()){
            System.out.println(authorInDb.toString());
        }

        System.out.println("Author id'ye göre getirme");
        System.out.println(authorService.getById(author.getId()).toString());


        System.out.println("Book Listeleme");
        for (Book bookInDb : bookService.getAll()){
            System.out.println(bookInDb);
        }

        System.out.println("Book id'ye göre getirme");
        System.out.println(bookService.getById(book.getId()).toString());


        // ReturnBook adında servis olmalı.
    }
}


