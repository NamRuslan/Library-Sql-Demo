package com.library.demo.repo;

import com.library.demo.entity.AuthorEntity;
import com.library.demo.sqlquery.SqlQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends JpaRepository<AuthorEntity, Integer> {

    @Query(value = SqlQuery.SHOW_ALL_AUTHORS_AND_THEIR_BOOKS,
            nativeQuery = true)
    List<String> findAllBooksByAuthor();

    @Query(value = SqlQuery.FIND_AUTHOR_WITH_MOST_BOOK_COUNT, nativeQuery = true)
    String findAuthorWithMostBookCount();
}
