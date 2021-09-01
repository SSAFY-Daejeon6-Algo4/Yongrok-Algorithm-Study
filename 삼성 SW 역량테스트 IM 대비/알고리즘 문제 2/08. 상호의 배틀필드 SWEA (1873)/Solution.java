import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        class Tank {
            int x;
            int y;
            int dx;
            int dy;
            char dir;
             
            Tank(int x, int y, char dir){
                this.x = x;
                this.y = y;
                setDir(dir);
            }
             
            void setDir(char dir){
                this.dir = dir;
                if(dir == '^') {
                    this.dx = -1;
                    this.dy = 0;
                }else if(dir == 'v') {
                    this.dx = 1;
                    this.dy = 0;
                }else if(dir == '<') {
                    this.dx = 0;
                    this.dy = -1;
                }else if(dir == '>') {
                    this.dx = 0;
                    this.dy = 1;
                }
            }
             
            void setTank(int x, int y, char dir) {
                this.x = x;
                this.y = y;
                this.dir = dir;
                setDir(dir);
            }
        }
         
        int T = Integer.parseInt(in.readLine());
         
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(in.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
             
            Tank tk = new Tank(0,0,'^');
             
            char[][] field = new char[h][w];
            for(int i=0;i<h;i++) {
                String str = in.readLine();
                for(int j=0;j<w;j++) {
                    char tile = str.charAt(j);
                    field[i][j] = tile;
                    if(tile == '^' || tile == 'v' ||
                            tile == '<' || tile == '>') {
                        tk.setTank(i, j, tile);
                    }
                }
            }
             
            int n = Integer.parseInt(in.readLine());
             
            String commands = in.readLine();
             
            for(int c=0;c<n;c++) {
                char command = commands.charAt(c);
                 
                if(command == 'S') {
                    for(int i=1;i<=20;i++) {
                        int x = tk.x + tk.dx * i;
                        int y = tk.y + tk.dy * i;
                         
                        if(x < 0 || h <= x || y < 0 || w <= y) break;
                         
                        if(field[x][y] == '*') {
                            field[x][y] = '.';
                            break;
                        }else if(field[x][y] == '#') {
                            break;
                        }
                    }
                    continue;
                }
                 
                if(command == 'U') {
                    tk.setDir('^');
                    field[tk.x][tk.y] = tk.dir;
                }else if(command == 'D') {
                    tk.setDir('v');
                    field[tk.x][tk.y] = tk.dir;
                }else if(command == 'L') {
                    tk.setDir('<');
                    field[tk.x][tk.y] = tk.dir;
                }else if(command == 'R') {
                    tk.setDir('>');
                    field[tk.x][tk.y] = tk.dir;
                }
                 
                int x = tk.x + tk.dx;
                int y = tk.y + tk.dy;
                 
                if(x < 0 || h <= x || y < 0 || w <= y) continue;
                if(field[x][y] == '.') {
                    field[tk.x][tk.y] = '.';
                    tk.x = x;
                    tk.y = y;
                    field[tk.x][tk.y] = tk.dir;
                }
            }
             
            sb.append("#"+tc+" ");
            for(int i=0;i<h;i++) {
                for(int j=0;j<w;j++) {
                    sb.append(field[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
 
}