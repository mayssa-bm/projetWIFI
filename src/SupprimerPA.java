
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class SupprimerPA extends JFrame{
	static final double PI = 3.14;
	JPanel p1,p2;

	JLabel name;

	JTextField nm;

	JButton b;

	public SupprimerPA() {
		p1=new JPanel();
		p2=new JPanel();

		name=new JLabel("      Entrer le nom du point d'accès:");

		nm=new JTextField();

		b=new JButton("Supprimer le point d'accès");

	}
	public void creer(DessinCellulesAttenuation dc,BufferedImage image) {
		this.setTitle("Suppression d'un point d'accès");
		this.setSize(350,300);
		this.setLocationRelativeTo(null);

		p1.setLayout(new GridLayout(9,2));
		p2.setLayout(new FlowLayout());
		p1.add(name);
		p1.add(nm);


		p2.add(b);
		b.addActionListener(new ActionListener() {	

			@Override
			public void actionPerformed(ActionEvent e) {

				String  nom=nm.getText();

				double j,i, angle;
				for(int k=0;k<dc.APs.size();k+=1)
				{ if(dc.APs.get(k).nom.equals(nom))
				{
					for(j=0;j<=370;j+=0.7) {

						boolean test=true;
						for(i = 0; i <dc.APs.get(k).getRayon(); i +=0.7)
						{
							Color C= new Color(0,250,255);
							angle = j;
							int x1 = (int)(dc.APs.get(k).x+i * Math.cos(angle * PI /180));
							int y1 = (int)(dc.APs.get(k).y+i * Math.sin(angle * PI / 180));

							Color c= new Color(0,0,0);
							int black =c.getRGB();

							Color c1=new Color(dc.tr.image.getRGB(x1,y1));
					        /*int red = c1.getRed();
					       
					        if()*/
							
							if((dc.tr.image.getRGB(x1,y1)!=black)&&(test==true)){
								Graphics2D ga =(Graphics2D)image.getGraphics() ;
								Shape square = new Rectangle2D.Double(x1, y1,1, 1);
								ga.setPaint(C);
								ga.fill(square);
							
							}
							

						}}
					dc.APs.remove(dc.APs.get(k));

					dc.i--;
					closeApplication();}}}});


		this.getContentPane().add(p1 ,BorderLayout.CENTER);
		this.getContentPane().add(p2 ,BorderLayout.SOUTH);

		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setVisible(true);
	}
	public void closeApplication() {
		this.dispose();
	}
}

