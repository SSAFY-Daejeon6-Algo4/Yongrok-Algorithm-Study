import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static int[] convertPosValue(int w, int h, int direction, int index) {
		int[] pos = null;

		if (direction == 1) {
			pos = new int[] { 0, index };
		} else if (direction == 2) {
			pos = new int[] { h, index };
		} else if (direction == 3) {
			pos = new int[] { index, 0 };
		} else if (direction == 4) {
			pos = new int[] { index, w };
		}

		return pos;
	}

	public static void goLeft(int direction, int x, int y, int[][] left) {
		int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		int dMap[] = { 0, 0, 2, 3, 1 };
		int d = dMap[direction];

		int cnt = 0;
		int w = left[0].length - 1;
		int h = left.length - 1;
		int new_x = x;
		int new_y = y;

		while (cnt != 2 * (w + h) - 1) {
			new_x += deltas[d][0];
			new_y += deltas[d][1];

			if (new_x < 0 || h < new_x || new_y < 0 || w < new_y) {
				new_x -= deltas[d][0];
				new_y -= deltas[d][1];
				d = (d + 1) % 4;
				continue;
			}

			left[new_x][new_y] = ++cnt;
		}
	}

	public static void goRight(int direction, int x, int y, int[][] right) {
		int[][] deltas = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

		int dMap[] = { 0, 0, 2, 1, 3 };
		int d = dMap[direction];

		int cnt = 0;
		int w = right[0].length - 1;
		int h = right.length - 1;
		int new_x = x;
		int new_y = y;

		while (cnt != 2 * (w + h) - 1) {
			new_x += deltas[d][0];
			new_y += deltas[d][1];

			if (new_x < 0 || h < new_x || new_y < 0 || w < new_y) {
				new_x -= deltas[d][0];
				new_y -= deltas[d][1];
				d = (d + 1) % 4;
				continue;
			}

			right[new_x][new_y] = ++cnt;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(in.readLine());
		int[][] store = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			store[i][0] = Integer.parseInt(st.nextToken());
			store[i][1] = Integer.parseInt(st.nextToken());
		}

		int[] donggeun = new int[2];
		st = new StringTokenizer(in.readLine());
		donggeun[0] = Integer.parseInt(st.nextToken());
		donggeun[1] = Integer.parseInt(st.nextToken());

		int[][] left = new int[h + 1][w + 1];
		int[][] right = new int[h + 1][w + 1];

		int[] dgPos = convertPosValue(w, h, donggeun[0], donggeun[1]);

		goLeft(donggeun[0], dgPos[0], dgPos[1], left);
		goRight(donggeun[0], dgPos[0], dgPos[1], right);

		int answer = 0;

		for (int i = 0; i < n; i++) {
			int direction = store[i][0];
			int index = store[i][1];

			int[] pos = convertPosValue(w, h, direction, index);

			answer += Math.min(left[pos[0]][pos[1]], right[pos[0]][pos[1]]);
		}

		System.out.println(answer);
	}

}
