package ClientServer;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import controller.ControllerTabuleiro;
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
		
		String[] msgs = waitStart().split("_");
		Configuracao.cli = this; 
		Configuracao.getInstance().inicializaJogoRede(Integer.parseInt(msgs[0]),msgs[1]);
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
	
	private String waitStart() {
		
		Scanner in_serv = null;
		try {
			in_serv = new Scanner(Cliente.cli.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente esperando começar");
		String msgDoServidor = in_serv.nextLine();
		System.out.println(msgDoServidor);
		return msgDoServidor;
				
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
		ControllerTabuleiro.getInstance().desmembraMsg(msgDoServidor);
			
			
		}		

		System.out.println("Cliente nao escutando");
		in_serv.close();
	} 
}
