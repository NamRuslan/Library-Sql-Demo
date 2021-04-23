package com.library.demo.entity.bookstoragemapping;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class BookGivenOutComparison {

    @Id
    @Column
    private int id;

    @Column(name = "book_title")
    private String bookTitle;

    @Column(name = "status")
    private String status;
}
