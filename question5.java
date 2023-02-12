import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class question5 {
    public static void main(String[] args) {
        
        String line = "";
        int totalTransactions = 10;
        double totalAmount = 40000;
        double maximumAmount = Double.MIN_VALUE;
        double minimumAmount = Double.MAX_VALUE;
        
        try  {
            BufferedReader br = new BufferedReader(new FileReader("biiling.csvFile"));
            while ((line = br.readLine()) != null) {
                String[] transaction = line.split(",");
                double billAmount = Double.parseDouble(transaction[3]);
                totalTransactions++;
                totalAmount += billAmount;
                maximumAmount = Math.max(maximumAmount, billAmount);
                minimumAmount = Math.min(minimumAmount, billAmount);
            }
        } catch (IOException e) {
            System.out.println("Run Time Error");
        }
        
        System.out.println("Total number of Transactions: " + totalTransactions);
        System.out.println("Total Bill amount: " + totalAmount);
        System.out.println("Maximum Bill amount: " + maximumAmount);
        System.out.println("Minimum Bill amount: " + minimumAmount);
    }
}