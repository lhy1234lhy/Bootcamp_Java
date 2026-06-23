package com.wanted.entitymapping.section02.embedded;

import lombok.*;

import java.time.LocalDate;

// @Data // 나중에 테이블끼리 조인할 때 문제가 생길 수 있다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookRegistDTO {

    private String bookTitle;
    private String author;
    private String publisher;
    private LocalDate createdDate;
    private int regularPrice;
    private double discountRate;

}
