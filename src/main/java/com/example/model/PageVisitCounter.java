package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "page_visit_counter")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageVisitCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "page_name")
    private String pageName;

    @Column
    private Long counter;
}
