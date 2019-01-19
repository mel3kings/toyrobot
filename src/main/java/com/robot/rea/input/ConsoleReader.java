package com.robot.rea.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Console reader for processing commands
 */
public class ConsoleReader implements InputReader{

  @Override
  public List<String> getCommandsFromUser(String str) {
    Scanner scanner = new Scanner(System.in);
    List<String> result = new ArrayList<>();

    System.out.println("Please enter for the toy robot simulator. Enter one command per line.");
    System.out.println("Valid Commands:");
    System.out.println(" PLACE X,Y,F\n" +
            "    MOVE\n" +
            "    LEFT\n" +
            "    RIGHT\n" +
            "    REPORT");
    System.out.println("To run: 'CTRL + D' (Mac/Unix) or 'CTRL + Z' + 'Return' (Windows).");
    System.out.println();
    while (scanner.hasNext()) {
      result.add(scanner.nextLine());
    }
    return result.stream().collect(Collectors.toList());
  }
}
