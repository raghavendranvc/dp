Array Rotation : Array length n and rotate by d 
===============================================
1) Use GCD(length, value).
------------------------------------
	Let's say length is 12 and we need to rotate by 3, then GCD(12,3) is 3. 
	So we rotate all by 0, 3, 6, 9 and then do the same for 1,4,7,10 and for 2,5,8,11.  

2) Array Reversal
-----------------
	Another way is to reverse [0,d)	
	Reverse [d,n)
	Reverse (0,n)

Rotated Sorted Array Search
===========================
Find which half is sorted and then search 
-------------------------------------------
	If mid is greater than low, then first half is sorted. then if the element is here, such as usual.Else , if the element is outside this range, then make low = mid+1. Similarly check for the other half.

Find smallest element
---------------------
	Use recursion technique. Check mostly for mid if mid is the right one. Else traverse either left or right. We also need to make sure the case when array is not rotated. 
	Discard the second half of the array if it is sorted. If not, find the minimum there.
	
Querying on Circular array
==========================
	If asked to do m rotations left, n rotations right, we must only move the index from 0 to m by from m to n depending on directions using mod and when an element is asked we use this effective index to get the element
	
Q: Arrange given numbers to form the biggest number
>> xY, YX (merging) would determines which number is bigger X or Y

Minimum product of k integers in an array of positive Integers
>> Use heaps

K-th Largest Sum Contiguous Subarray
>>Precompute array called SumSoFar and then do maxHeap of k elements

K maximum sum combinations from two arrays
>> Sort, Use MaxHeap and insert i,j-1 and i-1,j. 


K maximum sums of overlapping contiguous sub-arrays
>> Tricky thing. User preFixSum 

Find k numbers with most occurrences in the given array
>> Map<> and do incrementKey operation on the heap when frequency is incremented

Find the smallest missing number in a sorted array
>> Modified binary search

Maximum and minimum of an array using minimum number of comparisons
>> Use Divide and Conquer method to get the min and max at each step






* Median of a sorted array of size n is defined as the middle element when n is odd and average of middle two elements when n is even.

