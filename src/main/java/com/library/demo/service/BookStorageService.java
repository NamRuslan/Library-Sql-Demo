package com.library.demo.service;

import com.library.demo.entity.bookstoragemapping.BookGivenOutAnnotation;
import com.library.demo.entity.bookstoragemapping.BookGivenOutComparison;
import com.library.demo.entity.bookstoragemapping.BookGivenOutValue;
import com.library.demo.entity.BookStorageEntity;
import com.library.demo.repo.BookStorageRepo;
import com.library.demo.sqlquery.SqlQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookStorageService {

    private EntityManager entityManager;

    private BookStorageRepo bookStorageRepo;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    public void setBookStorageRepo(BookStorageRepo bookStorageRepo) {
        this.bookStorageRepo = bookStorageRepo;
    }

    public void add(BookStorageEntity bookStorage) {
        bookStorageRepo.save(bookStorage);
    }

    public void addAll(List<BookStorageEntity> bookStorageList) {
        bookStorageRepo.saveAll(bookStorageList);
    }

    public List<BookStorageEntity> getAll() {
        return bookStorageRepo.findAll();
    }

    public List<BookGivenOutValue> bookStorageEntityListJpql() {
        List<BookGivenOutValue> resultList = new ArrayList<>();
        List<Object[]> toMapList = bookStorageRepo.findAllBookStatusJpql();

        toMapList
                .forEach(objects -> {
                    resultList.add(
                            new BookGivenOutValue()
                            .setBookTitle((String) objects[0])
                            .setStorageStatus((String) objects[1])
                    );
                });

        return resultList;
    }

    public List<BookGivenOutComparison> bookGivenOutComparisonList () {

        return entityManager.createNativeQuery(
                SqlQuery.FIND_ALL_GIVEN_OUT_BOOKS_COMPARISON,
                BookGivenOutComparison.class
        )
                .getResultList();
    }

    public List<BookGivenOutAnnotation> bookGivenOutAnnotationList() {
        return entityManager.createNativeQuery(
                SqlQuery.FIND_ALL_GIVEN_OUT_BOOKS_ANNOTATION,
                BookGivenOutAnnotation.class
        ).getResultList();
    }
}
