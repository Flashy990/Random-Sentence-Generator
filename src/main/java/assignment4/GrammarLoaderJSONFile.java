package assignment4;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.*;

import static assignment4.Constants.*;

/**
 * Loads grammars from JSON files in the specified directory.
 */
public class GrammarLoaderJSONFile {
  /**
   * Loads grammars from JSON files in the given directory.
   *
   * @param grammarDirectoryPath the path to the directory containing grammar files
   * @return a list of Grammar objects
   * @throws Exception if an error occurs while reading files
   */
  static List<Grammar> loadGrammars(String grammarDirectoryPath) throws Exception {
    List<Grammar> grammars = new ArrayList<>();
    File directory = new File(grammarDirectoryPath);
    File[] files = directory.listFiles((dir, name) -> name.endsWith(JSONEXTENSION));

    if (files == null) {
      throw new Exception(NODIRECTORYORFILE);
    }

    for (File file : files) {
      String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
      JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();

      String title = jsonObject.get(GRAMMARTITLE).getAsString();
      String description = jsonObject.get(GRAMMARDESCRIPTION).getAsString();
      String startSymbol = STARTSYMBOL;

      Grammar grammar = new Grammar(title, description, startSymbol);

      for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
        String key = entry.getKey();

        if (key.equalsIgnoreCase(GRAMMARTITLE) || key.equalsIgnoreCase(GRAMMARDESCRIPTION)) {
          continue;
        }

        JsonArray jsonArray = entry.getValue().getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
          String productionString = jsonElement.getAsString();
          List<AbstractSymbol> symbols = parseProduction(productionString);

          Production production = new Production(symbols);
          grammar.addProduction(key, production);
        }
      }

      grammars.add(grammar);
    }

    return grammars;
  }

  /**
   * Parses a production string into a list of symbols.
   *
   * @param productionString the production string
   * @return a list of Symbol objects
   */
  static List<AbstractSymbol> parseProduction(String productionString) {
    List<AbstractSymbol> symbols = new ArrayList<>();

    // Regular expression to match non-terminals and terminals
    Pattern pattern = Pattern.compile(PARSINGPATTERN);
    Matcher matcher = pattern.matcher(productionString);

    while (matcher.find()) {
      String symbol = matcher.group();

      if (symbol.startsWith(OPEN) && symbol.endsWith(CLOSE)) {
        String nonTerminalName = symbol.substring(1, symbol.length() - 1).trim();
        symbols.add(new NonTerminal(nonTerminalName));
      }

      else {
        symbols.add(new Terminal(symbol));
      }
    }

    return symbols;
  }
}