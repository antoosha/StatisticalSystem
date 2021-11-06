package korolov.project.business.export;

import java.io.IOException;

public interface IExporter {
    void export(Object dataToExport, String task, final String directoryToExport) throws IOException;
}
