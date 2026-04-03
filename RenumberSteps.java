import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class RenumberSteps {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("c:\\Users\\User\\IdeaProjects\\mobileauto\\src\\main\\java\\org\\example\\Loyalty.java");
        List<String> lines = Files.readAllLines(path);
        List<String> outLines = new ArrayList<>();

        int counter = 1;
        Pattern printPattern = Pattern.compile("System\\.out\\.println\\(\"(.*?)\"");

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            Matcher m = printPattern.matcher(line);
            if (m.find()) {
                String content = m.group(1);
                boolean isStep = false;
                if (content.matches("^\\d+\\.\\s*.*")) {
                    isStep = true;
                } else if (content.startsWith("Клик") || content.startsWith("Ввод") || content.startsWith("Проверка")) {
                    isStep = true;
                }

                if (isStep) {
                    // Backtrack in outLines to find an associated comment
                    int j = outLines.size() - 1;
                    while (j >= 0) {
                        String prev = outLines.get(j).trim();
                        if (prev.isEmpty() || prev.contains("Thread.sleep")) {
                            j--;
                            continue;
                        }
                        if (prev.startsWith("//")) {
                            if (prev.matches("^//\\s*\\d+\\.\\s*.*")) {
                                outLines.set(j, outLines.get(j).replaceFirst("^(\\s*//\\s*)\\d+\\.\\s*", "$1" + counter + ". "));
                            }
                        }
                        break;
                    }

                    // Remove old numbering if exists, and prepend our counter
                    String newContent = content.replaceFirst("^\\d+\\.\\s*", "");
                    String newLine = line.replaceFirst(Pattern.quote("System.out.println(\"" + content), 
                                                       Matcher.quoteReplacement("System.out.println(\"" + counter + ". " + newContent));
                    outLines.add(newLine);
                    counter++;
                    continue;
                }
            }
            outLines.add(line);
        }

        Files.write(path, outLines);
        System.out.println("Renumbered " + (counter - 1) + " steps successfully.");
    }
}
