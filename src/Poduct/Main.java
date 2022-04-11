package Poduct;

public class Main {

    public static void main(String[] args) {

        Warehouse wh = new Warehouse(13);
        while (true) {
            UserInteration.printMenu();

            switch (UserInteration.getUserCommand()) {
                case "1": {
                    UserInteration.printEnterProductNameInvitation();
                    String newProductName = UserInteration.getUserCommand();
                    if (wh.isProductAlreadyExist(newProductName)) {
                        UserInteration.printAlreadyExists(newProductName);
                    }
                    else {
                        if (wh.addProduct(newProductName)) {
                            UserInteration.printAddNewProduct(newProductName);
                        }
                        else {
                            UserInteration.warehouseIsFull();
                        }
                    }
                    break;
                }
                case "2": {
                    UserInteration.printEnterProductNameInvitation();
                    String productToDeleteName = UserInteration.getUserCommand();
                    if (!wh.isProductAlreadyExist(productToDeleteName)) {
                        UserInteration.printProductNotFound(productToDeleteName);
                    }
                    else {
                        wh.deleteProduct(productToDeleteName);
                        UserInteration.printDeletedProduct(productToDeleteName);
                    }
                    break;
                }
                case "3": {
                    UserInteration.printEnterProductNameInvitation();
                    String productName = UserInteration.getUserCommand();
                    if (wh.isProductAlreadyExist(productName)) {
                        UserInteration.printAlreadyExists(productName);
                    } else {
                        UserInteration.printProductNotFound(productName);
                    }
                    break;
                }
                case "4": {
                    System.out.println();
                    UserInteration.printWarehouse(wh.products);
                    System.out.println();
                }
                case "q":
                case "Q": {
                    break;
                }
                default: {
                    UserInteration.unknownCommand();
                }
            }
            System.out.println();
        }
    }
}
