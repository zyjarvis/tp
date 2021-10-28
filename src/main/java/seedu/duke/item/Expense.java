package seedu.duke.item;

import java.util.Date;

public class Expense extends Item {
    private String type;

    public Expense(String description, String category, double amount, Date date, String type) {
        super(description, category, amount, date);
        this.type = type;
    }

    @Override
    public String toString() {
        return "[E] " + super.toString();
    }
}