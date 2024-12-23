# Random Sentence Generator
Entry point -> In Main.java, the main() method.

Key classes and methods:

1. Main
  
  Purpose: Entry point of the program. Handles user interaction and program flow.
  
  Key Methods:
  
  public static void main(String[] args): Parses command-line arguments, loads grammars, and manages user interaction.
  
2. GrammarLoaderJSONFile
  
  Purpose: Loads grammars from JSON files.
  
  Key Methods:
  
  static List<Grammar> loadGrammars(String directoryPath): Loads grammars from the specified directory.
  
  static List<AbstractSymbol> parseProduction(String productionString): Parses a production string into a list of symbols.
  
3. Grammar
 
  Purpose: Represents a grammar, containing grammar settings and non-terminal productions.
  
  Key Methods:
  
  public void addProduction(String nonTerminal, Production production): Adds a production for a given non-terminal.
  
  public List<Production> getProductions(String nonTerminal): Retrieves productions for a given non-terminal.
  
  Overridden methods: equals(), hashCode(), toString().
  
4. Production
  
  Purpose: Represents a production rule consisting of a sequence of symbols.
  
  Key Methods:
  
  public List<Symbol> getSymbols(): Returns the list of symbols in the production.
  
  Overridden methods: equals(), hashCode(), toString().
  
5. AbstractSymbol (Abstract Class)
  
  Purpose: Abstract base class for grammar symbols.
  
  Key Methods:
  
  public abstract String getValue(): Returns the value of the symbol.
  
6. Terminal (Extends Symbol)
  
  Purpose: Represents a terminal symbol in the grammar.
  
  Key Methods:
  
  public String getValue(): Returns the terminal's value.
  
  Overridden methods: equals(), hashCode(), toString().
  
7. NonTerminal (Extends Symbol)
  
  Purpose: Represents a non-terminal symbol that can be expanded using production rules.
  
  Key Methods:
  
  public String getValue(): Returns the non-terminal's name.
  
  Overridden methods: equals(), hashCode(), toString().
  
8. RandomSentenceGenerator
  
  Purpose: Generates random sentences by recursively expanding non-terminals.
  
  Key Methods:
  
  public String generateSentence(Grammar grammar): Generates a random sentence from the given grammar.
  
  private String expandSymbol(AbstractSymbol symbol, Grammar grammar): Recursively expands a symbol into a string.
  
9. Constants
  
  Purpose: Houses all the magic numbers/strings used throughout the project.


Assumptions:

Grammar Files Format: The grammar files should be well-formed JSON files containing production rules with terminals and non-terminals.

Start Symbol: The start symbol of each grammar is named "start".

Ensuring Correctness:

Input Validation: We validated the user inputs to handle invalid selections and inputs.

Exception Handling: We included some exception handling to catch and display error messages for issues like undefined non-terminals, and unexpected choices/commands.

How to run:

Just include the directory where your grammar json files are located in the run config. Preferably in the same directory as src. There already is a test-files directory there with the provided test files. So, if you include "test-files/" in the config, and run main, it should be good. We are also using Google's Gson library, so if it gives an error after running doAll (which it should not), run dependencies first, and reset Intellij. You guys probably know better, but mentioning it here to inform you just in case.

Here is a result that was wild:

With the force of a particularly vicious she-bear in the midst of her menstrual cycle , may a funky platoon of fleas and a funky heard of crazed cockroaches seek a battleground in the sewer you call home .


Class Diagram

![assignment4/assignment4/Assignment 4 Design img.png](https://github.khoury.northeastern.edu/cs5010seaF24/Group_al1y3vk_akakadia/blob/assignment4/assignment4/assignment4/Assignment%204%20Design%20img.png)
