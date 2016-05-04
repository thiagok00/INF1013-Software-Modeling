package Visao;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controlador.ControladorMaquina;

public class StartPainel extends JPanel implements ActionListener {

	private JButton startButton;
	private ControladorMaquina maquina;
	StartPainel(ControladorMaquina m) {
		super();
		
		this.setBounds(0, 0, 100, 100);
		setLayout(new GridLayout(0,1));
		
		this.maquina = m;
		startButton = new JButton("START");
		startButton.setVisible(true);
		startButton.addActionListener(this);
		add(startButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		maquina.start();
	}
	
	
	
}
