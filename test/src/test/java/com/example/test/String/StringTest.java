package com.example.test.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        //        String aa = " med_list_codg, drug_prodname, alias, eng_name, dosform, dosform_name, reg_dosform, ing, efcc_atd, character, drug_spec, drug_spec_code,\n"
        //                    + "reg_spec, reg_spec_code, route_administration, storage, use_frequency, each_dos, drug_class, drug_class_name, otc_flag, otc_name, pacmatl,\n"
        //                    + " pacmatl_name, pacspec, manl, pac_cnt, min_useunt, min_salunt, min_unt, min_pac_cnt, min_pacunt, min_prepunt, min_prepunt_name, drug_expy,\n"
        //                    + "min_prcunt, defs, mnan, tabo, manufacturer_no, manufacturer_name, manufacturer_address, sp_lmtpric_drug_flag, aprvno,\n"
        //                    + "aprvno_start_date|date, aprvno_end_date|date, drug_reg_num, drug_reg_begin_time|date, drug_reg_end_time|date, conversion_ratio,\n"
        //                    + " lmt_used_range, min_pacunt_name, reg_name, sub_pack_manufacturer, market_status, drug_reg_doc, drug_sup_apply_doc, med_list_num,\n"
        //                    + " med_list_memo, vat_adj_drug_flag, vat_adj_drug_name, listed_drug_dir_drug, nhc_drug_code, memo, vali_flag, crte_time|date,\n"
        //                    + "updt_time|date, rid, data_create_time|date, date_update_time|date, ver, ver_name, self_preparation_license_num, chld_medc,\n"
        //                    + " gerontal_patient_medc, medical_institution_contact_name, medical_institution_contact_tel, self_preparation_license_doc";

        // 1310
        //        String aa = "id, bydise_setl_list_code, bydise_setl_name, limit_oprn_oprt_code, limit_oprn_oprt_name, vali_flag, rid, crte_time|date,\n"
        //                    + "  updt_time|date, ver, diseases_connotation, memo, ver_name, diagnose_guide_page_num, diagonse_guide_doc";

        //        1311
        //        String aa = "id, daysrg_dise_list_code, daysrg_dise_name, vali_flag, rid, crte_time|date, updt_time|date, ver, diseases_connotation, memo, ver_name,\n"
        //                    + "   diagnose_guide_page_num, diagonse_guide_doc, operation_name, operation_code ";

        //1313
        String aa = "id, tumor_cell_type_code, tumor_cell_type, morphological_classification_code, morphological_classification, vali_flag, rid, crte_time|date,\n"
                    + "updt_time|date, ver, ver_name";
        String[] as = {};

        String[] split = aa.split(",");
        int i = split.length % 10;
        int i1 = split.length / 10;
        if (i > 0) {
            i1 += 1;
        }
        List<String[]> list = new ArrayList<>(i1);
        for (int j = 1; j <= i1; j++) {
            String[] arr;
            if (i > 0 && j == i1) {
                arr = Arrays.copyOfRange(split, (j - 1) * 10, (j - 1) * 10 + i);
            } else {
                arr = Arrays.copyOfRange(split, (j - 1) * 10, j * 10);
            }
            list.add(arr);
        }

        list.forEach(strings -> {
            var builder = new StringBuilder();
            for (String string : strings) {
                builder.append("\"").append(string.trim()).append("\"").append(",");
            }
            System.out.println(builder);
        });
    }
}
