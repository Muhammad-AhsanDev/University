import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class todonow {
    public static void main(String[] args) throws IOException {
        ArrayList <String> Main = new ArrayList<>();
    File file= new File("lists.txt");
        if(!(file.exists())){
            file.createNewFile();
        }
        Scanner readfile = new Scanner(file);
        String line;
        System.out.println("******TASKS************");
        while (readfile.hasNextLine()) {
            line=readfile.nextLine();
            System.out.println(line);
            Main.add(line);
            
        }
        readfile.close();
        System.out.println("*********************");
        String text="";
        System.out.println("ENter the Task");
        Scanner inp = new Scanner(System.in);
        String userinp =inp.nextLine();
        while (!(userinp.equalsIgnoreCase("quit"))) {
            String[] parts = userinp.split(" ");
            if(parts[0].equalsIgnoreCase("add")){
                for(int i=1;i<parts.length;i++){
                    text = text+parts[i]+" ";
                    
                }
                Main.add(text);
                    text="";

        System.out.println("******TASKS************");
                for(int k=0;k<Main.size();k++){
                    System.out.println(Main.get(k));
                }
         System.out.println("*********************");
            }
            if(parts[0].equalsIgnoreCase("remove")){
                for(int j=1;j<parts.length;j++){
                    text = text+parts[j]+" ";
                   
                }
                 Main.remove(text);
                    text="";
          System.out.println("******TASKS************");
                for(int k=0;k<Main.size();k++){
                    System.out.println(Main.get(k));
                }
         System.out.println("*********************");
            }
            System.out.println("ENter the Task");
            userinp =inp.nextLine();


        }
         FileWriter writer =new FileWriter(file);
        for(String tasks:Main){
           
            writer.write(tasks);
        }
        writer.close();
        System.out.println(file+" has been Written");
        
    }
}
