/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.Clases;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author kenlu
 */
public class ManejoExcel {
    
    public List<Clases> importDataClases(Sheet hoja) throws Exception {
        List<Clases> list = new ArrayList<>();
        Clases filaClase;

        int nRows = hoja.getLastRowNum(); // Toma el número de filas de la hoja enviada.
        for (int i = 1; i <= nRows; i++) {
            filaClase = new Clases();
            try {
                String error = "";
                try {
                    filaClase.setGrupo(hoja.getRow(i).getCell(0).toString().trim());
                } catch (Exception e) {
                    error += " GRUPO";
                }
                try {
                    filaClase.setMateria(hoja.getRow(i).getCell(1).toString().trim());
                } catch (Exception e) {
                    error += ";MATERIA";
                }
                try {
                    filaClase.setDocente(hoja.getRow(i).getCell(2).toString().trim());
                } catch (Exception e) {
                    filaClase.setDocente(null);
                }
                try {
                    filaClase.setLunes(hoja.getRow(i).getCell(3).toString().trim());
                } catch (Exception e) {
                    filaClase.setLunes(null);
                }
                try {
                    filaClase.setMartes(hoja.getRow(i).getCell(4).toString().trim());
                } catch (Exception e) {
                    filaClase.setMartes(null);
                }
                try {
                    filaClase.setMiercoles(hoja.getRow(i).getCell(5).toString().trim());
                } catch (Exception e) {
                    filaClase.setMiercoles(null);
                }
                try {
                    filaClase.setJueves(hoja.getRow(i).getCell(6).toString().trim());
                } catch (Exception e) {
                    filaClase.setJueves(null);
                }
                try {
                    filaClase.setViernes(hoja.getRow(i).getCell(7).toString().trim());
                } catch (Exception e) {
                    filaClase.setViernes(null);
                }
                try {
                    filaClase.setSabado(hoja.getRow(i).getCell(8).toString().trim());
                } catch (Exception e) {
                    filaClase.setSabado(null);
                }
                try {
                    filaClase.setDomingo(hoja.getRow(i).getCell(9).toString().trim());
                } catch (Exception e) {
                    filaClase.setDomingo(null);
                }
                list.add(filaClase);
            } catch (Exception e) {
                System.out.println("ERRORES");
            }
        }

        return list;
    }
    
    
     public boolean esExcel(String archivo) {
        if (archivo.substring(archivo.length() - 4).equals("xlsx")) {
            return true;
        } else {
            return false;
        }
     }
    
    
}
