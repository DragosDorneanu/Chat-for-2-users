import java.io.DataInputStream;
import java.io.IOException;

public class RecieveMessageThread extends Thread 
{
	private DataInputStream from;
	private String message, username;
	
	public RecieveMessageThread(DataInputStream from, String username) 
	{
		this.from = from;
		this.username = username;
	}
	
	private synchronized void recieveMessage(DataInputStream from) throws IOException
	{
		int count;
		if(from.available() > 0)
		{
			for(count = 1; count <= username.length() + 3; ++count)
				System.out.print('\b');
			message = from.readUTF();
			System.out.println(message);
			System.out.print(username + " : ");
		}
	}
	
	@Override
	public void run() 
	{
		while(from != null)
		{
			try {
				recieveMessage(from);
			}
			catch(IOException e)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
}	