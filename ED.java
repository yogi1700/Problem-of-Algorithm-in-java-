import java.io.*;
import java.util.*;
public class ED
{
	public static int min(int i ,int j ,int k)//return minimum among the i,j,k
	{
	if(i<j)
	{
          if(i<k)
	    {
	      return i;
	    }
	  else
	    return k;
	 }
 	else
	  {
	    if(j<k)
	      return j;
	    else
	      return k;
	   }
       }
 public static int edit_distance(String str1, String str2)
  {
   int m=str1.length();
   int n=str2.length();
   //System.out.println(m+" and "+n);
   int [][] T=new int[m+1][n+1];
   for(int i=0;i<=n;i++) //for converting null string to i length string
   {
    T[0][i]=i;
   }
   for(int i=1;i<=m;i++) //for converting i length string to null string
    {
     T[i][0]=i;
    }
    for(int i=1;i<=m;i++) 
     {
       for(int j=1;j<=n;j++)
          {
           if(str1.charAt(i-1)==str2.charAt(j-1)) //if ends of both string are same
		{
			T[i][j]=T[i-1][j-1]; // then no. of operation for (i length to j length string) will be equals to no of operation  for string length i-1 to j-1 
		}
	   else

             // If last characters are not same, consider all three
             // operations on last character of first string
             //like insert then calculate T[i][j-1]
             //like remove then calculate T[i-1][j]
             //like replace then calculate T[i-1][j-1]
             //calculate minimum among and add 1 for one of operation
             
	    T[i][j]=min(T[i][j-1],T[i-1][j],T[i-1][j-1])+1;

	  }
    }
return T[str1.length()][str2.length()];//return the minimum no of operation
}
 public static void main(String args[])
 { 
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the your corrupted string");
  String str1=sc.next();
  System.out.println("Enter the your desired String");
  String str2=sc.next();
  int k=edit_distance(str1,str2);
  System.out.println("minimum no operation required is to convert "+str1+" to "+str2+" ="+k);
 }
}
