package com.example.configreader.controller;

import com.example.configreader.model.SectionConfig;
import com.example.configreader.service.ConfigService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigController {

    private final ConfigService service;

    public ConfigController(ConfigService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        service.loadConfig("src/main/resources/config.txt");
    }

    @GetMapping
    public SectionConfig getConfig(@RequestParam String section) {
        return service.getSection(section);
    }
}
