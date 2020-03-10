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
public class tblBiseccion extends AbstractTableModel{
    private String columnas[]={"iteracion", "xi", "xs", "xr", "f(xi)", "f(xr)", "Producto", "error"};
    private ArrayList<csBiseccion>lista=null;

    public tblBiseccion(ArrayList<csBiseccion>lista) {
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
        
        csBiseccion registro = this.lista.get(fila);
        switch(columna){
        
            case 0:
                return registro.getIteracion();
            
            case 1:
                return registro.getXi();
                
            case 2:
                return registro.getXs();
                
            case 3:
                return registro.getXr();
                
            case 4:
                return registro.getFxi();
                
            case 5:
                return registro.getFxr();
                
            case 6:
                return registro.getProducto();
                
            case 7:
                return registro.getError();
        }
        
        return null;
    }

    @Override
    public String getColumnName(int i) {
        return  this.columnas[i];
    }
    
    
    

}
