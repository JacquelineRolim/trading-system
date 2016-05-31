import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameVenda extends JFrame implements ActionListener {
	
	private JButton buttonAcrescentarProduto;
    private JButton buttonGravar;
    private JButton buttonRemoverProduto;
    private JButton buttonSelecionarCliente;
    private JButton buttonVoltar;
    private JTextArea textAreaProdutos;
    private JTextArea textAreaProdutosVenda;
    private JLabel labelCliente;
    private JLabel labelProdutos;
    private JLabel labelNomeCliente;
    private JLabel labelTitulo;
    
    private JLabel labelValorTotal;
    
    ArrayList<Produto> listaProdutosVenda = new ArrayList<Produto>();
    
    Cliente cliente;
    float valorTotal;
    
	public FrameVenda() {
		setSize(800, 600);
        setLayout(null);
        setVisible(true);
        
        labelTitulo = new JLabel();
        labelTitulo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        labelTitulo.setText("VENDA");
        labelTitulo.setBounds(350, 20, 70, 14);
        add(labelTitulo);
        
        labelCliente = new JLabel();
        labelCliente.setText("Cliente");
        labelCliente.setBounds(180, 60, 100, 20);
        add(labelCliente);
        
        labelNomeCliente = new JLabel();
        labelNomeCliente.setText("Nome do Cliente");
        labelNomeCliente.setBounds(280, 60, 360, 20);
        add(labelNomeCliente);
        
        buttonSelecionarCliente = new JButton();
        buttonSelecionarCliente.setText("Selecionar Cliente");
        buttonSelecionarCliente.addActionListener(this);
        buttonSelecionarCliente.setBounds(180, 80, 140, 23);
        add(buttonSelecionarCliente);
        
        labelProdutos = new JLabel();
        labelProdutos.setText("Produtos");
        labelProdutos.setBounds(180, 130, 100, 20);
        add(labelProdutos);
        
        buttonAcrescentarProduto = new JButton();
        buttonAcrescentarProduto.setText("Acrescentar Produto");
        buttonAcrescentarProduto.addActionListener(this);
        buttonAcrescentarProduto.setBounds(290, 130, 140, 23);
        add(buttonAcrescentarProduto);
        
        buttonRemoverProduto = new JButton();
        buttonRemoverProduto.setText("Remover Produto");
        buttonRemoverProduto.addActionListener(this);
        buttonRemoverProduto.setBounds(440, 130, 140, 23);
        add(buttonRemoverProduto);
        
        textAreaProdutos = new JTextArea();
        textAreaProdutos.setColumns(20);
        textAreaProdutos.setRows(10);
        textAreaProdutos.setBounds(180, 160, 410, 120);
        add(textAreaProdutos);
        
        labelValorTotal = new JLabel();
        labelValorTotal.setText("0.00");
        labelValorTotal.setBounds(680, 300, 100, 20);
        add(labelValorTotal);
        
        buttonGravar = new JButton();
        buttonGravar.setText("Gravar");
        buttonGravar.addActionListener(this);
        buttonGravar.setBounds(220, 300, 110, 30);
        add(buttonGravar);
        
        buttonVoltar = new JButton();
        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(this);
        buttonVoltar.setBounds(440, 300, 110, 30);
        add(buttonVoltar);
        
        // CARREGA TODOS OS PRODUTOS CADASTRADOS NO TEXT AREA
        String produtos = "";
    	for (int i = 0; i < Produto.listaProdutos.size(); i++) {
        	produtos = produtos + Produto.listaProdutos.get(i).getCod() + " - " + Produto.listaProdutos.get(i).getDescricao() + " - " + Produto.listaProdutos.get(i).getQuant() + " - " + Produto.listaProdutos.get(i).getPreco() + "\n";
        }
        
    	textAreaProdutos.setText(produtos);
    	
    	textAreaProdutosVenda = new JTextArea();        
        textAreaProdutosVenda.setText("");
        textAreaProdutosVenda.setBounds(100, 350, 600, 150);
        add(textAreaProdutosVenda);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttonGravar) {
			Venda venda = new Venda(cliente, listaProdutosVenda);
			
            JOptionPane.showMessageDialog(null, "Venda gravada com sucesso.");
            
            listaProdutosVenda = new ArrayList<Produto>(); // LIMPA A LISTA DE PRODUTOS 
            textAreaProdutosVenda.setText("");
            
            valorTotal = 0;
            labelValorTotal.setText(valorTotal + "");
			
        } else if (e.getSource() == buttonAcrescentarProduto) {
        	int codigoIncluir = 0;
        	
        	try {
        		codigoIncluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto para ser incluído na venda."));
        		
        	} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro no Código (00).\nInforme apenas números.");
			}
        	
        	for (int p = 0; p < Produto.listaProdutos.size(); p++) {
        		if (codigoIncluir == Produto.listaProdutos.get(p).getCod()) {
        			listaProdutosVenda.add(Produto.listaProdutos.get(p));
        			
        			valorTotal = valorTotal + Produto.listaProdutos.get(p).getPreco();
        			labelValorTotal.setText(valorTotal + "");
        			
        			JOptionPane.showMessageDialog(null, "Produto incluído com sucesso.");
        		}
        	}
        	
        	// CARREGA TODOS OS PRODUTOS DA VENDA NO OUTRO TEXT AREA
            String produtosVenda = "";
        	for (int i = 0; i < listaProdutosVenda.size(); i++) {
            	produtosVenda = produtosVenda + listaProdutosVenda.get(i).getCod() + " - " + listaProdutosVenda.get(i).getDescricao() + " - " + listaProdutosVenda.get(i).getQuant() + " - " + listaProdutosVenda.get(i).getPreco() + "\n";
            }
            
        	textAreaProdutosVenda.setText(produtosVenda);
        	
        } else if (e.getSource() == buttonRemoverProduto) {
        	int codigoExcluir = 0;
        	
        	try {
        		codigoExcluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do produto para ser excluído."));
        	
        	} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro no Código (00).\nInforme apenas números.");
			}
        	
        	for (int p = 0; p < listaProdutosVenda.size(); p++) {
        		if (codigoExcluir == listaProdutosVenda.get(p).getCod()) {
        			valorTotal = valorTotal - listaProdutosVenda.get(p).getPreco();
        			labelValorTotal.setText(valorTotal + "");
        			
        			listaProdutosVenda.remove(p);
        			
        			JOptionPane.showMessageDialog(null, "Produto removido com sucesso.");
        		}
        	}
        	
        	// CARREGA TODOS OS PRODUTOS DA VENDA NO OUTRO TEXT AREA
            String produtosVenda = "";
            for (int i = 0; i < listaProdutosVenda.size(); i++) {
            	produtosVenda = produtosVenda + listaProdutosVenda.get(i).getCod() + " - " + listaProdutosVenda.get(i).getDescricao() + " - " + listaProdutosVenda.get(i).getQuant() + " - " + listaProdutosVenda.get(i).getPreco() + "\n";
            }
            
        	textAreaProdutosVenda.setText(produtosVenda);
        	
        } else if (e.getSource() == buttonSelecionarCliente) {
        	String clientes = "";
        	for (int i = 0; i < Cliente.listaClientes.size(); i++) {
            	clientes = clientes + Cliente.listaClientes.get(i).getCod() + " - " + Cliente.listaClientes.get(i).getNome() + " - " + Cliente.listaClientes.get(i).getCpf() + " - " + Cliente.listaClientes.get(i).getEndereco() + "\n";
            }
            
        	JOptionPane.showMessageDialog(null, clientes);
        	
        	int codigoIncluir = 0;
        	
        	try {
        		codigoIncluir = Integer.parseInt(JOptionPane.showInputDialog("Informe o código do cliente."));
        	
        	} catch (NumberFormatException n) {
				JOptionPane.showMessageDialog(null, "Erro no Código (00).\nInforme apenas números.");
			}
        	
        	for (int p = 0; p < Cliente.listaClientes.size(); p++) {
        		if (codigoIncluir == Cliente.listaClientes.get(p).getCod()) {
        			cliente = Cliente.listaClientes.get(p);
        			labelNomeCliente.setText(cliente.getNome());
        			
        			JOptionPane.showMessageDialog(null, "Cliente selecionado com sucesso.");
        		}
        	}
        	
        } else if (e.getSource() == buttonVoltar) {
        	setVisible(false);       
        }
	} 
}