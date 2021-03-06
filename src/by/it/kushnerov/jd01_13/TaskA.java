package by.it.kushnerov.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            String name = e.getClass().getName();
            String className = "none";
            int lineNumber = 1;
            System.out.printf(" name: %s\n", name);
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getMethodName().equals("main")) {
                    className = element.getClassName();
                    lineNumber = element.getLineNumber();
                    System.out.printf(" name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d\n"
                            , name, className, lineNumber);
                    break;
                }
            }
        }
    }
}
