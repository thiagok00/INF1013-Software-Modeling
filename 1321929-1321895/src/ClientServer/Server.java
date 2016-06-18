package ClientServer;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Server implements Runnable {

	private static ServerSocket server;
	private static ConcurrentLinkedQueue<ClientThread> clientList = new ConcurrentLinkedQueue<ClientThread>()  ; 
	private static Server singleton = null;
	private static int numeroJogadores;
	
	ServerFrame frame;
	
	static public Server getInstance() {
		if (singleton == null) {
			singleton = new Server();
		}
		return singleton;
	}
	
	private Server() {

		
	}
	public void openSocket(int porta, int numJogadores) {
		this.numeroJogadores = numJogadores;
		try {
			server = new ServerSocket(porta);
			System.out.println("Porta: "+porta+" aberta.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		int i=0;
		while (i < numeroJogadores) {
			try {		
				ClientThread t = new ClientThread(server.accept());
				Server.clientList.add(t);
				i++;
				frame.qtdJogadoresLabel.setText("Jogadores Conectados: "+i);
				new Thread(t).start();

			} catch (IOException e) {
				System.out.println(e);
			}
		
		}	
		//BROADCAST INICIO JOGO
		Server.getInstance().broadCast(""+numeroJogadores);
		
		
	} 
	
	
	/////
	
	public void broadCast(String s) {

		for (ClientThread cThread : Server.clientList ) {
			Socket cSocket = cThread.getClientSocket();
			try {
				PrintStream output = new PrintStream(cSocket.getOutputStream());
				output.println(s);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
