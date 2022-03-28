package com.example.sprint_1.validation.employee.custom;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class DateValidator {
    public static boolean greaterThan18Year(String dateInput){
        try {
            String[] dateStr = dateInput.split("-");
            int year = Integer.parseInt(dateStr[0]);
            int month = Integer.parseInt(dateStr[1]);
            int day = Integer.parseInt(dateStr[2]);

            if(Integer.toString(year).length()!=4) return false;

            LocalDate currentDate = LocalDate.now();
            LocalDate myDate = LocalDate.of(year,month,day);
            return Period.between(myDate, currentDate).getYears() >= 18;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
//        System.out.println(greaterThan18Year("20-09-30"));
//        System.out.println(Boolean.valueOf("bede"));

//        Map<String,String[]> specChar = new HashMap<String,String[]>();
//        specChar.put("a",new String[]{"á","à","ả","ạ"});
//        specChar.put("u",new String[]{"ú","ù","ủ","ụ"});
//        specChar.put("i",new String[]{"í","ì","ỉ","ị"});
//        specChar.put("o",new String[]{"ó","ò","ỏ","ọ"});
//        specChar.put("e",new String[]{"é","è","ẻ","ẹ"});
//
//        String str = "Lê Công Hậu";
//        str = str.toLowerCase();
//        str = str.replaceAll(" ","");
//
//        for(int i=0; i<str.length(); i++){
//            for(int j=0; j<4; j++){
//                if((str.charAt(i)+ "").equals(specChar.get("a")[j])){
//                    str.replace(str.charAt(i),'a');
//                }
//            }
//        }

        String s = "Lê Công Hậu";
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        s =  pattern.matcher(temp).replaceAll("");

        System.out.println(s.toLowerCase().replaceAll(" ",""));
    }
}
