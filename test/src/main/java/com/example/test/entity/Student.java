package com.example.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(of = "name")
@Accessors(chain = true)
public class Student {
    private String name;

    private int age;
}
