package com.aman.fileHandling;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        try {
            String filePath = "/home/aman/Desktop/JavaFileHandlingTesting.txt";
            //There are many ways of writing into file system.We have displayed three here :- FileWriter, BufferedWriter and PrintStream
            //In FileWriter and BufferedWriter to insert data in next line we need to insert following object in the beginning of the line
            String ls = System.getProperty( "line.separator" );

            //First :- Using FileWriter Class
            //In FileWriter class you can pass second parameter as "true" if you want to append text with previous texts
            //and don't pass second parameter(or pass false) if you want to delete all previous texts and overwrite file again with new texts.
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.write("Sample text to check if file writing operation is working or not."+ls);
            fileWriter.append("This is text to be written in next line."+ls);
            fileWriter.close();

            //Second :- Using BufferedWriter Class
            //Java BufferedWriter class is used to provide buffering for Writer instances. It makes the performance fast. It inherits Writer class.
            //The buffering characters are used for providing the efficient writing of single arrays, characters, and strings.
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));
            bufferedWriter.write("This text is written using buffered writer."+ls);
            bufferedWriter.append("Second line written using buffered writer."+ls);
            bufferedWriter.close();
            //Third :- Using PrintStream Class
            //The PrintStream class of the java.io package can be used to write output data in commonly readable form (text) instead of bytes.
            //Unlike other output streams, a PrintStream never throws an IOException; instead, exceptional situations merely set an internal flag that can be tested via the checkError method.
            //It extends the abstract class OutputStream
            FileOutputStream fileOut=new FileOutputStream(filePath, true);
            //Set second parameter as true if you want to append text in previous texts rather than overwriting file again.
            PrintStream fileStream = new PrintStream(fileOut);
            //Another Possible Syntax for the same :-
            //PrintStream fileStream = new PrintStream(filePath);
            //OR
            //PrintStream fileStream = new PrintStream(new File(filePath));
            //In this method we don't need to create anything extra to insert data into a new line.It's println method does it by itself.
            fileStream.append("This text is appended");
            fileStream.println();
            fileStream.println("Appended next line");

            System.out.println("File written successfully");
        } catch (IOException e){
            System.out.println("An Exception occured");
            e.printStackTrace();
        }
    }
}
