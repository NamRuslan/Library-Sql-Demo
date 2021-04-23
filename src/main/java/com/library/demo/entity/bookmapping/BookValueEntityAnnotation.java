package com.library.demo.entity.bookmapping;

import lombok.Data;

import javax.persistence.*;

@SqlResultSetMapping(
        name = "BookValueMapping",
        entities = @EntityResult(
                entityClass = BookValueEntityAnnotation.class,
                fields = {
                        @FieldResult(name = "id", column = "book_id"),
                        @FieldResult(name = "title", column = "b.title"),
                        @FieldResult(name = "first_name", column = "a.first_name"),
                        @FieldResult(name = "second_name", column = "a.second_name"),
                        @FieldResult(name = "year", column = "b.year")
                }
        )
)
@Data
@Entity
@Table(name = "BookValueEntityAnnotation")
public class BookValueEntityAnnotation {

    @Id
    int id;

    @Column(name = "title")
    String title;

    @Column(name = "first_name")
    String authorFirstName;

    @Column(name = "second_name")
    String authorSecondName;

    @Column(name = "year")
    int year;
}

