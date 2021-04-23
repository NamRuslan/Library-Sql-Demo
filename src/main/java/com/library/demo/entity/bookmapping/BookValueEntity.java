package com.library.demo.entity.bookmapping;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Accessors(chain = true)
public class BookValueEntity {

    @Id
    private int id;

    private String title;

    private String authorFirstName;

    private String authorSecondName;

    private int year;
}
