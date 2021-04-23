package com.library.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Table(name = "storage_table")
@Accessors(chain = true)
@NoArgsConstructor
public class BookStorageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_id")
    private int bookId;

    @Column(name = "status")
    private String status;
}
