import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaCadastro extends JFrame implements ActionListener{

	private JLabel loginLabel, senhaLabel;
	private JTextField loginField, senhaField;
	private JButton addButton;
	
	public TelaCadastro(){
		super("Cadastro");
		
		loginLabel = new JLabel("Login: ");
		senhaLabel = new JLabel("Senha: ");
		
		loginField = new JTextField(10);
		senhaField = new JTextField(10);
		
		addButton = new JButton("Add");
		
		addButton.addActionListener(this);
		
		add(loginLabel);
		add(loginField);
		add(senhaLabel);
		add(senhaField);
		add(addButton);		
		
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() == addButton) && (verificarCadastrop() == false)){
			App.usuarios.add(new Usuario(loginField.getText(), senhaField.getText()));
			
			JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso!");
		}else{
			JOptionPane.showMessageDialog(null, "Usuario Já cadastrado!");
		}
	}
	
	public boolean verificarCadastrop(){
		for(Usuario usuario: App.usuarios){
			if(loginField.getText().equalsIgnoreCase(App.usuarios.get(0).getLogin())){
				return true;
			}
		}
		return false;
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
		this.senhaField = senhaField;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}
}