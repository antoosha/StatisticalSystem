package korolov.project.business.export;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

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
        String fileName = task + "exportedDataStaticticalSystem.txt";
        try (FileWriter fw = new FileWriter(Path.of(directoryToExport, fileName).toAbsolutePath().toString())) {
            fw.write(dataToExport.toString());
            fw.flush();
        }
    }
}
