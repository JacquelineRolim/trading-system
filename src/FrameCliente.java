import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameCliente extends JFrame implements ActionListener {
	
	private JButton buttonCadastrar;
    private JButton buttonListar;
    private JButton buttonRemover;
    private JButton buttonVoltar;
    private JLabel labelTitulo;
    private JLabel labelCodigo;
    private JLabel labelNome;
    private JLabel labelCPF;
    private JLabel labelEndereco;
    private JTextField textFieldCodigo;
    private JTextField textFieldNome;
    private JTextField textFieldCPF;
    private JTextField textFieldEndereco;
	private JTextArea textAreaLista;
    
	public FrameCliente() {
		setSize(780, 680);
        setLayout(null);
        setVisible(true);

        labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Times New Roman", 0, 14));
        labelTitulo.setText("CLIENTE");
        labelTitulo.setBounds(350, 20, 70, 14); // X, Y, LARGURA, ALTURA
        add(labelTitulo);
        
        labelCodigo = new JLabel();
        labelCodigo.setText("Código");
        labelCodigo.setBounds(210, 100, 100, 20);
        add(labelCodigo);

        labelNome = new JLabel();
        labelNome.setText("Nome");
        labelNome.setBounds(210, 130, 100, 20);
        add(labelNome);
        
        labelEndereco = new JLabel();
        labelEndereco.setText("Endereço");
        labelEndereco.setBounds(210, 190, 100, 20);
        add(labelEndereco);
        
        labelCPF = new JLabel();
        labelCPF.setText("CPF");
        labelCPF.setBounds(210, 160, 100, 20);
        add(labelCPF);
        
        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(310, 100, 250, 20);
        add(textFieldCodigo);
        
        textFieldNome = new JTextField();
        textFieldNome.setBounds(310, 130, 250, 20);
        add(textFieldNome);
        
        textFieldCPF = new JTextField();
        textFieldCPF.setBounds(310, 160, 250, 20);
        add(textFieldCPF);
        
        textFieldEndereco = new JTextField();
        textFieldEndereco.setBounds(310, 190, 250, 20);
        add(textFieldEndereco);
        
        buttonCadastrar = new JButton();
        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(this);
        buttonCadastrar.setBounds(170, 250, 110, 30);
        add(buttonCadastrar);
        
        buttonRemover = new JButton();
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(this);
        buttonRemover.setBounds(280, 250, 110, 30);
        add(buttonRemover);
        
        buttonListar = new JButton();
        buttonListar.setText("Listar");
        buttonListar.addActionListener(this);
        buttonListar.setBounds(390, 250, 110, 30);
        add(buttonListar);
        
        buttonVoltar = new JButton();        
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(this);
        buttonVoltar.setBounds(500, 250, 110, 30);
        add(buttonVoltar);
        
        textAreaLista = new JTextArea(); // USA O TEXT AREA PARA MOSTRAR OS CLIENTES        
        textAreaLista.setText("");
        textAreaLista.setBounds(100, 320, 600, 180);
        add(textAreaLista);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonCadastrar) {
			try {
				int cod = Integer.parseInt(textFieldCodigo.getText());
				String nom = textFieldNome.getText();
	        	String cpf = textFieldCPF.getText(); 
	        	String end = textFieldEndereco.getText();
	        	
	        	Cliente cliente = new Cliente(cod, nom, end, cpf);
	        	cliente.cadastrarCliente(cliente);
	            
	            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
	        	
	            textFieldCodigo.setText("");
	            textFieldNome.setText("");
	            textFieldCPF.setText("");
	            textFieldEndereco.setText("");
	            
			} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro no Código (00).\nInforme apenas números.");
			}
			
        } else if (e.getSource() == buttonRemover) {
        	String clientes = "";
        	for (int i = 0; i < Cliente.listaClientes.size(); i++) {
            	clientes = clientes + Cliente.listaClientes.get(i).getCod() + " - " + Cliente.listaClientes.get(i).getNome() + " - " + Cliente.listaClientes.get(i).getCpf() + " - " + Cliente.listaClientes.get(i).getEndereco() + "\n";
            }
            
        	textAreaLista.setText(clientes);
        	
        	int codigoExcluir = 0;
        	
        	try {
        		codigoExcluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente para ser excluído."));
        	
        	} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro no Código (00).\nInforme apenas números.");
			}
        	
        	for (int p = 0; p < Cliente.listaClientes.size(); p++) {
        		if (codigoExcluir == Cliente.listaClientes.get(p).getCod()) {
        			Cliente.removerCliente(p);
        			JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");
        		}
        	}
        	
        	textAreaLista.setText("");        	
            
        } else if (e.getSource() == buttonListar) {
            String clientes = "";
        	for (int i = 0; i < Cliente.listaClientes.size(); i++) {
        		clientes = clientes + Cliente.listaClientes.get(i).getCod() + " - " + Cliente.listaClientes.get(i).getNome() + " - " + Cliente.listaClientes.get(i).getCpf() + " - " + Cliente.listaClientes.get(i).getEndereco() + "\n";
            }
            
        	textAreaLista.setText(clientes);
        	
        	JOptionPane.showMessageDialog(null, "Pressione OK para finalizar a visualização.");
        	
        	textAreaLista.setText("");
        	
        } else if (e.getSource() == buttonVoltar) {
        	setVisible(false);       
        }
	} 
}