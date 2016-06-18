package ClientServer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ServerFrame extends JFrame implements MouseListener  {

	JFrame frame;
	JLabel qtdJogadoresLabel;
	
	
	
	public ServerFrame(JFrame frame) {
		this.frame = frame;
		
		this.setLayout(null);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		
		
		qtdJogadoresLabel = new JLabel("Jogadores Conectados: 0");
		this.add(qtdJogadoresLabel);
		qtdJogadoresLabel.setVisible(true);
		qtdJogadoresLabel.setBounds(0, 0, 200, 140);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		this.setVisible(true);
		
		Integer[] choices = { 3, 4, 5, 6};
		Integer in = (Integer) JOptionPane.showInputDialog(this, "Quantidade de jogadores?",
		            "Iniciar Jogo", JOptionPane.QUESTION_MESSAGE, null,choices,choices[0]);
		if (in == null){
		    	return;
		}   
		    
		String input = JOptionPane.showInputDialog(this, "Porta", "Porta para aplicação", JOptionPane.PLAIN_MESSAGE);
		
		
		if (input != null) {
			Integer porta = Integer.parseInt(input);
			System.out.println(porta+" "+in);		
			
			Server s = Server.getInstance();
			s.frame = this;
			s.openSocket(porta,in);
			new Thread(s).start();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
