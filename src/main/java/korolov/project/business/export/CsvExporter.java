package korolov.project.business.export;

public class CsvExporter implements IExporter{
    private final String fileToExport;

    public CsvExporter(String fileToExport) {
        this.fileToExport = fileToExport;
    }

    @Override
    public void export() {
        //TODO
    }
}
