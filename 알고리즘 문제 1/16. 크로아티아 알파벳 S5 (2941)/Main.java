import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String word = in.readLine();
		
		String[] croa = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(String cr: croa) {
			word = word.replaceAll(cr, " ");
		}
		
		System.out.println(word.length());
	}

}
