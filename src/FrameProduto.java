import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameProduto extends JFrame implements ActionListener {
	
	private JButton buttonCadastrar;
    private JButton buttonListar;
    //private JButton buttonRemover;
    private JButton buttonVoltar;
    private JLabel labelTitulo;
    private JLabel labelCodigo;
    private JLabel labelDescricao;
    private JLabel labelPreco;
    private JLabel labelQuantidade;
    private JTextField textFieldCodigo;
    private JTextField textFieldDescricao;
    private JTextField textFieldPreco;
    private JTextField textFieldQuantidade;
	private JTextArea textAreaLista;
    
	public FrameProduto() {
		setSize(800, 600);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(207,221,237));

        labelTitulo = new JLabel();
        labelTitulo.setFont(new Font("Times New Roman", 0, 14));
        labelTitulo.setText("PRODUTO");
        labelTitulo.setBounds(350, 20, 70, 14); // X, Y, LARGURA, ALTURA
        add(labelTitulo);
        
        labelCodigo = new JLabel();
        labelCodigo.setText("Código");
        labelCodigo.setBounds(210, 100, 100, 20);
        add(labelCodigo);

        labelDescricao = new JLabel();
        labelDescricao.setText("Descrição");
        labelDescricao.setBounds(210, 130, 100, 20);
        add(labelDescricao);
        
        labelPreco = new JLabel();
        labelPreco.setText("Preço");
        labelPreco.setBounds(210, 190, 100, 20);
        add(labelPreco);
        
        labelQuantidade = new JLabel();
        labelQuantidade.setText("Quantidade");
        labelQuantidade.setBounds(210, 160, 100, 20);
        add(labelQuantidade);
        
        textFieldPreco = new JTextField();
        textFieldPreco.setBounds(310, 190, 250, 20);
        add(textFieldPreco);
        
        textFieldCodigo = new JTextField();
        textFieldCodigo.setBounds(310, 100, 250, 20);
        add(textFieldCodigo);
        
        textFieldDescricao = new JTextField();
        textFieldDescricao.setBounds(310, 130, 250, 20);
        add(textFieldDescricao);
        
        textFieldQuantidade = new JTextField();
        textFieldQuantidade.setBounds(310, 160, 250, 20);
        add(textFieldQuantidade);
        
        buttonCadastrar = new JButton();
        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(this);
        buttonCadastrar.setBounds(170, 250, 110, 30);
        add(buttonCadastrar);
        
        /*buttonRemover = new JButton();
        buttonRemover.setText("Remover");
        buttonRemover.addActionListener(this);
        buttonRemover.setBounds(280, 250, 110, 30);
        add(buttonRemover);*/
        
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
        
        textAreaLista = new JTextArea(); // USA O TEXT AREA PARA MOSTRAR OS PRODUTOS        
        textAreaLista.setText("");
        textAreaLista.setBounds(100, 320, 600, 180);
        add(textAreaLista);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonCadastrar) {
			try {
				int cod = Integer.parseInt(textFieldCodigo.getText());
				String desc = textFieldDescricao.getText();
	        	float prec = Float.parseFloat(textFieldPreco.getText()); 
	        	int quant = Integer.parseInt(textFieldQuantidade.getText());
	        	
	        	Produto produto = new Produto(cod, desc, prec, quant);
	            produto.cadastrarProduto(produto);
	            
	            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
	        	
	            textFieldCodigo.setText("");
	            textFieldDescricao.setText("");
	            textFieldPreco.setText("");
	            textFieldQuantidade.setText("");
	            
			} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro no Código (00), Preço (0.00) ou Quantidade (00).\nInforme apenas números no código e na quantidade, e no preço coloca ponto (.)");
			}
			
        }/* else if (e.getSource() == buttonRemover) {
        	new LerArquivoProdutos();
        	
        	String produtos = "";
        	for (int i = 0; i < Produto.listaProdutos.size(); i++) {
            	produtos = produtos + Produto.listaProdutos.get(i).getCod() + " - " + Produto.listaProdutos.get(i).getDescricao() + " - " + Produto.listaProdutos.get(i).getQuant() + " - " + Produto.listaProdutos.get(i).getPreco() + "\n";
            }
            
        	textAreaLista.setText(produtos);
        	
        	int codigoExcluir = 0;
        	
        	try {
        		codigoExcluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto para ser excluído."));
        	
        	} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro no Código (00).\nInforme apenas números.");
			}
        	
        	for (int p = 0; p < Produto.listaProdutos.size(); p++) {
        		if (codigoExcluir == Produto.listaProdutos.get(p).getCod()) {
        			Produto.removerProduto(p);
        			JOptionPane.showMessageDialog(null, "Produto removido com sucesso.");
        		}
        	}
        	
        	textAreaLista.setText("");        	
            
        }*/ else if (e.getSource() == buttonListar) {
        	new LerArquivoProduto();
        	
        	String produtos = "";
        	for (int i = 0; i < Produto.listaProdutos.size(); i++) {
            	produtos = produtos + Produto.listaProdutos.get(i).getCod() + " - " + Produto.listaProdutos.get(i).getDescricao() + " - " + Produto.listaProdutos.get(i).getQuant() + " - " + Produto.listaProdutos.get(i).getPreco() + "\n";
            }
            
        	textAreaLista.setText(produtos);
        	
        	JOptionPane.showMessageDialog(null, "Pressione OK para finalizar a visualização.");
        	
        	textAreaLista.setText("");
        	
        } else if (e.getSource() == buttonVoltar) {
        	setVisible(false);       
        }
	} 
}