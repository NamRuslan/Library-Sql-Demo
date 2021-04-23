package com.library.demo.entity.bookstoragemapping;

import lombok.Data;

import javax.persistence.*;


@SqlResultSetMapping(
        name = "BookStorageValueMapping",
        entities = @EntityResult(
                entityClass = BookGivenOutAnnotation.class,
                fields = {
                        @FieldResult(name = "id", column = "b.id"),
                        @FieldResult(name = "bookTitle", column = "b.title"),
                        @FieldResult(name = "status", column = "s.status")
                }
        )
)
@Entity
@Data
@Table(name = "book_storage_value")
public class BookGivenOutAnnotation {

    @Id
//    @Column
    private int id;

    @Column
    private String bookTitle;

    @Column
    private String status;
}
