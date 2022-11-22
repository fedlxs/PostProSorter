
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

            copyToAeroSingle(files[i], folderSelector(files[i]));
            copyToDropBox(files[i], folderSelector(files[i]));
            System.out.println("Copied " + files[i].getName());
           // GetSpreadsheetData.copySheet();

        }

    }
    public String folderSelector(File file){
        String folderSelection = "";
        if (file.getName().contains("FW")) {
            folderSelection = "Frontwing";
        } else if (file.getName().contains("SW")) {
            folderSelection = "Undertray";
        } else if (file.getName().contains("RW")) {
            folderSelection = "Rearwing";
        } else if (file.getName().contains("D_")) {
            folderSelection = "Diffusor";
        } else if (file.getName().contains("N")) {
            folderSelection = "Bodywork";
        } else if (file.getName().contains("DT")) {
            folderSelection = "Bodywork";
        } else if (file.getName().contains("WP")) {
            folderSelection = "Wheelplate";
        }
    return folderSelection;
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