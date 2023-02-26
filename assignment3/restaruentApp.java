import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.io.File;
import java.time.LocalDateTime;
import java.io.IOException;
import java.time.format.DateTimeFormatter;



class restaruentApp {
    static Scanner sc = new Scanner(System.in);
    static String menuitems[] = { "Enter Order: ", "Edit Ordered Bill: ", "Collection of a day: " };
    static Food orderitem = new Food();


    public static void main(String[] args) {
        while (true) {
            Menulist();
            ExecutingMenu();
            System.out.println("Press 'y' to return 'Main_Menu'");
            char ch = sc.next().charAt(0);
            if (ch != 'y')
                break;
        }
    }

    static void Menulist() {
        System.out.println();
        System.out.println("Welcome to Mahaa's Kitchen , Kakinada");
        System.out.println("------------------------------------");
        for (int i = 0; i < 3; i++)
            System.out.println((i + 1) + "." + menuitems[i]);
    }

    static void ExecutingMenu() {
        System.out.println();
        System.out.print("Enter your Choice : ");
        int item = sc.nextInt();
        if (item == 1)
        orderitem.CreatingNewOrder();
        else if (item == 2)
            orderitem.CheckBillStatus();
        else if (item == 3) {
            orderitem.CollectionOfDay();
        } else
            System.out.println("Entered Choice not in List");
    }

    
}

class Food {
    File NewFile = new File("orderdetails.csv");
    static Scanner sc1 = new Scanner(System.in);
    static ArrayList<ArrayList<String>> Menu = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> FoodP = new ArrayList<ArrayList<String>>();

    static void Readingfile(String fileName, int f) {
        try {
            String line = " ";
            Scanner br = new Scanner(new FileReader(fileName));
            while ((br.hasNext())) {
                line = br.nextLine();
                String[] FoodItems1 = line.split(",");
                List<String> List = Arrays.asList(FoodItems1);
                ArrayList<String> Fooditems = new ArrayList<String>(List);
                if (f == 0)
                    Menu.add(Fooditems);
                else
                    FoodP.add(Fooditems);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    static double ClaculateAmount(int id, int q) {
        double a = 0;
        for (int i = 0; i < Menu.size(); i++) {
            ArrayList<String> b = Menu.get(i);
            if (id == Integer.parseInt(b.get(0))) {
                a += (q * Integer.parseInt(b.get(2)));
            }
        }
        return a;
    }

    static String ConfirmOrder(String c[]) {
        int Amount = 0;
        System.out.println();
        System.out.println("--Ordered Items--");
        for (int j = 0; j < c.length; j+= 2) {
            for (int l = 0; l < Menu.size(); j++) {
                ArrayList<String> b = Menu.get(j);
                if (Integer.parseInt(c[j]) == Integer.parseInt(b.get(0))) {
                    System.out.println("[ " + b.get(1) + "    ||  Cost  :  Rs."
                            + Integer.parseInt(c[l + 1]) * Integer.parseInt(b.get(2)) + " ||  Qty : "
                            + Integer.parseInt(c[l + 1]) + " ]");
                    Amount += Integer.parseInt(c[l+ 1]) * Integer.parseInt(b.get(2));
                }
            }
        }
        System.out.println();
        System.out.println("Total Bill : Rs." + Amount);
        System.out.println();
        System.out.println("Enter 'y' to Confirm order");
        char ch = sc1.next().charAt(0);
        if (ch == 'y')
            return ",Approved";
        return ",Cancelled";
    }

    void CreatingNewOrder() {
        String st = "\n", Food = "";
        ArrayList<String> dummy = FoodP.get(FoodP.size() - 1);
        int lastIndex = Integer.parseInt(dummy.get(0));
        double totalAmount = 0;
        int i = 1, it, count;
        while (true) {
            System.out.println();
            System.out.println("Enter Order Details--->");
            System.out.print("Item:" + i + "  Enter ItemId : ");
            it = sc1.nextInt();
            System.out.print("Item:" + i + "  Quantity : ");
            count = sc1.nextInt();
            i++;
            totalAmount += ClaculateAmount(it, count);
            Food += String.valueOf(it) + " " + String.valueOf(count) + " ";
            System.out.println();
            System.out.println("Press y to palce Another order");
            char c = sc1.next().charAt(0);
            if (c != 'y')
                break;
        }
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-dd-MMM");
        String formattedDate = myDateObj.format(myFormatObj);
        st += String.valueOf((lastIndex + 1)) + "," + formattedDate + "," + String.valueOf(totalAmount) + ',' + Food;
        String[] m = Food.split(" ");
        st += ConfirmOrder(m);
        sc1.nextLine();
        try {
            byte[] ByteInput = st.getBytes();
            FileOutputStream FileWrite = new FileOutputStream("orderdetails.csv", true);
            FileWrite.write(ByteInput);
            FoodP.clear();
            Readingfile("orderdetails.csv", 1);
            FileWrite.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void AddingIntoFile() {
        try {
            NewFile.delete();
            if (NewFile.createNewFile()) {
                System.out.println("Status updated in file");
            }
            for (ArrayList<String> arrayList : FoodP) {
                String listString = String.join(",", arrayList);
                listString += "\n";
                byte[] ByteInput = listString.getBytes();
                FileOutputStream FileWrite = new FileOutputStream("orderdetails.csv",
                        true);
                FileWrite.write(ByteInput);
                FileWrite.close();
            }
        } catch (Exception e) {
            System.out.println();
        }
    }

    void CheckBillStatus() {
        System.out.print("Enter order Id : ");
        int n = sc1.nextInt();
        for (int j = 0; j < FoodP.size(); j++) {
            ArrayList<String> dump = FoodP.get(j);
            if (n == Integer.parseInt(dump.get(0))) {
                System.out.println(dump);
                System.out.println("press 'a' to place Order");
                char c = sc1.next().charAt(0);
                if (c == 'a')
                    FoodP.get(j).set(4, "Approved");
                else
                    FoodP.get(j).set(4, "Cancelled");
            }
        }
        sc1.nextLine();
        AddingIntoFile();
    }

    void CollectionOfDay() {
        System.out.print("Enter the date in Format year-day-month :");
        String date = sc1.nextLine();
        double Coll = 0.0;
        for (ArrayList<String> dump : FoodP) {
            if ((dump.get(1)).equals(date)) {
                Coll += (Double.parseDouble(dump.get(2)));
            }
        }
        System.out.println(date + " day's Total Collection is  Rs." + Coll);
    }

    Food() {
        Readingfile("menulist.csv", 0);
        Readingfile("orderdetails.csv", 1);
    }
}


