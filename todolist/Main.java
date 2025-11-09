package todolist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList <String> Main = new ArrayList<>();
        File file= new File("Taskmanagment.txt");
        todollistclass tc = new todollistclass(Main, file);
        tc.loadile();
        System.out.println("Enter a task");
      Scanner sc = new Scanner(System.in);
      String userinp =sc.nextLine();
        while (!(userinp.equalsIgnoreCase("quit"))) {
            String[] parts = userinp.split(" ");
        if(parts[0].equalsIgnoreCase("add")){
            String text=tc.addtask(parts);
            Main.add(text);
            text="";
            System.out.println("here");
            tc.displaytasks();
            userinp =sc.nextLine();
        }

         if(parts[0].equalsIgnoreCase("remove")){
            String text=tc.removetask(parts);
            Main.remove(text);
            text="";
            tc.displaytasks();
            userinp =sc.nextLine();
        }
            
        }
        tc.WriteToFile();
    }
}
