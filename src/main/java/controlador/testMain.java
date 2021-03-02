/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author kenlu
 */
public class testMain {

    
    public static void main(String[] args) throws IOException {
        XSSFWorkbook libroNombres = new XSSFWorkbook();
        XSSFSheet hoja = libroNombres.createSheet("Sursazo");
     try {
            FileOutputStream output = new FileOutputStream("ostia" + ".xlsx");

           libroNombres.write(output);
            libroNombres.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
