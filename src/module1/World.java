package module1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class World implements WorldInterface{
	private final int ROWS = 10;
    private final int COLS = 10;
    private char[][] aWorld = new char[ROWS][COLS];
    private final String FILENAME;
    private int[][] aObjects = {{0, 2, 6}};
    
    public World(String pFilename){
        FILENAME = pFilename;
        try {
            InputStream in = new FileInputStream(FILENAME);
            Reader reader = new InputStreamReader(in);
            // buffer for efficiency
            Reader buffer = new BufferedReader(reader);
            int r;
            int i = 0;
            int j = 0;
            while ((r = buffer.read()) != -1) {
                char ch = (char) r;
                aWorld[i][j] = ch;
                i++;
                if(i == 10){
                    i = 0;
                    j++;
                }
                if(j == 10){
                    break;
                }
            }
            buffer.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    @Override
    public char[][] getWorld(){
        return aWorld.clone();
    }
    
    @Override
    public int[][] getObjects(){
        return aObjects.clone();
    }
    
    @Override
    public void moveLeft(){
        if(aObjects[0][2] > 0){
           aObjects[0][2]--; 
        }
    }
    
    @Override
    public void moveRight(){
        if(aObjects[0][2] < COLS){
           aObjects[0][2]++; 
        }
    }
    
    @Override
    public void goUp(){
        if(aObjects[0][1] > 0){
           aObjects[0][1]--; 
        }
    }
    
    @Override
    public void goDown(){
        if (aObjects[0][1] < ROWS){
           aObjects[0][1]++; 
        }
    }

}
