package com.kaitait.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Person {
    @Id
    private Long id;
    private String name;
    private int age;
}
