package Control;

import AccesoDatos.ProductorasDAO;
import ObjetosNegocio.Productora;
import java.util.ArrayList;

public class ProductoraControl {

    private ProductorasDAO productorasDAO;

    public ProductoraControl() {
        this.productorasDAO = new ProductorasDAO();
    }

    public ArrayList<Productora> findAll() {
        return this.productorasDAO.findAll();
    }

    public Productora findByCode(int code) {
        return this.productorasDAO.findByCode(code);
    }

    public boolean insertOne(Productora p) {
        return this.productorasDAO.insertOne(p);
    }

    public boolean delete(int codigo) {
        return this.productorasDAO.delete(codigo);
    }
}
