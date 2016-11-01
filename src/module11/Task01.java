package module11;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Task01 {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("to", "TOTOTO");
        map.put("a", "AAA");

        System.out.println("Formatted file:\n" + new Task01().replacer(map));
    }

    public String replacer(Map<String, String> map) throws IOException {
/*
        System.out.print("Enter file name: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] encoded = Files.readAllBytes(Paths.get(br.readLine()));
        br.close();
*/
        String path = "src/module11/1.txt";
        byte[] encoded = Files.readAllBytes(Paths.get(path));

        String fileText = new String(encoded, StandardCharsets.UTF_8);

        for (Map.Entry<String, String> entry : map.entrySet()) {
            fileText = fileText.replaceAll("\\b" + entry.getKey() + "\\b", entry.getValue());
        }

        return fileText;
    }
}
