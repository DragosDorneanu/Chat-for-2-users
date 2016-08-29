import java.io.DataOutputStream;
import java.util.Scanner;
import java.io.IOException;

public class SendMessageThread extends Thread
{	
	private DataOutputStream destination;
	private String message, username;
	private Scanner cin;
	
	public SendMessageThread(DataOutputStream destination, String username, Scanner cin) 
	{
		this.destination = destination;
		this.username = username;
		this.cin = cin;
	}

	private synchronized String readMessage(Scanner cin) {
		return cin.nextLine().trim();
	}
	
	private synchronized void sendMessage(DataOutputStream destination, String message) throws IOException
	{
		destination.writeUTF(message);
		destination.flush();
	}
	
	@Override
	public void run() 
	{
		while(destination != null)
		{
			System.out.print(username + " : ");
			message = username + " : " + readMessage(cin);
			try {
				sendMessage(destination, message);
			}
			catch(IOException e)
			{
				System.err.println(e.getMessage());
				e.printStackTrace();
				cin.close();
				System.exit(1);
			}
		}
	}	
}