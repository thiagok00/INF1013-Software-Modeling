import java.io.IOException;
import java.net.*;
import java.util.Scanner; 

public class Servidor {

	public static void main(String args[]) throws IOException {

		ServerSocket servidor = new ServerSocket(1111); 
		System.out.println("Porta 1111 aberta!");
		Socket cliente = servidor.accept(); 
		System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());
		
		Scanner in = new Scanner(cliente.getInputStream());
		while (in.hasNextLine()) { 

			System.out.println(in.nextLine());

		}
		in.close();
		servidor.close();
		cliente.close();
		System.out.println("O servidor terminou de executar!");
	} 
}
