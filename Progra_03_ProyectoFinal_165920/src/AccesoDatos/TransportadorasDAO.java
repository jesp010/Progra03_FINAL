package AccesoDatos;

import ObjetosNegocio.Transportadora;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TransportadorasDAO {

    private final String TRANSPORTADORAS_FILENAME = "transportadoras.txt";

    public ArrayList<Transportadora> findAll() {
        ArrayList<Transportadora> transportadoras = new ArrayList<>();
        boolean created = BaseDAO.createFile(TRANSPORTADORAS_FILENAME);

        if (created) {
            ArrayList<String> transportadoras_tmp = BaseDAO.readFile(TRANSPORTADORAS_FILENAME);
            for (String s : transportadoras_tmp) {
                String[] transportadora = s.split("_");
                int codigo = Integer.parseInt(transportadora[0]);
                String nombre = transportadora[1];
                String direccion = transportadora[2];
                String telefono = transportadora[3];
                transportadoras.add(new Transportadora(codigo, nombre, direccion, telefono));
            }
        }

        return transportadoras;
    }

    public Transportadora findByCode(int code) {
        for (Transportadora t : findAll()) {
            if (t.getCodigo() == code) {
                return t;
            }
        }
        return null;
    }

    public boolean insertOne(Transportadora p) {
        String line = p.getCodigo() + "_" + p.getNombre() + "_" + p.getDireccion() + "_" + p.getNumeroTelefono();
        return BaseDAO.writeFile(TRANSPORTADORAS_FILENAME, line);
    }
    
    public boolean delete(int codigo) {
        File inputFile = new File(TRANSPORTADORAS_FILENAME);
        File tempFile = new File("transportadoras_tmp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            Transportadora t = findByCode(codigo);

            String lineToRemove
                    = t.getCodigo() + "_" + t.getNombre() + "_" + t.getDireccion() + "_" + t.getNumeroTelefono();
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
