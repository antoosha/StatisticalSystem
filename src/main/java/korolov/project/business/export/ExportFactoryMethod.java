package korolov.project.business.export;

import korolov.project.business.find.*;

import java.util.Locale;
import java.util.Optional;

public class ExportFactoryMethod {
    private final String format;

    public ExportFactoryMethod(String format) {
        this.format = format;
    }

    public Optional<IExporter> getExporter() {
        IExporter result;
        switch (format.toUpperCase(Locale.ROOT)) {
            case "JSON" -> {
                result = new JsonExporter();
            }
            case "TXT" -> {
                result = new TextExporter();
            }
            case "CSV" -> {
                result = new CsvExporter();
            }
            default -> {
                result = null;
            }

        }
        return Optional.ofNullable(result);
    }
}
