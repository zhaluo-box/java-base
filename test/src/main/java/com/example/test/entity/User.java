package com.example.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


@Data
@EqualsAndHashCode(of = "name")
@Accessors(chain = true)
public class User {

    private String name;

    private int age;

    private String address;
}
