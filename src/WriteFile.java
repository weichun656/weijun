/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
import java.io.*;


public class WriteFile {
    public static void main(String[] args) {
        //File myOutputFile
        try{
            FileOutputStream myOutputFile = new FileOutputStream("myFile.txt");
            myOutputFile.write(1);
            myOutputFile.write(2);
            myOutputFile.write('T');
            myOutputFile.write('H');
            myOutputFile.write('I');
            myOutputFile.write('S');
            myOutputFile.close();
        }catch(IOException ex){
            System.out.println("File output error!");
        }
    }
}
