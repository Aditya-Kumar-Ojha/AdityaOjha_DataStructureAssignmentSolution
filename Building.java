package com.GreatLearning.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Building
{
	
	Stack<Integer> stack = new Stack<>();
	Queue<List<Integer>> queue = new LinkedList<>();
	int ht;

	void construction(int[] arr )
	{
	  for (int i = 0; i < arr.length; i++) {
	  if (ht == arr[i]) {
	  List<Integer> list = new ArrayList<>();
	  list.add(arr[i]);
	  int x = arr[i];
	  while (!stack.isEmpty() && stack.peek()== --x)
	  {
		/// 4 5 1 2 3
	     list.add(stack.pop());
	  }                       
	  
	  /// 1 2 3 8 9 10 4 5 7 6
	  queue.add(list);
	  ht = ht-list.size();

	  }
	else 
	  {
	   stack.push(arr[i]);
	   queue.add(new ArrayList<>());
	  }
   }

  }	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Building Obj1=new Building();
      Scanner sc=new Scanner(System.in);
      System.out.println("\n Enter the height of Building:");
      int j=sc.nextInt();
      Obj1.ht=j;
      int a[]=new int[j];
      
      for(int i=0;i<j;i++)
      {
    	  System.out.println("\n Enter the Floor size given on day:" +(i+1));
    	  a[i]=sc.nextInt();
      }
      Obj1.construction(a);
      System.out.println("\n The order of construction is as follows:");
      for(int i=1;i<=j;i++)
      {
    	  System.out.println("Day:"+i);
    	  System.out.println(Obj1.queue.poll());
      }
	}

}
