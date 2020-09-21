import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;


public class PlusProche extends JFrame{


	
	JPanel p1,p2;
	JLabel abs;
	JLabel ord;
	JLabel deb;
	JTextField x1;
	JTextField y1;
	JTextField d1;
	JButton b;
	
	
	public PlusProche() {
		p1=new JPanel();
		p2=new JPanel();

		abs=new JLabel("      Entrer l'abscisse du point d'accès:");
		ord=new JLabel("      Entrer l'ordonnée du point d'accès:");
		deb=new JLabel("      Le point d'acces le plus proche est :");
		x1=new JTextField();
		y1=new JTextField();
		d1=new JTextField();
		b=new JButton("Ajouter le point d'accès");

	}
	public void creer(String pix[][],int x,int y) {
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
		
		p2.add(b);
		x1.setText(String.valueOf(x));
		y1.setText(String.valueOf(y));
		b.addActionListener(new ActionListener() {	

		

		@Override
		public void actionPerformed(ActionEvent e) {
		
            d1.setText(	pix[x][y]);

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


