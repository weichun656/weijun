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


public class ReadFile {
    public static void main(String[] args) {
        try{
            FileInputStream myInputFile = new FileInputStream("image/yoda.tif");
            int value;
            int i=0;
            while((value = myInputFile.read())!=-1){
                i++;
                System.out.println(i+": "+value);
                
            }
//            System.out.println(myInputFile.read());
            
            myInputFile.close();
        }catch(IOException ex){
            System.out.println("File Error!!!");
        }
    }
}
