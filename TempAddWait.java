import java.nio.file.*;
import java.util.*;

public class TempAddWait {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("c:\\Users\\User\\IdeaProjects\\mobileauto\\src\\main\\java\\org\\example\\Loyalty.java");
        List<String> lines = Files.readAllLines(path);
        List<String> outLines = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String stripped = line.trim();
            
            if (stripped.startsWith("System.out.println") && 
                (stripped.contains("Клик") || stripped.contains("Ввод") || stripped.contains("Проверка"))) {
                
                boolean hasSleep = false;
                int j = i - 1;
                while (j >= 0) {
                    String sj = lines.get(j).trim();
                    if (sj.isEmpty() || sj.startsWith("//")) {
                        j--;
                        continue;
                    }
                    if (sj.startsWith("System.out.println")) {
                        // ignore print statements when searching upwards for a sleep
                        // so that chains of prints don't hide the missing sleep
                        j--;
                        continue;
                    }
                    if (sj.contains("Thread.sleep")) {
                        hasSleep = true;
                    }
                    break;
                }
                
                if (!hasSleep) {
                    // get indent
                    int indentLen = line.length() - line.stripLeading().length();
                    String indent = line.substring(0, indentLen);
                    outLines.add(indent + "Thread.sleep(1000);");
                }
            }
            outLines.add(line);
        }
        
        Files.write(path, outLines);
        System.out.println("Modified Loyalty.java successfully.");
    }
}
