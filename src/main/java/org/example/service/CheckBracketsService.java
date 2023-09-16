package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class CheckBracketsService {

    public boolean getText(String text) {
        int a = 0;
        String str = (text.substring(1, text.length() - 1)).trim();
        if (str.isBlank()) {
            throw new NoInformationFoundException("Empty string");
        }
        String[] ar = str.split("");
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].equals("(")) {
                if (i == ar.length - 1) {
                    return false;
                }
                for (int j = i + 1; j < ar.length; j++) {
                    if (ar[j].equals(")")) {
                        if ((str.substring(i + 1, j)).isBlank()) {
                            return false;
                        }
                    }
                }
                ++a;
            } else if (ar[i].equals(")")) {
                if (a == 0) {
                    return false;
                } else {
                    a--;
                }
            } else continue;
        }
        return a == 0;
    }
}

