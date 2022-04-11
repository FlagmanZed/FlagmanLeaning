package Poduct;

class Warehouse {

    Product[] products;

    public Warehouse(int warehouseCapacity) {
        products = new Product[warehouseCapacity];

        for (int i = 0; i < products.length; i++) {
            products[i] = new Product();
        }
    }

    public boolean isProductAlreadyExist(String productName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(String newProductName) {
        int emptySlot = firstEmptySlot();
        if (emptySlot > -1) {
            products[emptySlot].setProductName(newProductName);
            return true;
        }
        return false;
    }

    public void deleteProduct(String deletedProductName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(deletedProductName)) {
                products[i].setProductName(Product.DEFAUL_PRODUCT_NAME);
                return;
            }
        }
    }

    private int firstEmptySlot() {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductName().equals(Product.DEFAUL_PRODUCT_NAME)) {
                return i;
            }
        }
        return -1;
    }
}