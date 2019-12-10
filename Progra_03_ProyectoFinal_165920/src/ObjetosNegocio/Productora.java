package ObjetosNegocio;

import java.util.Random;

public class Productora {

    private int codigo;
    private String nombre;
    private String direccion;
    private String numeroTelefono;

    public Productora(int codigo, String nombre, String direccion, String numeroTelefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public Productora(String nombre, String direccion, String numeroTelefono) {
        this.codigo = getRandomCode();
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroTelefono = numeroTelefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    private static int getRandomCode() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        System.out.println(n);
        return n;
    }

    @Override
    public String toString() {
        return "Productora{" + "codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", numeroTelefono=" + numeroTelefono + '}';
    }
}
