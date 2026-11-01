package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable{

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {

    }

    public PhysicalProduct(Long id,String name ,double price, double weightKg , String dimensions){
        super(id,name,price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getweightKg() {
        return weightKg;
    }

    public void setweightKg(double weightKg){
        this.weightKg = weightKg;
    }

    public String getdimensions() {
        return dimensions;
    }

    public void setdimensions(String dimensions){
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName();
    }


    @Override
    public void applyDiscount(double rate) {
         double capped = Math.min(rate, 0.20);
         discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double GetDiscountPrice() {
        return discountedPrice;
    }
}
