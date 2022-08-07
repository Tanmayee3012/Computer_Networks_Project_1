import java.net.*;
import java.io.*;
import java.util.Scanner;

public class SimpleTCPClient
{
	public static void connect(){
		try
		{
			Socket clientSock=new Socket("localhost",1234);
			
			InputStream inFromServer=clientSock.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(inFromServer));

			System.out.println("Data Received\n"+br.readLine());

			System.out.println("Do you want to tear down the connection?(Y/N)");
			Scanner inp = new Scanner(System.in);
        	char ch2 = inp.next().charAt(0);
			if(ch2=='Y'){
		    	System.out.println("Tearing down connection.....\n");
				br.close();
				clientSock.close();
			}
		}
		catch(ConnectException ce)
			{
				System.err.println("could not Connect");
			}
			
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String args[])
	{
		while(true)
		{
			Scanner inp = new Scanner(System.in);
        	string ch = inp.nextLine();
			if(ch=="connect")
			{
				connect();
			}
		}
	}
	}
