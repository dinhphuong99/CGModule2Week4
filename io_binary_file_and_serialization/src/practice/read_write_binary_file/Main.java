package practice.read_write_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }

    public static void writeToFile(String path, List<Student> products) {
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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Data in file: ");
        List<Student> studentDataFromFile = readDataFromFile("student.bin");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }

//        List<Student> studentList = new ArrayList<>();

        studentDataFromFile.add(new Student(7,"dinghy","sight"));
        studentDataFromFile.add(new Student(8,"dossing","saddles"));
//        studentList.add(new Student(9,"saga","tattered"));

        //this part is serializing the list and writing it to file
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.bin"));
//        System.out.println("Writing information");
//        oos.writeObject(studentDataFromFile);
//        oos.close();
//        System.out.println("Done");

        writeToFile("student.bin",studentDataFromFile);

        //this part deserializes the list from file, and then iterates over its members
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.bin"));
//        System.out.println("reading object");
//        List<Student> list = (List) ois.readObject();
//        ois.close();

        studentDataFromFile = readDataFromFile("student.bin");

        System.out.println("done reading object");
        for (Student stu : studentDataFromFile) {
            System.out.println(stu.getId());
            System.out.println(stu.getName());
            System.out.println(stu.getAddress());
        }

        System.out.println("Data in file: ");
        List<Student> studentDataFromFile1 = readDataFromFile("student.bin");
        for (Student student : studentDataFromFile1){
            System.out.println(student);
        }
    }
}
