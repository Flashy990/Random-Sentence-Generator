# Random Sentence Generator

## Entry Point
- **File:** `Main.java`
- **Method:** `public static void main(String[] args)`
- **Purpose:** Serves as the entry point of the program, handling user interaction and managing program flow.

---

## 📚 **Key Classes and Methods**

### **1. Main**
- **Purpose:** Entry point of the program.
- **Key Method:**
  - `public static void main(String[] args)`
    - Parses command-line arguments.
    - Loads grammars.
    - Manages user interaction.

### **2. GrammarLoaderJSONFile**
- **Purpose:** Loads grammars from JSON files.
- **Key Methods:**
  - `static List loadGrammars(String directoryPath)`
    - Loads grammars from the specified directory.
  - `static List parseProduction(String productionString)`
    - Parses a production string into a list of symbols.

### **3. Grammar**
- **Purpose:** Represents a grammar with settings and non-terminal productions.
- **Key Methods:**
  - `public void addProduction(String nonTerminal, Production production)`
    - Adds a production for a given non-terminal.
  - `public List getProductions(String nonTerminal)`
    - Retrieves productions for a given non-terminal.
- **Overridden Methods:** `equals()`, `hashCode()`, `toString()`

### **4. Production**
- **Purpose:** Represents a production rule consisting of symbols.
- **Key Method:**
  - `public List getSymbols()`
    - Returns the list of symbols in the production.
- **Overridden Methods:** `equals()`, `hashCode()`, `toString()`

### **5. AbstractSymbol (Abstract Class)**
- **Purpose:** Abstract base class for grammar symbols.
- **Key Method:**
  - `public abstract String getValue()`
    - Returns the value of the symbol.

### **6. Terminal (Extends Symbol)**
- **Purpose:** Represents a terminal symbol.
- **Key Method:**
  - `public String getValue()`
    - Returns the terminal's value.
- **Overridden Methods:** `equals()`, `hashCode()`, `toString()`

### **7. NonTerminal (Extends Symbol)**
- **Purpose:** Represents a non-terminal symbol.
- **Key Method:**
  - `public String getValue()`
    - Returns the non-terminal's name.
- **Overridden Methods:** `equals()`, `hashCode()`, `toString()`

### **8. RandomSentenceGenerator**
- **Purpose:** Generates random sentences by recursively expanding non-terminals.
- **Key Methods:**
  - `public String generateSentence(Grammar grammar)`
    - Generates a random sentence from the given grammar.
  - `private String expandSymbol(AbstractSymbol symbol, Grammar grammar)`
    - Recursively expands a symbol into a string.

### **9. Constants**
- **Purpose:** Stores all magic numbers and strings used throughout the project.

---

## 📑 **Assumptions**
- **Grammar Files Format:** Grammar files must be well-formed JSON files containing production rules with terminals and non-terminals.
- **Start Symbol:** The start symbol of each grammar is named `"start"`.

---

## ✅ **Ensuring Correctness**
- **Input Validation:** Validates user inputs to handle invalid selections and inputs.
- **Exception Handling:** Catches and displays error messages for undefined non-terminals and unexpected commands.

---

## 🚀 **How to Run**
1. Include the directory where your grammar JSON files are located in the run configuration.
2. Place the grammar files in a directory, e.g., `test-files/`.
3. If using IntelliJ:
   - Run `doAll` first.
   - If errors persist, run `dependencies` and reset IntelliJ.
4. Run the `Main` class.

**Example Directory Setup:**
```
/src
/test-files/
```

---

## 🎲 **Sample Output (this was really interesting XD)**
*With the force of a particularly vicious she-bear in the midst of her menstrual cycle, may a funky platoon of fleas and a funky herd of crazed cockroaches seek a battleground in the sewer you call home.*

---

## 📊 **Class Diagram**

![Assignment 4 Design img.png](https://github.com/Flashy990/Random-Sentence-Generator/blob/main/Assignment%204%20Design%20img.png)
