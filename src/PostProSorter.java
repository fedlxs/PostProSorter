import java.io.IOException;
import java.util.Scanner;

public class PostProSorter {
public static final String baseline = "Baseline 3";
public static String model = "22E";

    public static void main(String[] args) throws IOException {

        System.out.println("Please wait while we sort your shit, in the meantime do not close this window :)");

         Sort sortingModule = new Sort();
        sortingModule.sort();
        System.out.println("Press Enter to close the program...");
        try{
         System.in.read();
        }catch(Exception e){

        }
    }

}
