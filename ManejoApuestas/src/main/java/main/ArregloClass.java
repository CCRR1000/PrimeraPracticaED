/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author CIROSS
 */
public class ArregloClass {
    ArrayList<String[]> arreglos = new ArrayList<>();

    public void print() {
        
        for (int i = 0; i < arreglos.size(); i++) {
            
            printArray(arreglos.get(i));
           
        }
        
    }
    
    public void printArray(String[] arr) {
        System.out.print("[ "+arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print(", "+arr[i]);
            
        }
        System.out.println(" ]");
    }
    public ArrayList<String[]> getArreglos() {
        return arreglos;
    }

    public void setArreglos(ArrayList<String[]> arreglos) {
        this.arreglos = arreglos;
    }

    
}
