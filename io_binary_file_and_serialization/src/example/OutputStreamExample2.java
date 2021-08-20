package example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import static example.InputStreamExample2.createFile;

public class OutputStreamExample2 {

    public static void main(String[] args) throws IOException {
        String fileTest = "D:\\Intellij\\CodeGymBT\\io_binary_file_and_serialization\\src\\example\\testOut.txt";
        createFile(fileTest);
        // Tạo một luồng nhị phân đầu ra với mục đích ghi thông tin vào file
        OutputStream os = new FileOutputStream(fileTest);
        Scanner scanner = new Scanner(System.in);
        ArrayList<byte[]> arrayList = new ArrayList<>();

        String strEnter;

        while (true){
            System.out.println("Nhập vào chuỗi: ");
            strEnter = scanner.nextLine();

            if (strEnter.length() == 0)
                break;
            byte[] bytes = new byte[strEnter.length()];
            byte[] byteDown = new byte[] {13,10};

            for (int i = 0; i < strEnter.length(); i++) {
                bytes[i] = (byte) strEnter.charAt(i);
            }

            arrayList.add(bytes);
            arrayList.add(byteDown);
        }

        for (byte[] bytes : arrayList) {
            os.write(bytes);
            os.flush();
        }

////         Tạo một mảng byte ,ta sẽ ghi các byte này vào file nói trên .
//        byte[] b1 = new byte[] {(byte) 010101, (byte) 0110111, (byte) 0110111, (byte) 0110111, (byte) 0110111};
//        byte[] b2 = new byte[] { (byte) 0110111, (byte) 0100111, (byte) 0111111};
//        byte[] b3 = new byte[] {13,10}; // Xuống dòng mới
//        byte[] b4 = new byte[] { 'I', '/', 'O' };
////
////        // Ghi cả các byte trong mảng byte[] by vào luồng
//        os.write(b1);
////
////         Đẩy các byte hiện có trên luồng xuống file .
//        os.flush();
////
////         Tiếp tục ghi các byte trong mảng thứ 2 vào luồng
//        os.write(b2);
//        os.write(b3);
//        os.write(b4);
//
//        // Đóng luồng vào công việc ghi thành công .
        os.close();
    }
}
