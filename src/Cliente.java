
import java.util.ArrayList;

public class Cliente {

	private int cod;
	private String nome;
	private String endereco;
	private String cpf;
	static ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	public Cliente(int codigo, String nome, String endereco, String cpf) {
		this.cod = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	public String getCpf(){
		return cpf;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	public int getCod(){
		return cod;
	}
	public void setCod(int cod){
		this.cod = cod;
	}
	
	//METODOS
	public void cadastrarCliente(Cliente cliente){
		listaClientes.add(cliente);
	}
	
	public static void removerCliente(int posicaoCliente) {
		listaClientes.remove(posicaoCliente);
	}
}