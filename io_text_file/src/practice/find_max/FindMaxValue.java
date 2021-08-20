package practice.find_max;

import java.util.List;

import static practice.find_max.ReadAndWriteFile.findMax;

public class FindMaxValue {
    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\Intellij\\CodeGymBT\\" +
                "CGModule2Week4\\io_text_file\\src\\practice\\find_max\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\Intellij\\CodeGymBT\\CGModule2Week4\\" +
                "io_text_file\\src\\practice\\find_max\\result.txt", maxValue);
    }
}