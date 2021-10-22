package seedu.duke;

import seedu.duke.expense.Expense;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class ExpenseList {
    public ArrayList<Expense> expenses;
    public int size;

    public ExpenseList(ArrayList<Expense> expenses) {
        this.expenses = expenses;
        this.size = expenses.size();
    }

//<<<<<<< master
    public void addExpense(Date date, String description, double amount,  Timestamp recordDateTime) {
        Expense expense = new Expense(date, description, amount);
//=======
//    public void addExpense(String date, String description, double amount, Timestamp recordDateTime) {
        Expense expense = new Expense(date, description, amount, recordDateTime);
//>>>>>>> master
        expenses.add(expense);
        size++;
    }

    public void addIncome(String date, String description, double amount, Timestamp recordDateTime) {
        Expense income = new Expense(date, description, amount, recordDateTime);
        expenses.add(income);
        size++;
    }

    public void find(String keyword, ArrayList<Integer> findResult) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).toString().contains(keyword)) {
                findResult.add(i);
            }
        }
    }

    public void delete(int index) {
        expenses.remove(index);
        size--;
    }
}
