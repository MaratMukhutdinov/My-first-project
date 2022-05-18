package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "coffee_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "coffee_id")
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    private Coffee coffee;

    @Column
    private Integer capacity;

    @Column
    private Integer count;
}
