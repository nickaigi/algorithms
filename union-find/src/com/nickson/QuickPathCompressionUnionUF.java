package com.nickson;

public class QuickPathCompressionUnionUF {
    private int[] id;
    private int[] sz; //size array to count the number of objects in the tree rooted at i

    public QuickPathCompressionUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1; // each node is a root node, therefore only 1 item rooted at i
        }
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // only difference from weighted union-find
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j =  root(q);

        if (i == j)
            return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
