import java.io.*;
import java.util.*;

public class KS
 {
 int T[][];
 void dp(int [] w,int [] p, int c,int n)
  {
   T=new int[n+1][c+1];
   for(int i=0;i<=c;i++)
   {
    T[0][i]=0;
   }
   for(int i=1;i<=n;i++)
   {
    T[i][0]=0;
    for(int j=1;j<=c;j++)
     {
      if((w[i]<=j)&&T[i-1][j-w[i]]+p[i]>T[i-1][j])
      T[i][j]=T[i-1][j-w[i]]+p[i];
      else
      T[i][j]=T[i-1][j];
     }
   }
//checking which items are included in computation
int i=n,j=c,count=0;
int [] store=new int[n];
while(i!=0&&j!=0)
{
if(T[i-1][j]==T[i][j])
{
i=i-1;
}
else
{
store[count++]=i;
j=j-w[i];
i=i-1;
}
}
//printing that items which are included
for(int z=0;z<n;z++)
{
if(store[z]!=0)
{
System.out.println(" it is included with item no "+store[z]+" with weight "+w[store[z]]+" and profit is="+p[store[z]]);
}
}
}

//for printing storage array of computation
void print(int c, int n)
{
/*for(int i=0;i<=n;i++)
{
for(int j=0;j<=c;j++)
{
System.out.print(T[i][j]+" ");
}
System.out.print(i+" \n");
}*/
System.out.println("\nand maximum profit is="+T[n][c]);
}

public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("no of items=");
int n=sc.nextInt();
int[] w=new int[n+1];
int[] p=new int[n+1];
System.out.println("now enter weight and profit of item");
for(int k=1;k<n+1;k++)
{
w[k]=sc.nextInt();
p[k]=sc.nextInt();
}
System.out.println("now enter your knapsack capicity");
int c=sc.nextInt();
KS ks=new KS();
ks.dp(w,p,c,n);
//System.out.println("now calculated array");
ks.print(c,n);
}
}
