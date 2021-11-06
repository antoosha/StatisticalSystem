package korolov.project.business.export;

public class JsonExporter implements IExporter{
    private final String fileToExport;

    public JsonExporter(String fileToExport) {
        this.fileToExport = fileToExport;
    }

    @Override
    public void export() {
        //TODO
    }
}
