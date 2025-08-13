# 💰 Personal Expense Tracker (Java)

A simple **console-based Personal Expense Tracker** built using Java.  
This program allows you to record, view, and analyze your daily expenses.  
Data is stored in a **CSV file** so your expenses are saved even after closing the program.

---

## ✨ Features
- ➕ **Add Expense** — Enter date, category, and amount.
- 📜 **View All Expenses** — See all your recorded transactions.
- 📊 **Monthly Total** — Calculate total expenses for a given month/year.
- 💾 **Persistent Storage** — Stores data in `expenses.csv`.
- 🖥 **Console Menu Interface** — Easy navigation through options.

---

## 🛠 Technologies Used
- **Java** (Core, Collections, File I/O)
- **CSV File Storage**

---

## 📂 Project Structure
PersonalExpenseTracker.java # Main source code
expenses.csv # Data file (auto-created)

yaml
Copy
Edit

---

## 🚀 How to Run
1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/personal-expense-tracker-java.git
   cd personal-expense-tracker-java
Compile the code:

bash
Copy
Edit
javac PersonalExpenseTracker.java
Run the program:

bash
Copy
Edit
java PersonalExpenseTracker
Follow the menu options to add/view expenses.

📌 Sample Menu
markdown
Copy
Edit
==== Personal Expense Tracker ====
1. Add Expense
2. View All Expenses
3. Show Monthly Total
4. Exit
Choose an option:
🔮 Future Improvements
Replace CSV with MySQL database using JDBC.

Add JavaFX GUI for a better visual interface.

Include data filtering by category/date range.

Generate PDF/Excel reports.
