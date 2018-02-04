public class Planete {
	
	String planeteName;
	double planeteMasse;
	double x;
	double y;
	double z;
	double vx;
	double vy;
	double vz;
	

	
	
public Planete(String nameP,double masseP,double x,double y,double z,double vx,double vy,double vz) {
	
	planeteName = nameP;
	planeteMasse = masseP;
	this.x= x;
	this.y= y;
	this.z= z;
	this.vx=vx;
	this.vy=vy;
	this.vz=vz;
	
}


public double getX() {
	return x;
}


public void setX(double x) {
	this.x = x;
}


public double getY() {
	return y;
}




public void setY(double y) {
	this.y = y;
}


public double getZ() {
	return z;
}


public void setZ(double z) {
	this.z = z;
}


public static void showdata(Planete[] PlaneteEntre) {
		
	for(int i = 0; i < PlaneteEntre.length; i++)
	{
	  System.out.println("les planetes sont :" + PlaneteEntre[i].getPlanetName() + " et ses coordonnées sont (" + PlaneteEntre[i].getX()+","+ PlaneteEntre[i].getY()+","+ PlaneteEntre[i].getZ()+")"  );
	}
}

/*
public static Planete[] simulation(Planete[] PlaneteEntre) {
	return ;
	
}

double x1;
double y1;
double z1;
double x2;
double y2;
double z2;


Planete A= new Planete( x1, y1, z1);
Planete B= new Planete( x2, y2, z2);

double distance(Planete A,Planete B) {
	
	return sqrt()
}
*/
	
public void setPlanetName(String nameP) {
	this.planeteName= nameP;
}	


public void setPlanetMasse(double masseP) {
	this.planeteMasse= masseP;
}


public String getPlanetName() {
	
	return planeteName;
}

public double getPlanetMasse() {
	
	return planeteMasse;
}


}
