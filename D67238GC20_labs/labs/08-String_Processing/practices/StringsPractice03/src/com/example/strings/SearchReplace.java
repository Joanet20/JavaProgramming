package com.example.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplace {

    private String fileName = "E:\\IFC332N\\Programacio\\D67238GC20_labs\\labs\\08-String_Processing\\practices\\StringsPractice03\\gettys.html";

    public static void main(String[] args) {
        SearchReplace sr = new SearchReplace();
        sr.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String targetTag = "p";
            String replaceTag = "span";
            String attribute = "class";
            String value = "sentence";
            String line = "";
            int c = 1;
            // Create a Pattern object to match the entire line.
            Pattern p = Pattern.compile("(<" + targetTag + " " + attribute + "=\".*? >) (.*?) (<" + targetTag + ">)");


            while ((line = reader.readLine()) != null) {
                // Create a matcher
                Matcher m = p.matcher(line);


                // Find a match
                if (m.find()){
                    String newStart = replaceTag(m.group(1), targetTag, replaceTag);

                    newStart = replaceAttribute(newStart, attribute, value);

                    String newEnd = replaceTag(m.group(3), targetTag, replaceTag);

                    String newLine = newStart + m.group(2) + newEnd;

                    System.out.printf("%3d %s\n" + newLine);
                }


                // Replace Start Tag
                // Replace End Tag
                // Replace the attribute
                // Reassemble the new line
                //String newLine = "dhjdgh";

                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String replaceTag(String tag, String targetTag, String replaceTag) {

        Pattern p = Pattern.compile(targetTag);
        Matcher m = p.matcher(tag);

        if (m.find()){
            return m.replaceFirst(replaceTag);
        }

        return targetTag;
    }

    public String replaceAttribute(String tag, String attribute, String value) {

        Pattern p = Pattern.compile((attribute + "=") + "(\".*?\")");
        Matcher m = p.matcher(tag);

        if (m.find()){
            return m.replaceFirst(m.group(1) + value);
        }

        return tag;
    }
}
