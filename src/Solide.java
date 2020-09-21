import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JToolTip;
import javax.swing.ToolTipManager; 		

public class Solide extends JComponent implements MouseListener{
	public String type;
	private int largeur, longueur ;
    private int abscisse ; // abcisse du coté du rectangle
    private int ordonnee ; // ordonnee du coté du rectangle
	private float affaiblisssement; 
	private Color color;


		    public Solide (String type , int largeur,int longueur,int abscisse,int ordonnee,Color color,float affaiblissement) {
		    	super();
		    	this.type=type;
		    this.setLargeur(largeur);;
		    this.setLongueur(longueur);;
		    this.setAbscisse(abscisse);
		    this.setOrdonnee(ordonnee);
		    this.setColor(color);
		    this.setAffaiblisssement(affaiblissement);
        	 }
		
		    // fixer le nombre  de Rectangle
	    public void setLargeur(int largeur) { this.largeur = largeur;}
		    public void setLongueur(int longueur) { this.longueur =longueur;}
	        public int getLargeur(){return this.largeur;}
	        public int getLongueur(){return this.longueur;}
	    
	        public void setOrdonnee(int ordonnee) {this.ordonnee =ordonnee;}
		    public void setAbscisse(int abscisse) {this.abscisse =abscisse;}
		    public int getOrdonnee() {return ordonnee;}
	        public int getAbscisse() {return abscisse;}
	        public Color getColor() {return color;}
			public void setColor(Color color) {this.color = color;}
			public float getAffaiblisssement() {return affaiblisssement;}
            public void setAffaiblisssement(float affaiblisssement) {this.affaiblisssement = affaiblisssement;}
	
	       
		
	        public void dessiner(Graphics g,Color color){
			//	g.setColor(Color.black);
	        	g.setColor(this.getColor());
	        	
		        g.fillRect(this.getAbscisse(), this.getOrdonnee(), (int)this.getLargeur(), (int)this.getLongueur());
		      
		        this.setToolTipText("aa");   
	        
	        }			
		public  String prop() {
			
				return(type+"- taux d'affaiblissement est: "+this.getAffaiblisssement());}
		

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=e.getY();
		

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
 }


