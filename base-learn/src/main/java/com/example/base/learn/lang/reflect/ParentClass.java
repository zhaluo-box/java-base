package com.example.base.learn.lang.reflect;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created  on 2022/9/19 12:12:33
 *
 * @author zl
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ParentClass extends TopClass {

    String parentDefaultField;

    public String parentPublicField;

    private String parentPrivateField;

}
