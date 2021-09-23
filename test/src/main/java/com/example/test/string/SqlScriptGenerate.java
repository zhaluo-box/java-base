package com.example.test.string;

public class SqlScriptGenerate {

    public static String generate(String tableName, int columnSize) {
        var builder = new StringBuilder();
        builder.append("insert into ").append(tableName).append(" ( ");
        builder.append(StringUtil.generateFields(columnSize));
        builder.append(" ) ");

        builder.append("value ( ");
        builder.append(StringUtil.generateFields2(columnSize));

        builder.append(" ) ");

        return builder.toString();
    }

}
