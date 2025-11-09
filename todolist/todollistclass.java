package todolist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class todollistclass {
 ArrayList <String> fMain = new ArrayList<>();
 File file;
    todollistclass(ArrayList <String> fMain,File file){
        this.fMain=fMain;
        this.file=file;
    }
     void loadile() throws IOException{
         
        if(!(this.file.exists())){
            this.file.createNewFile();
            System.out.println("CREAted "+this.file);
        }
        Scanner readfile = new Scanner(this.file);
        String line;
        System.out.println("******TASKS************");
        while (readfile.hasNextLine()) {
            line=readfile.nextLine();
            System.out.println(line);
            this.fMain.add(line);
            
        }
        readfile.close();
        System.out.println("*********************");}



        
     String addtask(String[] parts){//ADDING TASK 
        String text="";
                for(int i=1;i<parts.length;i++){
                    text = text+parts[i]+" ";  
                }
                return text;
    }

         void displaytasks(){
           System.out.println("******TASKS************");
                for(int k=0;k<fMain.size();k++){
                    System.out.println(fMain.get(k));
                }
         System.out.println("*********************");
        
    }
       String removetask(String[] parts){
        String text="";
                for(int i=1;i<parts.length;i++){
                    text = text+parts[i]+" ";  
                }
                return text;

    }

       void WriteToFile() throws IOException{
                 FileWriter writer =new FileWriter(this.file);
        for(String tasks:this.fMain){
           
            writer.write(tasks+"\n");
        }
        writer.close();
        System.out.println(file+" has been Written");
    }




    }

