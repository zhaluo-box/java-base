package com.example.base.test.object;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对象引用测试
 * Created  on 2023/8/2 10:10:57
 *
 * @author zl
 */
public class ObjectRefTest {

    @Test
    @DisplayName("对象引用测试  list<obj> map<obj>")
    public void testRef() {

        Map<String, TableDesc> cache = new HashMap<>(128);
        DataSegregationField area = new DataSegregationField().setDataType(DataScope.area).setFieldName("area");
        DataSegregationField productType = new DataSegregationField().setDataType(DataScope.product_type).setFieldName("product_type");
        DataSegregationField customerType = new DataSegregationField().setDataType(DataScope.customer_type).setFieldName("customer_type");

        List<DataSegregationField> dataSegregationFields = new ArrayList<>();
        dataSegregationFields.add(area);
        dataSegregationFields.add(productType);
        dataSegregationFields.add(customerType);

        TableDesc tableDesc = new TableDesc().setTableName("student").setAlisa("st").setDataSegregationFields(dataSegregationFields);
        System.out.println("tableDesc1 = " + tableDesc);

        cache.put("student", tableDesc);

        TableDesc desc = cache.get("student");

        TableDesc clone = ObjectUtil.cloneByStream(desc);
        System.out.println(clone == desc);

        clone.setAlisa("123");
        clone.getDataSegregationFields().remove(2);

        System.out.println("desc = " + clone);

        System.out.println("tableDesc2 = " + cache.get("student"));

    }

    /**
     * EqualsAndHashCode(of = "tableName") 表名一致 我们就认为是相同
     */
    @Data
    @Accessors(chain = true)
    @EqualsAndHashCode(of = "tableName")
    public static class TableDesc implements Serializable {

        private static final long serialVersionUID = 3633378049681019052L;

        /**
         * 表名与数据库一致
         */
        private String tableName;

        /**
         * 别名
         */
        private String alisa;

        /**
         * 数据隔离维度字段
         */
        private List<DataSegregationField> dataSegregationFields;

    }

    @Data
    @Accessors(chain = true)
    public static class DataSegregationField implements Serializable {

        private static final long serialVersionUID = 5998714183738452407L;

        /**
         * 字段名称
         */
        private String fieldName;

        /**
         * 数据隔离类型
         */
        private DataScope dataType;
    }

    public enum DataScope {
        area, product_type, customer_type;
    }

}
