package com.library.demo.service;

import com.library.demo.entity.AuthorEntity;
import com.library.demo.entity.BookEntity;
import com.library.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepo bookRepo;

    @Autowired
    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void add(BookEntity bookEntity) {
        bookRepo.save(bookEntity);
    }

    public void delete(int id) {
        bookRepo.deleteById(id);
    }

    public List<BookEntity> getAll() {
        return bookRepo.findAll();
    }


    public void addAll(List<BookEntity> list) {
        bookRepo.saveAll(list);
    }

    public String findEarliestBook() {
        return bookRepo.findEarliestBook();
    }

    public List<BookEntity> findBooksBetween(int min, int max) {
        return bookRepo.findAllByYearBetween(min, max);
    }
}
