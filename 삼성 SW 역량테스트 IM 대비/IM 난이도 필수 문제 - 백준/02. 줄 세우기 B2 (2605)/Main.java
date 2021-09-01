import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		
		List<Integer> line = new ArrayList<>();
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<n;i++) {
			int k = Integer.parseInt(st.nextToken());
			line.add(i-k, i+1);
		}
		
		for(int student: line) {
			System.out.print(student+" ");
		}
	}

}
