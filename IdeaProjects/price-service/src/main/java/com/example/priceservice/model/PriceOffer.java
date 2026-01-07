
package com.example.priceservice.model;

import java.time.LocalTime;

public class PriceOffer {
    public String skuId;
    public LocalTime startTime;
    public LocalTime endTime;
    public int price;

    public PriceOffer(String skuId, LocalTime startTime, LocalTime endTime, int price) {
        this.skuId = skuId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }
}