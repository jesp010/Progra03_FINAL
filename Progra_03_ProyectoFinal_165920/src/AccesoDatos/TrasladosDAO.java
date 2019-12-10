package AccesoDatos;

import ObjetosNegocio.Residuo;
import ObjetosNegocio.Transportadora;
import ObjetosNegocio.Traslado;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TrasladosDAO {

    private final String TRASLADOS_FILENAME = "traslados.txt";
    private ResiduosDAO residuosDAO;
    private TransportadorasDAO transportadorasDAO;

    public TrasladosDAO() {
        residuosDAO = new ResiduosDAO();
        transportadorasDAO = new TransportadorasDAO();
    }

    public ArrayList<Traslado> findAll() {
        ArrayList<Traslado> traslados = new ArrayList<>();
        boolean created = BaseDAO.createFile(TRASLADOS_FILENAME);

        if (created) {
            ArrayList<String> traslados_tmp = BaseDAO.readFile(TRASLADOS_FILENAME);
            for (String s : traslados_tmp) {
                String[] traslado = s.split("_");
                int codigo = Integer.parseInt(traslado[0]);
                Residuo residuo = residuosDAO.findByCode(Integer.parseInt(traslado[1]));
                String origen = traslado[2];
                String destino = traslado[3];
                Date fechaSalida = null, fechaLlegada = null;
                try {
                    fechaSalida = new SimpleDateFormat("dd/MM/yyyy").parse(traslado[4]);
                    fechaLlegada = new SimpleDateFormat("dd/MM/yyyy").parse(traslado[5]);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                String tratamientoPosterior = traslado[6];
                Transportadora transportadora = transportadorasDAO.findByCode(Integer.parseInt(traslado[7]));
                String medioTransporte = traslado[8];

                traslados.add(
                        new Traslado(codigo, residuo, origen, destino, fechaSalida, fechaLlegada, tratamientoPosterior, transportadora, medioTransporte));
            }
        }

        return traslados;
    }
    
    public Traslado findByCode(int code) {
        for (Traslado t : findAll()) {
            if (t.getCodigo() == code) {
                return t;
            }
        }
        return null;
    }
    
    public boolean insertOne(Traslado t) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String line = t.getCodigo() + "_" + t.getResiduo().getCodigo() + "_" + t.getOrigen() + "_" + t.getDestino() + "_" + sdf.format(t.getFechaSalida()) + "_" + sdf.format(t.getFechaLlegada()) + "_" + t.getTratamientoPosterior() + "_" + t.getTransportadora().getCodigo() + "_" + t.getMedioTransporte();
        return BaseDAO.writeFile(TRASLADOS_FILENAME, line);
    }
    
    public boolean delete(int codigo) {
        File inputFile = new File(TRASLADOS_FILENAME);
        File tempFile = new File("traslados_tmp.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            Traslado t = findByCode(codigo);

            String lineToRemove = t.getCodigo() + "_" + t.getResiduo().getCodigo() + "_" + t.getOrigen() + "_" + t.getDestino() + "_" + t.getFechaSalida() + "_" + t.getFechaLlegada() + "_" + t.getTratamientoPosterior() + "_" + t.getTransportadora() + "_" + t.getMedioTransporte();

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
