


public class Planete {
	
	String planeteName;
	double planeteMasse;
	double x;
	double y;
	double z;
	
public Planete(String nameP,double masseP) {
	
	planeteName = nameP;
	planeteMasse = masseP;
	
}

public Planete(double x,double y, double z) {
	
	this.x= x;
	this.y= y;
	this.z= z;
	
}
	
void setPlanetName(String nameP) {
	this.planeteName= nameP;
}	


void setPlanetMasse(double masseP) {
	this.planeteMasse= masseP;
}


public String getPlanetName() {
	
	return planeteName;
}

public double getPlanetMasse() {
	
	return planeteMasse;
}


}
