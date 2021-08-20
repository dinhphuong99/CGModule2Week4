package exercise;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }

    public static void writeToFile(String path, List<Product> products) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            System.out.println("Writing information");
            oos.writeObject(products);
            oos.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data in file: ");
        List<Product> productDataFromFile = readDataFromFile("product.bin");
        for (Product product : productDataFromFile){
            product.getAllInFor();
        }

        while (true){
            int addId;
            do {
                System.out.println("Nhập vào ID, nhập vào số -1 để dừng: ");
                addId = scanner.nextInt();

                for (Product product : productDataFromFile) {
                    if (product.getID() == addId) {
                        System.out.println("ID đã tồn tại!");
                        addId = -2;
                    }
                }

            } while (addId != -1 && addId < 0);

            if (addId < 0) {
                break;
            }

            System.out.println("Nhập tên sản phẩm: ");
            String addName = (new Scanner(System.in)).nextLine();

            System.out.println("Nhập tên nhà sản xuất: ");
            String addManufacturer = (new Scanner(System.in)).nextLine();

            System.out.println("Nhập mô tả: ");
            String addDescription = (new Scanner(System.in)).nextLine();

            System.out.println("Nhập giá sản phẩm: ");
            float addPrice = (new Scanner(System.in)).nextFloat();

            productDataFromFile.add(new Product(addId,addName,addManufacturer,
                    addDescription,addPrice));
        }
        writeToFile("product.bin",productDataFromFile);

        System.out.println("Nhập tên sản phẩm để tìm: ");
        String findName = (new Scanner(System.in)).nextLine();

        for (Product product : productDataFromFile) {
            if (product.getProductName().equals(findName)) {
                System.out.println("Thông tin sản phẩm: ");
                product.getAllInFor();
            }
        }

        System.out.println("Data in file: ");
        List<Product> productDataFromFile1 = readDataFromFile("product.bin");
        for (Product product : productDataFromFile1){
            product.getAllInFor();
        }
    }
}