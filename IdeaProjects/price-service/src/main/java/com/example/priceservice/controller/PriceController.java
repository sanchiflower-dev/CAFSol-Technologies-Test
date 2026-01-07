package com.example.priceservice.controller;

import com.example.priceservice.service.PriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }

    @GetMapping("/upload")
    public String upload() throws Exception {
        service.loadFile();
        return "File loaded";
    }

    @GetMapping
    public String getPrice(@RequestParam String skuid,
                           @RequestParam String time) {
        return service.getPrice(skuid, time);
    }
}