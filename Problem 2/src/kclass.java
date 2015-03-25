/*
 * saurabh mishra 	  100462788
 * denesh partipan 	  100
 * naqbil patel		  100
 * Kmap slover and thedisplay only SOP
 */
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class kclass 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); // take the input for the array
		int [][] a = new int [4][4]; //intalizing the array 
		int [][] b = new int[4][4];//intalizing the flag array
		int f=0;
		
		System.out.println("Please enter only 1 and 0 for the output For equation'a' is neagative and 'A'is positive");
		System.out.println("Please enter the output of truth table:");
		for(int i = 0; i < a.length; i++)// for loop get the input
			for(int j = 0; j < a.length; j++)
			{
				System.out.print(f+":");//
				a[i][j] = sc.nextInt(); //get the input
				f++;//inceasee the variable by 1
			}
		// display the truth table
		System.out.println("Truth table: \n");
		System.out.println("A  "+"B  "+"C  "+"D  "+"| O  ");
		System.out.println("0  "+"0  "+"0  "+"0  "+"| "+a[0][0]);
		System.out.println("0  "+"0  "+"0  "+"1  "+"| "+a[0][1]);
		System.out.println("0  "+"0  "+"1  "+"0  "+"| "+a[0][2]);
		System.out.println("0  "+"0  "+"1  "+"1  "+"| "+a[0][3]);
		System.out.println("0  "+"1  "+"0  "+"0  "+"| "+a[1][0]);
		System.out.println("0  "+"1  "+"0  "+"1  "+"| "+a[1][1]);
		System.out.println("0  "+"1  "+"1  "+"0  "+"| "+a[1][2]);
		System.out.println("0  "+"1  "+"1  "+"1  "+"| "+a[1][3]);
		System.out.println("1  "+"0  "+"0  "+"0  "+"| "+a[2][0]);
		System.out.println("1  "+"0  "+"0  "+"1  "+"| "+a[2][1]);
		System.out.println("1  "+"0  "+"1  "+"0  "+"| "+a[2][2]);
		System.out.println("1  "+"0  "+"1  "+"1  "+"| "+a[2][3]);
		System.out.println("1  "+"1  "+"0  "+"0  "+"| "+a[3][0]);
		System.out.println("1  "+"1  "+"0  "+"1  "+"| "+a[3][1]);
		System.out.println("1  "+"1  "+"1  "+"0  "+"| "+a[3][2]);
		System.out.println("1  "+"1  "+"1  "+"1  "+"| "+a[3][3]);
		// swap row and column to get the kamp
		swapc(a,2,3);//swap column
		swapr(a,2,3);//swap row
		//display for the kmap
		System.out.println("Kmap Display: \n");
		printArray(a);// print the kmap with swaping
		System.out.print("\n");
		System.out.print("\n");
		// check if the array is consit of the 1 
		if(checkallarray(a))//check the method if it is true and implement the if stament
			//if true make flag one and force the equation to 1
		{
			for(int i = 0; i < a.length; i++)
				for(int j = 0; j < a.length; j++)
				{
					b[i][j]=1;
				}
			System.out.print("Equation \n");
			System.out.print("1");
		}
		else
		{//false check for the four, eight two and single in the array and implement the proper method
				System.out.print("Equation \n");
				findeightOnes(a,b);// search for eight group 1 and diaplay the equation 
				findFourOnes(a,b);//seach for the four groap for 1 and display the equation 
				solve1(a,b);//slove for the two group for 1 and display the equation
				solve(a,b);	//search for the 1 and diaplay the equation
		}	
	}
private static boolean checkallarray(int[][] a) //check for the 1 in the whole matrix
{
	int check = 1;//check variable
	for(int i = 0; i < a.length; i++)
		for(int j = 0; j < a.length; j++)
		{
			if (a[i][j] != check) //check the array element if they consist of 1
			{
            return false;//return flase
			}
		}
        return true;//lop to the other element of the body
}
	

private static void printArray(int [][] a) {//display the kamp on the screen
		int r=a.length;
		int c=a[0].length;
		for(int i =0;i<r;i++)
		{
			for(int j =0;j<c;j++)
			{
				System.out.print("|"+" "+a[i][j] +" "+"|");//format of the kamp and diaplay the array
			}
			System.out.print("\n");
		}
		System.out.println("");
	}
