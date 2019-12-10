package AccesoDatos;

import ObjetosNegocio.Quimico;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuimicosDAO {

    private final String QUIMICOS_FILENAME = "quimicos.txt";

    public ArrayList<Quimico> findAll() {
        ArrayList<Quimico> quimicos = new ArrayList<>();
        boolean created = BaseDAO.createFile(QUIMICOS_FILENAME);

        if (created) {
            ArrayList<String> quimicos_tmp = BaseDAO.readFile(QUIMICOS_FILENAME);
            for (String s : quimicos_tmp) {
                String[] quimico = s.split("_");
                int codigo = Integer.parseInt(quimico[0]);
                String nombre = quimico[1];
                quimicos.add(new Quimico(codigo, nombre));
            }
        }

        return quimicos;
    }

    public Quimico findByCode(int code) {
        ArrayList<Quimico> quimicos = findAll();

        for (Quimico q : quimicos) {
            if (q.getCodigo() == code) {
                return q;
            }
        }
        return null;
    }

    public boolean insertOne(Quimico q) {
        String line = q.getCodigo() + "_" + q.getNombre();
        return BaseDAO.writeFile(QUIMICOS_FILENAME, line);
    }

    public boolean delete(int codigo) {
        File inputFile = new File(QUIMICOS_FILENAME);
        File tempFile = new File("quimicos_tmp.txt");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            
            Quimico q = findByCode(codigo);
            
            String lineToRemove = q.getCodigo() + "_" + q.getNombre();
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
