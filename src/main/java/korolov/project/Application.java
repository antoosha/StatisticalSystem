package korolov.project;

import korolov.project.business.InputArgumentsParser;
import korolov.project.cli.Devider;

public class Application {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Three arguments expected.");
            System.exit(1);
        } else {
            InputArgumentsParser iap = new InputArgumentsParser();
            if (!iap.parseArgs(args[0], args[1], args[2])) {
                System.err.println("Arguments are not correct.");
                throw new IllegalArgumentException("Arguments are not correct");
            }
            Devider devider = new Devider(iap.getNameOfInFile(), iap.getListOfTasks(), iap.getListOfOutFormats());
            devider.processRequests();
        }
    }
}
