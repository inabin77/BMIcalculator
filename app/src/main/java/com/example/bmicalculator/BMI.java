package com.example.bmicalculator;

public class BMI {
    private Double height, weight;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double CalculateBIM() {

        return weight / (height * height);
    }

}

