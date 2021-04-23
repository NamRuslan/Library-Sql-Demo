package com.library.demo.service;

import com.library.demo.entity.*;
import com.library.demo.entity.bookmapping.BookValueEntity;
import com.library.demo.entity.bookmapping.BookValueEntityAnnotation;
import com.library.demo.entity.bookmapping.BookValueEntityComparison;
import com.library.demo.repo.BookRepo;
import com.library.demo.sqlquery.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepo bookRepo;

    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

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

    public List<String> findBooksBetween(int min, int max) {
        return bookRepo.findAllByYearBetween(min, max).stream()
                .map(BookEntity::toString)
                .collect(Collectors.toList());
    }

    public List<String> joinBookString() {
        return bookRepo.joinBookString();
    }

    public List<BookValueEntity> joinBookObj() {
        List<Object[]> objects = bookRepo.joinBookObj();

        List<BookValueEntity> bookValueEntities = new ArrayList<>();

        objects.stream()
                .forEach(obj -> {
                    bookValueEntities.add(
                            new BookValueEntity()
                            .setTitle((String) obj[0])
                            .setAuthorFirstName((String) obj [1])
                            .setAuthorSecondName((String) obj [2])
                            .setYear((int) obj[3])
                    );
                });
        return bookValueEntities;
    }

    public List<BookValueEntityComparison> bookValueEntityComparisonList () {
        return entityManager
                .createNativeQuery(
                SqlQuery.SQL_COMPARISON,
                BookValueEntityComparison.class
        )
                .getResultList();
    }

    public List<BookValueEntityAnnotation> bookValueEntityAnnotationList() {
        return entityManager
                .createNativeQuery(
                        SqlQuery.SQL_ANNOTATION,
                        BookValueEntityAnnotation.class
                )
                .getResultList();
    }
}
