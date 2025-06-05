# Data Science Data Manager

## Module: CS1OPNU
## Nuist Student Number: 202383700039
## Reading Student Number:32804226
## Actual Hours Spent: about 16 hours 
## AI Tools Used: 
ChatGPT (for code explanation and template generation), GitHub Copilot (optional)

---

## Features:

- ✅ Data import (CSV)
- ✅ Data transformation (Filter)
- ✅ Data analysis (Mean, Median, Mode) using Observer pattern
- ✅ Data export (CSV)
- ✅ CLI interface with user interaction
- ✅ JUnit unit tests implemented (≥ 50% coverage)

---

## Design Patterns Used:

- **Factory Pattern** (TransformerFactory to create DataTransformer)
- **Observer Pattern** (Observer / DataObserver for statistics update)
- **Strategy Pattern** (DataExporter interface + CsvExporter implementation)

---

## How to Run:
1️⃣ Run `App.java`

2️⃣ CLI menu options:

Import Data (CSV/JSON)

Apply Data Transformation

Perform Data Analysis

Export Data (CSV/JSON)

Exit

3️⃣ Follow menu instructions to:

- Import sample CSV
- Apply Filter transformation
- Perform Analysis
- Export Data to CSV

---

## Dependencies:

- OpenCSV (for CSV reading/writing)
- JUnit 5 (for unit testing)

---

## Assumptions:

- Input CSV file uses UTF-8 encoding
- JSON import/export is not implemented yet (CSV only for current version)
- CSV file must have header row (first row = column names)

---

## Limitations / Future Work:

- Add JSON import/export
- Implement more advanced transformations (Sort, Aggregate)
- GUI interface (optional extension)
