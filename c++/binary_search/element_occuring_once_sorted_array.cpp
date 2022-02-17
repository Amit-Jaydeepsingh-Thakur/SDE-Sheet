/*
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.



Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10

*/

#include<algorithm>

int uniqueElement(vector<int> arr, int n)
{
	// Write your code here
    int low = 0,high=arr.size()-1;

        while(low < high)
        {
            int mid = (low+high)/2;

            //if mid is even then [0,mid] is odd
            //check if arr[mid]==arr[mid+1]
            //if yes then there doen't exists single element from [0,mid+1]
            if(mid%2 == 0 )
            {
                if(arr[mid]==arr[mid+1])
                    low = mid+2;
                else
                    high = mid;
            }
            else
            {
                if(arr[mid]==arr[mid-1])
                    low = mid+1;
                else
                    high = mid;
            }
        }

    return arr[low];
}

