import java.util.*;
import java.lang.*;
import java.io.*;

class TrappingRainWater {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();

		while (t>0)
		{
			int n=input.nextInt();

			int[] arr= new int[n];


			for(int i=0;i<n;i++)
			{
				arr[i]=input.nextInt();
			}


				System.out.println(findWater(arr));

			t--;
		}

	}

	private static int findWater(int[] arr) {
		// TODO Auto-generated method stub
		 // left[i] contains height of tallest bar to the
	    // left of i'th bar including itself
	    int n=arr.length;
		int [] left=new int [n];
	 
	    // Right [i] contains height of tallest bar to
	    // the right of ith bar including itself
	    int [] right =new int [n];
	 
	    // Initialize result
	    int water = 0;
	 
	    // Fill left array
	    left[0] = arr[0];
	    for (int i = 1; i < n; i++)
	       left[i] = Math.max(left[i-1], arr[i]);
	 
	    // Fill right array
	    right[n-1] = arr[n-1];
	    for (int i = n-2; i >= 0; i--)
	       right[i] = Math.max(right[i+1], arr[i]);
	 
	    // Calculate the accumulated water element by element
	    // consider the amount of water on i'th bar, the
	    // amount of water accumulated on this particular
	    // bar will be equal to min(left[i], right[i]) - arr[i] .
	    for (int i = 0; i < n; i++)
	       water += Math.min(left[i],right[i]) - arr[i];
	 
	    return water;
	}
}