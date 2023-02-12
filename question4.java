import java.util.Scanner;

class Product {
     String name;
     String specification;
     double cost;
    int count;

    public Product(String name, String specification, double cost, int count) {
        this.name = name;
        this.specification = specification;
        this.cost = cost;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Inventory {
     Product[] products;
     int count;

    public Inventory(int size) {
        products = new Product[size];
        count = 0;
    }

    public void addProduct(Product product) {
        products[count++] = product;
    }

    public void viewProductList() {
        System.out.println("Product List:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + products[i].getName());
        }
    }

    public void viewProductCount(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                System.out.println("Count of " + name + ": " + products[i].getCount());
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void viewProductDetails(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                System.out.println("Product Details:");
                System.out.println("Name: " + name);
                System.out.println("Specification: " + products[i].getSpecification());
                System.out.println("Cost: " + products[i].getCost());
                System.out.println("Count: " + products[i].getCount());
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void editProduct(String name, String newName, String newSpecification, double newCost) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                products[i].setName(newName);
                products[i].setSpecification(newSpecification);
                products[i].setCost(newCost);
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void updateInventory(String name, int quantity) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                products[i].setCount(products[i].getCount() + quantity);
                System.out.println("Inventory updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
}

public class question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory(100);

        while (true) {
            System.out.println("Inventory Management System for a Small Electronics Store");
            System.out.println("1. Product List");
            System.out.println("2. Product Count");
            System.out.println("3. View Product Details");
            System.out.println("4. Edit Product");
            System.out.println("5. Update Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    inventory.viewProductList();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String name = sc.next();
                    inventory.viewProductCount(name);
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    name = sc.next();
                    inventory.viewProductDetails(name);
                    break;
                case 4:
                    System.out.print("Enter product name: ");
                    name = sc.next();
                    System.out.print("Enter new product name: ");
                    String newName = sc.next();
                    System.out.print("Enter new product specification: ");
                    String newSpecification = sc.next();
                    System.out.print("Enter new product cost: ");
                    double newCost = sc.nextDouble();
                    inventory.editProduct(name, newName, newSpecification, newCost);
                    break;
                case 5:
                    System.out.print("Enter product name: ");
                    name = sc.next();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    inventory.updateInventory(name, quantity);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter again.");
            }
        }
    }
}

