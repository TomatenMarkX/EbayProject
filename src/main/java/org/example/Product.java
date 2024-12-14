package org.example;

import javax.swing.*;

public class Product {
    private Long generatedId;
    private Long ItemNumber;
    private String title;
    private Long customLabel;
    private Integer availableQuantity;
    private String currency;
    private Double startPrice;
    private Double currentPrice;
    private Integer soldQuantity;
    private Integer watchers;
    private String startDate;
    private String endDate;
    private String ebayCategory1Name;
    private Integer ebayCategory1Number;
    private String condition;
    private String ListingSite;
    private Long P_EAN;

    public Long getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId(Long id) {
        this.generatedId = id;
    }

    public Long getItemNumber() {
        return ItemNumber;
    }

    public void setItemNumber(Long ItemNumber) {
        this.ItemNumber = ItemNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCustomLabel() {
        return customLabel;
    }

    public void setCustomLabel(Long customLabel) {
        this.customLabel = customLabel;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Integer getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEbayCategory1Name() {
        return ebayCategory1Name;
    }

    public void setEbayCategory1Name(String ebayCategory1Name) {
        this.ebayCategory1Name = ebayCategory1Name;
    }

    public Integer getEbayCategory1Number() {
        return ebayCategory1Number;
    }

    public void setEbayCategory1Number(int ebayCategory1Number) {
        this.ebayCategory1Number = ebayCategory1Number;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getListingSite() {
        return ListingSite;
    }

    public void setListingSite(String listingSite) {
        ListingSite = listingSite;
    }

    public Long getP_EAN() {
        return P_EAN;
    }

    public void setP_EAN(Long P_EAN) {
        this.P_EAN = P_EAN;
    }

    @Override
    public String toString() {
        return "Item Number :" + getItemNumber() + ", Title: " + getTitle() + ", Custom Label: " + getCustomLabel();
    }
}
