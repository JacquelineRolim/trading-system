import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


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
        
        imagem = new JLabel();
        imagem.setSize(400, 400);
        imagem.setLocation(50, 150);
        imagem.setIcon(new javax.swing.ImageIcon("C:/Users/Usuario/Dropbox/UFRPE-UAST/UFRPE-UAST 5º PERIODO/PDS/trading-system-/sistemaComercial.jpg"));
        
        imagem.setVisible(true);
        add(imagem);
        
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