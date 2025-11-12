#include <iostream>
#include <iomanip>

using namespace std;

// Structure to represent an expense
struct Expense {
    char description[100];
    double amount;
    char category[50];
    char date[11]; // YYYY-MM-DD
};

// Function to add a new expense
void addExpense(Expense expenses[], int& numExpenses) {
    cout << "Enter expense amount: $";
    cin >> expenses[numExpenses].amount;

    cin.ignore(); // Consume newline character

    cout << "Enter expense description: ";
    cin.getline(expenses[numExpenses].description, 100);
    cout << "Enter expense category: ";
    cin.getline(expenses[numExpenses].category, 50);

    cout << "Enter expense date (YYYY-MM-DD): ";
    cin.getline(expenses[numExpenses].date, 11);

    numExpenses++;

    cout << "Expense added successfully!\n";
}

// Function to delete an expense by index
void deleteExpense(Expense expenses[], int& numExpenses) {
    if (numExpenses == 0) {
        cout << "No expenses to delete.\n";
        return;
    }

    int index;
    cout << "Enter the index of the expense to delete: ";
    cin >> index;

    if (index >= 0 && index < numExpenses) {
        for (int i = index; i < numExpenses - 1; ++i) {
            expenses[i] = expenses[i + 1];
        }
        numExpenses--;
        cout << "Expense deleted successfully!\n";
    } else {
        cout << "Invalid expense index.\n";
    }
}

// Function to display all expenses
void viewExpenses(const Expense expenses[], int numExpenses) {
    if (numExpenses == 0) {
        cout << "No expenses recorded.\n";
        return;
    }

    cout << "---------------------------------------------------------\n";
    cout << "| Index | Description  | Amount | Category   | Date       |\n";
    cout << "---------------------------------------------------------\n";

    for (int i = 0; i < numExpenses; ++i) {
        cout << "| " << setw(4) << i << " | "
             << setw(13) << expenses[i].description << " | "
             << setw(6) << fixed << setprecision(2) << expenses[i].amount << " | "
             << setw(11) << expenses[i].category << " | "
             << setw(10) << expenses[i].date << " |\n";
    }

    cout << "---------------------------------------------------------\n";
}

int main() {
    const int MAX_EXPENSES = 100;
    Expense expenses[MAX_EXPENSES];
    int numExpenses = 0;

    int choice;

    do {
        cout << "\nExpense Tracker Menu:\n";
        cout << "1. Add Expense\n";
        cout << "2. Delete Expense\n";
        cout << "3. View Expenses\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                if (numExpenses < MAX_EXPENSES) {
                    addExpense(expenses, numExpenses);
                } else {
                    cout << "Maximum number of expenses reached.\n";
                }
                break;
            case 2:
                deleteExpense(expenses, numExpenses);
                break;
            case 3:
                viewExpenses(expenses, numExpenses);
                break;
            case 4:
                cout << "Exiting...\n";
                break;
            default:
                cout << "Invalid choice!\n";
        }
        cin.ignore(); // Consume newline character
    } while (choice != 4);

    return 0;
}