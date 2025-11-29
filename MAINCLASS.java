
import java.io.*;
import java.util.*;

class SaleData {

    private String date;
    private String region;
    private String repId;
    private String product;
    private int qty;
    private int unitPrice;

    public SaleData(String date, String region, String repId, String product, int qty, int price) {//COnstructor
        this.date = date;
        this.region = region;
        this.repId = repId;
        this.product = product;
        this.qty = qty;
        this.unitPrice = price;
    }

    public String getDate() { return date; }
    public String getRegion() { return region; }
    public String getRepId() { return repId; }
    public String getProduct() { return product; }
    public int getQty() { return qty; }
    public int getPrice() { return unitPrice; }

    public int getAmount() {
        return qty * unitPrice;
    }

    public String getField(int index) {
        if(index == 0) return date;
        else if(index == 1) return region;
        else if(index == 2) return repId;
        else if(index == 3) return product;
        else if(index == 4) return "" + qty;
        else return "" + unitPrice;
    }
}// Clas ends here


public class MAINCLASS {

    static ArrayList<SaleData> sales = new ArrayList<>();

    // ------------------ LOAD FILE ---------------------
    public static void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Sales.txt"));
            String line;
            br.readLine(); // skip header

            while((line = br.readLine()) != null) {
                if(line.trim().isEmpty()) continue;

                String[] fields = line.split("\t+");
                if(fields.length != 6) continue;

                String date = fields[0];
                String region = fields[1];
                String repId = fields[2];
                String product = fields[3];
                int qty = Integer.parseInt(fields[4].trim());
                int price = Integer.parseInt(fields[5].trim());

                sales.add(new SaleData(date, region, repId, product, qty, price));
            }
            br.close();
        }
        catch(Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // ------------------ SORT FUNCTION ---------------------
    public static void sortBy(int index) {
        Collections.sort(sales, new Comparator<SaleData>() {
            public int compare(SaleData a, SaleData b) {
                return a.getField(index).compareTo(b.getField(index));
            }
        });

        System.out.println("\n--- SORTED SUCCESSFULLY ---\n");
        displayAll();
    }

    // ------------------ AGGREGATE FUNCTION ---------------------
    public static void aggregateBy(int index) {
        HashMap<String, Integer> sumMap = new HashMap<>();

        for(SaleData s : sales) {
            String key = s.getField(index);
            int amount = s.getAmount();

            if(sumMap.containsKey(key)) {
                sumMap.put(key, sumMap.get(key) + amount);
            } else {
                sumMap.put(key, amount);
            }
        }

        System.out.println("\n--- AGGREGATED SALES ---");
        for(String k : sumMap.keySet()) {
            System.out.println(k + " → Rs. " + sumMap.get(k));
        }
    }

    // ------------------ DISPLAY ALL DATA ---------------------
    public static void displayAll() {
        System.out.println("Date\tRegion\tRep\tProduct\tQty\tPrice");
        for(SaleData s : sales) {
            System.out.println(
                s.getDate() + "\t" +
                s.getRegion() + "\t" +
                s.getRepId() + "\t" +
                s.getProduct() + "\t" +
                s.getQty() + "\t" +
                s.getPrice()
            );
        }
    }

    // ------------------ MAIN MENU ---------------------
    public static void main(String[] args) {

        loadFile();
        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n========== MENU ==========");
            System.out.println("1. Sort by Salesperson");
            System.out.println("2. Sort by Product");
            System.out.println("3. Sort by Region");
            System.out.println("4. Sort by Month");
            System.out.println("5. Aggregate by Salesperson");
            System.out.println("6. Aggregate by Product");
            System.out.println("7. Aggregate by Region");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if(choice == 1) {
                sortBy(2); // repId
            }
            else if(choice == 2) {
                sortBy(3); // product
            }
            else if(choice == 3) {
                sortBy(1); // region
            }
            else if(choice == 4) {
                Collections.sort(sales, new Comparator<SaleData>() {
                    public int compare(SaleData a, SaleData b) {
                        return a.getDate().substring(3,6).compareTo(b.getDate().substring(3,6));
                    }
                });
                displayAll();
            }
            else if(choice == 5) {
                aggregateBy(2); // repId
            }
            else if(choice == 6) {
                aggregateBy(3); // product
            }
            else if(choice == 7) {
                aggregateBy(1); // region
            }
            else if(choice == 8) {
                System.out.println("Exiting program...");
                break;
            }
            else {
                System.out.println("Invalid choice! Try again.");
            }
        }

        sc.close();
    }
}
