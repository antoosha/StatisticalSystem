package korolov.project.business.export;

import java.io.FileWriter;
import java.io.IOException;

public class TextExporter implements IExporter {
    public TextExporter() {
    }

    @Override
    public void export(Object dataToExport) throws IOException {
        try(FileWriter fw = new FileWriter("exportedDataStaticticalSystem.txt")){
            fw.write(dataToExport.toString());
        }
    }
}
