package com.my.arrays;

import com.my.common.UtilityClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class MaxProd {

    //LS = A[j] > A[i] ( i>j ). ; maximum value of j.
    //RS = A[j] > A[i] ( j>i )  ; minimum value of j.

    //      0  1  2  3  4  5  6  7
    //      2  3  6  7  3  2  4  5

    //LS    -  -  -  -  3  4  3  3
    //RS    1  2  3  -  6  6  7  -
    //P                18 24 21

    //      0  1  2  3  4  5  6  7  8  9  10
    //A : [ 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 ]

    //LS    -  -  1  1  3  4  3  -  7  8  -
    //RS    1  -  3  7  7  6  7  -  10 10   -

    public int maxSpecialProduct(ArrayList<Integer> A) {

        int[] LS = new int[A.size()];
        int[] RS = new int[A.size()];

        Stack<Integer> stack = new Stack<>();

        for(int i=1; i<A.size();i++){
            if(A.get(i-1) > A.get(i)){
                stack.push(i-1); //Push the index so that further elements can check
                LS[i] = i-1;
                continue;
            }

            while(!stack.empty()){
                if(A.get(stack.peek()) > A.get(i)){
                    LS[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        //UtilityClass.print(LS);

        stack = new Stack<>();
        for(int i=A.size()-2; i>=0;i--){
            if(A.get(i+1) > A.get(i)){
                RS[i] = i+1;
                stack.push(i+1);
                continue;
            }
            while(!stack.empty()){
                if(A.get(stack.peek()) > A.get(i)){
                    LS[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        //UtilityClass.print(RS);

        long max = 0;
        for(int i=0;i<A.size();i++) {
            max = Math.max(max, 1L*LS[i]*RS[i]);
        }

        return (int)(max%1000000007);
    }

    public int maxSpecialProduct1(ArrayList<Integer> A) {
        int n = A.size();

        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> q = new ArrayDeque<>(); //Stack version
        q.addLast(0);

        for(int i = 1; i < n; i++){
            while(!q.isEmpty()){
                if(A.get(q.getLast()) > A.get(i)) {
                    break;
                }
                q.removeLast();
            }
            left[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }

        q = new ArrayDeque<>();
        q.addLast(n - 1);
        for(int i = n - 2; i >= 0; i--){
            while(!q.isEmpty()){
                if(A.get(q.getLast()) > A.get(i)) {
                    break;
                }
                q.removeLast();
            }
            right[i] = (q.isEmpty()) ? 0 : q.getLast();
            q.addLast(i);
        }

        long mx = -1;
        for(int i = 0; i < n; i++){
            mx = Long.max(mx, 1L * left[i] * right[i]);
        }
        return (int)(mx % 1000000007);
    }

    public int maxSpecialProduct2(ArrayList<Integer> A) {
        int n = A.size();
        if(n==0)
            return 0;
        int left[] = new int[n];
        left[0] = 0;
        for(int i=1;i<n;i++) //(.....i.....) for each i find max Element between (0,i-1)
        {
            int j = i-1;
            while(j>0){
                if(A.get(i)<A.get(j)){
                    left[i] = j;
                    break;
                }
                j = left[j];
            }
        }
        int right[] = new int[n];
        for(int i=n-2;i>=0;i--)
        {
            int j = i+1;
            while(j>0)
            {
                if(A.get(i)<A.get(j))
                {
                    right[i] = j;
                    break;
                }
                j = right[j];
            }
        }
        long max = 0;
        for(int i=0;i<n;i++)
            max = Math.max((long)left[i]*right[i], max);
        return (int)(max%1000000007);
    }

    private ArrayList<Integer> leftSpecialV(ArrayList<Integer> A){

        ArrayList<Integer> r = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<A.size();i++){
            while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                s.pop();
            }

            if(s.empty()){
                r.add(0);
            }
            else{
                r.add(s.peek());
            }
            s.push(i);
        }

        return r;
    }

    private ArrayList<Integer> rightSpecialV(ArrayList<Integer> A){

        ArrayList<Integer> r = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=A.size()-1;i>=0;i--){
            while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                s.pop();
            }

            if(s.empty()){
                r.add(0,0);
            }
            else{
                r.add(0,s.peek());
            }
            s.push(i);
        }

        return r;
    }

    public int maxSpecialProduct3(ArrayList<Integer> A) {
        ArrayList<Integer> l = leftSpecialV(A);
        ArrayList<Integer> r = rightSpecialV(A);

        long product=0, res= 0;

        for(int i=0;i<A.size();i++){
            res= (long)l.get(i) * (long)r.get(i);
            if(product < res){
                product  = res;
            }
        }

        return (int)(product%1000000007);
    }

    public int maxSpecialProductNonStack(ArrayList<Integer> A) {

        int[] LS = new int[A.size()];
        int[] RS = new int[A.size()];

        for(int i=0; i<A.size();i++){
            for(int j = i-1; j>= 0; j--) {
                if(A.get(j) > A.get(i)){
                    LS[i] = j;
                    break;
                }
            }
        }

        for(int i=A.size()-1; i>=0; i--){
            for(int j = i+1; j<A.size(); j++) {
                if(A.get(j) > A.get(i)){
                    RS[i] = j;
                    break;
                }
            }
        }

        long max = 0;
        for(int i=0;i<A.size();i++) {
            max = Math.max(max, 1L*LS[i]*RS[i]);
        }

        return (int)(max%1000000007);
    }

    public static void main(String[] args) {
        //int[] a = new int[] {5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9 };
        int[] a = new int[] {523, 4241, 1053, 7816, 5181, 1293, 7152, 6053, 4974, 4678, 418, 7627, 2466, 6262, 2740, 850, 5008, 7720, 2431, 377, 7826, 3582, 8328, 8660, 3498, 1194, 8226, 4830, 8823, 1349, 2554, 880, 9469, 6228, 7425, 6432, 4278, 6407, 501, 1273, 1602, 3931, 699, 9078, 4550, 7295, 7128, 3653, 60, 9578, 4671, 8152, 7225, 7085, 5021, 5016, 5220, 4178, 8696, 6896, 5665, 5601, 5119, 5118, 3724, 1618, 3755, 9569, 8588, 4576, 4914, 8123, 4158, 717, 583, 143, 963, 8009, 8441, 7306, 1171, 7407, 5202, 8720, 1621, 2963, 318, 7136, 1753, 895, 3236, 4611, 832, 4364, 1852, 3848, 5452, 1111, 5550, 9448, 6235, 1749, 9224, 8089, 6772, 933, 8960, 7257, 5346, 4703, 9724, 2890, 1820, 7495, 4887, 7108, 7393, 2501, 4947, 5402, 9366, 2745, 2757, 4475, 7918 };

        UtilityClass.print(a);

        ArrayList<Integer> intList = new ArrayList<Integer>(a.length);
        for (int i : a)
        {
            intList.add(i);
        }
        MaxProd maxProd = new MaxProd();
        maxProd.maxSpecialProduct(intList);
    }


}
