package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class Person {
    @JsonProperty("id")
    UUID id;

    @JsonProperty("name")
    @NotBlank
    String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
