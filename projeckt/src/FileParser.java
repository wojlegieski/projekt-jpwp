import MyException.*;
import MyException.Record;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileParser {
    Record parseLine(String line, int lineNumber) throws InvalidFormatException {
        String[] tokens = line.split(";");
        if (tokens.length != 4) {
            throw new InvalidFormatException(
                    "Niepoprawna liczba pól (" + tokens.length + " zamiast 4)",
                    lineNumber,
                    null
            );
        }
        int id;
        try {
            id = Integer.parseInt(tokens[0].trim());
        } catch (NumberFormatException nfe) {
            throw new InvalidFormatException(
                    "Nieprawidłowy identyfikator w linii " + lineNumber
                            + ": \"" + tokens[0] + "\"",
                    lineNumber,
                    nfe
            );
        }

        String name = tokens[1].trim();
        if (name.isEmpty()) {
            throw new InvalidFormatException(
                    "Brak imienia/nazwiska w linii " + lineNumber,
                    lineNumber,
                    null
            );
        }

        int age;
        try {
            age = Integer.parseInt(tokens[2].trim());
        } catch (NumberFormatException nfe) {
            throw new InvalidFormatException(
                    "Nieprawidłowy wiek w linii " + lineNumber
                            + ": \"" + tokens[2] + "\"",
                    lineNumber,
                    nfe
            );
        }

        String email = tokens[3].trim();
        if (!email.contains("@")) {
            throw new InvalidFormatException(
                    "Niepoprawny e-mail w linii " + lineNumber
                            + ": \"" + email + "\"",
                    lineNumber,
                    null
            );
        }

            return new Record(id, name, age, email);
//        try {
//            int id = Integer.parseInt(tokens[0]);
//            String name = tokens[1];
//            int age = Integer.parseInt(tokens[2]);
//            String email = tokens[3];
//            return new Record(id, name, age, email);
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//            return null;
//        }
    }
    List<Record> parseFile(String path) throws FileProcessingException, InvalidFormatException{
        List<Record> list = new ArrayList<>();
        Path p = Paths.get(path);
        try (BufferedReader reader = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    list.add(parseLine(line, lineNumber));
                } catch (InvalidFormatException ife) {
                    throw ife;
                }
            }
        } catch (NoSuchFileException nsfe) {
            throw new FileProcessingException(path, "Plik nie istnieje", nsfe);
        } catch (AccessDeniedException ade) {
            throw new FileProcessingException(path, "Brak uprawnień do odczytu", ade);
        } catch (IOException ioe) {
            throw new FileProcessingException(path, "Błąd odczytu pliku", ioe);
        }

        return list;
    }

}
