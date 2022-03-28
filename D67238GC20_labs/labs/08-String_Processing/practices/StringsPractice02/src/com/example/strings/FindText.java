package com.example.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {

    private String fileName = "E:\\IFC332N\\Programacio\\D67238GC20_labs\\labs\\08-String_Processing\\practices\\StringsPractice02\\gettys.html";
    // Create Pattern
    private Pattern p;
    // Create Matcher
    private Matcher m;



    public static void main(String[] args) {
        FindText find = new FindText();
        find.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line = "";


            int c = 1;
            while ((line = reader.readLine()) != null) {
                // Generate a matcher based on Pattern
                m = p.matcher(line);
                p = Pattern.compile("<h4>");
                //p = Pattern.compile("\\bto\\b");
                //p = Pattern.compile("^\\s{4}");
                //p = Pattern.compile("^[<p|<d]");
                //p = Pattern.compile("^.*?</.*?>$");

                // Search for text
                if (m.find()){
                    System.out.println(c + " " + line);
                }

                // Print results
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
