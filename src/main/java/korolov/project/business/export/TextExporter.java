package korolov.project.business.export;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Service, which exports data in .txt format.
 */
public class TextExporter implements IExporter {
    public TextExporter() {
    }

    @Override
    /**
     * Exporting method.
     * @throws IOException if it could not write data.
     */
    public void export(Object dataToExport, String task, final String directoryToExport) throws IOException {
        try (FileWriter fw = new FileWriter(directoryToExport + "/" + task + "exportedDataStaticticalSystem.txt")) {
            fw.write(dataToExport.toString());
            fw.flush();
        }
    }
}
