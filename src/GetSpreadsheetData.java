import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.Path.of;

public class GetSpreadsheetData {
    public static void createSheet() throws IOException {

        File postProData = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\"+PostProSorter.model+"\\"+PostProSorter.baseline+"\\PostProData.txt");
        postProData.createNewFile();
    }
    public static void writeToPostProFile(String fileName) throws IOException {
        FileWriter editPostProFile = new FileWriter("\\\\NAS2EC52B\\AeroSingle\\CFD\\"+PostProSorter.model+"\\"+PostProSorter.baseline+"\\PostProData.txt", true);
    editPostProFile.write(fileName + ":  " + returnCl(fileName) + ", " +returnCd(fileName)+ ", " + returnEfficiency(fileName)  + ", "+returnCoP(fileName)+", " + returnBalance(fileName) +"\n");
    editPostProFile.close();
    }

    public static String returnCl(String folderName) throws IOException {
     File dst = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\PostProSortFolder\\"+folderName+"\\PostPro\\cl_lift_coefficient Monitor Plot.csv");

        String cl = Files.readAllLines(Paths.get(dst.getPath())).get(3000);
       cl = cl.replace("3000.0,","");
    return cl;}
    public static String returnCd(String folderName) throws IOException {
        File dst = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\PostProSortFolder\\"+folderName+"\\PostPro\\cd_drag_coefficient Monitor Plot.csv");

        String cP = Files.readAllLines(Paths.get(dst.getPath())).get(3000);
        cP = cP.replace("3000.0,","");
        return cP;}
    public static String returnCoP(String folderName) throws IOException {
        File dst = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\PostProSortFolder\\"+folderName+"\\PostPro\\CP_XYZ.csv");
        String coP = Files.readAllLines(Paths.get(dst.getPath())).get(3000);
        coP = coP.replace("3000.0,","");
        String[] copArray = coP.split(",");
        double copDouble = Double.parseDouble(copArray[0]);
                copDouble = Math.abs(((copDouble)/1.53)*100);
        coP = String.valueOf(copDouble);
        return coP;
    }
    public static String returnEfficiency(String folderName) throws IOException {
        float eff = Float.parseFloat(returnCl(folderName)) / Float.parseFloat(returnCd(folderName));
        String effString = Float.toString(eff);
        return effString;
    }
    public static String returnBalance(String folderName) throws IOException {
        double balance = Math.abs((Double.parseDouble(returnCoPZ(folderName))/1.53) * (100/Double.parseDouble(returnEfficiency(folderName))) + Double.parseDouble(returnCoP(folderName)));
        String effString = Double.toString(balance);
        return effString;
    }
    public static String returnCoPZ(String folderName) throws IOException {
        File dst = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\PostProSortFolder\\"+folderName+"\\PostPro\\CP_XYZ.csv");
        String coP = Files.readAllLines(Paths.get(dst.getPath())).get(3000);
        coP = coP.replace("3000.0,","");
        String[] copArray = coP.split(",");
        return copArray[2];
    }

    }



