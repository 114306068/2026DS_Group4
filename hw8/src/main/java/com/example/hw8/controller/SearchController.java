package com.example.hw8.controller;

import com.example.hw8.service.TavilySearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class SearchController {

    private final TavilySearchService tavilySearchService;

    public SearchController(TavilySearchService tavilySearchService) {
        this.tavilySearchService = tavilySearchService;
    }

    @GetMapping("/")
    public String index(@RequestParam(value = "query", required = false) String query, Model model) {
        if (query != null && !query.trim().isEmpty()) {
            Map<String, String> results = tavilySearchService.search(query);
            model.addAttribute("results", results);
            model.addAttribute("query", query);
        }
        return "index";
    }
}