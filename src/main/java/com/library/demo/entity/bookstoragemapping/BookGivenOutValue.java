package com.library.demo.entity.bookstoragemapping;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Accessors(chain = true)
public class BookGivenOutValue {

    @Id
    private int id;

    @Column
    private String bookTitle;

    @Column
    private String storageStatus;
}
