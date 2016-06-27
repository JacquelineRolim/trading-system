import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class EscreverArquivoProdutos {
	
	int linhasEscritas = 0; 
	int linhaAEscrever = 0;
	String aux;
	
	File arquivo;
	
	ArrayList<String> arrayDadosLidosArquivo = new ArrayList<String>()	;
	
	ArrayList<Produto> arrayNomes = new ArrayList<Produto>();
	
	public EscreverArquivoProdutos(Produto produtoNovo) {
		arquivo = new File("Produtos.txt");
		
		try {
			BufferedReader lerConteudoExistente = new BufferedReader(new FileReader(arquivo));
			
			while ((aux = lerConteudoExistente.readLine()) != null) {
				arrayDadosLidosArquivo.add(aux);
				linhasEscritas++;
			}
			
			lerConteudoExistente.close();
			
		} catch(IOException ioe) {
			System.out.println("Erro ao ler arquivo: " + ioe);
		}
		
		try {
			BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivo));
			
			while (linhaAEscrever < linhasEscritas) {
				escrever.write(arrayDadosLidosArquivo.get(linhaAEscrever));
				escrever.newLine();
				linhaAEscrever++;
			}
			
			int codigo = produtoNovo.getCod(); 
			String descricao = produtoNovo.getDescricao();
			float preco = produtoNovo.getPreco();
			int quantidade = produtoNovo.getQuant();
			
			try {
				escrever.write(codigo + "-" + descricao + "-" + preco + "-" + quantidade);
				
			} catch(Exception e) {
				System.out.println("Erro na escrita no arquivo!");
			}
			
			escrever.close();
			
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo!");
			e.printStackTrace();
		}
	}
	
	public static void deletarArquivo() {
		File arquivo = new File("Produtos.txt");
		
		try {
			arquivo.delete();
			
		} catch(Exception ioe) {
			System.out.println("Erro ao deletar arquivo: " + ioe);
		}
	}
}
