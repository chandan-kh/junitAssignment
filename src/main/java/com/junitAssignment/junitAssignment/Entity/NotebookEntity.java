package com.junitAssignment.junitAssignment.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "notebooks")
@Entity

public class NotebookEntity {

    @GeneratedValue
    @Id
    int id;

    String username;
    String note;

}
