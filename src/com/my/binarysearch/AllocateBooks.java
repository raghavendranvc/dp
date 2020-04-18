package com.my.binarysearch;

import com.my.common.UtilityClass;

import java.util.ArrayList;

public class AllocateBooks {


    public int books(ArrayList<Integer> A, int B) {

        if(A.size() > B){
            return -1;
        }

        long min = A.get(0);
        long max = A.get(0);

        for(int i=1;i<A.size();i++){
            min = Math.max(min,A.get(i));
            max += A.get(i);
        }

        while(min < max){
            long mid = min*1L + (max-min)/2;
            System.out.println("---mid="+mid+" min="+min+" max="+max);
            if(isPossibleToAllocate(A,B,mid)){
                max = mid;
                System.out.println("---Possible mid="+mid+" min="+min+" max="+max);
            } else {
                min = mid+1;
                System.out.println("***Not Possible mid="+mid+" min="+min+" max="+max);
            }
        }

        return (int)min%1000003;
    }

    public boolean isPossibleToAllocate(ArrayList<Integer> A, int numberOfStudents, long maxPagesPerStudent){

        int studentCount = 1;
        int pageCountOfStudent = 0;

        for(int bookPages : A){
            pageCountOfStudent += bookPages;
            System.out.println("A="+A+" bookAssigned="+pageCountOfStudent+" for student="+studentCount);
            if(pageCountOfStudent > maxPagesPerStudent){
                studentCount++;
                pageCountOfStudent = bookPages;
                System.out.println(" Next Student with new starting count="+pageCountOfStudent+ " student="+studentCount );
            }

            if(studentCount > numberOfStudents){
                return false;
            }
        }
        if(studentCount > numberOfStudents){
            return false;
        }
        return true;

    }

    public static void main(String[] args){
        int[] A = new int[] {640, 435, 647, 352, 8, 90, 960, 329, 859};
        int B = 3;

        UtilityClass.print(A);

        ArrayList<Integer> intList = new ArrayList<>(A.length);
        for (int i : A){
            intList.add(i);
        }

        AllocateBooks allocateBooks = new AllocateBooks();

        System.out.println("Result="+allocateBooks.books(intList,B));
    }


}

