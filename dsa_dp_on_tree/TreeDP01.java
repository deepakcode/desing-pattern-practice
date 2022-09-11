package com.practice.dsa_dp_on_tree;
import java.util.LinkedList;

class TreeDP01 {

    static int[] dp = new int[100];

    static void dfs(LinkedList<Integer>[] tree, int node, int parent) {
        dp[node-1] = 1;
        int count=0;
        for (int child : tree[node]) {
            if(child==parent)
                continue;
            dfs(tree,child,node);
            dp[node-1] = dp[node-1] + dp[child-1];
        }
    }

    //use DFS here
    static void countSubOrdinate(LinkedList<Integer>[] tree){
        dfs(tree, 1, 0);
        for(int i=0; i<5 ; i++){
            System.out.print((i+1)+"-"+(dp[i]-1)+" \n");
        }
    }

    public static void main(String[] args){
        int n = 14;
        LinkedList<Integer>[] tree = new LinkedList[n + 1];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new LinkedList<>();

        tree[1].add(2); tree[2].add(1);
        tree[1].add(3); tree[3].add(1);
        tree[2].add(4); tree[4].add(2);
        tree[3].add(5); tree[5].add(3);

        countSubOrdinate(tree);
    }
}

