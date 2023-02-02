package setup;

import java.util.Scanner;

public class ChromeVersion {
	
	String S1;
	String S2;
	
	public void checkversion()
	{
	
	Scanner s = new Scanner(System.in);
	System.out.println("Enter the first Version");
    S1=s.next();
    System.out.println("Enter the second Version");
    S2= s.next();
    
    String[] str1 = S1.split("\\.");
	String[] str2 = S2.split("\\."); 
	int count=0;
	int size=str1.length;
	int size1=str2.length;
	int length1=S1.length();
	int length2=S2.length();
	
	for(String g :str1)
	{
	    if(length1 > 0 && length2 > 0)
	    {
	    	if(Integer.parseInt(g)>Integer.parseInt(str2[count]))
	    	{
	    		System.out.println(S1+" is the latest version");
	    		break;
	    	}
	    	else if(Integer.parseInt(g)< Integer.parseInt(str2[count]))
	    	{
	    		System.out.println(S2+" is the latest version");
	    		break;
	    	}	
	    	else if((count==size-1)&&( length1==length2) && Integer.parseInt(g) == Integer.parseInt(str2[count]))
	    	{
	    		System.out.println("Both versions are same");
	    	}
	    	else if((size>size1) && Integer.parseInt(g) == Integer.parseInt(str2[count]))
	    	{
	    		System.out.println(S1+" is the latest version");
	    		break;
	    	}
	    	else if((size<size1) && Integer.parseInt(g) == Integer.parseInt(str2[count]))
	    	{
	    		System.out.println(S2+" is the latest version");
	    		break;
	    	}
	     }
	    length1--;
        length2--;
        count++;		    
	    	    		    
	    }
	}
	
	public static void main(String[] args)
	{
		ChromeVersion c=new ChromeVersion();	
		c.checkversion();	
	}

}




