import java.util.ArrayList;

public class Venda {
	
	private Cliente cliente;
	static ArrayList <Produto> listaProduto = new ArrayList<>();
	
	static ArrayList <Venda> listaVenda = new ArrayList<>();
	
	public Venda(Cliente clien, ArrayList<Produto> produtos) {
		this.cliente = clien;
		listaProduto = produtos;
	}
	
	public Cliente getCodCliente() {
		return cliente;
	}

	public void setCliente(Cliente clien) {
		this.cliente = clien;
	}	
}