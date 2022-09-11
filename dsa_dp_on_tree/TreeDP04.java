package com.practice.dsa_dp_on_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

class TreeDP04 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    /*
    use in for reading input
    use out for printing output
    */
    static ArrayList<Integer>[] child;
    static int[] level;
    static int[] parent;
    static int MAXBIT = 9;
    static int[][] table;

    static void build(int n) {
        table = new int[MAXBIT + 1][n + 1];
        table[0] = parent;

        for (int p = 1; p <= MAXBIT; p++) {
            for (int i = 2; i <= n; i++) {
                int par = table[p - 1][i];
                table[p][i] = table[p - 1][par];
            }
        }
    }

    static void dfs(int node, int l) {
        level[node] = l;
        for (int c : child[node]) {
            parent[c] = node;
            dfs(c, l + 1);
        }
    }

    static int lca(int u, int v) {
        if (level[u] > level[v]) {
            int t = u;
            u = v;
            v = t;
        }
        ////while is not optimized
        // --level[v] > level[u]
        /*while (level[u] != level[v]) {
            v = parent[v];
        }*/

        int k = level[v] - level[u];
        for (int i = MAXBIT; i >= 0; i--) {
            int mask = 1 << i;
            if ((k & mask) > 0) {
                v = table[i][v];
            }
        }

        if (u == v) {
            return u;
        }

        for (int i = MAXBIT; i >= 0; i--) {
            int up = table[i][u];
            int vp = table[i][v];
            if (up != vp) {
                u = up;
                v = vp;
            }
        }
        u = parent[u];

        ////while is not optimized
        /*while (u != v) {
            u = parent[u];
            v = parent[v];
        }*/
        return u;
    }

    public static void solve() throws IOException {
        int n = Integer.parseInt(in.readLine());

        child = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++)
            child[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {// {count, c1, c2, c3, .....}

            String inp[] = in.readLine().split(" ");

            int count = Integer.parseInt(inp[0]);

            for (int j = 1; j <= count; j++) {
                int u = Integer.parseInt(inp[j]);
                child[i].add(u);
            }
        }

        level = new int[n + 1];
        parent = new int[n + 1];

        dfs(1, 1);
        build(n);
        int q = Integer.parseInt(in.readLine());

        while (q-- > 0) {
            String inp[] = in.readLine().split(" ");
            int u = Integer.parseInt(inp[0]);
            int v = Integer.parseInt(inp[1]);
            int ans = lca(u, v);
            out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            out.println("Case " + i + ":");
            solve();
        }
        out.close();
    }
}

