package com.example.configreader.model;

import java.util.Map;

public class SectionConfig {

    private Map<String, Object> values;

    public SectionConfig(Map<String, Object> values) {
        this.values = values;
    }

    public Map<String, Object> getValues() {
        return values;
    }
}
