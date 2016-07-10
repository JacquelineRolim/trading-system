import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class App extends JFrame implements ActionListener {
	
	static ArrayList<Usuario> usuario;
			
	private JLabel labelTitulo;
	private JLabel imagem;
	private JButton buttonProduto;
	private JButton buttonCliente;
    private JButton buttonVenda;
    private JButton buttonSair;
	
	public App() {      
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocation(112, 0);
        setLayout(null);
        getContentPane().setBackground(new Color(207,221,237));
        
        labelTitulo = new JLabel();
        labelTitulo.setFont(new java.awt.Font("Times New Roman", 0, 18));
        labelTitulo.setText("Projeto PDS");
        labelTitulo.setBounds(300, 10, 200, 30);
        add(labelTitulo);
        
        buttonProduto = new JButton();
        buttonProduto.setText("PRODUTO");
        buttonProduto.setSize(150, 50);
        buttonProduto.setLocation(70, 120);
        add(buttonProduto);
        buttonProduto.addActionListener(this);
        
        buttonCliente = new JButton();
        buttonCliente.setText("CLIENTE");
        buttonCliente.setSize(150, 50);
        buttonCliente.setLocation(310, 120);
        add(buttonCliente);
        buttonCliente.addActionListener(this);
        
        buttonVenda = new JButton();
        buttonVenda.setText("VENDA");
        buttonVenda.setSize(150, 50);
        buttonVenda.setLocation(550, 120);
        add(buttonVenda);
        buttonVenda.addActionListener(this);
        
        buttonSair = new JButton();
        buttonSair.setText("SAIR");
        buttonSair.setSize(100, 30);
        buttonSair.setLocation(650, 500);
        add(buttonSair);
        buttonSair.addActionListener(this);
        setVisible(true);
        
        JPanel imagem2 = new JPanel();
        imagem2.setSize(200, 200);
        imagem2.setLocation(50, 200);
        imagem2.setVisible(true);
        add(imagem2);
        
        imagem = new JLabel();
        imagem.setSize(200, 200);
        imagem.setLocation(50, 200);
        imagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/images.jpg")));
        imagem.setVisible(true);
        imagem2.add(imagem);
        
        usuario = new ArrayList<>();
        
        new LerArquivoUsuario();
    	new Login();	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonCliente) {
			FrameCliente frameCliente = new FrameCliente();
            
        } else if (e.getSource() == buttonProduto) {        	
        	FrameProduto frameProduto = new FrameProduto();
            
        } else if (e.getSource() == buttonVenda) {
        	FrameVenda frameVenda = new FrameVenda();
            
        } else if (e.getSource() == buttonSair) {
            System.exit(0);
        }
	}
	
	public static void main(String[] args) {
		new App();
	}	
}