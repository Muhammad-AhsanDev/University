package MiniSearchEngine;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== MINI SEARCH ENGINE ===");
        System.out.print("Enter folder path (e.g., texts): ");
        String folderPath = sc.nextLine();

        System.out.print("Enter search query: ");
        String query = sc.nextLine();

        System.out.print("Choose mode (1 = Exhaustive, 2 = RegEx): ");
        int mode = sc.nextInt();

        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {//Checks,Whether,is//a//folder,or,not
            System.out.println("Invalid folder path!");
            return;
        }

        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No .txt files found!");
            return;
        }

        System.out.println("\n=== SEARCH RESULTS ===\n");

        for (File file : files) {
            searchInFile(file, query, mode);
        }
    }


    // ------------------ MAIN SEARCH FUNCTION ------------------
    public static void searchInFile(File file, String query, int mode) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int lineNumber = 1;

            boolean foundAnything = false;

            while ((line = br.readLine()) != null) {

                boolean matched = false;

                if (mode == 1) {   // Exhaustive Mode (simple string search)
                    matched = line.toLowerCase().contains(query.toLowerCase());
                }
                else if (mode == 2) { // RegEx Mode
                    Pattern pattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(line);
                    matched = matcher.find();
                }

                if (matched) {
                    if (!foundAnything) {
                        System.out.println("File: " + file.getName());
                        foundAnything = true;
                    }
                    System.out.println("  Line " + lineNumber + ": " + line);
                }

                lineNumber++;
            }

            if (foundAnything) System.out.println();

            br.close();

        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}
