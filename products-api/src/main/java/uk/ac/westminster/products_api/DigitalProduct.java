package uk.ac.westminster.products_api;


public class DigitalProduct extends Product implements Discountable {

    private String downloadUrl;
    private double filesizeMB;
    private double discountedPrice;


    public DigitalProduct() {

    }

    public DigitalProduct(Long id,String name,double price,String downloadUrl, double filesizeMB) {
        super(id,name,price);
        this.downloadUrl = downloadUrl;
        this.filesizeMB = filesizeMB;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFilesizeMB() {
        return filesizeMB;
    }

    public void setFilesizeMB(double filesizeMB) {
        this.filesizeMB = filesizeMB;
    }

    @Override
    public String getSummary() {
        return "Digital: " + getName()
                + " | Download: " + downloadUrl;
    }


    @Override
    public void applyDiscount(double rate) {
        discountedPrice = getPrice() * (1 - rate);
    }



    @Override
    public double GetDiscountPrice() {
        return discountedPrice;
    }
}