package ObjetosNegocio;

import java.util.Date;
import java.util.Random;

public class Traslado {

    private int codigo;
    private Residuo residuo;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private String tratamientoPosterior;
    private Transportadora transportadora;
    private String medioTransporte;

    public Traslado(int codigo, Residuo residuo, String origen, String destino, Date fechaSalida, Date fechaLlegada, String tratamientoPosterior, Transportadora transportadora, String medioTransporte) {
        this.codigo = codigo;
        this.residuo = residuo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.tratamientoPosterior = tratamientoPosterior;
        this.transportadora = transportadora;
        this.medioTransporte = medioTransporte;
    }
    
    public Traslado(Residuo residuo, String origen, String destino, Date fechaSalida, Date fechaLlegada, String tratamientoPosterior, Transportadora transportadora, String medioTransporte) {
        this.codigo = getRandomCode();
        this.residuo = residuo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.tratamientoPosterior = tratamientoPosterior;
        this.transportadora = transportadora;
        this.medioTransporte = medioTransporte;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Residuo getResiduo() {
        return residuo;
    }

    public void setResiduo(Residuo residuos) {
        this.residuo = residuos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getTratamientoPosterior() {
        return tratamientoPosterior;
    }

    public void setTratamientoPosterior(String tratamientoPosterior) {
        this.tratamientoPosterior = tratamientoPosterior;
    }

    public Transportadora getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(Transportadora transportadora) {
        this.transportadora = transportadora;
    }

    public String getMedioTransporte() {
        return medioTransporte;
    }

    public void setMedioTransporte(String medioTransporte) {
        this.medioTransporte = medioTransporte;
    }

    private static int getRandomCode() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        System.out.println(n);
        return n;
    }

    @Override
    public String toString() {
        return "Traslado{" + "codigo=" + codigo + ", residuo=" + residuo + ", origen=" + origen + ", destino=" + destino + ", fechaSalida=" + fechaSalida + ", fechaLlegada=" + fechaLlegada + ", tratamientoPosterior=" + tratamientoPosterior + ", transportadora=" + transportadora + ", medioTransporte=" + medioTransporte + '}';
    }
}