private static void swapc (int[][] arry,int c1, int c2)//swap the coloumn for the effect of the kmap numbering
{//this method will swap column 3 and 4
	for (int i=0;i<arry.length;i++)
	{
		int temp= arry[i][c1];//store the variable for refrence
		arry[i][c1]= arry[i][c2];//swaping the element
		arry[i][c2]= temp;
	}
	
}
private static void swapr (int [][] arry,int r1, int r2)//swap the row for the effect of the kmap numbering
{//this method will swap row 3 and 4
	int cols = arry[0].length;
    for (int j=0; j<cols; j++)
	    {
			int temp= arry[r1][j];//store the variable for refrence
			arry[r1][j]= arry[r2][j];//swaping the element
			arry[r2][j]= temp;
		}
	
}
//search for the four 1's in the equation
public static void findFourOnes(int[][] arr, int[][] b){//search for the 1 in array
	String w="00";
	for(int i=0;i<4;i++)
	{//check for the for consecutive 1 in the array
		if(arr[i][0]==1 && arr[i][1]==1 && arr[i][2]==1 && arr[i][3]==1 && b[i][0]==0 && b[i][1]==0 && b[i][2]==0 && b[i][3]==0)
			{//set the flag matrix to 1 for refrence 
				b[i][0]=1;b[i][1]=1;b[i][2]=1;b[i][3]=1;
				if (i==0){w="00";}//creating 2 bit for the row for the group
				else if(i==1){w="01";}
				else if(i==2){w="11";}
				else if(i==3){w="10";}
				String a="00";//creating 2 bit for the column for the group
				String h="01";
				String c="10";
				String d="11";
				//make the stack array
				Deque<String> s = new ArrayDeque<String>();
				s.push(w);//put the value in the array index for the row
				s.push(w);
				s.push(w);
				s.push(w);
				String p= eqn(s);//solve the row bits 
				Deque<String> m = new ArrayDeque<String>();//put the value in the array index for the column
				m.push(a);m.push(h);m.push(c);m.push(d);
				String n= eqn(m);//slove the column bit
				String v=p.concat(n);//contect the bit
				Display(v);// display the equation
			}	
	}
	
	//Check all the columns
	for(int i=0;i<4;i++)
	{
		if(arr[0][i]==1 && arr[1][i]==1 && arr[2][i]==1 && arr[3][i]==1 && b[0][i]==0 && b[1][i]==0 && b[2][i]==0 && b[3][i]==0)
			{
				b[0][i]=1;b[1][i]=1;b[2][i]=1;b[3][i]=1;
				if (i==0){w="00";}//creates the bite for the column
				else if(i==1){w="01";}
				else if(i==2){w="11";}
				else if(i==3){w="10";}
				String a="00";
				String h="01";
				String c="10";
				String d="11";
				//stack for the column pair
				Deque<String> s = new ArrayDeque<String>();
				s.push(a);//put the row bit in the stack for column group
				s.push(h);
				s.push(c);
				s.push(d);
				String p= eqn(s);
				Deque<String> m = new ArrayDeque<String>();//put the row bit in the stack for column group
				m.push(w);m.push(w);m.push(w);m.push(w);
				String n= eqn(m);
				String v=p.concat(n);//conect the bit to make byte
				Display(v);//display the equation
			}
	}
	
	//Check across corners
for(int i=0;i<4;i++)
	{
		for(int j=0;j<4;j++)
			if(arr[i][j]==1 && arr[(i+1)%4][j]==1 && arr[(i+1)%4][(j+1)%4]==1 && arr[i][(j+1)%4]==1)//Wrap arounds are also included in this
				if(b[i][j]==0 && b[(i+1)%4][j]==0 && b[(i+1)%4][(j+1)%4]==0 && b[i][(j+1)%4]==0)
				{
					String a="00",h="00",c="00";
					b[i][j]=1;b[(i+1)%4][j]=1;b[(i+1)%4][(j+1)%4]=1;b[i][(j+1)%4]=1;
					int k=(j+1)%4;//create the bit
					int l=(i+1)%4;
					if (i==0){w="00";}
					else if(i==1){w="01";}
					else if(i==2){w="11";}
					else if(i==3){w="10";}
					if (j==0){a="00";}
					else if(j==1){a="01";}
					else if(j==2){a="11";}
					else if(j==3){a="10";}
					if (k==0){h="00";}
					else if(k==1){h="01";}
					else if(k==2){h="11";}
					else if(k==3){h="10";}
					if (l==0){c="00";}
					else if(l==1){c="01";}
					else if(l==2){c="11";}
					else if(l==3){c="10";}
					//stack for the column four group row bit
					Deque<String> s = new ArrayDeque<String>();
					s.push(w);//push the row bit
					s.push(c);
					s.push(c);
					s.push(w);
					String p= eqn(s);
					//stack for the coulumn four group column bits
					Deque<String> m = new ArrayDeque<String>();
					m.push(a);m.push(a);m.push(h);m.push(h);
					String n= eqn(m);//search for the common bit
					String v=p.concat(n);//conect the string
					Display(v);//diaplay the equation
				}
	}
	
	
	
}
//search for the two group of the 1 in the array and display them
private static void solve1 (int [][] arry,int [][] b)
{
	
	
	for(int i = 0; i < arry.length; i++)//search the row pairs and loop for array
		for(int j = 0; j < arry.length; j++)
		{
			if (arry[i][j]==1 && b[i][j]==0 )
				if(arry[i][(j+1)%4]==1 && b[i][(j+1)%4]==0 )//(j+1)%4 search for the loop
				{
					String w="00",g="00",a="00";
					b[i][(j+1)%4] =1;b[i][j]=1;
					int l=(j+1)%4;
					if (i==0){w="00";}
					else if(i==1){w="01";}
					else if(i==2){w="11";}
					else if(i==3){w="10";}
					if (l==0){g="00";}
					else if(l==1){g="01";}
					else if(l==2){g="11";}
					else if(l==3){g="10";}
					if (j==0){a="00";}
					else if(j==1){a="01";}
					else if(j==2){a="11";}
					else if(j==3){a="10";}
					Deque<String> s = new ArrayDeque<String>();
					s.push(w);s.push(w);
					String p= eqn(s);
					Deque<String> m = new ArrayDeque<String>();
					m.push(a);m.push(g);
					String n= eqn(m);
					String v=p.concat(n);
					Display(v);
				}
			
			}
	//search for the column pair in the array and the loop
	for(int i = 0; i < arry.length; i++)
		for(int j = 0; j < arry.length; j++)
		{
			if (arry[i][j]==1 && b[i][j]==0 )
				if(arry[(i+1)%4][j]==1 && b[i][(j+1)%4]==0 )
				{
					String w="00",g="00",a="00";
					b[i][(j+1)%4] =1;b[i][j]=1;
					int l=(i+1)%4;
					if (j==0){w="00";}
					else if(j==1){w="01";}
					else if(j==2){w="11";}
					else if(j==3){w="10";}
					if (l==0){g="00";}
					else if(l==1){g="01";}
					else if(l==2){g="11";}
					else if(l==3){g="10";}
					if (i==0){a="00";}
					else if(i==1){a="01";}
					else if(i==2){a="11";}
					else if(i==3){a="10";}
					Deque<String> s = new ArrayDeque<String>();
					s.push(g);s.push(a);
					String p= eqn(s);
					Deque<String> m = new ArrayDeque<String>();
					m.push(w);m.push(w);
					String n= eqn(m);
					String v=p.concat(n);//make the byte
					Display(v);//display the equation
					
				}
		}
}
//search for the single element in the array
private static void solve (int [][] arry,int [][] b)
{
	for(int i = 0; i < arry.length; i++)
		for(int j = 0; j < arry.length; j++)
		{
			if (arry[i][j]==1 && b[i][j]==0 )
			{
					
					b[i][j]=1;
					String w="00",a="00";
					if (i==0){w="00";}
					else if(i==1){w="01";}
					else if(i==2){w="11";}
					else if(i==3){w="10";}
					if (j==0){a="00";}
					else if(j==1){a="01";}
					else if(j==2){a="11";}
					else if(j==3){a="10";}
					String v=w.concat(a);//make the byte
					Display(v);//display the equation
					
			}
		}
}
//search for the eight pair in the array and display the equatin
public static void findeightOnes(int[][] arr,int[][] b){
	//Check all the rows and the row loop
	for(int i=0;i<4;i++)
	{//check for the eight continous 1 in the array for the row and row loop
		if(arr[i][0]==1 && arr[i][1]==1 && arr[i][2]==1 && arr[i][3]==1)
			if (arr[(i+1)%4][0]==1 && arr[(i+1)%4][1]==1 && arr[(i+1)%4][2]==1 && arr[(i+1)%4][3]==1)
				if(b[i][0]==0 && b[i][1]==0 && b[i][2]==0 && b[i][3]==0)
					if(b[(i+1)%4][0]==0 && b[(i+1)%4][1]==0 && b[(i+1)%4][2]==0 && b[(i+1)%4][3]==0)
					{
						String w="00",g="00";
						b[i][0]=1;b[i][1]=1;b[i][2]=1;b[i][3]=1;b[(i+1)%4][0]=1;b[(i+1)%4][1]=1;b[(i+1)%4][2]=1;b[(i+1)%4][3]=1;
						int l=(i+1)%4;
						if (i==0){w="00";}
						else if(i==1){w="01";}
						else if(i==2){w="11";}
						else if(i==3){w="10";}
						if (l==0){g="00";}
						else if(l==1){g="01";}
						else if(l==2){g="11";}
						else if(l==3){g="10";}
						String a="00";
						String h="01";
						String c="10";
						String d="11";
						Deque<String> s = new ArrayDeque<String>();
						s.push(w);s.push(w);s.push(w);s.push(w);s.push(w);s.push(g);s.push(g);s.push(g);s.push(g);
						String p= eqn(s);//check for the common bits for row
						Deque<String> m = new ArrayDeque<String>();
						m.push(a);m.push(h);m.push(c);m.push(d);
						String n= eqn(m);//check for the common bits for column
						String v=p.concat(n);//create the byte
						Display(v);//display the equation
						
					}			
	}
	
	//Check all the columns
	for(int i=0;i<4;i++)
	{
		if(arr[0][i]==1 && arr[1][i]==1 && arr[2][i]==1 && arr[3][i]==1)
			if(arr[0][(i+1)%4]==1 && arr[1][(i+1)%4]==1 && arr[2][(i+1)%4]==1 && arr[3][(i+1)%4]==1)
				if(b[0][i]==0 && b[1][i]==0 && b[2][i]==0 && b[3][i]==0)
					if(b[0][(i+1)%4]==0 && b[1][(i+1)%4]==0 && b[2][(i+1)%4]==0 && b[3][(i+1)%4]==0)
					{
						String w="00",g="00";
						b[0][i]=1;b[1][i]=1;b[2][i]=1;b[3][i]=1;b[0][(i+1)%4]=1;b[1][(i+1)%4]=1;b[2][(i+1)%4]=1;b[3][(i+1)%4]=1;
						int l=(i+1)%4;
						if (i==0){w="00";}
						else if(i==1){w="01";}
						else if(i==2){w="11";}
						else if(i==3){w="10";}
						if (l==0){g="00";}
						else if(l==1){g="01";}
						else if(l==2){g="11";}
						else if(l==3){g="10";}
						String a="00";
						String h="01";
						String c="10";
						String d="11";
						Deque<String> s = new ArrayDeque<String>();
						s.push(a);s.push(h);s.push(c);s.push(d);
						String p= eqn(s);
						Deque<String> m = new ArrayDeque<String>();
						m.push(w);m.push(w);m.push(w);m.push(w);m.push(g);m.push(g);m.push(g);m.push(g);
						String n= eqn(m);
						String v=p.concat(n);
						Display(v);
						
					}
	}
}
//method to check the common bit in the row and column and return sing for the sop equation
private static String eqn(Deque<String> s) {
	String temp= s.pop();
	while(!s.isEmpty())//check for the empty stack
	{
		String b=s.pop();
		for (int i = 0; i < temp.length(); i++)
			if (temp.charAt(i) != b.charAt(i))
			{
				char[] CharTemp = temp.toCharArray();//convert the string  to the char 
				CharTemp[i] = '-';//put the - to refrence the change in the bit
				temp = String.valueOf(CharTemp);//convrt char to the string
			}
	}
	return temp;//return the common bit to the make the byte
}
//display the SOP equation check for bit and crossponding character and equation
public static void Display(String d)
{
	char[] CharTemp = d.toCharArray();//convert the string to array
	//check for bit and crossponding character and equation
	for (int i = 0; i < d.length(); i++)
	{
		
		//Check for A
	if ((CharTemp[i] == '1') && (i == 0))
		{
			CharTemp[i] = 'A'; 
		}
		
		else if ((CharTemp[i] == '0')&& (i == 0))
		{
			CharTemp[i] = 'a'; 
		}
		else if ((CharTemp[i] == '-')&& (i == 0))
		{
			CharTemp[i] = '\0'; //empty char 
		}
		//Check for B
		if ((CharTemp[i] == '1') && (i == 1))
		{
			CharTemp[i] = 'B'; 
		}
		
		else if ((CharTemp[i] == '0')&& (i == 1))
		{
			CharTemp[i] = 'b'; 
		}
		else if ((CharTemp[i] == '-')&& (i == 1))
		{
			CharTemp[i] = '\0'; 
		}
		//Check for C
		if ((CharTemp[i] == '1') && (i == 2))
		{
			CharTemp[i] = 'C'; 
		}
		else if ((CharTemp[i] == '0')&& (i == 2))
		{
			CharTemp[i] = 'c'; 
		}
		else if ((CharTemp[i] == '-')&& (i == 2))
		{
			CharTemp[i] = '\0'; 
		}
	//Check for D
		if ((CharTemp[i] == '1') && (i == 3))
		{
			CharTemp[i] = 'D'; 
		}
		
		else if ((CharTemp[i] == '0')&& (i== 3))
		{ 
			CharTemp[i] = 'd'; 
		}
		else if ((CharTemp[i] == '-')&& (i == 3))
		{
			CharTemp[i] = '\0'; 
		}
	}
	d = String.valueOf(CharTemp);//create the strind for the SOP
	System.out.print(d+"+");//Display the SOP
}
}



