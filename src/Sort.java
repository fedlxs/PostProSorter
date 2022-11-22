
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
            if (files[i].getName().contains("FW")) {
                copyToDropBox(files[i], "Frontwing");
                copyToAeroSingle(files[i], "Frontwing");
                System.out.println("Copied " + files[i].getName());

            } else if (files[i].getName().contains("SW")) {
                copyToDropBox(files[i], "Undertray");
                copyToAeroSingle(files[i], "Undertray");
                System.out.println("Copied " + files[i].getName());

            } else if (files[i].getName().contains("RW")) {
                copyToDropBox(files[i], "Rearwing");
                copyToAeroSingle(files[i], "Rearwing");
                System.out.println("Copied " + files[i].getName());

            } else if (files[i].getName().contains("D")) {
                copyToDropBox(files[i], "Diffusor");
                copyToAeroSingle(files[i], "Diffusor");
                System.out.println("Copied " + files[i].getName());

            } else if (files[i].getName().contains("N")) {
                copyToDropBox(files[i], "Bodywork");
                copyToAeroSingle(files[i], "Bodywork");
                System.out.println("Copied " + files[i].getName());

            } else if (files[i].getName().contains("DT")) {
                copyToDropBox(files[i], "Bodywork");
                copyToAeroSingle(files[i], "Bodywork");
                System.out.println("Copied " + files[i].getName());

            } else if (files[i].getName().contains("WP")) {
                copyToDropBox(files[i], "Bodywork");
                copyToAeroSingle(files[i], "Bodywork");
                System.out.println("Copied " + files[i].getName());

            }
        }

    }

    public void copyToDropBox(File shortenedFolderName, String dropBoxFolderName) throws IOException {
        File src = new File(shortenedFolderName.getPath() + "\\PostPro");
        File dstDropbox = new File("C:\\Users\\CFD2\\Dropbox\\PostPro\\" + PostProSorter.baseline +"\\" + dropBoxFolderName + "\\" + shortenedFolderName.getName() + "\\PostPro");
        FileUtils.copyDirectory(src, dstDropbox);
    }

    public void copyToAeroSingle(File shortenedFolderName, String aeroSingleFolderName) throws IOException {
        File src = new File(shortenedFolderName.getPath() + "\\PostPro");
        File dstAeroSim = new File("\\\\NAS2EC52B\\AeroSingle\\CFD\\" + PostProSorter.model +"\\" + PostProSorter.baseline +"\\" + aeroSingleFolderName + "\\" + shortenedFolderName.getName() + "\\PostPro");
        FileUtils.copyDirectory(src, dstAeroSim);
    }
}