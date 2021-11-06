package korolov.project.business.export;

public class TextExporter implements IExporter {
    private final String fileToExport;

    public TextExporter(String fileToExport) {
        this.fileToExport = fileToExport;
    }

    @Override
    public void export() {
        //TODO
    }
}
