package com.library.demo.util;

import com.library.demo.entity.AuthorEntity;
import com.library.demo.entity.BookEntity;
import com.library.demo.entity.BookStorageEntity;
import com.library.demo.entity.bookstoragemapping.BookGivenOutComparison;
import com.library.demo.service.AuthorService;
import com.library.demo.service.BookService;
import com.library.demo.service.BookStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class InitiateApp implements CommandLineRunner {

    private BookService bookService;

    private AuthorService authorService;

    private BookStorageService bookStorageService;

    @Autowired
    public void setBookStorageService(BookStorageService bookStorageService) {
        this.bookStorageService = bookStorageService;
    }

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<BookEntity> bookEntityList = new ArrayList<>(
                Arrays.asList(
                        new BookEntity()
                        .setTitle("War and Peace")
                        .setYear(1874)
                        .setAuthorId(1),
                        new BookEntity()
                        .setTitle("Hobbit")
                        .setYear(1967)
                        .setAuthorId(2),
                        new BookEntity()
                        .setTitle("Anna Karenina")
                        .setYear(1854)
                        .setAuthorId(1),
                        new BookEntity()
                        .setTitle("Fight Club")
                        .setYear(1996)
                        .setAuthorId(3),
                        new BookEntity()
                        .setTitle("Lord of the Rings")
                        .setYear(1974)
                        .setAuthorId(2),
                        new BookEntity()
                        .setTitle("Voskresenie")
                        .setYear(1866)
                        .setAuthorId(1)
                )
        );

        List<AuthorEntity> authorEntityList = new ArrayList<>(
                Arrays.asList(
                        new AuthorEntity()
                        .setFirstName("Lev")
                        .setSecondName("Tolstoy"),
                        new AuthorEntity()
                        .setFirstName("John")
                        .setSecondName("Tolkien"),
                        new AuthorEntity()
                        .setFirstName("Chuck")
                        .setSecondName("Palahniuk")
                )
        );

        List<BookStorageEntity> bookStorageEntityList = new ArrayList<>(
                Arrays.asList(
                        new BookStorageEntity()
                        .setBookId(1)
                        .setStatus("Gave out"),

                        new BookStorageEntity()
                        .setBookId(2)
                        .setStatus("In storage"),

                        new BookStorageEntity()
                        .setBookId(3)
                        .setStatus("Under restoration"),

                        new BookStorageEntity()
                        .setBookId(4)
                        .setStatus("Gave out"),

                        new BookStorageEntity()
                        .setBookId(5)
                        .setStatus("Gave out"),

                        new BookStorageEntity()
                        .setBookId(6)
                        .setStatus("In storage")
                )
        );

        bookService.addAll(bookEntityList);
        authorService.addAll(authorEntityList);
        bookStorageService.addAll(bookStorageEntityList);

        System.out.println("All authors and their books:");
        for (String s : authorService.getAllAuthorsAndTheirBooks()) {
            System.out.println(s);
        }

        System.out.println("\nThe earliest book:");
        System.out.println(bookService.findEarliestBook());

        System.out.println("\nAll books created between 1900 and 1990");
//        System.out.println(bookService.findBooksBetween(1900, 1990));

        for (String s : bookService.findBooksBetween(1900, 1990)) {
            System.out.println(s);
        }
        System.out.println("\nAuthor with most book count:");
        System.out.println(authorService.findAuthorMostBookCount());

        System.out.println("\nAll books and authors: ");
        for(String s : bookService.joinBookString()) System.out.println(s);

        System.out.println("\nAll books and authors(comparison): ");
        for(Object book : bookService.bookValueEntityComparisonList()) System.out.println(book);

        System.out.println("\nAll books and authors(annotation): ");
        for(Object book : bookService.bookValueEntityAnnotationList()) System.out.println(book);

        System.out.println("\nBook status: ");
        for (BookStorageEntity book : bookStorageService.getAll()) System.out.println(book);

        System.out.println("\nAll book status(JPQL): ");
        for(Object book : bookStorageService.bookStorageEntityListJpql()) System.out.println(book);

        System.out.println("\nAll book status(Comparison): ");
        for(Object book : bookStorageService.bookGivenOutComparisonList()) System.out.println(book);

        System.out.println("\nAll book status(Annotation): ");
        for(Object book : bookStorageService.bookGivenOutAnnotationList()) System.out.println(book);

    }
}
