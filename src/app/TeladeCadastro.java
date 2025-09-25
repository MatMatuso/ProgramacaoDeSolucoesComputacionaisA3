package app;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.swt.graphics.RGB;


public class TeladeCadastro extends Composite {
	private Text txtNome;
	private LocalResourceManager localResourceManager;
	private Label lblCadastro_1;
	private Text txtCpf;
	private Text txtCargo;
	private Text txtSenha;
	private Text txtLogin;
	private Text txtEmail;
	private Label lblCpf;
	private Label lblEmail;
	private Label lblCargo;
	private Label lblLogin;
	private Label lblSenha;
	private Label lblPerfil;
	private Combo lstPerfil;
	private Label lblAviso;
	private Button btnVoltar;

	public TeladeCadastro(Composite parent, int style) {
		super(parent, style);
		createResourceManager();
		setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(240, 240, 240))));
		
		txtNome = new Text(this, SWT.BORDER);
		txtNome.setBounds(295, 150, 182, 21);
		
		Label lblCadastro = new Label(this, SWT.NONE);
		lblCadastro.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 12, SWT.BOLD | SWT.ITALIC)));
		lblCadastro.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblCadastro.setBounds(234, 150, 55, 21);
		lblCadastro.setText("Nome:");
		
		lblCadastro_1 = new Label(this, SWT.NONE);
		lblCadastro_1.setText("Cadastro");
		lblCadastro_1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblCadastro_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 19, SWT.BOLD | SWT.ITALIC)));
		lblCadastro_1.setBounds(329, 90, 114, 36);
		
		txtCpf = new Text(this, SWT.BORDER);
		txtCpf.setBounds(295, 188, 182, 21);
		
		txtCargo = new Text(this, SWT.BORDER);
		txtCargo.setBounds(295, 272, 182, 21);
		
		txtSenha = new Text(this, SWT.BORDER);
		txtSenha.setBounds(295, 363, 182, 21);
		
		txtLogin = new Text(this, SWT.BORDER);
		txtLogin.setBounds(295, 317, 182, 21);
		
		txtEmail = new Text(this, SWT.BORDER);
		txtEmail.setBounds(295, 233, 182, 21);
		
		lblCpf = new Label(this, SWT.NONE);
		lblCpf.setText("CPF:");
		lblCpf.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblCpf.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 12, SWT.BOLD | SWT.ITALIC)));
		lblCpf.setBounds(244, 188, 45, 21);
		
		lblEmail = new Label(this, SWT.NONE);
		lblEmail.setText("E-mail:");
		lblEmail.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblEmail.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 12, SWT.BOLD | SWT.ITALIC)));
		lblEmail.setBounds(223, 233, 55, 21);
		
		lblCargo = new Label(this, SWT.NONE);
		lblCargo.setText("Cargo:");
		lblCargo.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblCargo.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 12, SWT.BOLD | SWT.ITALIC)));
		lblCargo.setBounds(234, 272, 55, 21);
		
		lblLogin = new Label(this, SWT.NONE);
		lblLogin.setText("Login:");
		lblLogin.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblLogin.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 12, SWT.BOLD | SWT.ITALIC)));
		lblLogin.setBounds(234, 317, 45, 21);
		
		lblSenha = new Label(this, SWT.NONE);
		lblSenha.setText("Senha:");
		lblSenha.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblSenha.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 12, SWT.BOLD | SWT.ITALIC)));
		lblSenha.setBounds(234, 366, 55, 21);
		
		lblPerfil = new Label(this, SWT.NONE);
		lblPerfil.setText("Perfil:");
		lblPerfil.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblPerfil.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 12, SWT.BOLD | SWT.ITALIC)));
		lblPerfil.setBounds(234, 407, 55, 21);
		
		

        Button btnCadastrar = new Button(this, SWT.NONE);
        btnCadastrar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDown(MouseEvent e) {
        		ConexaoBanco bd = new ConexaoBanco();
        	  bd.adicionaUsuario(txtNome.getText(), txtCpf.getText(), txtEmail.getText(), txtCargo.getText(), txtLogin.getText(), txtSenha.getText(), lstPerfil.getText());
        		lblAviso.setVisible(true);
        		
         
        		
        	   }
        	});
		btnCadastrar.setBounds(329, 459, 125, 25);
		btnCadastrar.setText("Cadastrar");
		
		lstPerfil = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		lstPerfil.setBounds(295, 410, 182, 23);
		lstPerfil.add("Administrador");
		lstPerfil.add("Gerente");
		lstPerfil.add("Colaborador");
		
		lblAviso = new Label(this, SWT.NONE);
		lblAviso.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblAviso.setBounds(329, 445, 103, 15);
		lblAviso.setText("Usuário Cadastrado");
		lblAviso.setVisible(false);
		
		btnVoltar = new Button(this, SWT.NONE);
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Shell shell = getShell(); // pega o Shell pai deste Composite

				for (org.eclipse.swt.widgets.Control c : shell.getChildren()) {
				    if (!c.isDisposed()) {
				        c.dispose();
				    }
				}

				// Recria a tela principal (App)
				App telaPrincipal = new App(shell, SWT.NONE);
				shell.layout();
				
			}
		});
		btnVoltar.setText("Voltar");
		btnVoltar.setBounds(329, 498, 125, 25);
		
 
		}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),this);
	}
}
