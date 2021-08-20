package optional;

import practice.read_write_binary_file.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFile {
    public static ArrayList readDataFromFile(String path){
        ArrayList list = new ArrayList();
        try {
            InputStream in = new FileInputStream(path);

            byte[] bytes = new byte[10];
            int i = -1;
            while ((i = in.read(bytes)) != -1) {
                // Tạo String từ các byte đọc được
                String s = new String(bytes, 0, i);
                list.add(s);
            }
            in.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return list;
    }

    public static void writeToFile(String path, ArrayList <String> list) {
        try {
            OutputStream os = new FileOutputStream(path);
            ArrayList<byte[]> arrayList = new ArrayList<>();

            for (String s : list) {
                byte[] bytes = new byte[s.length()];
                byte[] byteDown = new byte[]{13, 10};

                for (int j = 0; j < s.length(); j++) {
                    bytes[j] = (byte) s.charAt(j);
                }

                arrayList.add(bytes);
                arrayList.add(byteDown);
            }

            for (byte[] bytes : arrayList) {
                os.write(bytes);
                os.flush();
            }

            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createFile("writeCopy.bin");
        createFile("readCopy.bin");

        ArrayList arrayList = readDataFromFile("readCopy.bin");
        writeToFile("writeCopy.bin",arrayList);
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
}
