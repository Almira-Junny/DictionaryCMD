import java.io.*;
import java.util.*;

public class Utils {
    public static Scanner readFile(String filePath) {
        File file = new File(filePath);
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error: Can't open " + filePath);
        }
        return null;
    }
}
