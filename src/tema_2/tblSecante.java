/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema_2;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class tblSecante extends AbstractTableModel{
    
    private String []columnas =
    {"i","Xi-1","Xi","f(xi-1)","(xi-1 - xi)","f(xi)","Numerador","Denominador", "Error"};
    private ArrayList<csSecante>lista=null;

    public tblSecante(ArrayList<csSecante>lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {

        return columnas.length;
        
    }

    @Override
    public Object getValueAt(int fila, int columna) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     switch(columna){
         case 0: 
             return this.lista.get(fila).getId();
         case 1:
             return this.lista.get(fila).getM1();
         case 2:
             return this.lista.get(fila).getM2();
         case 3:
             return this.lista.get(fila).getM3();
         case 4:
             return this.lista.get(fila).getM4();
         case 5:
             return this.lista.get(fila).getM5();
         case 6:
             return this.lista.get(fila).getM6();
         case 7:
             return this.lista.get(fila).getM7();
         case 8:
             return this.lista.get(fila).getM8();
         default:return null;     
     }
    }

    @Override
    public String getColumnName(int i) {
        return  this.columnas[i];
    }
    
    
    

}
