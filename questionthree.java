import java.util.ArrayList;
import java.util.Scanner;

public class questionthree {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String[] products ={"mobilesPhones","laptops","Earphones","Pendrives"};
        String[] specifications = {"8gb ram 512 gb memory-With-HelioG95processer","Hp-Ryzen5500,512gb ssd","wired and 3mm spekers","32gb-to-1tb"};
        int[] prices = {40000,90000,500,4000};
        int[] count = {20,10,50,1000};
        while (true) {
            System.out.println("--- Inventory Management System ---");
            System.out.println("1. Product List");
            System.out.println("2. Product count");
            System.out.println("3. View Product details");
            System.out.println("4. Edit Product");
            System.out.println("5. Update Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
              case 1:
                viewProductList(products);
                break;
              case 2:
                viewProductCount(products,count);
                break;
              case 3:
                viewProductDetails(products,specifications,count,prices);
                break;
              case 4:
                    String change=sc.nextLine();
                        int incremnetIndex=sc.nextInt();
                        
                    editProduct( products,specifications, incremnetIndex, change );
                break;
              case 5:
              
                    int incrementIndex=sc.nextInt();
                        int countt=sc.nextInt();
                    updateInventory(products,count, incrementIndex, countt);
                break;
              case 6:
                System.out.println("Exiting...");
                System.exit(0);
              default:
                System.out.println("Invalid choice. Try again.");
            }
          }

    }
    private static void editProduct(String[] products, String[] specifications, int incremnetIndex, String change) {
    }
    static  void viewProductList(String[] products){
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1+" "+products[i]);


        }
    }
    static void viewProductCount(String[] products,int[]count){
        for(int i=0;i<4;i++){
            System.out.println(i+1+" "+products[i]+" "+count[i]);
        }
    }
    static void viewProductDetails(String[] products, String[] specifications, int[] count, int[]prices){
        for (int i = 0; i < 4; i++) {
            System.out.println(i+1+" category:"+products[i]+" specifications:"+specifications[i]+" products avilaible:"+count[i]+" prices:"+products[i]);
        }
    }
    static void editProduct(String[] products,int incremnetIndex,String change ) {
            specification[incremnetIndex-1] = change;
        System.out.println("the product "+products[incremnetIndex-1]+" specification changed to "+specification[incremnetIndex-1]);


    }

        static void updateInventory(String[]products,int[]count,int incrementIndex,int countt){
        count[incrementIndex-1] = count[incrementIndex-1]+countt;
        System.out.println("after changes product  :"+products[incrementIndex-1]+" have new count :"+count[incrementIndex-1]);
    }

    

}