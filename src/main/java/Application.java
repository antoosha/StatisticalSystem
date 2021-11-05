import business.InputArgumentsParser;
import cli.Devider;

public class Application {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Three arguments expected.");
        } else {
            InputArgumentsParser iap = new InputArgumentsParser();
            if(!InputArgumentsParser.parseArgs(args[0], args[1], args[2])){
                System.err.println("Arguments are not correct.");
            }
            Devider devider = new Devider(iap.getNameOfInFile(), iap.getListOfTasks(), iap.getListOfOutFormats());
            devider.processRequests();
        }
    }
}
