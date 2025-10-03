package com.sampleapi.SortandFilter.model;

public class Beer {

    private String name;
    private String price;
    private Rating rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public double getPriceDoubleLiteral(){
        try{
            String extractedPrice = price.replace("$","");
            return Double.parseDouble(extractedPrice);
        }catch (Exception e){
            return Double.MAX_VALUE;
        }
    }


}
