package com.aman.fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {
        try {
            File fileObj = new File("/home/aman/Desktop/JavaFileHandlingTesting.txt");
            Scanner reader = new Scanner(fileObj);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("File not Found");
            e.printStackTrace();
        }
    }
}
