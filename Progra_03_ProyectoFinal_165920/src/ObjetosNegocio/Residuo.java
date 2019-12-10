package ObjetosNegocio;

import java.util.ArrayList;
import java.util.Random;

public class Residuo {

    private int codigo;
    private String nombre;
    private float cantidadMG;
    private Productora productora;
    private ArrayList<Quimico> quimicos;

    public Residuo(int codigo, String nombre, float cantidadMG, Productora productora, ArrayList<Quimico> quimicos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadMG = cantidadMG;
        this.productora = productora;
        this.quimicos = quimicos;
    }

    public Residuo(String nombre, float cantidadMG, Productora productora, ArrayList<Quimico> quimicos) {
        this.codigo = getRandomCode();
        this.nombre = nombre;
        this.cantidadMG = cantidadMG;
        this.productora = productora;
        this.quimicos = quimicos;
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

    public float getCantidadMG() {
        return cantidadMG;
    }

    public void setCantidadMG(float cantidadMG) {
        this.cantidadMG = cantidadMG;
    }

    public Productora getProductora() {
        return productora;
    }

    public void setProductora(Productora productora) {
        this.productora = productora;
    }

    public ArrayList<Quimico> getQuimicos() {
        return quimicos;
    }

    public void setQuimicos(ArrayList<Quimico> quimicos) {
        this.quimicos = quimicos;
    }

    private static int getRandomCode() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        System.out.println(n);
        return n;
    }

    @Override
    public String toString() {
        return "Residuo{" + "codigo=" + codigo + ", nombre=" + nombre + ", cantidadMG=" + cantidadMG + ", productora=" + productora + ", quimicos=" + quimicos + '}';
    }
}
