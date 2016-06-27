import java.io.BufferedReader;
import java.io.FileReader;


public class LerArquivoProduto {
		
		FileReader fileReader;
		BufferedReader reader;
		
		public LerArquivoProduto() {
			String linhaLida;
			Produto produtoLido;
			
			while (Produto.listaProdutos.size() > 0) {
				Produto.listaProdutos.remove(0);
			}
			
			try {
				fileReader = new FileReader("Produtos.txt");
				reader = new BufferedReader(fileReader);
				
				while((linhaLida = reader.readLine()) != null){
					char produtoChar[] = linhaLida.toCharArray();
					String codigo = "";
					String descricao = "";
					String preco = "";
					String quantidade = "";
					
					int posicaoLinhaLida = 0;
					
					for (; produtoChar[posicaoLinhaLida] != '-'; posicaoLinhaLida++) {
						codigo = codigo + produtoChar[posicaoLinhaLida];
					}
					
					posicaoLinhaLida++;
					
					for (; produtoChar[posicaoLinhaLida] != '-'; posicaoLinhaLida++) {
						descricao = descricao + produtoChar[posicaoLinhaLida];
					}
					
					posicaoLinhaLida++;
					
					for (; produtoChar[posicaoLinhaLida] != '-'; posicaoLinhaLida++) {
						preco = preco + produtoChar[posicaoLinhaLida];
					}
					
					for (posicaoLinhaLida++; posicaoLinhaLida < produtoChar.length; posicaoLinhaLida++) {
						quantidade = quantidade + produtoChar[posicaoLinhaLida];
					}
						
				    produtoLido = new Produto(Integer.parseInt(codigo), descricao, Float.parseFloat(preco), Integer.parseInt(quantidade));
				    Produto.listaProdutos.add(produtoLido);
				}
				
				fileReader.close();
				reader.close();
				
			} catch (Exception e) {
				System.out.println("ERRO AO LER ARQUIVO: " + e);
			}
		}
	}