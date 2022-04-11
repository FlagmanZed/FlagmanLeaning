package Warehouse;

import java.util.Scanner;

public class Product {

    private String productName;
    static int productCount;
    static boolean isExit = false;
    static char choice;


    public Product() {
        this.productName = "noname";

    }

    public static void warehouseMenu() {
        System.out.println("Warehouse menu:");
        System.out.println("1. Add product");
        System.out.println("2. Delete product");
        System.out.println("3. Verify product");
        System.out.println("4. Print warehouse catalog");
        System.out.println("Q - quit");
        Scanner scan = new Scanner(System.in);
        choice = scan.next().charAt(0);
        switch (choice) {
            case 'Q', 'q' -> isExit = true;
        }
    }

    static void addProduct(Product[] warehouse) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        if (productCount >= warehouse.length) System.out.println("Warehouse is crowded!");
        else {
            for (int i = 0; i < warehouse.length; i++) {

                if (warehouse[i].productName.equals(name)) {
                    System.out.printf("Product: %s - already available in warehouse\n", warehouse[i].productName);
                    break;
                } else if (warehouse[i].productName.equals("noname")) {
                    warehouse[i].productName = name;
                    productCount++;
                    System.out.printf("Product: %s is added\n", warehouse[i].productName);
                    break;
                }
            }
        }
    }

    public static void deleteProduct(Product[] warehouse) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i].productName.equals(name)) {
                warehouse[i].productName = "noname";
                productCount--;
                System.out.printf("Product: %s is deleted\n", name);
                break;
            }
        }
    }

    public static void printLibrary(Product[] warehouse) {
        for (int i = 0; i < warehouse.length; i++) {
            if (!warehouse[i].productName.equals("noname"))
                System.out.printf("Product №%d: %s\n", i + 1, warehouse[i].productName);
        }
    }
}