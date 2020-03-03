
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList; // import the ArrayList class
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Student
 */
public class Assignment1 {
    public static void main(String[] args) {
        try{
            FileInputStream myInputFile = new FileInputStream("image/yoda.tif");
            int value;
            String hex = "";
            int i=1;
            int m=0;
            System.out.print("Byte Order : ");
            while((i<=2)&&((value = myInputFile.read())!=-1)){
                hex = Integer.toHexString(value);
                System.out.print(hex);
                i++;
            }
            System.out.println("");
            System.out.print("Version : ");
            while((i<=4)&&((value = myInputFile.read())!=-1)){
                hex = Integer.toHexString(value);
                if(value==0){
                    hex = "";
                }else{
                    m=value;
                }
                System.out.print(hex);
                i++;
            }
            System.out.println("");
            System.out.print("Offset : ");
            while((i<=8)&&((value = myInputFile.read())!=-1)){
                hex = Integer.toHexString(value);
                if(value==0){
                    hex = "";
                }
                System.out.print(hex);
                i++;
            }
            
            System.out.println("");
            System.out.print("M : ");
            while((i<=10)&&((value = myInputFile.read())!=-1)){
                hex = Integer.toString(value);
                if(value==0){
                    hex = "";
                }
                System.out.print(hex);
                i++;
            }
            System.out.println("");
            System.out.println("-----------------------------Data  Entry-----------------------------");
            System.out.println("Tag					Type		Count	Value");
            System.out.println("---------------------------------------------------------------------");
            
            
            ArrayList<String> num = new ArrayList<String>(); // Create an ArrayList object
            num.add("0");
            for(int array=1;array<(12*m);array++){
//                num.add(value = myInputFile.read());
                value = myInputFile.read();
                String data = String.format("%02X", value);
                num.add(data);
            }
//            System.out.println(num.get(2));
            String tag = "";
            String type = "";
            String length = "";
            String fvalue = "";
            for(int j=0;j<m;j++){
                tag = getTag(num.get(1+(12*j)),num.get(2+(12*j)));
                type = getType(num.get(3+(12*j)),num.get(4+(12*j)));
                length = getLength(num.get(5+(12*j)),num.get(6+(12*j)),num.get(7+(12*j)),num.get(8+(12*j)));
                fvalue = getValue(num.get(9+(12*j)),num.get(10+(12*j)),num.get(11+(12*j)),num.get(12+(12*j)));
//                System.out.print(tag);
                System.out.println(tag + "                                      " + type + "               " + length + "       " + fvalue);
            }
//            int addTW = i + (12*m);
//            System.out.println("");
//            System.out.print("DE : ");
//            while((i<=addTW)&&((value = myInputFile.read())!=-1)){
//                  
//            }
            myInputFile.close();
        }catch(IOException ex){
            System.out.println("File Error!!!");
        }
    }
    public static String getTag(String i, String m){

        String tag = i + m;
        int value = Integer.parseInt(tag,16);
        String hex = String.format("%02X", value);
        
        return hex;
    }
    public static String getType(String i, String m){

         String tag = i + m;
        int value = Integer.parseInt(tag,16);
        String hex = Integer.toHexString(value);
        
        return tag;
    }
    public static String getLength(String i, String m, String j, String k){
        String tag = k + j + m + i;
        int value = Integer.parseInt(tag,16);
        String hex = Integer.toHexString(value);
        
        return hex;
    }
    public static String getValue(String i, String m, String j, String k){
        String tag = k + j + m + i;
        int value = Integer.parseInt(tag,16);
        String hex = Integer.toHexString(value);
        return hex;
    }
}
