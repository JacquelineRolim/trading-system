//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//
//public class Login {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		public class TelaCadastroCantor extends JFrame {
//		private static final long serialVersionUID = 1L;
//		JLabel idLabel, nomeLabel, loginLabel, senhaLabel;
//		private JTextField idField, nomeField, loginField, senhaField;
//		private JButton salvarButton, cancelarButton;
//		
//		ButtonHandlerTelaCadastro handler;
//
//		public TelaCadastroCantor() {
//		super("CANTOR");
//		
//		setLayout(new FlowLayout());
//
//				handler=new ButtonHandlerTelaCadastro(this);
//
//				nomeLabel=new JLabel("Nome:");
//				add(nomeLabel);
//
//				nomeField=new JTextField(20);
//				add(nomeField);
//
//				idLabel=new JLabel("ID");
//				add(idLabel);
//
//				idField=new JTextField(20);
//				add(idField);
//
//				loginLabel=new JLabel("Login: ");
//				add(loginLabel);
//
//				loginField=new JTextField(20);
//				add(loginField);
//
//				senhaLabel=new JLabel("Senha: ");
//				add(senhaLabel);
//
//				senhaField=new JTextField(20);
//				add(senhaField);
//
//				salvarButton=new JButton("Salvar");
//				add(salvarButton);
//
//				cancelarButton=new JButton("Cancelar");
//				add(cancelarButton);
//
//				salvarButton.addActionListener(handler);
//				cancelarButton.addActionListener(handler);
//
//				setSize(300, 200);
//				setLocationRelativeTo(null);
//				setVisible(true);
//			}
//
//			public JButton getSalvarButton() {
//				return salvarButton;
//			}
//
//			public JButton getCancelarButton() {
//				return cancelarButton;
//			}
//
//			public JTextField getIdField() {
//				return idField;
//			}
//
//			public JTextField getNomeField() {
//				return nomeField;
//			}
//
//			public JTextField getLoginField() {
//				return loginField;
//			}
//
//			public JTextField getSenhaField() {
//				return senhaField;
//			}
//		}
//	}
//}