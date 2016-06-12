import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class LerArquivoUsuario {
		
		FileReader fileReader;
		BufferedReader reader;
		
		public LerArquivoUsuario() {
			String linhaLida;
			Usuario usuarioLido;
			
			try {
				fileReader = new FileReader("Usuarios.txt");
				reader = new BufferedReader(fileReader);
				
				while((linhaLida = reader.readLine()) != null){
					char usuarioChar[] = linhaLida.toCharArray();
					String login = "";
					String senha = "";
					
					int i = 0;
					
					for (; usuarioChar[i] != '-'; i++) {
						login = login + usuarioChar[i];
					}
					
					for (i++; i < usuarioChar.length; i++) {
						senha = senha + usuarioChar[i];
					}
						
				    usuarioLido = new Usuario(login, senha);
				    App.usuario.add(usuarioLido);
				}
				
				fileReader.close();
				reader.close();
				
			} catch (Exception e) {
				System.out.println("ERRO AO LER ARQUIVO: " + e);
			}
		}
	}