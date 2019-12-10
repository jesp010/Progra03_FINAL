package AccesoDatos;

import ObjetosNegocio.Quimico;
import ObjetosNegocio.Residuo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ResiduosDAO {
    
    private final String RESIDUOS_FILENAME = "residuos.txt";
    private ProductorasDAO productorasDAO;
    private QuimicosDAO quimicosDAO;
    
    public ResiduosDAO() {
        this.productorasDAO = new ProductorasDAO();
        this.quimicosDAO = new QuimicosDAO();
    }
    
    public ArrayList<Residuo> findAll() {
        ArrayList<Residuo> residuos = new ArrayList<>();
        boolean created = BaseDAO.createFile(RESIDUOS_FILENAME);
        
        if (created) {
            ArrayList<String> residuos_tmp = BaseDAO.readFile(RESIDUOS_FILENAME);
            for (String s : residuos_tmp) {
                String[] residuo = s.split("_");
                int codigo = Integer.parseInt(residuo[0]);
                String nombre = residuo[1];
                float cantidadMG = Float.parseFloat(residuo[2]);
                int productoraCodigo = Integer.parseInt(residuo[3]);
                String codesQuimicos = residuo[4];
                
                residuos.add(new Residuo(codigo, nombre, cantidadMG, productorasDAO.findByCode(productoraCodigo), getQuimicosByCode(codesQuimicos)));
            }
        }
        
        return residuos;
    }
    
    public Residuo findByCode(int code) {
        for (Residuo r : findAll()) {
            if (r.getCodigo() == code) {
                return r;
            }
        }
        return null;
    }
    
    public boolean insertOne(Residuo r) {
        String line = r.getCodigo() + "_" + r.getNombre() + "_" + r.getCantidadMG() + "_" + r.getProductora().getCodigo() + "_" + getCodesQuimicos(r.getQuimicos());
        return BaseDAO.writeFile(RESIDUOS_FILENAME, line);
    }
    
    private String getCodesQuimicos(ArrayList<Quimico> quimicos) {
        String codes = "";
        for (Quimico q : quimicos) {
            codes += q.getCodigo() + " ";
        }
        codes += "";
        return codes;
    }
    
    private ArrayList<Quimico> getQuimicosByCode(String codes) {
        ArrayList<Quimico> quimicos = new ArrayList<>();
        String[] codesArr = codes.split(" ");
        for (String s : codesArr) {
            quimicos.add(quimicosDAO.findByCode(Integer.parseInt(s)));
        }
        
        return quimicos;
    }
    
    public boolean delete(int codigo) {
        File inputFile = new File(RESIDUOS_FILENAME);
        File tempFile = new File("residuos_tmp.txt");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            Residuo r = findByCode(codigo);
            
            String lineToRemove
                    = r.getCodigo() + "_" + r.getNombre() + "_" + r.getCantidadMG() + "_" + r.getProductora().getCodigo();
            String currentLine;
            
            while ((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
