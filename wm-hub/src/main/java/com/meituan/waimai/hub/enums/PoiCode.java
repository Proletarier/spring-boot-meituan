package com.meituan.waimai.hub.enums;

import java.util.*;

public class PoiCode {

    public static List<String> apartmentAndDwellingCode = Arrays.asList("120000", "120100", "120200", "120201", "120202", "120203", "120300", "120301", "120302",
            "120303", "120304");

    public static List<String> hotelCode = Arrays.asList("100000", "100100", "100101", "100102", "100103", "100104", "100105", "100200", "100201");

    public static List<String> gardenCode = Arrays.asList("110000", "110100", "110101", "110102", "110103", "110104", "110105", "110106", "110200","110201","110202",
    "110203","110204","110205","110206","110207","110208","110209","110210");

    public static List<String> companyCode = Arrays.asList("170000", "170100", "170200", "170201", "170202", "170203", "170204", "170205", "170206","170207",
            "170208","170209","170300");

    public static List<String> otherCode = Arrays.asList("010000", "020000", "030000", "050000", "060000", "070000", "090000", "160000", "140000", "130000");

    public static Set<List<String>> poiCodes = new HashSet<List<String>>() {{
        add(apartmentAndDwellingCode);
        add(hotelCode);
        add(gardenCode);
        add(companyCode);
        add(otherCode);
    }};

    public static String getAllCode(String strDivide) {
        StringBuilder codeStr = new StringBuilder();
        poiCodes.forEach(list -> {
            for (String s : list) {
                codeStr.append(s).append(strDivide);
            }
        });
        return codeStr.deleteCharAt(codeStr.length()-1).toString();
    }
}
