package oprecon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CodeGenerator {
    static String absoluteRootPath = "/Users/lpichardomartinez/Desktop/oprecon/";
    static String absoluteProjectPath = "/Users/lpichardomartinez/Desktop/oprecon/src/oprecon/";
    static String absoluteRulesPath = "/Users/lpichardomartinez/Desktop/oprecon/src/oprecon/rules/";

    static String lexerCup = absoluteRulesPath + "lexer_cup.flex";
    static String[] cupSyntaxCommand = { "-parser", "CupParser", absoluteRulesPath + "cup_rules.cup" };

    public static void main(String[] args) throws Exception {
        generate(lexerCup, cupSyntaxCommand);
    }

    public static void generate(String lexerCup, String[] cupSyntaxCommand) throws IOException, Exception {
        JFlex.Main.generate(new File(lexerCup));
        java_cup.Main.main(cupSyntaxCommand);
        move();
    }

    public static void move() throws IOException {
        Files.move(
            Paths.get(absoluteRulesPath + "LexerCup.java"),
            Paths.get(absoluteProjectPath + "LexerCup.java")
        );

        Files.move(
            Paths.get(absoluteRootPath + "sym.java"),
            Paths.get(absoluteProjectPath + "sym.java")
        );

        Files.move(
            Paths.get(absoluteRootPath + "CupParser.java"),
            Paths.get(absoluteProjectPath + "CupParser.java")
        );
    }
}
