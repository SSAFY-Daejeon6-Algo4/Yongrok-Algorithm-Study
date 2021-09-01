import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarfs = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			int h = Integer.parseInt(in.readLine());
			dwarfs[i] = h;
			sum += h;
		}
		
		out : for(int i=0;i<8;i++) {
			for(int j=i+1;j<9;j++) {
				int d1 = dwarfs[i];
				int d2 = dwarfs[j];
				if(sum - d1 - d2 == 100) {
					dwarfs[i] = 101;
					dwarfs[j] = 101;
					break out;
				}
			}
		}
		
		Arrays.sort(dwarfs);
		
		for(int i=0;i<7;i++) {
			System.out.println(dwarfs[i]);
		}
	}

}
