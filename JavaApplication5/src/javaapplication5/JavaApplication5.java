/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;
/**
 *
 * @author fausto
 */
import java.util.Scanner;
public class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                Scanner entrada = new Scanner (System.in);
                System.out.println("Entradalarga");
                String entradalarga = entrada.next();
                System.out.println("Final");
                String end = entrada.next();
                System.out.println(solution(entradalarga,end)   );
        // TODO code application logic here
        String a ="aa";
        a.e
    }
    public static boolean solution(String str, String ending){
    int endLen = ending.length();
    int strLen = str.length();
    int subs = strLen - endLen;
    int anssubs = Integer.signum(subs);
    if(anssubs==-1) {
    subs = 0;
    }
    String strend = str.substring(subs);
    if (strend.equals(ending)){
        return true;
    }
    else{
        return false;
    }
    }
}
