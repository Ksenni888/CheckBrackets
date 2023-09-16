package org.example.controller;

import org.example.service.CheckBracketsService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckBracketsControllerTest {
    boolean response = true;
    boolean response1 = false;
    String text = "{(dsds)}";
    String text1 = "{)}";
    private final CheckBracketsService checkBracketsService = new CheckBracketsService();

    @Test
    public void isCorrect() {
        assertEquals(checkBracketsService.getText(text), response);
    }

    @Test
    public void isNotCorrect() {
        assertEquals(checkBracketsService.getText(text1), response1);
    }
}

