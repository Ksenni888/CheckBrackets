package org.example.controller;

import org.example.service.CheckBracketsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CheckBracketsController {
    private final CheckBracketsService checkBracketsService;

    public CheckBracketsController(CheckBracketsService checkBracketsService) {
        this.checkBracketsService = checkBracketsService;
    }

    @PostMapping("/checkBrackets")
    public boolean getText(@RequestBody String text) {
        return checkBracketsService.getText(text);
    }
}
