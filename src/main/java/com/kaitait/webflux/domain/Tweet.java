package com.kaitait.webflux.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Document(collection = "tweets")
@Data
@RequiredArgsConstructor
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank
    @Size(max = 140)
    private String text;

    @NotNull
    private Date createdAt = new Date();
}