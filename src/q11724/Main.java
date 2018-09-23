package q11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,cnt;
	static boolean visited[];
	static boolean[][] edge;
	
	public static void DFS(int n) {
		int i;
		visited[n] = true;
		
		for(i=1;i<=N;i++) {
			if(visited[i]) continue;
			if(edge[n][i]) {
				DFS(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int i,u,v;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		edge = new boolean[N+1][N+1];
		
		for(i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			edge[u][v] = true;
			edge[v][u] = true;
		}
		
		for(i=1;i<=N;i++) {
			if(!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
		in.close();
	}
}
