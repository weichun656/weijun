
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
            
            ArrayList<Integer> num = new ArrayList<Integer>(); // Create an ArrayList object
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
            num.add(value = myInputFile.read());
//            System.out.println(num.get(0));

            String tag = getTag(num.get(0),num.get(1));
//            System.out.print(tag);
            
            String type = getType(num.get(2),num.get(3));
//            System.out.print(type);
            
            String length = getLength(num.get(4),num.get(5),num.get(6),num.get(7));
            
            String fvalue = getValue(num.get(8),num.get(9),num.get(10),num.get(11));
//            System.out.print(fvalue);
            
            System.out.println(tag + "                                      " + type + "               " + 1 + "       " + fvalue);
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
    public static String getTag(int i, int m){
        String first = String.valueOf(i);
        String second = String.valueOf(m);

        String tag = second + first;
        int value = Integer.parseInt(tag);
        String hex = Integer.toHexString(value);
        
        return hex;
    }
    public static String getType(int i, int m){
        String first = String.valueOf(i);
        String second = String.valueOf(m);

        String tag = second + first;
        int value = Integer.parseInt(tag);
        String hex = Integer.toHexString(value);
        
        return hex;
    }
    public static String getLength(int i, int m, int j, int k){
        String first = String.valueOf(i);
        String second = String.valueOf(m);
        String third = String.valueOf(i);
        String fourly = String.valueOf(m);

        String tag = fourly + third + second + first;
        int value = Integer.parseInt(tag);
        String hex = Integer.toHexString(value);
        
        return hex;
    }
    public static String getValue(int i, int m, int j, int k){
        String first = String.valueOf(i);
        String second = String.valueOf(m);
        String third = String.valueOf(i);
        String fourly = String.valueOf(m);

        String tag = fourly + third + second + first;
        int value = Integer.parseInt(tag);
        String hex = Integer.toHexString(value);
        return hex;
    }
}
