package app;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class App extends Composite {
	private ConexaoBanco conn = new ConexaoBanco();
    private LocalResourceManager localResourceManager;
    private Text escreverLogin;
    private Text escreverSenha;
    private Label lblErro;
    public static void main(String[] args) {
        Display tela = new Display();
        Shell conchinha = new Shell(tela, SWT.CLOSE | SWT.TITLE | SWT.MIN);
        conchinha.setText("Tela de Login");
        conchinha.setSize(800, 600);
        conchinha.setLayout(new GridLayout(1, true));

        App app = new App(conchinha, 0);
        conchinha.open();

        while (!conchinha.isDisposed()) {
            if (!tela.readAndDispatch()) {
                tela.sleep();
            }
        }

        tela.dispose();
    }

    public App(Composite parent, int style) {
        super(parent, style);
        createResourceManager();

        final Shell shell = (Shell) this.getParent(); // referência segura ao Shell

        Label loginMensagem = new Label(this, SWT.NONE);
        loginMensagem.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 19, SWT.BOLD | SWT.ITALIC)));
        loginMensagem.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
        loginMensagem.setBounds(268, 149, 284, 36);
        loginMensagem.setText("Planejamentos Projetos");

        Button btnEntrar = new Button(this, SWT.NONE);
        btnEntrar.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
        btnEntrar.setBounds(309, 301, 167, 25);
        btnEntrar.setText("Entrar");

        btnEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDown(MouseEvent e) {
              boolean logiver = conn.validaUsuario(escreverLogin.getText(), escreverSenha.getText());
              if (logiver) {
            	  
            	  for (org.eclipse.swt.widgets.Control c : shell.getChildren()) {
            		  if (!c.isDisposed()) {
            			  c.dispose();
            		  }
            	  }
            	  
            	  DashboardTela dashboard = new DashboardTela(shell, SWT.NONE);
            	  shell.layout();
              }else {
            	  lblErro.setVisible(true);
            	  System.out.print("Usuario ou senha Invalidos");
            	  return;
              }
            }
        });

        Button btnCadastrar = new Button(this, SWT.NONE);
        btnCadastrar.addSelectionListener(new SelectionAdapter() {
        	@Override
        	public void widgetSelected(SelectionEvent e) {
        	}
        });
        btnCadastrar.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseDown(MouseEvent e) {
        		
        		for (org.eclipse.swt.widgets.Control c : shell.getChildren()) {
        			if (!c.isDisposed()) {
        				c.dispose();
        			}
        		}
        		
                TeladeCadastro dashboard = new TeladeCadastro(shell, SWT.NONE);
                shell.layout();
        		
        	   }
        	});
        
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 13, SWT.NORMAL)));
        btnCadastrar.setBounds(309, 332, 167, 25);

        escreverLogin = new Text(this, SWT.BORDER);
        escreverLogin.setBounds(309, 202, 167, 25);

        escreverSenha = new Text(this, SWT.BORDER);
        escreverSenha.setBounds(309, 248, 167, 25);

        Label lblNome = new Label(this, SWT.NONE);
        lblNome.setText("Login:");
        lblNome.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
        lblNome.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 14, SWT.BOLD | SWT.ITALIC)));
        lblNome.setBounds(235, 202, 60, 25);

        Label loginMensagem_2_1 = new Label(this, SWT.NONE);
        loginMensagem_2_1.setText("Senha:");
        loginMensagem_2_1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
        loginMensagem_2_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 14, SWT.BOLD | SWT.ITALIC)));
        loginMensagem_2_1.setBounds(235, 248, 68, 25);
        
        lblErro = new Label(this, SWT.CENTER);
        lblErro.setVisible(false);
        lblErro.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
        lblErro.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 9, SWT.NORMAL)));
        lblErro.setBounds(309, 280, 167, 15);
        lblErro.setText("Usuário ou senha inválidos");
    }

    private void createResourceManager() {
        localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }
}
