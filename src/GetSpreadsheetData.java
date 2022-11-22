import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Path.of;

public class GetSpreadsheetData {
    public static void copySheet(String destination) throws IOException {
        Files.copy(Path.of("\\\\NAS2EC52B\\AeroSingle\\CFD\\22E\\Baseline 3\\00_Copyfolder\\PostPro\\22E_B3_K_Postpro.xlsm"), Path.of("\\\\NAS2EC52B\\AeroSingle\\CFD\\"+PostProSorter.model+"\\"+PostProSorter.baseline+"\\"+destination));

    }
}
