package Control;

import AccesoDatos.ResiduosDAO;
import ObjetosNegocio.Residuo;
import java.util.ArrayList;

public class ResiduosControl {

    private ResiduosDAO residuosDAO;

    public ResiduosControl() {
        this.residuosDAO = new ResiduosDAO();
    }

    public ArrayList<Residuo> findAll() {
        return this.residuosDAO.findAll();
    }

    public Residuo findByCode(int code) {
        return this.residuosDAO.findByCode(code);
    }

    public boolean insertOne(Residuo r) {
        return this.residuosDAO.insertOne(r);
    }

    public boolean delete(int codigo) {
        return this.residuosDAO.delete(codigo);
    }
}
