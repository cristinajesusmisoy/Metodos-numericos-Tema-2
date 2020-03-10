
package tema_2;

public class csBiseccion {
    
   private int iteracion;
   private double xi;
   private double xs;
   private double xr;
   private double fxi;
   private double fxr;
   private double producto;
   private double error;

    public int getIteracion() {
        return iteracion;
    }

    public void setIteracion(int iteracion) {
        this.iteracion = iteracion;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public double getXs() {
        return xs;
    }

    public void setXs(double xs) {
        this.xs = xs;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getFxi() {
        return fxi;
    }

    public void setFxi(double fxi) {
        this.fxi = fxi;
    }

    public double getFxr() {
        return fxr;
    }

    public void setFxr(double fxr) {
        this.fxr = fxr;
    }

    public double getProducto() {
        return producto;
    }

    public void setProducto(double producto) {
        this.producto = producto;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "csBiseccion{" + "iteracion=" + iteracion + ", xi=" + xi + ", xs=" + xs + ", xr=" + xr + ", fxi=" + fxi + ", fxr=" + fxr + ", producto=" + producto + ", error=" + error + '}'+"\n";
        
        
    }
   
    
   
    

}
