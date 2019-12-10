package Control;

import AccesoDatos.QuimicosDAO;
import ObjetosNegocio.Quimico;
import java.util.ArrayList;

public class QuimicoControl {
    private QuimicosDAO quimicosDAO;

    public QuimicoControl() {
        this.quimicosDAO = new QuimicosDAO();
    }
    
    public ArrayList<Quimico> findAll() {
        return this.quimicosDAO.findAll();
    } 
    
    public Quimico findByCode(int code) {
        return this.quimicosDAO.findByCode(code);
    }
    
    public boolean insertOne(Quimico q) {
        return this.quimicosDAO.insertOne(q);
    }
    
     public boolean delete(int codigo) {
         return this.quimicosDAO.delete(codigo);
     }
}
