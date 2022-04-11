package Poduct;

import java.util.Scanner;

class UserInteration {

    private static Scanner scan = new Scanner(System.in);

    public static String getUserCommand() {
        return scan.nextLine();
    }

    public static void printMenu() {
        System.out.println("Warehouse menu:");
        System.out.println("1. Add product");
        System.out.println("2. Delete product");
        System.out.println("3. Verify product");
        System.out.println("4. Print warehouse catalog");
        System.out.println("Q - quit");
    }

    public static void printAlreadyExists(String productName) {
        System.out.printf("Product: %s - already available in warehouse\n", productName);
    }

    public static void printProductNotFound(String productName) {
        System.out.printf("Product: %s - not found in warehouse\n", productName);
    }

    public static void printAddNewProduct(String addedProductName) {
        System.out.printf("Product: %s is added\n", addedProductName);
    }

    public static void printDeletedProduct(String deletedProductName) {
        System.out.printf("Product: %s is deleted\n", deletedProductName);
    }

    public static void warehouseIsFull() {
        System.out.println("Warehouse is crowded!");
    }

    public static void unknownCommand() {
        System.out.println("User input not recognize as valid!");
    }

    public static void printWarehouse(Product[] products) {
        System.out.println("Actual warehouse:");
        for (int i = 0; i < products.length; i++) {
            if (!products[i].getProductName().equals("noname"))
                System.out.printf("Product №%d: %s\n", i + 1, products[i].getProductName());
        }
    }

    public static void printEnterProductNameInvitation() {
        System.out.println("Input product name:");
    }
}