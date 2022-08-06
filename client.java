import java.net.*;
import java.io.*;
public class client {
    public static void main(String args[])
    {
        try{
            Socket clientSock=new Socket("localhost",1234);
            InputStream inFromServer=clientSock.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(inFromServer));
            System.out.println("Data Received\n"+br.readLine());
            br.close();
            clientSock.close();
        }
        catch(ConnectException ce)
        {
            System.out.println("Could not connect");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
