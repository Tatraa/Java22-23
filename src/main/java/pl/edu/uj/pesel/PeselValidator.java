package pl.edu.uj.pesel;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.text.MessageFormat;

public class PeselValidator {

  private static final Logger logger = LoggerFactory.getLogger(PeselValidator.class);

  public static void main(String[] args) throws IOException {

    File fileToRead = new File("input.txt");
    if (!fileToRead.exists()) {
      System.out.println("plik nie istnieje, tworze nowy plik");
      fileToRead.createNewFile();
    }

    File fileToWrite = new File("output.txt");
    if (!fileToWrite.exists()) {
      System.out.println("plik nie istnieje, tworze nowy plik");
      fileToWrite.createNewFile();
    }

    BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite));

    String readLine;

    while ((readLine = reader.readLine()) != null) {
      Pesel pesel = new Pesel(readLine);
      boolean isValid = Pesel.check(pesel);

      if (isValid) {
        writer.write("VALID\n");
      } else {
        writer.write("INVALID\n");
      }
    }
    writer.close();
  }
}
