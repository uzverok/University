package Students.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Logger {
    public Logger() {
        try {
            System.setErr(new PrintStream(new File("log.txt")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeLog(String string){
        System.err.println(string);
    }
}
