import java.util.ArrayList;

public class Produto {
	private String descricao;
	private int cod;
	private float preco;
	private int quant;
	
	static ArrayList<Produto> listaProdutos = new ArrayList<>();
	
	public Produto(int cod, String descricao, float preco, int quant) {
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

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	public void cadastrarProduto(Produto produtoNovo){
		new EscreverArquivoProdutos(produtoNovo);
	}
}