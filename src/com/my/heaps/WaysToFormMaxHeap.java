package com.my.heaps;

public class WaysToFormMaxHeap {

    //TODO

    private static final int MAX = 100;

    int[] dp = new int[MAX];
    int[][] nck = new int[MAX][MAX];
    int[] log2 = new int[MAX];

    public int solve(int A) {
        for(int i=0;i<=A;i++){
            dp[i] = -1;
        }

        for(int i=0;i<=A;i++){
            for(int j=0;j<=A;j++){
                nck[i][j]=-1;
            }
        }

        /*
        At level 'i', number of nodes possible is 2^i
        nodes[i] = 2^i => x = 2^i;

        nodes[1] = 1
        nodes[2] = 4
        nodes[3] = 8

        Doing reverse if tree has 8 nodes, height possible = 4 (For 7 is a complete full binary tree)
        if tree has 7 nodes, height possible = 3 (nodes between 4-7)
        So we are storing the height possible for each of the i nodes


         */
        int currentLog = -1;
        int current2Power = 1;
        for(int i=1;i<=A;i++){
            if(current2Power == i){
                currentLog++;
                current2Power=current2Power*2;
            }
            log2[i] = currentLog;
        }

        return getNumberOfHeaps(A);

    }

    public int getNumberOfHeaps(int n){
        if( n <= 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int left = getLeftHeapRecursively(n);
        dp[n] = nckRecu(n-1,left) * getNumberOfHeaps(left) * getNumberOfHeaps(n-1-left);
        return dp[n];
    }


    // ncr = (n-1)c(r-1) + (n-1)cr
    // nc0=1 ncn=1 1cn = 1
    public int nckRecu(int n, int k){
        if(k>n){
            return 0;
        }

        if(k == 0){
            return 1;
        }

        if(n<=1){
            return 1;
        }

        if(nck[n][k] == -1){
            nck[n][k] = nckRecu(n-1,k-1) * nckRecu(n-1,k);
        }
        return nck[n][k];
    }

    public int getLeftHeapRecursively(int n){
        if(n == 1){ //lowest subtree
            return 0;
        }

        int h = log2[n];

        int maxNodesPossible = (1 <<h); //2^h //Nodes possible at height h
        int nodesActuallyPresentInTheLastLevel = n - (maxNodesPossible-1);

        /*
        Contains more than half
         */
        if(nodesActuallyPresentInTheLastLevel > maxNodesPossible/2){
            return (maxNodesPossible) - 1;  //2^h-1
        } else {
            return (maxNodesPossible - 1 - (maxNodesPossible/2-nodesActuallyPresentInTheLastLevel)) ;
        }
    }

}
