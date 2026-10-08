package model;
import java.sql.Date;

public class anime {
    private String nombre;
    private String descripcion;
    private Date data;
    private int puntuacion;


    public anime(String nombre, String descripcion, Date data, int puntuacion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.data = data;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public Date getData() {
        return data;
    }
    public int getPuntuacion() {
        return puntuacion;
    }




}
