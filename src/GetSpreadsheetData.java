import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Path.of;

public class GetSpreadsheetData {
    public static void copySheet(String destination) throws IOException {
        Files.copy(Path.of("C:\\Users\\afedy\\Documents\\KA-Race.ing\\Copyfoldertest\\00_CopyFolder\\TesterWorksheet.xlsx"), Path.of(destination));

    }
}
