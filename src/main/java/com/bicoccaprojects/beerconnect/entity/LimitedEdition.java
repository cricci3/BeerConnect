package com.bicoccaprojects.beerconnect.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;

@DiscriminatorValue("limited")
public class LimitedEdition extends Beer{
    @Column(name = "le_beer", nullable = false, columnDefinition = "TEXT", unique = true)
    private String limitedEditionName;

    @Column(name = "production_year", nullable = false, columnDefinition = "INTEGER", unique = true)
    private Integer productionYear;

    public LimitedEdition(String name_beer, String type, String aroma, Double alcohol, String color, String country, String ingredients, Float price, Integer quantityInStock, String limitedEditionName, Integer productionYear) {
        super(name_beer, type, aroma, alcohol, color, country, ingredients, price, quantityInStock);
        this.limitedEditionName = limitedEditionName;
        this.productionYear = productionYear;
    }

    public LimitedEdition() {
    }

    public String getLimitedEditionName() {
        return limitedEditionName;
    }

    public void setLimitedEditionName(String limitedEditionName) {
        this.limitedEditionName = limitedEditionName;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "LimitedEdition{" +
                "limitedEditionName='" + limitedEditionName + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}
