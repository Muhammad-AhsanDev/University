import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SORT{
    public static void main(String[] args) throws FileNotFoundException {
    File file =new File("countryInfo.txt");
    Scanner sc = new Scanner(file);
    String line =sc.nextLine(); // to skip the first line
    ArrayList <String[]> Mainarray = new ArrayList<>();
    while (sc.hasNextLine()) {
        line= sc.nextLine();
        System.out.println(line);
        String[] colseperated = line.split("\t");
        
    }

            
        }
    }
