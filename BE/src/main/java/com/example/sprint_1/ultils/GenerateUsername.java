package com.example.sprint_1.ultils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class GenerateUsername {
    public static String generate(String s){
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("")
                .replaceAll(" ","").toLowerCase()
                .replaceAll("đ","d")
                .replaceAll("ê","e")
                .replaceAll("^[ơ|ô]$","o")
                .replaceAll("^[ă|â]$","a")
                .replaceAll("ư","a");
    }
}