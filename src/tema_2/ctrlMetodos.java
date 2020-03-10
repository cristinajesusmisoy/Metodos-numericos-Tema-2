/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tema_2;

import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ctrlMetodos {
    
//METODOS DE BISECCION    
public ArrayList<csBiseccion> Biseccion(double li, double ls, double errorDeseado, int iteraciones){
  
    double producto;
    double errorCalculado=1;
    int  iteracion = 0;
    double  xAnterior;
    
    ArrayList<csBiseccion> lista = null;
    
    producto = this.getFx(li)*this.getFx(ls);
    if (producto<0) {
        
        lista= new ArrayList<csBiseccion>();
        while(errorCalculado>=errorDeseado && iteraciones>0){
            
            csBiseccion fila= new csBiseccion();
            
            fila.setIteracion(iteracion+1);
            iteracion ++;
            
            fila.setXi(li);
            
            fila.setXs(ls);
            
            fila.setXr((li+ls)/2);
            
            fila.setFxi(this.getFx(li));
            
            fila.setFxr(this.getFx(fila.getXr()));
            
            fila.setProducto(fila.getFxi()*fila.getFxr());
            
            if (fila.getFxi()*fila.getFxr()>0) {
                
                xAnterior=li;
                li=fila.getXr();
                
            }
            
            else    {
            
             xAnterior=ls;   
             ls=fila.getXr();
                
            }
            
            errorCalculado = this.getErrorRelativo(fila.getXr(), xAnterior);
            fila.setError(errorCalculado);
            
            lista.add(fila);
            System.out.println(fila.toString());
            
          iteraciones--;  
          
        }
        
        return lista;
    }
    else    {
    return null;
    }
    
}

private double getFx(double x){
    
return (668.061/x)*(1-Math.exp(-1*(x/68.1)*10))-40;

}

private double getErrorRelativo(double xActual, double xAnterior){
return Math.abs((xActual-xAnterior)/xActual);

}

//METODOS DE PUNTO FIJO
public ArrayList<csPuntoFijo> PuntoFijo(double xi, double errorDeseado, int iteraciones){
    
    double errorCalculado=1;
    int  iteracion = 0;
    double  Gxi;
    
    ArrayList<csPuntoFijo> lista = null;
    
        
        lista= new ArrayList<csPuntoFijo>();
        while(errorCalculado >= errorDeseado && iteraciones>0){
            
            csPuntoFijo fila= new csPuntoFijo();
            
            fila.setIteracion(iteracion+1);
            iteracion ++;
            
            fila.setXi(xi);
            
            fila.setGxi(this.getXIMAS1(xi));
            
            errorCalculado = this.getError2(xi, fila.getGxi());
            fila.setError(errorCalculado);
            
            lista.add(fila);
            System.out.println(fila.toString());
            
            xi = fila.getGxi();
        
          iteraciones--;
            
        }
        
        return lista;
    }

    private double getXIMAS1(double xi)
  {
     return Math.exp(-1*(xi));
  }
    
    private double getError2(double xi, double ximasuno)
  {
     return Math.abs((ximasuno-xi)/ximasuno);
  }
    
    //METODOS DE NEWTON
    public ArrayList<csNewton> Newton(double xo, double error){

        double errorCalculado = 1;
        double xanterior; 
        ArrayList<csNewton> lista;
        int i = 1;
        lista = new ArrayList<csNewton>();
        while (errorCalculado > error) {
            csNewton fila = new csNewton();
            fila.setI(i); 
            fila.setXo(xo); 
            double fxo = this.Funcion1(fila.getXo());
            double fxdo = this.Funcion2(fila.getXo());
            fila.setFx(fxo); 
            fila.setDfx(fxdo); 
            fila.setRes(fila.getXo() - (fxo / fxdo));
            xanterior = fila.getXo(); 
            xo = fila.getRes();          
            if (i > 1) {
                      
                errorCalculado = Math.abs((fila.getRes() - fila.getXo()) / fila.getRes());
                fila.setError(errorCalculado);

            } else {
                fila.setError(errorCalculado);
            }
            lista.add(fila);
            i++;
        }
        if (errorCalculado < error) {
            return lista;
        } else {
            return null;
        }

    }
       
public double Funcion1(double x) {
        return Math.pow(2.7182818284590452353602874713527, -x) - x;
    }

    public double Funcion2(double x) {
        return -Math.pow(2.7182818284590452353602874713527, -x) - 1;
    }
    
//METODOS DE SECANTE
    public ArrayList<csSecante> Secante(double x0,double x1, double errorDeseado){
       double error = 1;
       double xanterior; 
       
        ArrayList<csSecante> lista;
        int i = 1;
        lista = new ArrayList<csSecante>();
     
        while (error> errorDeseado) {
            csSecante fila = new csSecante();
            fila.setId(i); 
            fila.setM1(x0);
            fila.setM2(x1);
            double funcionAB = this.FuncionSecante(fila.getM1());
            fila.setM3(funcionAB);
            double restDeno= fila.getM1() - fila.getM2();
            fila.setM4(restDeno);
            
            double funcionCD = this.FuncionSecante(fila.getM2());
            fila.setM5(funcionCD);
            double ProdF = fila.getM5() * fila.getM4();
            fila.setM6(ProdF);
           
            
            double restG = fila.getM3() - fila.getM5();
            fila.setM7(restG);
           
       
            double raizH = fila.getM2() - fila.getM6() / fila.getM7();
            fila.setM8(raizH);

            
                error = Math.abs((fila.getM8() - fila.getM2()) / fila.getM8());
                fila.setId(error);
            

            x0= fila.getM2();

           
            x1 = fila.getM8();
            lista.add(fila);
            i++;
        }
       
         return lista;
    }
    public double FuncionSecante(double x) {
        return Math.pow(2.7182818284590452353602874713527, -Math.pow(x, 2)) - x;
    }
} //Fin de la clase principal
