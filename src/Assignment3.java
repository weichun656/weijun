
import java.io.FileInputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Assignment3 {
    public static void main(String[] args) {
        try{
            FileInputStream myInputFile = new FileInputStream("image/yoda.raw");
            
            int data[] = new int [256];
            int num[] = new int [256];
            int pixel[] = new int [256];
            int value;
            int m=0;
            int sum = 0;
            double nor  = 0.0;
            int mutiple = 0;
//            int total = 0;
            while((value = myInputFile.read())!=-1){
                data[value] = data[value]+1;    
                m++;
            }
            System.out.println("-----------------------------Header Info-----------------------------");
            System.out.println("Gray-level--No of Pixel--Rum Sum--Normalized--Mutiple 7--No of Pixel-");
            for(int i=0;i<256;i++){
                sum  += data[i];
                nor = ((double)sum/m);
                mutiple = (int) Math.round(nor*255);
                num[i] = mutiple;
                
//                pixel = mutiple;
                if(i!=0){
                    if(num[i]==num[i-1]){
                        pixel[mutiple] = pixel[mutiple]+data[i];
                    }else{
                        pixel[mutiple] = data[i];
                    }
                }else{
                    pixel[mutiple] = data[i];
                }
                System.out.println(i+"               "+data[i]+"           "+sum+"         "+nor+"          "+mutiple+"           "+pixel[i]+"        ");
            }
//            for(int k=0;k<256;k++){
//                total = total + pixel[k];
//            }
            
            
            
            myInputFile.close();
        }catch(IOException ex){
            System.out.println("File Error!!!");
        }
    }
}
