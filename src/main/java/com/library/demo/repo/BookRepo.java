package com.library.demo.repo;

import com.library.demo.entity.BookEntity;
import com.library.demo.sqlquery.SqlQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {

    @Query(value = SqlQuery.FIND_EARLIEST_BOOK, nativeQuery = true)
    String findEarliestBook();

    List<BookEntity> findAllByYearBetween(int min, int max);
}
