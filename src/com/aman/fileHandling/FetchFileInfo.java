package com.aman.fileHandling;

import java.io.File;
import java.io.IOException;

public class FetchFileInfo {
    public static void main(String[] args) {
        try{
            File fileObj = new File("/home/aman/Desktop/JavaFileHandlingTesting.txt");
            if(fileObj.exists()){
                System.out.println("File Name :-"+ fileObj.getName());
                System.out.println("File's Full path :- "+ fileObj.getPath());
                System.out.println("File's Absolute path :- "+ fileObj.getAbsolutePath());
                System.out.println("File's Canonical path :- "+ fileObj.getCanonicalPath());
                System.out.println("Is File writable :- "+ fileObj.canWrite());
                System.out.println("Is File readable :- "+ fileObj.canRead());
                System.out.println("File size in bytes :- "+ fileObj.length());
            } else {
                System.out.println("File does not exist");
            }
        } catch(IOException e){
            System.out.println("An Exception occured");
            e.printStackTrace();
        }
    }
}
