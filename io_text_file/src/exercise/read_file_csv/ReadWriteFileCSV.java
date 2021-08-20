package exercise.read_file_csv;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadWriteFileCSV {
    static ArrayList<Country> listCountry = new ArrayList<>();
    public static void readFile(String filePath){
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                Country country = new Country(Integer.parseInt(words[0]),words[1],words[2]);
                listCountry.add(country);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
            createFile(filePath);
        }
    }

    public void writeFile(String filePath){
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Country country:
                 listCountry) {
                bufferedWriter.write(country.getId()+ "," + country.getCode()
                        + "," + country.getName() + "\n");
            }
            //bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createFile("D:\\Intellij\\CodeGymBT\\CGModule2Week4\\" +
                "io_text_file\\src\\exercise\\read_file_csv\\file.csv");

        readFile("D:\\Intellij\\CodeGymBT\\CGModule2Week4\\" +
                "io_text_file\\src\\exercise\\read_file_csv\\file.csv");

        for (Country country:
             listCountry) {
            System.out.println(country);
        }
    }
}
