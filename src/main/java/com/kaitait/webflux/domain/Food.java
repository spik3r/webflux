package com.kaitait.webflux.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Food")
public class Food {

    @Id
    public String id;

    public String name;
    public String temperature;

    public Food() {}

    public Food(String name, String temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format(
                "Food[id=%s, name='%s', temperature='%s']",
                id, name, temperature);
    }

}