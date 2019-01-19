package com.robot.rea.input;

import java.util.List;

/**
 * Dynamic interface for changing input type from user
 * Console/FileInputReader
 */
public interface InputReader {

    List<String> getCommandsFromUser(String str);
}
