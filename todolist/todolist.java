package todolist;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class todolist {
    static void loadile(ArrayList <String> fMain,File file) throws IOException{//LODAING FILE 
        
        if(!(file.exists())){
            file.createNewFile();
            System.out.println("CREAted "+file);
        }
        Scanner readfile = new Scanner(file);
        String line;
        System.out.println("******TASKS************");
        while (readfile.hasNextLine()) {
            line=readfile.nextLine();
            System.out.println(line);
            fMain.add(line);
            
        }
        readfile.close();
        System.out.println("*********************");}



    static String addtask(String[] parts){//ADDING TASK 
        String text="";
                for(int i=1;i<parts.length;i++){
                    text = text+parts[i]+" ";  
                }
                return text;
    }

    static void displaytasks(ArrayList <String> dMain){
           System.out.println("******TASKS************");
                for(int k=0;k<dMain.size();k++){
                    System.out.println(dMain.get(k));
                }
         System.out.println("*********************");
        
    }

    static String removetask(String[] parts){
        String text="";
                for(int i=1;i<parts.length;i++){
                    text = text+parts[i]+" ";  
                }
                return text;

    }
    static void WriteToFile(File file,ArrayList <String> wMain) throws IOException{
                 FileWriter writer =new FileWriter(file);
        for(String tasks:wMain){
           
            writer.write(tasks+"\n");
        }
        writer.close();
        System.out.println(file+" has been Written");
    }


    public static void main(String[] args) throws IOException {
        ArrayList <String> Main = new ArrayList<>();
        File file= new File("Taskmanagment.txt");
      loadile(Main,file);
      System.out.println("Enter a task");
      Scanner sc = new Scanner(System.in);
      String userinp =sc.nextLine();
        while (!(userinp.equalsIgnoreCase("quit"))) {
            String[] parts = userinp.split(" ");
        if(parts[0].equalsIgnoreCase("add")){
            String text=addtask(parts);
            Main.add(text);
            text="";
            System.out.println("here");
            displaytasks(Main);
            userinp =sc.nextLine();
        }

         if(parts[0].equalsIgnoreCase("remove")){
            String text=removetask(parts);
            Main.remove(text);
            text="";
            displaytasks(Main);
            userinp =sc.nextLine();
        }
            
        }
        WriteToFile(file, Main);
       
      
    }
}