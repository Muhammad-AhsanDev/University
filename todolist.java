import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class todolist {
    
    public static void main(String[] args) {
        String text="";
        ArrayList <String> array=new ArrayList<>(); 
        Scanner inp = new Scanner(System.in);


        //Reading a file 
        File todolist = new File("todolist.txt");
        if(!(todolist.exists())){
            try {
                todolist.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating One File ");
                e.printStackTrace();
            }
        }
         Scanner reader;
     try {
        reader = new Scanner(todolist);
   System.out.println("****TASK ****");
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            System.out.println(line);
            array.add(line);
        }
        System.out.println("**********");
        reader.close();}
    catch (FileNotFoundException e) {
       System.out.println("error Reading File");
        e.printStackTrace();
     }
          
       

///ADDDING And Removing A task
 System.out.println("Enter a Task (add task;to add a task)(remove task//To reove it)(quit to exit )");
        String taskinp = inp.nextLine();
        while(!(taskinp.equalsIgnoreCase("quit"))){
    
        String[] split = taskinp.split(" ");


        if(split[0].equalsIgnoreCase("add")){
           
         for(int i=1;i<split.length;i++){
                
           text = text+split[i]+" ";
            }
            array.add(text);
            text="";
        
        }
        if(split[0].equalsIgnoreCase("remove")){
       for(int i=1;i<split.length;i++){
                
        text = text+split[i]+" ";
            }
            array.remove(text);
            text="";

        }
        System.out.println("****TASK ****");
          for(String tasks:array){
            
            System.out.println(tasks);
        }
        System.out.println("**********");
        taskinp = inp.nextLine();
    
    }

    System.out.println();
    System.out.println();
    System.out.println();
  
    try {
      
        FileWriter writer = new FileWriter(todolist);
        for(int l =0 ; l<array.size();l++){
            writer.write(array.get(l)+"\n");
            System.out.println(array.get(l));
        }
        writer.close();
         System.out.println("Tasks saved to todolist.txt successfully!");
    } catch (IOException e) {
        e.printStackTrace();
    }
      
    }
}