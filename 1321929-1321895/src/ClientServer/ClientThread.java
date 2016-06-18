package ClientServer;
import java.net.Socket;
import java.util.Scanner;

public class ClientThread implements Runnable {

	private Socket clientSocket;
	
	
	ClientThread(Socket c) {
		this.clientSocket = c;
	}
	
	public Socket getClientSocket(){
		return clientSocket;
	}
	
	@Override
	public void run() {
		Server server = Server.getInstance();
		try {
			Scanner in = new Scanner(clientSocket.getInputStream());
			while(in.hasNextLine()) {
				String input = in.nextLine();	
				String inputString = (String) input;
				System.out.println(inputString);
				server.broadCast(inputString);								
			}
			in.close();
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

}
