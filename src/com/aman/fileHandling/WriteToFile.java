package com.aman.fileHandling;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        try {
            String filePath = "/home/aman/Desktop/JavaFileHandlingTesting.txt";
            //There are many ways of writing into file system.We have displayed four here :- FileWriter, BufferedWriter, PrintStream, PrintWriter(most recommended)
            //In FileWriter and BufferedWriter to insert data in next line we need to insert following object in the beginning of the line
            String ls = System.getProperty( "line.separator" );

            /*
            First :- Using FileWriter Class
            In FileWriter class you can pass second parameter as "true" if you want to append text with previous texts
            and don't pass second parameter(or pass false) if you want to delete all previous texts and overwrite file again with new texts.
            */
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write("Sample text to check if file writing operation is working or not."+ls);
            fileWriter.append("This is text to be written in next line."+ls);
            fileWriter.close();


            /*
            Second :- Using BufferedWriter Class
            Java BufferedWriter class is used to provide buffering for Writer instances. It makes the performance fast. It inherits Writer class.
            The buffering characters are used for providing the efficient writing of single arrays, characters, and strings.
            */
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write("This text is written using buffered writer."+ls);
            bufferedWriter.append("Second line written using buffered writer."+ls);
            bufferedWriter.close();

            /*
            Third :- Using PrintStream Class
            The PrintStream class of the java.io package can be used to write output data in commonly readable form (text) instead of bytes.
            Unlike other output streams, a PrintStream never throws an IOException; instead, in case of exceptions it merely set an internal flag that can be tested via the checkError method.
            It extends the abstract class OutputStream
            */
            FileOutputStream fileOut=new FileOutputStream(filePath, true);
            //Set second parameter as true if you want to append text in previous texts rather than overwriting file again.
            PrintStream fileStream = new PrintStream(fileOut);
            /*
            Another Possible Syntax for the same :-
            PrintStream fileStream = new PrintStream(filePath);
            OR
            PrintStream fileStream = new PrintStream(new File(filePath));
            In this method we don't need to create anything extra to insert data into a new line.It's println method does it by itself.
            */
            fileStream.append("This text is appended");
            fileStream.println();
            fileStream.println("Appended next line");
            fileStream.close();

            //We can also print anything on console as well using printstream.
            PrintStream psout = new PrintStream(System.out);
            psout.println("Printing on console using PrintStream");
            //Actually System.out.println() is an instance of PrintStream only.
            psout.flush();
            //psout.close();
            //If we close PrintStream or PrintWriter Object of System.out then it will not allow System.out.println() also to print anything on console until a new object of it is created.
            System.out.println("Testing by printing next line");


            /*
            Fourth :- Using PrintWriter Class(Most Recommended)
            PrintWriter class is very much similar to PrintStream except from the fact that PrintStream prints to an OutputStream, and PrintWriter prints to a Writer.
            Actually OutputStream is a stream of bytes while a Writer is a stream of characters.
            So to print strings PrintStream converts chars to bytes using the default platform encoding.
            Using the default encoding is generally a bad thing since it can lead to bugs when moving from one platform to another, especially if you are generating the file on one platform and consuming it on another.
            */
            //#Note :- Please flush and close(or at least close) the PrintWriter object at the end otherwise it will not print anything.
            PrintWriter printWriter = new PrintWriter(new FileWriter(filePath, true));
            //We can use File class also in place of FileWriter, but in that case it will not give functionality to append new texts with previous one, rather it will overwrite the file again.
            printWriter.write("This text is printed using printwriter's write method");
            printWriter.println();
            printWriter.append("Second lin e written using printwritter's append method");
            printWriter.println();
            printWriter.println("Written using printwriter's println method");
            printWriter.print("Line written using print method");
            //printWriter.flush();
            printWriter.close();

            //We can also print on console using PrintWriter.
            //It works similar as in case of printstream.
            PrintWriter pwout = new PrintWriter(System.out);
            pwout.println("Printing on Console using PrintWriter");
            //pwout.close();
            pwout.flush();

            System.out.println("File written successfully");
        } catch (IOException e){
            System.out.println("An Exception occured");
            e.printStackTrace();
        }
    }
}
