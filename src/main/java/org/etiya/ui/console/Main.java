package org.etiya.ui.console;

import org.etiya.core.util.DateUtil;
import org.etiya.entities.concretes.Author;
import org.etiya.entities.concretes.Book;
import org.etiya.entities.concretes.Borrow;
import org.etiya.entities.concretes.Punishment;
import org.etiya.entities.concretes.Student;
import org.etiya.repositories.concretes.InMemoryAuthorRepository;
import org.etiya.repositories.concretes.InMemoryBookRepository;
import org.etiya.repositories.concretes.InMemoryBorrowRepository;
import org.etiya.repositories.concretes.InMemoryPunishmentRepository;
import org.etiya.repositories.concretes.InMemoryStudentRepository;
import org.etiya.services.abstracts.AuthorService;
import org.etiya.services.abstracts.BookService;
import org.etiya.services.abstracts.BorrowService;
import org.etiya.services.abstracts.PunishmentSerivce;
import org.etiya.services.abstracts.StudentService;
import org.etiya.services.concretes.AuthorManager;
import org.etiya.services.concretes.BookManager;
import org.etiya.services.concretes.BorrowManager;
import org.etiya.services.concretes.PunishmentManager;
import org.etiya.services.concretes.StudentManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static final Date DATE = new Date();

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

        Student student = new Student(1, "Nebi", "Gül", 29, "86997843762", null);
        Student student1 = new Student(2, "Ali", "Çallı", 24, "12312", null);
        Student student2 = new Student(3, "Namık", "Kemal", 24, "12312", null);

        StudentService studentService = new StudentManager(new InMemoryStudentRepository());
        studentService.add(student);
        studentService.add(student1);
        studentService.add(student2);


        AuthorService authorService = new AuthorManager(new InMemoryAuthorRepository());
        Author author = new Author(1, "Halit",
                "Kalaycı", 25, "12345678901", null);
        Author author1 = new Author(2, "Ozan Boran", "Polat", 25,
                "12345678902", null);
        authorService.add(author);
        authorService.add(author1);

        BookService bookService = new BookManager(new InMemoryBookRepository());
        Book book = new Book(1, "Kitap 1", 100, author);
        bookService.add(book);
        bookList.add(book);
        author.setBooks(bookList);
        authorService.update(author);

        Book book1 = new Book(2, "Kitap 2", 100, author1);
        bookService.add(book1);
        books.add(book1);
        author1.setBooks(books);
        authorService.update(author1);

        Borrow borrow = new Borrow(1, 1, 1, DateUtil.removeDayToDate(DATE, 7), DateUtil.removeDayToDate(DATE, 3));
        Borrow borrow1 = new Borrow(2, 2, 2, DATE, DateUtil.addDayToDate(DATE, 3));
        Borrow borrow3 = new Borrow(3, 3, 3, DateUtil.removeDayToDate(DATE, 7), DateUtil.removeDayToDate(DATE, 3));
        BorrowService borrowService = new BorrowManager(new InMemoryBorrowRepository());
        borrowService.add(borrow);
        student.setBooks(books);
        studentService.update(student);
        borrowService.add(borrow1);
        student1.setBooks(bookList);
        studentService.update(student1);
        borrowService.add(borrow3);
        student2.setBooks(bookList);
        studentService.update(student2);

        PunishmentSerivce punishmentSerivce = new PunishmentManager(new InMemoryPunishmentRepository());
        int idCount = 0;
        for (Borrow borrowInDb : borrowService.getAll()) {
            if (punishmentSerivce.checkIfBorrowEndDatePassedThreeDay(borrowInDb.getEndDate())) {
                idCount += 1;
                Punishment punishment = new Punishment(idCount, borrowInDb.getStudentId(), borrowInDb.getBookId());
                punishmentSerivce.add(punishment);
            }
        }

        for (Author authorInDb : authorService.getAll()) {
            System.out.println(authorInDb.getName());
        }

        System.out.println("Author Listeleme");
        for (Author authorInDb : authorService.getAll()) {
            System.out.println(authorInDb.toString());
        }

        System.out.println("********************************************");
        System.out.println("Author id'ye göre getirme");
        System.out.println(authorService.getById(author.getId()).toString());

        System.out.println("********************************************");
        System.out.println("Book Listeleme");
        for (Book bookInDb : bookService.getAll()) {
            System.out.println(bookInDb);
        }
        System.out.println("********************************************");
        System.out.println("Book id'ye göre getirme");
        System.out.println(bookService.getById(book.getId()).toString());

        /**
         * Student ekleme yapılmalı.
         *
         * */

        System.out.println("********************************************");
        System.out.println("Student Listeleme");
        for (Student studentInDb : studentService.getAll()) {
            System.out.println(studentInDb);
        }


        System.out.println("********************************************");
        System.out.println("Borrow Listele");
        for (Borrow borrowInDb : borrowService.getAll()) {
            System.out.println(borrowInDb);

        }


        System.out.println("********************************************");
        System.out.println("Punishmnet Listele");
        for (Punishment punishmentInDb : punishmentSerivce.getAll()) {
            System.out.println(punishmentInDb);
        }

    }
}


