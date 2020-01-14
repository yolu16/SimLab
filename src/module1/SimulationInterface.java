package module1;

public interface SimulationInterface {
	public WorldInterface loadSim();
    public boolean endOfSim(WorldInterface w);
    public void displaySim(WorldInterface w);
    public char getInput();
    public WorldInterface updateSim(char x, WorldInterface w);
}
