package seedu.duke.item;

import java.util.Date;

public class Income extends Item {
    private String type;

    public Income(String description, String category, double amount, Date date, String type) {
        super(description, category, amount, date);
        this.type = type;
    }

    @Override
    public String toString() {
        return "[I] " + super.toString();
    }
}