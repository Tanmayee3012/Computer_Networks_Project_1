import java.net.*;
import java.io.*;

public class SimpleTCPServer
{
	public static void main(String args[])
	{
		ServerSocket s=null;
		
		try
		{
			s=new ServerSocket(1234);
			
			System.out.println ("TCPServer Waiting for client on port 1234");
		
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		while(true)
		{
		
			try
			{
				Socket connSock=s.accept();
				
				System.out.println("Client connected......Preparing to send the data....");
				
				OutputStream outToClient = connSock.getOutputStream();
				BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(outToClient));
				bw.write("Hello Client");
				System.out.println("Data Sent.");		
				
				bw.close();
				outToClient.close();
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}