package korolov.project.business.export;

import java.io.IOException;

public interface IExporter {
    void export(Object dataToExport) throws IOException;
}
