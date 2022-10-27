package pl.edu.uj.pesel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.text.MessageFormat;

public class PeselValidator {

  private static final Logger logger = LoggerFactory.getLogger(PeselValidator.class);

  public static void main(String[] args) throws IOException {
    // TODO should read input file path and write to output file

    File fileToRead = new File("input.txt");
    if(!fileToRead.exists()){
      System.out.println("plik nie istnieje, tworze nowy plik");
      fileToRead.createNewFile();
    }

    File fileToWrite = new File("output.txt");
    if(!fileToWrite.exists()){
      System.out.println("plik nie istnieje, tworze nowy plik");
      fileToWrite.createNewFile();
    }

    BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite));

    String readLine;

    while((readLine = reader.readLine()) != null){
      Pesel pesel = new Pesel(readLine);
      boolean isValid = Pesel.check(pesel);

      if(isValid){
        writer.write("VALID\n");
      }else{
        writer.write("INVALID\n");
      }
    }
    writer.close();

    for (String arg : args) {
      Pesel pesel = new Pesel(arg);
      boolean valid = Pesel.check(pesel);
      logger.info(MessageFormat.format("PESEL \"{0}\" is {1}", arg, valid ? "valid" : "invalid"));
    }
  }
}
