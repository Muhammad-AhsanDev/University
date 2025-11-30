package MiniSearchEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class practice {
    static void loadfiles(String folderpath,int mode,String query){
        File folder = new File(folderpath);
        if(!folder.exists()||!folder.isDirectory()){
            System.out.println("Invalid Folder path enter a correct one ");
        }
        
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));
          if (files == null || files.length == 0) {
            System.out.println("No .txt files found!");
            return;
        }
         System.out.println("\n=== SEARCH RESULTS ===\n");
        for(File file:files){
            searchInFile(file,mode,query);
        }
    }
    static void searchInFile(File file,int mode,String query){
        try {
            Scanner readline=new Scanner(file);
            String line;
            int linecounter=1;
            boolean foundAnything=false;
            line=readline.nextLine();
            while (readline.hasNextLine()) {

                
                boolean matched =false;
                if(mode==1){
                   matched = line.toLowerCase().contains(query.toLowerCase());
                }
                else if (mode==2){
                    Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(line);
                    matched = matcher.find();
                }
                if(matched){
                    if(!foundAnything){
                        System.out.println("File:-------"+" "+file.getName());
                        foundAnything=true;
                    }
                    System.out.println(linecounter+": "+line); 
                }
                linecounter++;
                line=readline.nextLine();

                

            }
            if(foundAnything){
                System.out.println("----------SEARCHING FILE DONE --------------");
                readline.close();
            }

        } catch (FileNotFoundException e) {
           
          System.out.println("An error Occured while reading ");
        }
        

    }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
     System.out.println("=== MINI SEARCH ENGINE ===");
    System.out.println("ENTER THE FOLDER PATH");
    String folderpath=sc.nextLine();
    System.out.println("ENTER 1)For Exhaustive Search 2)Regex Search");
    int mode =sc.nextInt();
    sc.nextLine();
    System.out.println("Enter the query to Search");
    String query= sc.nextLine();
    loadfiles(folderpath,mode,query);


  }
     
}
