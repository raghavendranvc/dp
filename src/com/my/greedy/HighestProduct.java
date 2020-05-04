package com.my.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {
    public int maxp3(ArrayList<Integer> A) {
        Collections.sort(A, Collections.reverseOrder());
        return Math.max(A.get(0)*A.get(1)*A.get(2), A.get(0)*A.get(A.size()-1)*(A.get(A.size()-2)));
    }
}
