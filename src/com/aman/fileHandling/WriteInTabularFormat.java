package com.aman.fileHandling;

import java.io.*;

public class WriteInTabularFormat {
    public static void main(String[] args) {
        try {
            String filePath = "/home/aman/Desktop/JavaTablularFile.txt";

            File fileObj = new File(filePath);
            if(!fileObj.exists()){
                fileObj.createNewFile();
            }
            FileOutputStream fileOut=new FileOutputStream(filePath, true);
            PrintStream fileStream = new PrintStream(fileOut);
            //We are using here -10s to make it left-aligned(which seems like normal table format), in case of +10s it will be right-aligned(seems awkward).
            fileStream.append(String.format("%-10s %-10s %-10s \r\n", "data 1", "data 2", "data 3"));
            fileStream.append(String.format("%-10s %-10s %-10s \r\n", "column 1", "column 2", "column 3"));
        } catch (IOException e){
            System.out.println("An Exception occured");
            e.printStackTrace();
        }
    }
}
