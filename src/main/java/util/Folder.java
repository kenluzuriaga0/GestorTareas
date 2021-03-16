/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Luis.Jose.local
 */
public class Folder {

    public void escribirBytes(byte[] arreglo_bytes, String ruta) {

        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            BufferedOutputStream output = new BufferedOutputStream(archivo);
            System.out.println("largo de arreglo al llegar a escribir bytes: "+arreglo_bytes.length);
           
            output.write(arreglo_bytes);
            
            output.close();
        } catch (FileNotFoundException ex) {

            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
    
    
    public String asignarNombreAleatorio(){
        Random r=new Random();
        String nombre="";
        for(int i=0; i<5; i++){
            nombre=nombre+r.nextInt(100);
        }
        System.out.println(nombre);
        return nombre;
    }
}
