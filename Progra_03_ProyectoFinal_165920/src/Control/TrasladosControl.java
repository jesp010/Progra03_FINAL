package Control;

import AccesoDatos.TrasladosDAO;
import ObjetosNegocio.Traslado;
import java.util.ArrayList;

public class TrasladosControl {

    private TrasladosDAO trasladosDAO;

    public TrasladosControl() {
        this.trasladosDAO = new TrasladosDAO();
    }

    public ArrayList<Traslado> findAll() {
        return this.trasladosDAO.findAll();
    }

    public Traslado findByCode(int code) {
        return this.trasladosDAO.findByCode(code);
    }

    public boolean insertOne(Traslado t) {
        return this.trasladosDAO.insertOne(t);
    }

    public boolean delete(int codigo) {
        return this.trasladosDAO.delete(codigo);
    }
}
