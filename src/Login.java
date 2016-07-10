
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{

	private JLabel loginLabel, senhaLabel;
	private JTextField loginField;
	private JPasswordField senhaField;
	private JButton loginButton;
	
	public Login(){
		super("Login");
		
		loginLabel = new JLabel("Login: ");
		senhaLabel = new JLabel("Senha: ");
		
		loginField = new JTextField(10);
		senhaField = new JPasswordField(10);
		
		loginButton = new JButton("Login");
		
		loginButton.addActionListener(this);
		
		add(loginLabel);
		add(loginField);
		add(senhaLabel);
		add(senhaField);
		add(loginButton);		
		
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocation(112, 0);
		setResizable(false);
		setVisible(true);
		getContentPane().setBackground(new Color(207,221,237));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean encontrouUsuario = false;
		if(e.getSource() == loginButton) {	
			for(int i = 0; i < App.usuario.size(); i++){	
				if(loginField.getText().equalsIgnoreCase(App.usuario.get(i).getLogin())){
					if(senhaField.getText().equalsIgnoreCase(App.usuario.get(i).getSenha())){
						encontrouUsuario = true;
						setVisible(false);
					}
				}
			}
			if(encontrouUsuario == false){
				JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
			}
		}		
	}
	
	public JLabel getLoginLabel() {
		return loginLabel;
	}

	public void setLoginLabel(JLabel loginLabel) {
		this.loginLabel = loginLabel;
	}

	public JLabel getSenhaLabel() {
		return senhaLabel;
	}

	public void setSenhaLabel(JLabel senhaLabel) {
		this.senhaLabel = senhaLabel;
	}

	public JTextField getLoginField() {
		return loginField;
	}

	public void setLoginField(JTextField loginField) {
		this.loginField = loginField;
	}

	public JTextField getSenhaField() {
		return senhaField;
	}

	public void setSenhaField(JTextField senhaField) {
		this.senhaField = (JPasswordField) senhaField;
	}

	public JButton getAddButton() {
		return loginButton;
	}

	public void setAddButton(JButton addButton) {
		this.loginButton = addButton;
	}
}