package com.library.demo.sqlquery;

public class SqlQuery {

    public static final String SHOW_ALL_AUTHORS_AND_THEIR_BOOKS = "select author_table.first_name, author_table.second_name, book_table.title, book_table.year from author_table left join book_table on author_table.id = book_table.author_id";

    public static final String FIND_EARLIEST_BOOK = "select b.title, b.year, a.first_name, a.second_name from book_table b left join author_table a on b.author_id = a.id where b.year = (select MIN(year) from book_table)";

    public static final String FIND_AUTHOR_WITH_MOST_BOOK_COUNT = "select a.first_name, a.second_name, count(a.id) from author_table a left join book_table b on a.id = b.author_id group by a.id order by count(a.id) desc limit 1";

//    public static final String FIND_BOOKS_BETWEEN_YEAR_WITH_AUTHOR = "select b.title, b.year, a.first_name, a.second_name from book_table b left join author_table a on b.author_id = a.id where b.year between ";

    public static final String SQL_COMPARISON = "select b.id, b.title, a.first_name, a.second_name, b.year from author_table a left join book_table b on a.id = b.author_id";

    public static final String SQL_ANNOTATION = "select b.id as book_id, b.title, a.first_name, a.second_name, b.year from author_table a left join book_table b on a.id = b.author_id";

    public static final String FIND_ALL_GIVEN_OUT_BOOKS_JPQL = "select b.title, s.status from BookEntity b left join BookStorageEntity s on b.id = s.bookId";

    public static final String FIND_ALL_GIVEN_OUT_BOOKS_COMPARISON = "select b.id, b.title as book_title, s.status from book_table b left join storage_table s on b.id = s.book_id";

    public static final String FIND_ALL_GIVEN_OUT_BOOKS_ANNOTATION = "select b.id, b.title as book_title, s.status from book_table b left join storage_table s on b.id = s.book_id";
}
