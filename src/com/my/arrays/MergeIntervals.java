package com.my.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class MergeIntervals {

    public static  class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        public String toString(){
            return "("+start+", "+end+")";
        }


    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        /*Interval[] intervalArray = intervals.toArray(new Interval[intervals.size()]);

        intervals = Arrays.sort(intervals.toArray(new Interval[intervals.size()]), (i1,i2) -> {

            return 0;
        });*/


        int originalSize = intervals.size();
        int i=0;
        for(;i<originalSize;i++){
            if(intervals.get(i).start < newInterval.start) {
                continue;
            } else {
                if(intervals.get(i).start == newInterval.start) {
                    if(intervals.get(i).end <= newInterval.end) {
                        continue;
                    }
                }
            }
            //System.out.println("i="+i+" int="+intervals.get(i)+" newInterval="+newInterval);
            break;
        }

        //System.out.println(intervals);


        if(i == originalSize){
            intervals.add(newInterval);
        } else {
            //i+1, i+2, i+3 .... n
            //i+1(x), i+2, i+3 .... n, n+1
            intervals.add(intervals.get(originalSize-1)); //Move 1 to the right
            for(int j=originalSize-1;j>i;j--){
                intervals.set(j,intervals.get(j-1));
            }
            intervals.set(i,newInterval);
        }

        //System.out.println("After Insertion");
        //System.out.println(intervals);

        ArrayList<Interval> returnList = new ArrayList<>();

        returnList.add(intervals.get(0));

        for(i=1;i<intervals.size();i++){

            Interval i1 = returnList.get(returnList.size()-1);
            Interval i2 = intervals.get(i);
            //System.out.println("interation="+i+ " Checking i1="+i1+" i2"+i2);
            if(overlaps(i1,i2)) {
                returnList.set(returnList.size()-1, getMergedInterval(i1,i2));
            } else {
                returnList.add(i2);
            }

            //System.out.println(returnList);
        }

        System.out.println(returnList);
        return returnList;
    }

    public Interval getMergedInterval(Interval i1, Interval i2){
        Interval interval = new Interval();
        if(i1.start <= i2.start){
            interval.start = i1.start;
        } else {
            interval.start = i2.start;
        }

        if(i1.end <= i2.end){
            interval.end = i2.end;
        } else {
            interval.end = i1.end;
        }

        return interval;
    }

    public boolean overlaps(Interval i1, Interval i2){

        if(i1.start < i2.start){
            if(i1.end > i2.start) {
                return true;
            }
        } else if(i1.start > i2.start){
            if(i2.end > i1.start) {
                return true;
            }
        } else {
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        ArrayList<Interval> A = new ArrayList<>();
        A.add(new Interval(6037774, 6198243));  A.add(new Interval(6726550, 7004541));  A.add(new Interval (8842554, 10866536));
        A.add(new Interval (11027721, 11341296));A.add(new Interval (11972532, 14746848));A.add(new Interval (16374805, 16706396));
        A.add(new Interval (17557262, 20518214));A.add(new Interval (22139780, 22379559));A.add(new Interval (27212352, 28404611));
        A.add(new Interval (28921768, 29621583));A.add(new Interval (29823256, 32060921));A.add(new Interval (33950165, 36418956));
        A.add(new Interval (37225039, 37785557));A.add(new Interval (40087908, 41184444));A.add(new Interval (41922814, 45297414));
        A.add(new Interval (48142402, 48244133));A.add(new Interval (48622983, 50443163));A.add(new Interval (50898369, 55612831));
        A.add(new Interval (57030757, 58120901));A.add(new Interval (59772759, 59943999));A.add(new Interval (61141939, 64859907));
        A.add(new Interval (65277782, 65296274));A.add(new Interval (67497842, 68386607));A.add(new Interval (70414085, 73339545));
        A.add(new Interval (73896106, 75605861));A.add(new Interval (79672668, 84539434));A.add(new Interval (84821550, 86558001));
        A.add(new Interval (91116470, 92198054));A.add(new Interval (96147808, 98979097));


        Interval B = new Interval(36210193, 61984219);


        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.insert(A,B);

    }
}
