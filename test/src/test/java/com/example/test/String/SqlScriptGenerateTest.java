package com.example.test.String;

import com.example.test.string.SqlScriptGenerate;
import org.junit.Test;

public class SqlScriptGenerateTest {

    @Test
    public void generate() {
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_XY", 92));//1301
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_YP", 29)); // 1302
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_ZJ", 78));//1303
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_FWXM", 16));//1305
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_HC", 71)); //1306
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_ZD", 24)); //1307
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_SS", 24)); //1308
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_MT", 16)); //1309
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_BZ", 15)); //1310
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_RS", 15));//1311
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_BL", 11)); //1313
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_ZYJB", 14));//1314
        System.out.println(SqlScriptGenerate.generate("T_INS_DT_ZYZH", 14)); // 1315

    }

}

//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_XY", 92));
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_YP", 29));
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_ZJ", 78));
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_FWXM", 16));
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_HC", 71)); //1306
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_ZD", 24)); //1307
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_SS", 24)); //1308
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_MT", 16)); //1309
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_BZ", 15)); //1310
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_RJSS", 15));//1311
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_BL", 11)); //1313
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_ZYJB", 14));//1314
//System.out.println(SqlScriptGenerate.generate("T_JSINS_DT_ZYZH", 14)); // 1315