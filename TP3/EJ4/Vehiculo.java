package TP3.EJ4;

public class Vehiculo {

    private String patente;
    private String marca;
    private int anioFabricacion;

    public Vehiculo() {
        
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public int getAnioFabricacion() {
        return this.anioFabricacion;
    }
    
}
