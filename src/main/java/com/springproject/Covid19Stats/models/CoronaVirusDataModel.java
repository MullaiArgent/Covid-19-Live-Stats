package com.springproject.Covid19Stats.models;

public class CoronaVirusDataModel {
    private String state;
    private String country;
    private String today;
    private String confirmed;
    private String recovered;
    private String deaths;
    private String increaseRate;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getIncreaseRate() {
        return increaseRate;
    }

    public void setIncreaseRate(String increaseRate) {
        this.increaseRate = increaseRate;
    }



}
