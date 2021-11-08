package korolov.project.business.export;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Service, which exports data in JSON format.
 */
public class JsonExporter implements IExporter {
    public JsonExporter() {
    }

    @Override
    /**
     * Exporting method.
     * @throws IOException if it could not write data.
     */
    public void export(Object dataToExport, String task, final String directoryToExport) throws IOException {
        Gson gson = new Gson();
        String fileName = task + "exportedDataStaticticalSystem.json";
        try (FileWriter fw = new FileWriter(Path.of(directoryToExport, fileName).toAbsolutePath().toString())) {
            fw.write(gson.toJson(dataToExport));
            fw.flush();
        }
    }

}
