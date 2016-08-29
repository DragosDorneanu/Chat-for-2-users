import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;

public class ChatClient 
{	
	private static Socket client;

	private static String readClientName(Scanner cin)
	{
		String name = cin.nextLine();
		return name;
	}
	
	private static void sendClientNameToServer(DataOutputStream clientOutput, String clientName) throws IOException
	{
		clientOutput.writeUTF(clientName);
		clientOutput.flush();
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner cin = new Scanner(System.in);
		String clientName;
		client = new Socket("localhost", 8888);
		DataInputStream clientInput = new DataInputStream(client.getInputStream());
		DataOutputStream clientOutput = new DataOutputStream(client.getOutputStream());
		System.out.print("Enter your user name : ");
		clientName = readClientName(cin);
		sendClientNameToServer(clientOutput, clientName);
		new SendMessageThread(clientOutput, clientName, cin).start();
		new RecieveMessageThread(clientInput, clientName).start();
	}
}
