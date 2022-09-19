package com.example.base.learn.lang.reflect;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created  on 2022/9/19 12:12:32
 *
 * @author zl
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SubClass extends ParentClass {

    String defaultField;

    protected String protectedField;

    public String publicField;

    private String privateField;
}
