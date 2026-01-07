package com.example.configreader.service;

import com.example.configreader.model.SectionConfig;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

@Service
public class ConfigService {


    private Map<String, SectionConfig> store = new HashMap<>();


    public void loadConfig(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            String currentSection = null;
            Map<String, Object> data = new HashMap<>();

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) continue;


                if (!line.contains("=")) {

                    if (currentSection != null) {
                        store.put(currentSection, new SectionConfig(data));
                    }

                    currentSection = line;
                    data = new HashMap<>();
                }

                else {
                    String[] parts = line.split("=", 2);
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    if (value.contains(",")) {
                        data.put(key, Arrays.asList(value.split(",")));
                    } else {
                        data.put(key, value);
                    }
                }
            }

            // Last section
            if (currentSection != null) {
                store.put(currentSection, new SectionConfig(data));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public SectionConfig getSection(String name) {
        return store.get(name);
    }
}
