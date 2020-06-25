package com.aman.fileHandling;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        try{
            //First create a new object of File class for any file handling task;
            File fileObj = new File("/home/aman/Desktop/JavaFileHandlingTesting.txt");
            if(fileObj.createNewFile()){
                System.out.println("File created successfully :- "+fileObj.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e){
            System.out.println("An exception occured :-");
            e.printStackTrace();
        }
    }
}
