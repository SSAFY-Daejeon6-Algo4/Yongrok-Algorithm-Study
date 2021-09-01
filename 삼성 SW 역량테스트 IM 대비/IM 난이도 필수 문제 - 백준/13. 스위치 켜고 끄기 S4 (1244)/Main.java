import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int swtchNum = Integer.parseInt(in.readLine());
		int[] swtch = new int[swtchNum];
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<swtchNum;i++) {
			swtch[i] = Integer.parseInt(st.nextToken());
		}
		
		int stuNum = Integer.parseInt(in.readLine());
		for(int i=0;i<stuNum;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int gender = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if(gender == 1) {
				int j = 1;
				while(k*j-1 < swtchNum) {
					swtch[k*j-1] = (swtch[k*j-1]+1)%2;
					j++;
				}
			}else {
				k -= 1;
				swtch[k] = (swtch[k]+1)%2;
				int j = 1;
				while(0 <= k-j && k+j < swtchNum) {
					if(swtch[k-j] != swtch[k+j]) {
						break;
					}
					swtch[k-j] = (swtch[k-j]+1)%2;
					swtch[k+j] = (swtch[k+j]+1)%2;
					j++;
				}
			}
		}
		
		for(int a=0;a<swtchNum;a++) {
			System.out.print(swtch[a]+" ");
			if(a%20 == 19) System.out.println();
		}
	}

}
