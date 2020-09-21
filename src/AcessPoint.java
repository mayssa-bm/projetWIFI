
import java.awt.*; 
import java.awt.event.*;
import java.awt.geom.*; 
import java.util.*;
class AcessPoint {
	int x , y;
 // rayon de couverture sans obstacle est de 100 mètres
	int num ; // numéro du point d'accès
	int P;
	String nom ;
	public AcessPoint( int x, int y, int n, int debit,String nom)
	{ 
		this.x=x; 
		this.y=y; 
		num=n;
		this.P=debit;
		this.nom =nom ;
	}
	int getRayon()
	{
		return(10*P);
	}
}
