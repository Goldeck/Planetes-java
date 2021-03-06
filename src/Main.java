public class Main {


    public static void main(String[] args) {
//3.84 4 e 8
        Planete earth = new Planete("Terre", 5.972*Math.pow(10,24), 0, 0, 0,0,0,0);
        String earthName = earth.getPlanetName();
        System.out.println("le nom de la premi�re planete est :");
        System.out.println(earthName);
        Planete moon = new Planete("lune", 7.342*Math.pow(10,22), 3.844*Math.pow(10,8), 0, 0,0,1022.222,0);

        Planete[] PlaneteEntre = {earth, moon};
        System.out.println(PlaneteEntre.length);
        Planete.showdata(PlaneteEntre);

        simulation(PlaneteEntre, 3600, 10000);
    }

    private static void simulation(Planete[] planeteEntre, int temps, int iteration) {
        Planete[] planetes = planeteEntre;
        Planete.showdata(planetes);
        for (int i=0; i<iteration;i++) {
            planetes = claculnouvelleposition(planetes,temps);
            Planete.showdata(planetes);
        }
    }

    private static Planete[] claculnouvelleposition(Planete[] planeteEntre, int temps) {
        Planete[] planetesSorite=new Planete[planeteEntre.length];
        for (int planeteIndex=0;planeteIndex<planeteEntre.length;planeteIndex++){
            planetesSorite[planeteIndex]=nouvellePosition(planeteEntre,planeteIndex,temps);
        }
        return  planetesSorite;
    }

    private static Planete nouvellePosition(Planete[] planeteEntre, int planeteIndex, int temps) {

        //SOMMEpouri 1->n & planeteIndex!=k (mi/xk-xi)�
        Planete planeteactuelle=planeteEntre[planeteIndex];
        Force force = calculForces(planeteEntre, planeteIndex);
        double G=6.67*Math.pow(10,-11);
        //double x=planeteactuelle.getX()+ G/2*force.getX()*temps*temps+planeteactuelle.vx*temps ;
        double x=planeteactuelle.getX()+ G/2*force.getX()*temps*temps+planeteactuelle.vx*temps ;
        double y=planeteactuelle.getY()+ G/2*force.getY()*temps*temps+planeteactuelle.vy*temps ;
        double z=planeteactuelle.getZ()+ G/2*force.getZ()*temps*temps+planeteactuelle.vz*temps ;
        double vx=G*force.getX()*temps+planeteactuelle.vx;
        double vy=G*force.getY()*temps+planeteactuelle.vy;
        double vz=G*force.getZ()*temps+planeteactuelle.vz;
        Planete newPlanete=new Planete(planeteactuelle.getPlanetName(),planeteactuelle.getPlanetMasse(),x,y,z,vx,vy,vz);

        return newPlanete;
    }

    private static Force calculForces(Planete[] planeteEntre, int planeteIndex) {
        Force sommefinal =new Force(0,0,0);
        for(int i=0;i<planeteEntre.length;i++){
            if(i!=planeteIndex) {
            	double d = distance(planeteEntre[planeteIndex],planeteEntre[i]);
                double dx = (planeteEntre[i].getX() - planeteEntre[planeteIndex].getX())*planeteEntre[i].getPlanetMasse()/(d*d*d);
                double dy = (planeteEntre[i].getY() - planeteEntre[planeteIndex].getY())*planeteEntre[i].getPlanetMasse()/(d*d*d);
                double dz = (planeteEntre[i].getZ() - planeteEntre[planeteIndex].getZ())*planeteEntre[i].getPlanetMasse()/(d*d*d);

                sommefinal.setX(sommefinal.getX() + dx);
                sommefinal.setY(sommefinal.getY() + dy);
                sommefinal.setZ(sommefinal.getZ() + dz);
            }
        }
        return  sommefinal;
    }
    
    private static double distance(Planete A,Planete B) {
    	double dx=A.getX()-B.getX();
    	double dy=A.getY()-B.getY();
    	double dz=A.getZ()-B.getZ();
    	return Math.sqrt(dx*dx+dy*dy+dz*dz);
    }


}
