package Poduct;

final class Product {

    public static final String DEFAUL_PRODUCT_NAME = "NONAME";

    private String productName;

    public Product() {
        this.setProductName(DEFAUL_PRODUCT_NAME);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}