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

			System.out.println("Do you want to tear down the connection?(1)\nDo you want to reconnect?(2)");
			Scanner inp = new Scanner(System.in);
        	char ch2 = inp.next().charAt(0);
			if(ch2=='1'){
		    	System.out.println("Tearing down connection.....\n");
				br.close();
				clientSock.close();
			}
			if(ch2=='2'){
		    	System.out.println("Reconnecting.....\n");
				connect();
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
		
			Scanner inp = new Scanner(System.in);
			System.out.println("Enter c to connect\n");
        	Character ch = inp.next().charAt(0);
            if(ch=='c')
			{
				System.out.println("Connecting to server.....\n");
				connect();
			}
		
	}
	}