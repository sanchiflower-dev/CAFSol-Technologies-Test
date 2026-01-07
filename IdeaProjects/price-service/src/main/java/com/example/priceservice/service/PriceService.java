package com.example.priceservice.service;

import com.example.priceservice.model.PriceOffer;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.*;

@Service
public class PriceService {

    private final Map<String, List<PriceOffer>> map = new HashMap<>();

    public void loadFile() throws Exception {
        List<String> lines = Files.readAllLines(
                Paths.get("src/main/resources/data/offers.tsv"));

        for (int i = 1; i < lines.size(); i++) {
            String[] p = lines.get(i).split("\\|");

            String sku = p[0].trim();
            LocalTime start = LocalTime.parse(p[1].trim());
            LocalTime end = LocalTime.parse(p[2].trim());
            int price = Integer.parseInt(p[3].trim());

            map.computeIfAbsent(sku, k -> new ArrayList<>())
                    .add(new PriceOffer(sku, start, end, price));
        }
    }

    public String getPrice(String sku, String time) {

        if (!map.containsKey(sku)) return "NOT SET";

        LocalTime t = LocalTime.parse(time.trim());


        map.get(sku).sort((a, b) -> b.startTime.compareTo(a.startTime));

        for (PriceOffer o : map.get(sku)) {
            if (!t.isBefore(o.startTime) && t.isBefore(o.endTime)) {
                return String.valueOf(o.price);
            }
        }
        return "NOT SET";
    }
}