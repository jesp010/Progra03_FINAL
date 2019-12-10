package AccesoDatos;

import ObjetosNegocio.Productora;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductorasDAO {

    private final String PRODUCTORAS_FILENAME = "productoras.txt";

    public ArrayList<Productora> findAll() {
        ArrayList<Productora> productoras = new ArrayList<>();
        boolean created = BaseDAO.createFile(PRODUCTORAS_FILENAME);

        if (created) {
            ArrayList<String> productoras_tmp = BaseDAO.readFile(PRODUCTORAS_FILENAME);
            for (String s : productoras_tmp) {
                String[] quimico = s.split("_");
                int codigo = Integer.parseInt(quimico[0]);
                String nombre = quimico[1];
                String direccion = quimico[2];
                String telefono = quimico[3];
                productoras.add(new Productora(codigo, nombre, direccion, telefono));
            }
        }

        return productoras;
    }

    public Productora findByCode(int code) {
        for (Productora p : findAll()) {
            if (p.getCodigo() == code) {
                return p;
            }
        }
        return null;
    }

    public boolean insertOne(Productora p) {
        String line = p.getCodigo() + "_" + p.getNombre() + "_" + p.getDireccion() + "_" + p.getNumeroTelefono();
        return BaseDAO.writeFile(PRODUCTORAS_FILENAME, line);
    }

    public boolean delete(int codigo) {
        File inputFile = new File(PRODUCTORAS_FILENAME);
        File tempFile = new File("productoras_tmp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            Productora p = findByCode(codigo);

            String lineToRemove
                    = p.getCodigo() + "_" + p.getNombre() + "_" + p.getDireccion() + "_" + p.getNumeroTelefono();
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
