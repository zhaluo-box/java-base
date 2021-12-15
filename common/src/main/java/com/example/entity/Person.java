package com.example.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 反射需要调用, 所以字段访问权限为public
 * Created   on 2021/11/25 17:17:04
 */
@Data
@Accessors(chain = true)
public class Person {

    public String name;

    public int age;

    public String sex;
}
