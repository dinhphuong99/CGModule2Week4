package practice.copy_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
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

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[8];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //System.out.printf("Enter source file:");
        //D:\Intellij\CodeGymBT\io_binary_file_and_serialization\src\practice\copy_file\destinationFile.bin
        String sourcePath = "D:\\Intellij\\CodeGymBT\\io_binary_file_and_serialization\\src\\" +
                "practice\\copy_file\\destinationFile.bin";
        //System.out.printf("Enter destination file:");
        //D:\Intellij\CodeGymBT\io_binary_file_and_serialization\src\practice\copy_file\sourceFile.bin
        String destPath = "D:\\Intellij\\CodeGymBT\\io_binary_file_and_serialization\\src\\practice\\copy_file\\sourceFile.bin";

        createFile(sourcePath);
        createFile(destPath);

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try {
            copyFileUsingStream(sourceFile, destFile);
//            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            //copyFileUsingStream(sourceFile, destFile);
            System.out.printf("Copy completed");
        } catch (IOException ioe) {
            System.out.printf("Can't copy that file");
            System.out.printf(ioe.getMessage());
        }
    }
}
