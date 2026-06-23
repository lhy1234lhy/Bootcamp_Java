package com.wanted.restapi.section01.response;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Message {

    private int httpStatusCode;
    private String message;
}