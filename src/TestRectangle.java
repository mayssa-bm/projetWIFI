import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;



public class TestRectangle extends JFrame {
	JPanel  p1,p3;
	JPanel panimage;
	JMenuBar menuBar;
	JMenu menu1;
	JLabel lab;
	JLabel lab2;
	JButton b;
	JLabel l;

	JMenuItem item1;
	JMenuItem item2;
	JMenuItem item3;
	
	static ArrayList<Solide> listRectangles;
	DessinCellulesAttenuation dc ;
	static  BufferedImage image;
	String pix[][];
 
	public TestRectangle() {	

		dc = new DessinCellulesAttenuation(this);  
		listRectangles = new ArrayList<Solide>();


	}
	public void creer() {
		p1=new JPanel();
		panimage=new JPanel();
		p3=new JPanel();
		menuBar = new JMenuBar();
		menu1=new JMenu();
		lab=new JLabel("Coordonnées");
        lab2= new JLabel("                 details");
		item1=new JMenuItem();
		item2=new JMenuItem();
		item3=new JMenuItem();
		this.setTitle("Wireless Control System");
	    this.setSize(1650,800);
	    this.setLocationRelativeTo(null);
	    
	    p1.setLayout(new FlowLayout());
	    panimage.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		p3.add(lab);
		p3.add(lab2);
      
	    this.getContentPane().add(p1,BorderLayout.NORTH);
	    this.getContentPane().add(panimage ,BorderLayout.CENTER);
	    this.getContentPane().add(p3,BorderLayout.SOUTH);
		
	    setJMenuBar(menuBar);	
		menuBar.add(menu1);
		menu1.setText("...");
		menu1.setToolTipText("Menu");
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		
		item1.setText("Ajouter un point d'accés");
		item2.setText("Supprimer un point d'accés");
		item3.setText("Vérifier l'appartenance d'un point à un point d'accès");

		item1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				AjoutPA pa=new AjoutPA();
				pa.creer(dc,image);
			
			}});
		item2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				SupprimerPA pa=new SupprimerPA();
				pa.creer(dc,image);	
			}});
		
		image =createImage();
		pix=new String[image.getWidth()][image.getHeight()];
		l=new JLabel(new ImageIcon(image));
		panimage.add(l);

		MouseAdapter listener = new MouseAdapter() {
		
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				//récupérer les coordonnées(x,y) de la souris
				int x=e.getX();
				int y=e.getY();
				
				JPopupMenu pop = new JPopupMenu() ;
				JMenuItem coord;
				JMenuItem affPA;
				JMenuItem suppPA;
				JMenuItem PlusP;

				/*pop.setLightWeightPopupEnabled(false);
				pop.setOpaque(false);*/
				
				coord = new JMenuItem("Ce point est de coordonnées ("+x+","+y+")") ;
				affPA= new JMenuItem("Ajouter un point d'accès");
				suppPA= new JMenuItem("Supprimer un point d'accès");
				PlusP= new JMenuItem("Trouver le point d'acces le plus proche ");
				
				coord.setEnabled(false);
				affPA.addActionListener(new ActionListener() {			
					@Override
					public void actionPerformed(ActionEvent e) {
						AjoutPA pa=new AjoutPA();
						pa.creer(dc,image);
						pa.x1.setText(Integer.toString(x));
						pa.y1.setText(Integer.toString(y));
					}});
				suppPA.addActionListener(new ActionListener() {			
					@Override
					public void actionPerformed(ActionEvent e) {
						SupprimerPA pa=new SupprimerPA();
						pa.creer(dc,image);		
					}});
				PlusP.addActionListener(new ActionListener() {			
					@Override
					public void actionPerformed(ActionEvent e) {
						PlusProche pa=new PlusProche();
						pa.creer(pix,x,y);
						
						//dispose();
					}});
				
				pop.add(coord) ;
				pop.add(affPA);
				pop.add(suppPA);
				pop.add(PlusP);
				
				if(e.isPopupTrigger())
				{
					pop.show(l, x, y);
				}

			}
		};
		l.addMouseListener(listener);

		l.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				int x=e.getX();
				int y=e.getY();
				lab.setText("("+x+","+y+")");
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				int x=e.getX();
				int y=e.getY();
				lab.setText("("+x+","+y+")");
				
			}
			
			
		});
		creer_Solide();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);

	}

	private static BufferedImage createImage() {  
		final BufferedImage image = new BufferedImage(1650,700,BufferedImage.TYPE_INT_RGB);
		final WritableRaster raster = image.getRaster();
		Graphics g;
		g=image.createGraphics();

		for(int i=0;i<1650;i++)
		{
			for(int j=0;j<700;j++) {
				int[] color = {0,255,255};
				raster.setPixel(i,j,color);  
			}
		}
		return image;
	}
	void creer_Solide()
	{
		//hedha ahawka badalt el red bel taux 
		   Solide rect1 = new Solide("-mur en briques",200,10,200,20,new Color(8,0,0),8);
		   Solide rect2 = new Solide("-une fenetre",40,5,400,23,new Color(3,0,0),3); 
		   Solide rect3 = new Solide("-mur en briques",200,10,440,20,new Color(8,0,0),8); 
		   Solide rect4 = new Solide("-mur en briques",100,10,640,20,new Color(8,0,0),8);
		   Solide rect5 = new Solide("-mur en briques",10,150,200,20,new Color(8,0,0),8);
		   Solide rect6 = new Solide("-mur en briques",10,250,640,20,new Color(8,0,0),8);
		   Solide rect7 = new Solide("-une fenetre",40,5,740,23,new Color(3,0,0),3); 
		   Solide rect8 = new Solide("-une fenetre",100,10,780,20,new Color(8,0,0),8); 
		   Solide rect9 = new Solide("-mur en briques",200,10,200,170,new Color(8,0,0),8); 
		   Solide rect10 = new Solide("-porte",40,5,400,173,new Color(2,0,0),2); 
		   Solide rect11 = new Solide("-mur en briques",220,10,440,170,new Color(8,0,0),8);
		   Solide rect12 = new Solide("-mur en briques",100,10,640,170,new Color(8,0,0),8);
		   Solide rect13 = new Solide("-porte",40,5,740,173,new Color(2,0,0),2);
		   Solide rect14 = new Solide("-mur en briques",100,10,780,170,new Color(8,0,0),8);
		   Solide rect15 = new Solide("-mur en briques",10,270,880,20,new Color(8,0,0),8);
		   Solide rect16 = new Solide("-mur en bois",480,10,880,20,new Color(2,0,0),2);
		   Solide rect17 = new Solide("-porte fenetre",5,75,883,290,new Color(2,0,0),2);
		   Solide rect18 = new Solide("-mur en bois",10,80,880,365,new Color(8,0,0),8);
		   Solide rect19 = new Solide("-mur en briques",10,150,200,170,new Color(8,0,0),8);
		   Solide rect20 = new Solide("-porte",5,40,203,320,new Color(2,0,0),2); 
		   Solide rect21 = new Solide("-mur en briques",10,250,200,360,new Color(8,0,0),8);
		   Solide rect22 = new Solide("-mur en briques",300,10,200,440,new Color(8,0,0),8); 
		   Solide rect23 = new Solide("-mur en briques",250,10,640,440,new Color(8,0,0),8);
		   Solide rect24 = new Solide("-mur en bois",480,10,880,390,new Color(2,0,0),2);
		   Solide rect25 = new Solide("-des plantes",10,380,1360,20,new Color(8,0,0),8);
		   Solide rect28 = new Solide("-mur en briques",690,10,200,610,new Color(8,0,0),8);
		   Solide rect33 = new Solide("-verre teinté",5,160,885,450,new Color(8,0,0),8);
		   Solide rect34 = new Solide("-mur en verre",10,50,300,20,new Color(3,0,0),3);
		   Solide rect35 = new Solide("-mur en verre",10,70,300,110,new Color(3,0,0),3);
		   Solide rect36 = new Solide("-mur en briques",10,220,1300,400,new Color(2,0,0),2);
		   Solide rect37 = new Solide("-mur en briques",420,10,883,610,new Color(8,0,0),8);
		   Solide rect38 = new Solide("-mur en bois",10,100,1200,400,new Color(2,0,0),2);
		   Solide rect39 = new Solide("-mur en bois",10,100,1200,520,new Color(2,0,0),2);
		   Solide rect40 = new Solide("-mur en bois",120,10,890,550,new Color(2,0,0),2);
		   Solide rect41 = new Solide("-mur en bois",130,10,1070,550,new Color(2,0,0),2); 
		   Solide rect42 = new Solide("-mur en bois",200,10,200,270,new Color(2,0,0),2); 
		   Solide rect43 = new Solide("-mur en bois",200,10,450,270,new Color(2,0,0),2); 
		   Solide rect44 = new Solide("-mur en bois",10,100,1100,20,new Color(2,0,0),2);
		   Solide rect45 = new Solide("-mur en bois",10,100,1100,160,new Color(2,0,0),2);
		   Solide rect46 = new Solide("-mur en bois",260,10,1100,260,new Color(2,0,0),2);

		   listRectangles.add(rect1 );
            listRectangles.add(rect2 );
            listRectangles.add(rect3 );
            listRectangles.add(rect4 );
            listRectangles.add(rect5 );
            listRectangles.add(rect6 );
            listRectangles.add(rect7 );
            listRectangles.add(rect8 );
            listRectangles.add(rect9 );
            listRectangles.add(rect10 );
            listRectangles.add(rect11 );
            listRectangles.add(rect12 );
            listRectangles.add(rect13 );
            listRectangles.add(rect14 );
            listRectangles.add(rect15 );
            listRectangles.add(rect16 );
            listRectangles.add(rect17 );
            listRectangles.add(rect18 );
            listRectangles.add(rect19 );
            listRectangles.add(rect20 );
            listRectangles.add(rect21 );
            listRectangles.add(rect22 );
            listRectangles.add(rect23 );
            listRectangles.add(rect24 );
            listRectangles.add(rect25 );
            listRectangles.add(rect28 );
            listRectangles.add(rect33 );
            listRectangles.add(rect34 );
            listRectangles.add(rect35 );
            listRectangles.add(rect36 );
            listRectangles.add(rect37 );
            listRectangles.add(rect38);
            listRectangles.add(rect39 );
            listRectangles.add(rect40 );
            listRectangles.add(rect41);
            listRectangles.add(rect42);
            listRectangles.add(rect43);
            listRectangles.add(rect44);
            listRectangles.add(rect45);
            listRectangles.add(rect46);

			changeImage(image);
		}
	

	void changeImage(BufferedImage image) { 
		Graphics g=image.getGraphics();
		for (Solide rect : listRectangles) {
			rect.dessiner(g,rect.getColor());
			lab2.setText(rect.prop());
			JLabel l=new JLabel();
			l.addMouseMotionListener(new MouseMotionListener() {
				public void mouseEntered(MouseEvent e) {
					int x=e.getX();
					int y=e.getY();
					if (rect.contains(x, y))
					{lab2.setText(rect.prop());}
				}

				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub

				}

			});
		}
	}

     
	
	public static void main(String[] arg) {
		
		TestRectangle f=new TestRectangle();
		f.creer();
	}
}


	
 

