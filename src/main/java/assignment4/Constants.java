package assignment4;

/**
 * Constant variables used throughout the project
 */
public final class Constants {
    // Grammar

    /** Indicates the end of a production block in the toString output. */
    public static final String ENDPRODUCTIONSTRING = "\n***END PRODUCTION***\n";

    /** Indicates the start of a production block in the toString output. */
    public static final String STARTPRODUCTIONSTRING = "\n***START PRODUCTION***\n";

    /** Prefix label for the grammar title in the toString output. */
    public static final String GRAMMARTITLESTRING = "Grammar Title: ";

    /** Prefix label for the grammar description in the toString output. */
    public static final String GRAMMARDESCRIPTIONSTRING = "Grammar Description: ";

    /** Label for non-terminal symbols in the toString output. */
    public static final String GRAMMARNONTERMINAL = "Non-terminal Symbol: ";

    /** Label for productions in the toString output. */
    public static final String GRAMMARPRODUCTIONS = "Productions:";

    /** Represents a newline character. */
    public static final String NEWLINE = "\n";

    /** Prefix label for the start symbol in the toString output. */
    public static final String STARTSYMBOLSTRING = "Start Symbol: ";

    /** String used to separate productions in the toString output. */
    public static final String PRODUCTIONSPLITTER = " - ";

    // Production

    /** Character used to split symbols in a production. */
    public static final char PRODUCTIONSPLITTER2 = ' ';

    // Sentence generator

    /** Error message for unknown symbol types during sentence generation. */
    public static final String UNKNOWNSYMBOL = "Unknown symbol type.";

    /** Error message prefix for undefined non-terminals during sentence generation. */
    public static final String UNDEFINEDOPEN = "Undefined non-terminal: <";

    /** String representing the closing angle bracket. */
    public static final String CLOSE = ">";

    /** String representing the opening angle bracket. */
    public static final String OPEN = "<";

    // Grammar loader

    /** File extension for JSON files. */
    public static final String JSONEXTENSION = ".json";

    /** Error message when the directory is invalid or no JSON files are found. */
    public static final String NODIRECTORYORFILE = "Invalid directory or no JSON files found";

    /** Regular expression pattern used to parse production strings. */
    public static final String PARSINGPATTERN = "<[^<>]+>|[^<>]+";

    /** Key for the grammar title in the JSON files. */
    public static final String GRAMMARTITLE = "grammarTitle";

    /** Key for the grammar description in the JSON files. */
    public static final String GRAMMARDESCRIPTION = "grammarDesc";

    /** Default start symbol name used in grammars. */
    public static final String STARTSYMBOL = "start";

    // Main

    /** Usage message displayed when incorrect arguments are provided. */
    public static final String USAGESTRING = "Usage: java Main <grammar_directory>";

    /** Message displayed when loading grammars. */
    public static final String LOADINGGRAMMARS = "Loading grammars...";

    /** Error message prefix when an error occurs during grammar loading. */
    public static final String LOADINGGRAMMARSERROR = "Error loading grammars: ";

    /** Message displayed when no grammars are found in the directory. */
    public static final String NOGRAMMARSFOUND = "No grammars found in the directory.";

    /** Message listing the available grammars to the user. */
    public static final String AVAILABLEGRAMMARS = "The following grammars are available:";

    /** Separator used between the title number and the title in the list of grammars. */
    public static final String TITLENUMBERSPLIT = ". ";

    /** Prompt asking the user to choose a grammar or quit. */
    public static final String CHOICE = "Which would you like to use? (q to quit)";

    /** Input string that indicates the user wants to quit the program. */
    public static final String QUIT = "q";

    /** Message displayed when the user makes an invalid selection. */
    public static final String INVALIDSELECTION = "Invalid selection.";

    /** Message displayed when the user provides invalid input. */
    public static final String INVALIDINPUT = "Invalid input.";

    /** Error message prefix when an error occurs during sentence generation. */
    public static final String GENERATINGSENTENCEERROR = "Error generating sentence: ";

    /** Prompt asking the user if they would like another sentence. */
    public static final String ANOTHERPROMPT = "Would you like another? (y/n)";

    /** Input string that indicates the user wants another sentence. */
    public static final String YES = "y";

    /** Input string that indicates the user does not want another sentence. */
    public static final String NO = "n";

    /** Error message for invalid inputs during sentence generation prompt. */
    public static final String YESORNO = "Invalid input. Please enter 'y' or 'n'.";
}