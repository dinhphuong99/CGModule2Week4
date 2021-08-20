package exercise.copy_file_text;

import exercise.read_file_csv.Country;

import java.io.*;
import java.util.ArrayList;

public class CopyFileText {
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

    static ArrayList<String> list = new ArrayList<>();
    public static void readFile(String filePath){
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
            createFile(filePath);
        }
    }

    public static void writeFile(String filePath){
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i) + "\n");
            }
            bufferedWriter.close();
            System.out.println("Copy complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createFile("D:\\Intellij\\CodeGymBT\\CGModule2Week4\\io_text_file\\src\\exercise\\copy_file_text\\sourceFile.txt");
        createFile("D:\\Intellij\\CodeGymBT\\CGModule2Week4\\io_text_file\\src\\exercise\\copy_file_text\\targetFile.txt");

        readFile("D:\\Intellij\\CodeGymBT\\CGModule2Week4\\io_text_file\\src\\exercise\\copy_file_text\\sourceFile.txt");
        writeFile("D:\\Intellij\\CodeGymBT\\CGModule2Week4\\io_text_file\\src\\exercise\\copy_file_text\\targetFile.txt");
    }
}
