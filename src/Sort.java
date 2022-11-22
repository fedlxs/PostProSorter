
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.apache.commons.io.FileUtils;
public class Sort {
    public String defaultDirectory = "\\\\NAS2EC52B\\AeroSingle\\CFD\\PostProSortFolder";
    public File f1 = new File(defaultDirectory);
    public int numberOfFolders = f1.list().length;
    public File[] files = f1.listFiles();


    public void sort() throws IOException {
        String destination;

        System.out.println("Running app... ");
        for (int i = 0; i < numberOfFolders; i++) {
            System.out.println(files[i].getPath());
            String folderSelection = "";
            if (files[i].getName().contains("FW")) {
                folderSelection = "Frontwing";
            } else if (files[i].getName().contains("SW")) {
                folderSelection = "Undertray";
            } else if (files[i].getName().contains("RW")) {
                folderSelection = "Rearwing";
            } else if (files[i].getName().contains("D_")) {
                folderSelection = "Diffusor";
            } else if (files[i].getName().contains("N")) {
                folderSelection = "Bodywork";
            } else if (files[i].getName().contains("DT")) {
                folderSelection = "Bodywork";
            } else if (files[i].getName().contains("WP")) {
                folderSelection = "Wheelplate";
            }
            copyToAeroSingle(files[i], folderSelection);
            copyToDropBox(files[i], folderSelection);
            System.out.println("Copied " + files[i].getName());
           // GetSpreadsheetData.copySheet();

        }

    }

    public void copyToDropBox(File shortenedFolderName, String dropBoxFolderName) throws IOException {
        File src = new File(shortenedFolderName.getPath() + "\\PostPro");
        File dstDropbox = new File("C:\\Users\\CFD2\\Dropbox\\PostPro\\" + PostProSorter.baseline +"\\" + dropBoxFolderName + "\\" + shortenedFolderName.getName() + "\\PostPro");
        FileUtils.copyDirectory(src, dstDropbox);
        src = new File(shortenedFolderName.getPath() + "\\STEP");
        FileUtils.copyDirectory(src, dstDropbox);
    }

    public void copyToAeroSingle(File shortenedFolderName, String aeroSingleFolderName) throws IOException {
        File src = new File(shortenedFolderName.getPath() + "\\PostPro");
        File dstAeroSim = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\" + PostProSorter.model +"\\" + PostProSorter.baseline +"\\" + aeroSingleFolderName + "\\" + shortenedFolderName.getName() + "\\PostPro");
        FileUtils.copyDirectory(src, dstAeroSim);
    }
}