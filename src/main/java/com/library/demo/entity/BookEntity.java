package com.library.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "book_table")
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private int year;

    @Column(name = "author_id")
    private int authorId;

    @Override
    public String toString() {
        return title + " " + year;
    }
}
