package korolov.project.business.export;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class JsonExporter implements IExporter {
    public JsonExporter() {
    }

    @Override
    public void export(Object dataToExport, String task, final String directoryToExport) throws IOException {
        Gson gson = new Gson();
        try (FileWriter fw = new FileWriter(directoryToExport + "/" + task + "exportedDataStaticticalSystem.json")) {
            fw.write(gson.toJson(dataToExport));
            fw.flush();
        }
    }

}
