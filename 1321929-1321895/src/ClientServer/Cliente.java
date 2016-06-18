package ClientServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import view.Configuracao;

public class Cliente implements Runnable{
	private static Socket cli = null;
	private static PrintStream saida = null ;
	
	
	public Cliente(String ip, int porta) {
		try {
			Cliente.cli = new Socket(ip, porta);
			Cliente.saida = new PrintStream(cli.getOutputStream());
		} catch (IOException e) {
			System.out.println("Server not reached");
			e.printStackTrace();
		}
		int qtdJogadores = waitStart();
		Configuracao.getInstance().inicializaJogoRede(qtdJogadores);
		new Thread(this).start();
	}
	
	public void sendMsgToServer(String msg) {
		
		saida.println(msg);
		
	}
	
	public void closeConnection() {
		try {
			cli.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int waitStart() {
		
		Scanner in_serv = null;
		try {
			in_serv = new Scanner(Cliente.cli.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente esperando começar");
		String msgDoServidor = in_serv.nextLine();
		System.out.println(msgDoServidor);
		return Integer.parseInt(msgDoServidor);
				
	}

	@Override
	public void run() {
		Scanner in_serv = null;
		try {
			in_serv = new Scanner(Cliente.cli.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente escutando");
		while (in_serv.hasNextLine()) {
			String msgDoServidor = in_serv.nextLine();
			System.out.println(msgDoServidor);
			//TODO: fazer alguma coisa c msgDoServidor
		}		

		System.out.println("Cliente nao escutando");
		in_serv.close();
	} 
}
