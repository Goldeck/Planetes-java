public class Main  {
	
	
	public static void main(String[] args)	{
		
	Planete earth = new Planete("Terre",350000,0,0,0);
	String earthName = earth.getPlanetName();
	System.out.println ("le nom de la première planete est :");
	System.out.println (earthName);
	Planete moon = new Planete("lune",100,1,1,1);
	
	Planete[] PlaneteEntre = {earth,moon};
	System.out.println(PlaneteEntre.length);
	Planete.showdata(PlaneteEntre);
	PlaneteEntre.simulation(Time,numIteration);
	Planete[] PlaneteFinal = {};
	
	
	
	
	}



}
