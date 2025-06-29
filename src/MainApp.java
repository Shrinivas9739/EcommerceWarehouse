import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WarehouseManager manager = new WarehouseManager();

        while (true) {
            System.out.println("\n=== Warehouse Inventory Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Search Products by Price");
            System.out.println("6. Calculate Inventory Value");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear newline
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input! Please enter a number.");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        if (manager.getProductById(id) != null) {
                            System.out.println("❌ Product with this ID already exists!");
                            break;
                        }

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        manager.addProduct(new Product(id, name, price, qty));
                        System.out.println("✅ Product added successfully.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input format. Please try again.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        Product existing = manager.getProductById(id);
                        if (existing == null) {
                            System.out.println("❌ Product not found.");
                            break;
                        }

                        System.out.println("Current Product: " + existing);
                        System.out.print("Are you sure you want to update this product? (yes/no): ");
                        String confirm = sc.nextLine();
                        if (!confirm.equalsIgnoreCase("yes")) {
                            System.out.println("❌ Update cancelled.");
                            break;
                        }

                        System.out.print("New Name: ");
                        String name = sc.nextLine();
                        System.out.print("New Price: ");
                        double price = sc.nextDouble();
                        System.out.print("New Quantity: ");
                        int qty = sc.nextInt();

                        manager.updateProduct(id, name, price, qty);
                        System.out.println("✅ Product updated successfully.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input format.");
                        sc.nextLine();
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter ID to delete: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        Product toDelete = manager.getProductById(id);
                        if (toDelete == null) {
                            System.out.println("❌ Product not found.");
                            break;
                        }

                        System.out.println("Product: " + toDelete);
                        System.out.print("Are you sure you want to delete this product? (yes/no): ");
                        String confirm = sc.nextLine();
                        if (!confirm.equalsIgnoreCase("yes")) {
                            System.out.println("❌ Deletion cancelled.");
                            break;
                        }

                        manager.deleteProduct(id);
                        System.out.println("✅ Product deleted successfully.");
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid input format.");
                        sc.nextLine();
                    }
                    break;

                case 4:
                    manager.getAllProducts().forEach(System.out::println);
                    break;

                case 5:
                    try {
                        System.out.print("Enter max price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        List<Product> filteredProducts = manager.searchByPrice(price);

                        if (filteredProducts.isEmpty()) {
                            System.out.println("❌ No products found under ₹" + price);
                        } else {
                            System.out.println("✅ Products under ₹" + price + ":");
                            filteredProducts.forEach(System.out::println);
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("❌ Invalid price.");
                        sc.nextLine();
                    }
                    break;


                case 6:
                    double total = manager.calculateInventoryValue();
                    System.out.println("💰 Total Inventory Value: ₹" + total);
                    break;

                case 7:
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}
