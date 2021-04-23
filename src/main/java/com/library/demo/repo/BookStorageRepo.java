package com.library.demo.repo;

import com.library.demo.entity.BookStorageEntity;
import com.library.demo.sqlquery.SqlQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStorageRepo extends JpaRepository<BookStorageEntity, Integer> {

    @Query(SqlQuery.FIND_ALL_GIVEN_OUT_BOOKS_JPQL)
    List<Object[]> findAllBookStatusJpql();
}
