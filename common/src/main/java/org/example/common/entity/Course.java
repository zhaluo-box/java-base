package org.example.common.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 课程
 * Created  on 2023/7/13 15:15:59
 *
 * @author zl
 */
@Data
@Accessors(chain = true)
public class Course {

    private String name;

    private String teacherName;

}
