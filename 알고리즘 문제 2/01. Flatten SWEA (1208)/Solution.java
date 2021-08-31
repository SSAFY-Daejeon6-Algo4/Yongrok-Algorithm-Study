import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			int n = Integer.parseInt(in.readLine());
			int[] box = new int[100];
			st = new StringTokenizer(in.readLine(), " ");
			for(int i=0;i<100;i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			while(n-- > 0) {
				Arrays.sort(box);
				if(box[99] - box[0] <= 1) break;
				box[0]++;
				box[99]--;
			}
			Arrays.sort(box);
			int answer = box[99] - box[0];
			
			out.write("#"+tc+" "+answer+"\n");
		}
		out.close();
	}

}
