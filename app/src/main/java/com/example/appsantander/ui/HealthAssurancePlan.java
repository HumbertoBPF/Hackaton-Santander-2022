package com.example.appsantander.ui;

import java.util.List;

public class HealthAssurancePlan {

    private String title;
    private List<String> description;
    private String price;

    public HealthAssurancePlan(String title, List<String> characteristics, String price) {
        this.title = title;
        this.description = characteristics;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}
