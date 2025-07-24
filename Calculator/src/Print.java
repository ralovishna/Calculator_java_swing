import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter no : ");
        String no = scanner.nextLine();

        if(checkNumber(no))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean checkNumber(String no) {
        for (int i = 0; i < 9; i++) {
            if (!(isDigit(Character.getNumericValue(no.charAt(i)))))
                return false;
        }
        return true;
    }
}
