
package com.mycompany.ejercicio0_prueba;

import java.util.Scanner;

public class Ejercicio0_Prueba {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int[] numeros = {5,2,6};
        
        System.out.println("Que numero quieres ver?");   
        
        try {
            int num1 = Integer.parseInt( sc.nextLine() );
            System.out.println(numeros[num1]);
        
        } catch(ArrayIndexOutOfBoundsException aio) {
            System.out.println("No existe esa posición");
        
        } catch(NumberFormatException nfe){
            System.out.println("Eso no es un numero");
        
        } catch(Exception e){
            System.out.println("Ha sucedido un error");
        
        } finally {
            System.out.println("Hasta luego");
        }
        
        

        
    }
}
