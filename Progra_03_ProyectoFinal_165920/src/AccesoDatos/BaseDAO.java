package AccesoDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class BaseDAO {

    public static boolean writeFile(String fileName, String line) {
        try {
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(line + "\n");
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean createFile(String name) {
        File file = new File(name);
        try {
            if (!file.exists()) {
                file.createNewFile();
                //System.out.println("File created successfully!");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ArrayList<String> readFile(String fileName) {
        int counter = 0;
        ArrayList<String> fileLines = new ArrayList<>();

        try {
            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String data;
            while ((data = br.readLine()) != null) {
                fileLines.add(data);
            }
            fstream.close();
            in.close();
            br.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileLines;
    }

    public static int getRandomCode() {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        System.out.println(n);
        return n;
    }
}
