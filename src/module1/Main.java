package module1;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		simulate();
	}
	
	private static void simulate(){
	    SimulationInterface s = new Simulation();
	    WorldInterface w = s.loadSim();
	    
	    while(!s.endOfSim(w)) {
	        s.displaySim(w);
	        char x = s.getInput();
	        w = s.updateSim(x, w);
	    }
	}
}
