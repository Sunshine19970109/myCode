import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Xlsx {
	public static void main(String[] args) throws FileNotFoundException {		
		PrintWriter pw = new PrintWriter(new File("1.txt"));
		pw.print("hello");
		pw.close();		
	}
}
