import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Path.of;

public class GetSpreadsheetData {
    public static void createSheet() throws IOException {
        // Files.copy(Path.of("\\\\NAS2EC52B\\AeroSingle\\CFD\\22E\\Baseline 3\\00_Copyfolder\\PostPro\\22E_B3_K_Postpro.xlsm"), Path.of("\\\\NAS2EC52B\\AeroSingle\\CFD\\"+PostProSorter.model+"\\"+PostProSorter.baseline+"\\"+destination));
        File postProData = new File("C:\\Users\\CFD1\\Documents\\Alex\\PostProData.txt");
        postProData.createNewFile();
    }
    public static void writeToPostProFile(String fileName) throws IOException {
        FileWriter editPostProFile = new FileWriter("C:\\Users\\CFD1\\Documents\\Alex\\PostProData.txt", true);
    editPostProFile.write(fileName + ":  " + returnCl(fileName) + ", " +returnCp(fileName) + "\n");
    editPostProFile.close();
    }

    public static String returnCl(String folderName) throws IOException {
     File dst = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\PostProSortFolder\\"+folderName+"\\PostPro\\cl_lift_coefficient Monitor Plot.csv");

        String cl = Files.readAllLines(Paths.get(dst.getPath())).get(3000);
       cl = cl.replace("3000.0,","");
    return cl;}
    public static String returnCp(String folderName) throws IOException {
        File dst = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\PostProSortFolder\\"+folderName+"\\PostPro\\cd_drag_coefficient Monitor Plot.csv");

        String cP = Files.readAllLines(Paths.get(dst.getPath())).get(3000);
        cP = cP.replace("3000.0,","");
        return cP;}
}

