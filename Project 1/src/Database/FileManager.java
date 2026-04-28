package Database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.join;

public class FileManager {
    private String fileName;
    private String filePath;
    public FileManager(String fileName) {
        this.fileName = fileName.toLowerCase();
        this.filePath = "src/Database/"+this.fileName+".txt";
    }
    private void validateFile() {
        try {
            File file = new File(filePath);
            if(!file.exists()){
                file.createNewFile();
            }
        } catch (Exception e) {
            System.out.println("Error in File: " + this.fileName);
        }
    }
    //Column Extraction
    public List<String> s2l(String data) {
        return List.of(data.split(";"));
    }
    //Row conversion
    public String l2s(List<String> data) {
        return join(";", data);
    }
    public void addData(List<String> data) {
        this.validateFile();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.filePath, true));
            bw.write(l2s(data));
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("Error in writing File: " + this.fileName);
        }
    }
    public List<String> getData() {
        this.validateFile();
        List<String> data = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filePath));
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error in reading File: " + this.fileName);
        }
        return data;
    }
}
