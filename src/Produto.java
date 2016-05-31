import java.util.ArrayList;

public class Produto {
	private String descricao;
	private int cod;
	private float preco;
	private float quant;
	
	static ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	public Produto(int cod, String descricao, float preco, float quant) {
		this.cod = cod;
		this.descricao = descricao;
		this.preco = preco;
		this.quant = quant;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getQuant() {
		return quant;
	}

	public void setQuant(float quant) {
		this.quant = quant;
	}
	
	//METODOS
	public void cadastrarProduto(Produto produto){
		listaProdutos.add(produto);
	}
	
	public static void removerProduto(int posicaoProduto) {
		listaProdutos.remove(posicaoProduto);
	}
}