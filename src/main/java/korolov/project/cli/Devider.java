package korolov.project.cli;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import korolov.project.business.export.ExportFactoryMethod;
import korolov.project.business.export.IExporter;
import korolov.project.business.find.FinderFactoryMethod;
import korolov.project.business.find.IFinder;
import korolov.project.dao.Repository;
import korolov.project.domain.Record;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Main service, which works as Interface, that takes arguments and give tasks for smaller services
 */
public class Devider {
    private final String nameOfInFile;
    private final List<String> listOfTasks;
    private final List<String> listOfOutFormats;
    private final Repository repository = new Repository(Collections.emptyList());
    private final String directoryToExport = "exportDirStatisticalSystem";

    public Devider(String nameOfInFile, List<String> listOfTasks, List<String> listOfOutFormats) {
        this.nameOfInFile = nameOfInFile;
        this.listOfTasks = listOfTasks;
        this.listOfOutFormats = listOfOutFormats;
    }

    public String getNameOfInFile() {
        return nameOfInFile;
    }

    public List<String> getListOfTasks() {
        return listOfTasks;
    }

    public List<String> getListOfOutFormats() {
        return listOfOutFormats;
    }

    /**
     * Method, that reads from file records and run tasks with them.
     * DM - day with maximum number of records.
     * TR - total number of recorded cyclist passes.
     * MP - most frequently driven participation;
     * TD - the total number of cyclists recorded for each day;
     */
    public void processRequests() {
        try (FileReader fileReader = new FileReader(nameOfInFile)) {
            try (CSVReader reader = new CSVReader(fileReader)) {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'.'SSS'Z'");
                String[] nextLine;
                reader.skip(1);
                List<Record> records = new ArrayList<>();
                while ((nextLine = reader.readNext()) != null) {
                    Record record = new Record(
                            nextLine[0],
                            nextLine[1],
                            LocalDateTime.parse(nextLine[2], fmt),
                            LocalDateTime.parse(nextLine[3], fmt),
                            nextLine[4].isEmpty() ? 0 : Integer.parseInt(nextLine[4]));
                    records.add(record);
                }
                repository.setListOfRecords(records);
            }
        } catch (CsvValidationException e) {
            System.err.println("Non valid format of input data.");
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.err.println("File does not found.");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(directoryToExport);
        if (!file.mkdir()) {
            System.err.println("Could not to create directory with exporting files.");
            System.exit(1);
        }

        for (String task : listOfTasks) {
            Optional<IFinder<?>> ifinder = FinderFactoryMethod.getFinder(task, repository);
            if (ifinder.isPresent()) {
                Object dataToExport = ifinder.get().find();
                exportData(dataToExport, task);
            } else {
                System.out.println("Unknown task: " + task);
            }
        }

    }

    private void exportData(Object dataToExport, String task) {
        for (String outFormat : listOfOutFormats) {
            Optional<IExporter> iExporter = ExportFactoryMethod.getExporter(outFormat);

            if (iExporter.isPresent()) {
                try {
                    iExporter.get().export(dataToExport, task, directoryToExport);
                } catch (IOException ioex) {
                    System.out.println("Is not possible to export data with format: " + outFormat);
                    System.err.println(ioex.getMessage());
                }
            } else {
                System.out.println("Unknown export format: " + outFormat);
            }
        }
    }
}
