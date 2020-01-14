package module1;

import java.io.IOException;

public class Simulation implements SimulationInterface{
    
	@Override
	public WorldInterface loadSim(){
        WorldInterface w = new World("C:\\Users\\yaoli\\Desktop\\CompSci\\Simulators\\SimLab\\world1.txt");
        return w;
    }
    
    @Override
    public boolean endOfSim(WorldInterface w){
        int[][] copyO = w.getObjects();
        return (copyO[0][1] == 0 && copyO[0][1] == 0);
    }
    
    @Override
    public void displaySim(WorldInterface w){
        char[][] copyW = w.getWorld();
        int[][] copyO = w.getObjects();
        copyW[copyO[0][1]][copyO[0][2]] = 'o'; //modify to depend on obj type
        for(int i = 0; i < copyW.length; i++){
            for(int j = 0; j < copyW[0].length; j++){
                System.out.print(copyW[i][j]);
                if(j == 9) System.out.print("\n"); 
            }
            //if(i == 9) System.out.print("\n");
        }
    }
    
    @Override
    public char getInput(){
        System.out.println("Move the object: ");
        try{
            return ((char) System.in.read());
        }
        catch(ClassCastException e){
            return getInput();
        }
        catch(IOException e) {
        	return getInput();
        }
    }
    
    @Override
    public WorldInterface updateSim(char x, WorldInterface w){
        switch(x) {
            case 'a':
                w.moveLeft();
                break;
            case 'd':
                w.moveRight();
                break;
            case 'w':
                w.goUp();
                break;
            case 's':
                w.goDown();
                break;
            default:
                System.out.println("Invalid input");
        }
        return w;
    }
}
