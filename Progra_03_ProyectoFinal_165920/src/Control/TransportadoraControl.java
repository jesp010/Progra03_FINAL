package Control;

import AccesoDatos.TransportadorasDAO;
import ObjetosNegocio.Transportadora;
import java.util.ArrayList;

public class TransportadoraControl {

    private TransportadorasDAO transportadorasDAO;

    public TransportadoraControl() {
        this.transportadorasDAO = new TransportadorasDAO();
    }

    public ArrayList<Transportadora> findAll() {
        return this.transportadorasDAO.findAll();
    }

    public Transportadora findByCode(int code) {
        return this.transportadorasDAO.findByCode(code);
    }

    public boolean insertOne(Transportadora p) {
        return this.transportadorasDAO.insertOne(p);
    }

    public boolean delete(int codigo) {
        return this.transportadorasDAO.delete(codigo);
    }
}
