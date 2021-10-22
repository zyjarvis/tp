package seedu.duke;

import seedu.duke.expense.Expense;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Duke {
    private ExpenseList expenseList;
    private static Logger logger = Logger.getLogger("Foo");


    private Duke() {
        ArrayList<Expense> expenses = new ArrayList<>();
        this.expenseList = new ExpenseList(expenses);
    }

    private void run() {
        UI.welcome();
        // log a message at INFO level
        logger.log(Level.INFO, "Duke start processing");
        boolean isExit = false;
        while (!isExit) {
            try {
                logger.log(Level.INFO, "New input to execute");
                String fullCommand = UI.readCommand();
                Execution execution = new Execution(fullCommand);
                execution.execute(expenseList);
                isExit = execution.isExit;
            } catch (InputErrorException d) {
                switch(d.errorType) {
                    case "DateFormatError":
                        InputErrorException.toPrintDateFormatError();
                        break;
                    case "ListCommandFormatError":
                        InputErrorException.toPrintListFormatError();
                        break;
                    case "InValidListTypeCode":
                        InputErrorException.toPrintInValidListTypeCode();
                        break;
                    case "AddCommandFormatWrong":
                        InputErrorException.toPrintAddCommandFormatWrong();
                        break;
                    default:
                        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
