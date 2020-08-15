package oprecon;
import java.util.List;
import java.util.ArrayList;
import java.io.StringReader;
import java_cup.runtime.Symbol;

public class Recon
{
	static String input = "";
	static List<Tokens> tokens = new ArrayList<Tokens>();

	public static void main(String[] args) throws Exception
	{
		try
		{
			input = "" +
			"" +
			"";

			Sintax parser = new Sintax(new LexerCup(new StringReader(input)));

			try {
				Object res = parser.parse().value;
				System.out.println("Everything seems to be correct! :)");
				System.out.println(res);
			} catch (Exception ex) {
				Symbol sym = parser.getS();
				String parserOutput = "There is a syntax error on line: " + (sym.right + 1) + " column: " + (sym.left + 1) + ", value: \"" + sym.value + "\"";
				System.out.println(parserOutput);
			}
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
}

