package com.greatlearning.main;
import java.util.Stack;
import java.util.Scanner;


public class FloorConstruction {

	public static void main(String[] args) {
		System.out.println("Enter the total number of floors in the building");
		Scanner sc = new Scanner( System.in );
		int numFlr=sc.nextInt();
		Stack stack= new Stack();
		//storing the order of construction in array of arrays
		Integer[][] constr=new Integer[numFlr][numFlr];
		int index=0;
		int day=1;
		for (int i=numFlr;i>0;i--)
		{					
			System.out.println("enter the floor size given on day :"+day);
			day++;
			int FlrSize=sc.nextInt();
			if(FlrSize==i && stack.isEmpty()) {
				constr[index][0]=i;
				index++;
		}

			//if less than expected, anyway it gets postponed
			else if (FlrSize<i)
			{
				stack.push(FlrSize);
				constr[index][0]=null;
				index++;
				
			}
			else if (FlrSize>i&& !stack.isEmpty()&&(stack.size()==FlrSize-i)) {
	
				boolean found = false;
				while(!stack.isEmpty()) {
				int d=(int)stack.pop();
				found = false;
				for(int j=FlrSize-1;j>=i;j--) {					
					if (d==j) {
						found=true;
						break;
					}
				}
				if (found==false) {
					constr[index][0]=null;
					index++;
				}
				}
				if (stack.isEmpty()&&found==true) {
					int c=0;
					for (int k=FlrSize;k>=i;k--) {
						constr[index][c]=k;
						c++;
					}
					index++;
					
				}
					
				}

		}
		System.out.println("The order of construction is as follows");
		for (int ct=0;ct<index;ct++)
		{
			System.out.println("Day: "+ (ct+1));
			for (int fl=0;fl<constr[ct].length;fl++) {
				if (constr[ct][fl]!=null)
				{
					System.out.print(constr[ct][fl]);
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		}
		}




