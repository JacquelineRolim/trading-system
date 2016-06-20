import java.io.BufferedReader;
import java.io.FileReader;


public class LerArquivoProduto {
	FileReader fileReader;
	BufferedReader reader;
	
		String linhaLida;
		Produto produtoLido;
		
		try {
			fileReader = new FileReader("Produto.txt");
			reader = new BufferedReader(fileReader);
			
			while((linhaLida = reader.readLine()) != null){
				char produtoChar[] = linhaLida.toCharArray();
				
				int i = 0;
				
				for (; produtoChar[i] != '-'; i++) {
					produtoChar[i];
				}
				
				for (i++; i < produtoChar.length; i++) {
					produtoChar[i];
				}
					
			    produtoLido = new Produto();
			    App.produto.add(produtoLido);
			}
			
			fileReader.close();
			reader.close();
			
		} catch (Exception e) {
			System.out.println("ERRO AO LER ARQUIVO: " + e);
		}
	}
}
