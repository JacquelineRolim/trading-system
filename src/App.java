import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame implements ActionListener {
	
	private JLabel labelTitulo;
	private JButton buttonProduto;
	private JButton buttonCliente;
    private JButton buttonVenda;
    private JButton buttonSair;
	
	public App() {        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLayout(null);
        
        labelTitulo = new JLabel();
        labelTitulo.setFont(new java.awt.Font("Times New Roman", 0, 30));
        labelTitulo.setText("Trading System");
        labelTitulo.setBounds(320, 20, 220, 40);
        add(labelTitulo);
        
        buttonProduto = new JButton();
        buttonProduto.setText("PRODUTO");
        buttonProduto.setSize(160, 60);
        buttonProduto.setLocation(80, 120);
        add(buttonProduto);
        buttonProduto.addActionListener(this);
        
        buttonCliente = new JButton();
        buttonCliente.setText("CLIENTE");
        buttonCliente.setSize(160, 60);
        buttonCliente.setLocation(310, 120);
        add(buttonCliente);
        buttonCliente.addActionListener(this);
        
        buttonVenda = new JButton();
        buttonVenda.setText("VENDA");
        buttonVenda.setSize(160, 60);
        buttonVenda.setLocation(560, 120);
        add(buttonVenda);
        buttonVenda.addActionListener(this);
        
        buttonSair = new JButton();
        buttonSair.setText("SAIR");
        buttonSair.setSize(120, 40);
        buttonSair.setLocation(600, 400);
        add(buttonSair);
        buttonSair.addActionListener(this);
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
		App app = new App();
		app.setVisible(true);
	}
}