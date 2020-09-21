
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;



public class DessinCellulesAttenuation {
	static final double PI = 3.14;
	ArrayList<AcessPoint> APs = new ArrayList<AcessPoint>();
	int x ;
	int y ;

	static int i=0 ;
	TestRectangle tr;
	DessinCellulesAttenuation (TestRectangle tr)
	{
		this.tr=tr;

	}
	void init_accessPoints(int x,int y,int debit,String nom) 
	{

		APs.add(new AcessPoint (x,y,i,debit,nom));

	}
	void Affichage_AccessPoints(Graphics2D ga) // affichage des points d'accès
	{ 
		if(APs.size()!=0)
		{
			int xc , yc, r; 
			xc=APs.get(i).x; 
			yc=APs.get(i).y; 
			r=APs.get(i).getRayon();
			celluleDegrader (ga, xc, yc, r);
		}
	}
	void celluleDegrader (Graphics2D ga, int xc, int yc, int r  )
	{
		double j,k, angle;

		
		for(j=0;j<=370;j+=0.4) {
			int x1=xc, y1=yc;
			int R=(int) (255);
			int G=(int) (0);
			int B=(int) (0);
			boolean test=true;
			double aff=(double)0;
			for(k = 0; k <r; k +=0.4)
			{
				double	f=facteur_Attenuation (xc, yc,r,x1,y1);


				
				if(f!=0) {	
					R=(int) (255*f);

					G=(int) (255-f*0.4*255);
					B=(int) (255-f*255);


					Color C= new Color(R,G,B);
					angle = j;
					x1 = (int)(xc+k * Math.cos(angle * PI /180));
					y1 = (int)(yc+k * Math.sin(angle * PI / 180));


					Color c1=new Color(this.tr.image.getRGB(x1,y1));


					if((c1.getRGB()!=-16252928)&&(c1.getRGB()!=-16580608)&&(c1.getRGB()!=-16646144))
					{

						if((test==true)&&(C.getRed()>c1.getRed())) {
							Shape square = new Rectangle2D.Double(x1, y1,1,1);
							square.getBounds();
							ga.setPaint(C);

							ga.fill(square);
							tr.pix[x1][y1]=APs.get(i).nom ;

						}
						else if((test==false)&&(C.getRed()>c1.getRed())){



							
							R=(int) ((f+aff*0.1)*0.07*255);
							G=(int) (255-0.04*(f+aff*0.1)*0.07*255);
							B=(int) (255-(f+aff*0.1)*0.07*255);

							C= new Color(R,G,B); 
							Shape square = new Rectangle2D.Double(x1, y1,1,1);

							ga.setPaint(C);
							ga.fill(square); 
							tr.pix[x1][y1]=APs.get(i).nom ;


						}
					}else {test=false;
					 aff=c1.getRed();
                       aff=10*Math.log10(aff);
					}
				}
			}
		}
	}

	int SiNull (double f)
	{ 
		if (f==0) return (0); 
		else return(1);
	}
	
	double distance (double x1, double y1 , double x, double y)
	{ 
		return Math.sqrt( (x1-x)*(x1-x)+(y1-y)*(y1-y)); 
	}
	
	double facteur_Attenuation (double xc, double yc ,double r, double x, double y)
	{ 
		double f= 1.0-distance(xc,yc,x,y)/((double) r);
		//double f=(100+20*Math.log10(0.001*distance(xc,yc,x,y)))*0.001;
		if (f<0) return(0);
		return(f);
	}
	


	public void paint(Graphics g) {
		Graphics2D ga = (Graphics2D)g;
		Affichage_AccessPoints(ga) ;

	}





}