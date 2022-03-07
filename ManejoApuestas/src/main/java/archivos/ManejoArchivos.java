/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import gestionApuestas.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author CIROSS
 */
public class ManejoArchivos {

    public static File archivo;

    public static void abrirArchivo(Container container, ControlApuestas apuesta) {

        JFileChooser fileChosser = new JFileChooser();
        int seleccion = fileChosser.showOpenDialog(container);

        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            
            archivo = fileChosser.getSelectedFile();
            FileReader fr;
            
            try {   
                fr = new FileReader(archivo);
                
                BufferedReader br = new BufferedReader(fr);
                String linea;
                
                while ((linea = br.readLine()) != null) {
                    
                    String[] datos = linea.split(",");
                    apuesta.ingresarApuesta(datos);
                }
                
                fr.close();
                                
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
    
    public static void guardarArchivo(Component container, JTextArea txArea){

        try {

            if (archivo!=null) {

                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(txArea.getText());
                bw.close();

            } else {
                JFileChooser fileChosser = new JFileChooser();
                fileChosser.showSaveDialog(container);
                archivo = new File(fileChosser.getSelectedFile() + ".html");                

                BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(txArea.getText());
                bw.close();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    

}
