package com.ohyr.boj.problem10163;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int[][] grid = new int[1001][1001];
		
		int n = Integer.parseInt(in.readLine());
		
		for(int p=1;p<=n;p++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int i=x;i<x+w;i++) {
				for(int j=y;j<y+h;j++) {
					grid[i][j] = p;
				}
			}
		}
		
		int[] cnt = new int[n+1];
		
		for(int i=0;i<1001;i++) {
			for(int j=0;j<1001;j++) {
				cnt[grid[i][j]]++;
			}
		}
		
		for(int i=1;i<=n;i++) {
			System.out.println(cnt[i]);
		}
		
	}

}
