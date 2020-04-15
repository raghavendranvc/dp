package com.my.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeInterval {

    public static  class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
          public String toString(){
              return "start="+start+" end="+end;
          }
    }

    public class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval i1, Interval i2){
            if(i1.start < i2.start) {
                return -1;
            } else if(i2.start < i1.start) {
                return 1;
            } else {
                if(i1.end <= i2.end) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals,new IntervalComparator());

        Collections.sort(intervals,(a, b) -> Integer.compare(a.start,b.start));

        System.out.println(intervals);

        ArrayList<Interval> resultSet = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i=1;i<intervals.size();i++){
            if(end >= intervals.get(i).start){
                end = Math.max(end,intervals.get(i).end);
            } else {
                Interval interval = new Interval(start,end);
                resultSet.add(interval);
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        Interval interval = new Interval(start,end);
        resultSet.add(interval);

        /*int start = -1;
        int end = -1;
        for(int i=0;i<intervals.size();i++){
            if(start == -1){
                start = intervals.get(i).start;
                end = intervals.get(i).end;
                continue;
            }

            if(intervals.get(i-1).end > intervals.get(i).start){
                continue;
            } else {
                end = Math.max(end,intervals.get(i).end);
                Interval interval = new Interval(start,end);
                resultSet.add(interval);
                start = -1;
            }
        }
*/
        System.out.println(resultSet);
        return resultSet;
    }

    public static void main(String[] args){

        //A : [ (1, 10), (2, 9), (3, 8), (4, 7), (5, 6), (6, 6) ]
        ArrayList<Interval> arrayList = new ArrayList<>();
        /*arrayList.add(new Interval(1,10));
        arrayList.add(new Interval(2,9));
        arrayList.add(new Interval(3,8));
        arrayList.add(new Interval(4,7));
        arrayList.add(new Interval(5,6));
        arrayList.add(new Interval(6,6));*/

        arrayList.add(new Interval(47, 76));
        arrayList.add(new Interval(51, 99));
        arrayList.add(new Interval (28, 78));
        arrayList.add(new Interval  (54, 94));
        arrayList.add(new Interval  (12, 72));
        arrayList.add(new Interval  (31, 72));
        arrayList.add(new Interval  (12, 55));
        arrayList.add(new Interval  (24, 40));
        arrayList.add(new Interval  (59, 79));
        arrayList.add(new Interval  (41, 100));
        arrayList.add(new Interval (46, 99));
        arrayList.add(new Interval  (5, 27));
        arrayList.add(new Interval  (13, 23));
        arrayList.add(new Interval  (9, 69));
        arrayList.add(new Interval  (39, 75));
        arrayList.add(new Interval  (51, 53));
        arrayList.add(new Interval  (81, 98));
        arrayList.add(new Interval  (14, 14));
        arrayList.add(new Interval  (27, 89));
        arrayList.add(new Interval  (73, 78));
        arrayList.add(new Interval  (28, 35));
        arrayList.add(new Interval  (19, 30));
        arrayList.add(new Interval (39, 87));
        arrayList.add(new Interval (4, 4));
        //arrayList.add(new Interval  (60, 94), (71, 90), (9, 44), (56, 79), (58, 70), (25, 76), (18, 46), (14, 96), (43, 95), (70, 77), (13, 59), (52, 91), (47, 56), (63, 67), (28, 39), (51, 92), (30, 66), (4, 4), (29, 92), (58, 90), (6, 20), (31, 93), (52, 75), (41, 41), (64, 89), (64, 66), (24, 90), (25, 46), (39, 49), (15, 99), (50, 99), (9, 34), (58, 96), (85, 86), (13, 68), (45, 57), (55, 56), (60, 74), (89, 98), (23, 79), (16, 59), (56, 57), (54, 85), (16, 29), (72, 86), (10, 45), (6, 25), (19, 55), (21, 21), (17, 83), (49, 86), (67, 84), (8, 48), (63, 85), (5, 31), (43, 48), (57, 62), (22, 68), (48, 92), (36, 77), (27, 63), (39, 83), (38, 54), (31, 69), (36, 65), (52, 68) ]


        MergeInterval mergeInterval = new MergeInterval();

        mergeInterval.merge(arrayList);
    }

}
