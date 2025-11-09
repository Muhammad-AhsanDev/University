

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class contact {
    public static void main(String[] args) throws IOException {
       ArrayList <String> list = new ArrayList<>();
        File file = new File("contactbooklist.txt");
        if(!(file.exists())){
            file.createNewFile();
        }
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line=reader.nextLine();
            list.add(line);

          }  System.out.println("===== Contact Book =====");
        System.out.println("1. Add Contact");
        System.out.println("2. View All Contacts");
        System.out.println("3. Save Contacts");
        System.out.println("4. Exit");
        System.out.println("*******************");
        System.out.println("Enter you Choice");
        Scanner inp = new Scanner(System.in);
        String userinp = inp.nextLine();
        while (!(userinp.equals("4"))) {
            if(userinp.equals("1")){
                System.out.println("Enter Your Name");
                String name = inp.nextLine();
                System.out.println("Enter your Number");
                String number = inp.nextLine();
                System.out.println("Enter your Email");
                String email=inp.nextLine();
                String text =name+","+number+","+email;
                list.add(text);
            }
            if(userinp.equals("2")){
                if(list.size()==0){
                    System.out.println("Contact Book is Empyt");
                }
                else{
                     for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i));
                }
                }
               
            }
            if(userinp.equals("3")){
                System.out.println("Saving contacts to "+file);
                FileWriter writer= new FileWriter(file);
                for(int i=0;i<list.size();i++){
                writer.write(list.get(i)+"\n");}
                writer.close();
                System.out.println("Saved");
            }
        System.out.println("Enter you Choice");
            userinp = inp.nextLine();
        }

        
    }
}