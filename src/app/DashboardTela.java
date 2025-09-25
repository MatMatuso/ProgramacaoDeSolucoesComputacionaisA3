package app;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.SWT;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class DashboardTela extends Composite {
    private LocalResourceManager localResourceManager;

    public DashboardTela(Composite parent, int style) {
        super(parent, style);
        createResourceManager();

        
        ScrolledComposite scrolledComposite = new ScrolledComposite(this,
                SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
        scrolledComposite.setBounds(10, 10, 780, 580);
        scrolledComposite.setBackground(
                localResourceManager.create(ColorDescriptor.createFrom(new RGB(192, 192, 192))));
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        
        Composite compositeInterno = new Composite(scrolledComposite, SWT.NONE);
        compositeInterno.setLayout(new GridLayout(1, false));
        compositeInterno.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));


        scrolledComposite.setContent(compositeInterno);
        scrolledComposite.setExpandHorizontal(true);
        scrolledComposite.setExpandVertical(true);

        
        compositeInterno.setSize(scrolledComposite.getClientArea().width, 1000);

        
        for (int i = 1; i <= 3; i++) {
            Composite projeto = new Composite(compositeInterno, SWT.BORDER);
            projeto.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            projeto.setLayout(new GridLayout(1, false));
            projeto.setBackground(localResourceManager.create(ColorDescriptor.createFrom(new RGB(220, 220, 255))));

            Label nomeProjeto = new Label(projeto, SWT.NONE);
            nomeProjeto.setText("Novo Projeto");
            nomeProjeto.setFont(localResourceManager.create(FontDescriptor.createFrom("Segoe UI", 14, SWT.BOLD)));

            int projetoNum = i;
            projeto.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseDown(MouseEvent e) {
                    System.out.println("Você clicou no Projeto " + projetoNum);
                }

            });
        }
        scrolledComposite.setMinSize(compositeInterno.computeSize(SWT.DEFAULT, SWT.DEFAULT));
      
        compositeInterno.setSize(scrolledComposite.getClientArea().width,
                compositeInterno.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
    }

    private void createResourceManager() {
        localResourceManager = new LocalResourceManager(JFaceResources.getResources(), this);
    }
}
