package ObjetosNegocio;

import java.util.Random;

public class Quimico {

    private int codigo;
    private String nombre;

    public Quimico(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public Quimico(String nombre) {
        this.codigo = getRandomCode();
        this.nombre = nombre;
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

    private static int getRandomCode() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        System.out.println(n);
        return n;
    }

    @Override
    public String toString() {
        return "Quimico{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
}
