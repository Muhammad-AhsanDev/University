import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;

public class practice{
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
    
        public static void sortBy(int index) {
        Collections.sort(sales, new Comparator<SaleData>() {
            public int compare(SaleData a, SaleData b) {
                return a.getField(index).compareTo(b.getField(index));
            }
        });

        System.out.println("\n--- SORTED SUCCESSFULLY ---\n");
        displayAll();
    }
    public static void main(String[] args) {
     
    }
}