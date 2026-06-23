package com.wanted.docker.menu;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column // ("컬럼명") 이거 없으면 걍 name이 컬럼명이 됨
    private String name;

    @Column
    private Integer price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
