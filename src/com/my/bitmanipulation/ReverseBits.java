package com.my.bitmanipulation;

public class ReverseBits {

    public long reverse(long a) {

        // 0 0 0 0 0 0 1 0 1 0 1 1
        // 1 1 1 1 1 1 1 1 1 1 1 1
        // 1 1 1 1 1 1 0 1 0 1 0 0

        long reverserNumber = 0;
        int count = 0;
        while (count < 32){
            reverserNumber <<= 1;
            if((a & 1) == 1){
                reverserNumber = reverserNumber | 1;
            }
            a = a >> 1;
            count++;
        }
        return reverserNumber;
    }

    public long reverseCopied(long A) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1; // This will shift left. But '0' bit is set at the last
            if ((A & (1 << i)) != 0)
                rev |= 1;
        }

        return rev;

    }
    
}
