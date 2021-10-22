package seedu.duke;

import seedu.duke.command.AddExpenseCommand;
import seedu.duke.command.DeleteCommand;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Execution {
    protected String fullCommand;
    protected String command;
    protected boolean isExit;

    public Execution(String fullCommand) {
        this.fullCommand = fullCommand;
        this.command = Parser.command(fullCommand);
        this.isExit = false;
    }

    public void execute(ExpenseList expenseList) throws InputErrorException {
        Logger logger = Logger.getLogger("Foo");

        switch (command) {
        case "list":
            new ListCommand(fullCommand).run(expenseList);
            break;
        case "add":
            logger.log(Level.INFO, "Add command to execute");
            new AddExpenseCommand(fullCommand).run(expenseList);
            break;
        case "delete":
            new DeleteCommand(fullCommand).run(expenseList);
            break;
        case "exit":
            new ExitCommand(fullCommand).run(expenseList);
            isExit = true;
            break;
        default:
            System.out.println("Please key in valid command!");
        }
    }
}
