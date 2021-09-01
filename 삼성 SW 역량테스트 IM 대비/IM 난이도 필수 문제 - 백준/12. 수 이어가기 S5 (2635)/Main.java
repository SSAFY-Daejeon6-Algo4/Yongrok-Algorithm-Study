import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		int max = 0;
		List<Integer> answer = new LinkedList<>();
		
		for(int i=1;i<=n;i++) {
			List<Integer> arr = new LinkedList<>();
			arr.add(n);
			arr.add(i);
			while(true) {
				int cur = arr.get(arr.size()-2) - arr.get(arr.size()-1);
				if(cur < 0) break;
				arr.add(cur);
			}
			if(arr.size() > max) {
				max = arr.size();
				answer = arr;
			}
		}
		
		System.out.println(max);
		for(int i=0;i<max;i++) {
			System.out.print(answer.get(i)+" ");
		}
	}

}
