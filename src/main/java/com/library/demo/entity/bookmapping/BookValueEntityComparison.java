package com.library.demo.entity.bookmapping;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookValueEntityComparison {

    @Id
    @Column
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
