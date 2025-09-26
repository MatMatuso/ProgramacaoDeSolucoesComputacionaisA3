package app;

import javax.swing.ImageIcon;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;



public class ConfigProjeto extends Composite {

	private LocalResourceManager localResourceManager;
	private Text text;
	private Label lblNovoProjeto_2;

	public ConfigProjeto(Composite parent, int style) {
		super(parent, style);
		createResourceManager();
		
		Label lblNovoProjeto = new Label(this, SWT.NONE);
		lblNovoProjeto.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblNovoProjeto.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 16, SWT.BOLD | SWT.ITALIC)));
		lblNovoProjeto.setBounds(104, 39, 131, 34);
		lblNovoProjeto.setText("Novo Projeto");
		
		text = new Text(this, SWT.BORDER);
		text.setBounds(131, 79, 151, 21);
		
		Label lblNovoProjeto_1 = new Label(this, SWT.CENTER);
		lblNovoProjeto_1.setText("Nome:");
		lblNovoProjeto_1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblNovoProjeto_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 10, SWT.BOLD | SWT.ITALIC)));
		lblNovoProjeto_1.setBounds(10, 79, 116, 21);
		
		lblNovoProjeto_2 = new Label(this, SWT.CENTER);
		lblNovoProjeto_2.setText("Participantes");
		lblNovoProjeto_2.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblNovoProjeto_2.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 10, SWT.BOLD | SWT.ITALIC)));
		lblNovoProjeto_2.setBounds(10, 130, 116, 21);
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(131, 130, 151, 23);
		
		Label lblNovoProjeto_2_1 = new Label(this, SWT.CENTER);
		lblNovoProjeto_2_1.setText("Participantes");
		lblNovoProjeto_2_1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblNovoProjeto_2_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 10, SWT.BOLD | SWT.ITALIC)));
		lblNovoProjeto_2_1.setBounds(10, 159, 116, 21);
		
		Combo combo_1 = new Combo(this, SWT.NONE);
		combo_1.setBounds(131, 159, 151, 23);
		
		Combo combo_2 = new Combo(this, SWT.NONE);
		combo_2.setBounds(131, 188, 151, 23);
		
		Label lblNovoProjeto_2_1_1 = new Label(this, SWT.CENTER);
		lblNovoProjeto_2_1_1.setText("Participantes");
		lblNovoProjeto_2_1_1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
		lblNovoProjeto_2_1_1.setFont(localResourceManager.create(FontDescriptor.createFrom("Comic Sans MS", 10, SWT.BOLD | SWT.ITALIC)));
		lblNovoProjeto_2_1_1.setBounds(10, 186, 116, 21);
		

		
	}
	private void createResourceManager() {
		localResourceManager = new LocalResourceManager(JFaceResources.getResources(),this);
	}
}
