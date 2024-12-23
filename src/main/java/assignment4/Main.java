package assignment4;

import java.util.List;
import java.util.Scanner;

import static assignment4.Constants.*;

/**
 * Main class for running the program.
 */
public class Main {
    /**
     * The entry point of the program.
     *
     * @param args command-line arguments; expects one argument for the grammar directory
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(USAGESTRING);
            System.exit(1);
        }

        String directoryPath = args[0];
        List<Grammar> grammars;

        try {
            System.out.println(LOADINGGRAMMARS);
            grammars = GrammarLoaderJSONFile.loadGrammars(directoryPath);
        }

        catch (Exception e) {
            System.err.println(LOADINGGRAMMARSERROR + e.getMessage());
            return;
        }

        if (grammars.isEmpty()) {
            System.out.println(NOGRAMMARSFOUND);
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display available grammars
            System.out.println(AVAILABLEGRAMMARS);

            for (int i = 0; i < grammars.size(); i++) {
                System.out.println((i + 1) + TITLENUMBERSPLIT + grammars.get(i).getGrammarTitle());
            }

            System.out.println(CHOICE);
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase(QUIT)) {
                break;
            }

            int index;

            try {
                index = Integer.parseInt(choice) - 1;
                if (index < 0 || index >= grammars.size()) {
                    System.out.println(INVALIDSELECTION);
                    continue;
                }
            }

            catch (NumberFormatException e) {
                System.out.println(INVALIDINPUT);
                continue;
            }

            Grammar selectedGrammar = grammars.get(index);
            RandomSentenceGenerator generator = new RandomSentenceGenerator();

            while (true) {
                try {
                    String sentence = generator.generateSentence(selectedGrammar);
                    System.out.println(sentence);
                }

                catch (Exception e) {
                    System.err.println(GENERATINGSENTENCEERROR + e.getMessage());
                    break;
                }

                String another;

                while (true) {
                    System.out.println(ANOTHERPROMPT);
                    another = scanner.nextLine().trim().toLowerCase();

                    if (another.equals(YES) || another.equals(NO)) {
                        break;
                    }

                    else {
                        System.out.println(YESORNO);
                    }
                }

                if (another.equalsIgnoreCase(NO)) {
                    break;
                }
            }
        }

        scanner.close();
    }
}