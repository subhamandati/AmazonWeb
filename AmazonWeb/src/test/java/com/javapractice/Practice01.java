package com.javapractice;

import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rows");
		int rows = sc.nextInt();
		System.out.println("Here is the pattern");
		
		for(int i=0; i<=rows; i++)
		{
			for(int j=rows-1;j>=i;j--)
			{
				System.out.print(" ");
			}
			
			for(int j=0;j<=i;j++)
			{
				System.out.print("* ");
			}
			
			System.out.println();
			
			
		}
		sc.close();
	}

}
