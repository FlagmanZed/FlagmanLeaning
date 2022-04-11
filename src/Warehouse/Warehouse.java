package Warehouse;


public class Warehouse {

    public static void main(String[] args) {

        Product[] warehouse = new Product[5];
        for (int i = 0; i < warehouse.length; i++) {
            warehouse[i] = new Product();
        }

        do {
            Product.warehouseMenu();
            if (Product.choice == '1' || Product.choice == '3') {
                System.out.println("Input product name:");
                Product.addProduct(warehouse);

            } else if (Product.choice == '2') {
                Product.deleteProduct(warehouse);

            } else if (Product.choice == '4') {
                System.out.println("Actual warehouse:");
                Product.printLibrary(warehouse);
            }

            System.out.println();

        } while (!Product.isExit);
    }
}