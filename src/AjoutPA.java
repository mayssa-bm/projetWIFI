import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class AjoutPA extends JFrame /*implements ActionListener*/{
	
	JPanel p1,p2;
	JLabel abs;
	JLabel ord;
	JLabel deb;
	JLabel name;
	JTextField x1;
	JTextField y1;
	JTextField d1;
	JTextField nm;
	JButton b;
	JPanel pan;
	
	public AjoutPA() {
		p1=new JPanel();
		p2=new JPanel();

		abs=new JLabel("      Entrer l'abscisse du point d'accès:");
		ord=new JLabel("      Entrer l'ordonnée du point d'accès:");
		deb=new JLabel("      Entrer le débit du point d'accès:");
		name=new JLabel("      Entrer le nom du point d'accès:");

		x1=new JTextField();
		y1=new JTextField();
		d1=new JTextField();
		nm=new JTextField();
		b=new JButton("Ajouter le point d'accès");

	}
	public void creer(DessinCellulesAttenuation dc,BufferedImage image) {
		this.setTitle("Ajout d'un point d'accès");
	    this.setSize(350,300);
	    this.setLocationRelativeTo(null);
	    
	    p1.setLayout(new GridLayout(9,2));
	    p2.setLayout(new FlowLayout());
		p1.add(abs);
		p1.add(x1);
		p1.add(ord);
		p1.add(y1);
		p1.add(deb);
		p1.add(d1);
		p1.add(name);
		p1.add(nm);
		p2.add(b);

		b.addActionListener(new ActionListener() {	

		@Override
		public void actionPerformed(ActionEvent e) {

		dc.init_accessPoints(Integer.valueOf(x1.getText()),Integer.valueOf(y1.getText()),Integer.valueOf(d1.getText()),nm.getText());
		Graphics g= image.getGraphics();
		dc.paint(g);
		dc.i++;
		closeApplication();
			}
		});

		this.getContentPane().add(p1 ,BorderLayout.CENTER);
	    this.getContentPane().add(p2 ,BorderLayout.SOUTH);
	    
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);


	}

	public void closeApplication() {
		this.dispose();
	}
	}
	
	



