package korolov.project.business.export;

import java.io.FileWriter;
import java.io.IOException;

public class TextExporter implements IExporter {
    public TextExporter() {
    }

    @Override
    public void export(Object dataToExport, String task, final String directoryToExport) throws IOException {
        try (FileWriter fw = new FileWriter(directoryToExport + "/" + task + "exportedDataStaticticalSystem.txt")) {
            fw.write(dataToExport.toString());
        }
    }
}
