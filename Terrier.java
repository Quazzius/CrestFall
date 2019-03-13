// Terrier.java - terrier behavior in "Terriers and Squirrels"
// Author: Ethan Lambert
//		Modified by: Brian Weilmuenster
// Date: 11/6/2015
// Course: cs160

import java.lang.Math;

public class Terrier implements AnimalInterface {

    //
    // DO NOT MODIFY BELOW 
    //
    private int currentRow;
    private int currentCol;
    private int previousRow = -1;
    private int previousCol = -1;
    private int closestRow;
    private int closestCol;
    private char[][] field;

    // Initializes position and field
    public Terrier(int row, int col, char[][] field){
        this.currentRow = row;
        this.currentCol = col;
        this.field = field;
    }

    // Getters
    public int getCurrentRow(){ return currentRow; }
    public int getCurrentCol(){ return currentCol; }
    public int getPreviousRow(){ return previousRow; }
    public int getPreviousCol(){ return previousCol; }
    public int getClosestRow(){ return closestRow; }
    public int getClosestCol(){ return closestCol; }
    //
    // DO NOT MODIFY ABOVE 
    //

    // Find closest squirrel
    public void findClosest(){
    	double closestTemp = field.length;
    	double temp = field.length;
    	for(int i=0;i<field.length;i++){
    		for(int j=0;j<field[i].length;j++){
    			if(field[i][j] == 'S'){
    				temp = Math.sqrt(Math.pow((currentRow - i),2) + Math.pow((currentCol - j),2));
    			}
    			if(temp < closestTemp){
    				closestTemp = temp;
    				closestRow = i;
    				closestCol = j;
    			}
    		}
    	}

    }
    
    // Move terrier according to the rules
    public void moveAnimal() {

        eMove move = null;

        // Store previous position
        previousRow = currentRow;
        previousCol = currentCol;

        // TO DO: replace with code to select move (Step 1)
        if(closestRow == currentRow){
        	if(closestCol < currentCol){
        		move = eMove.LEFT;
        	}
        	else if(this.closestCol > currentCol){
        		move = eMove.RIGHT;
        	}
        }
        else if(closestCol == currentCol){
        	if(closestRow < currentRow){
        		move = eMove.UP;
        	}
        	else if(closestRow > currentRow){
        		move = eMove.DOWN;
        	}
        }
        else if(closestRow < currentRow){
        	if(closestCol < currentCol){
        		move = eMove.UP_LEFT;
        	}
        	else if(closestCol > currentCol){
        		move = eMove.UP_RIGHT;
        	}
        }
        else if(closestRow > currentRow){
        	if(closestCol < currentCol){
        		move = eMove.DOWN_LEFT;
        	}
        	else if(closestCol > currentCol){
        		move = eMove.DOWN_RIGHT;
        	}
        }
        //Now we have
        boolean isValidMove = false;	
        int tileLimit = 0;
        while(!isValidMove){
        	if(tileLimit == 8) { move = eMove.NO_MOVE; break; }
        	if(isOnBoard(move)){
        		if(isTileValid(getDestTile(move))){
        			isValidMove = true;
        			break;
        		}
        	}
        	switch(move){
			case LEFT:
				move = eMove.UP_LEFT;
				break;
			case UP_LEFT:
				move = eMove.UP;
				break;
			case UP:
				move = eMove.UP_RIGHT;
				break;
			case UP_RIGHT:
				move = eMove.RIGHT;
				break;        	
			case RIGHT:
				move = eMove.DOWN_RIGHT;
				break;
			case DOWN_RIGHT:
				move = eMove.DOWN;
				break;        			
			case DOWN:
				move = eMove.DOWN_LEFT;
				break;
			case DOWN_LEFT:
				move = eMove.LEFT;
				break;
			default:
				move = eMove.NO_MOVE;
			}
			tileLimit++;
        }

    	switch(move){
    	case UP:
    		currentRow -= 1;
    		break;
    	case DOWN:
    		currentRow += 1;
    		break;
    	case LEFT:
    		currentCol -= 1;
    		break;
    	case RIGHT:
    		currentCol += 1;
    		break;
    	case UP_LEFT:
    		currentRow -= 1;
    		currentCol -= 1;
    		break;
    	case UP_RIGHT:
    		currentRow -= 1;
    		currentCol += 1;
    		break;
    	case DOWN_LEFT:
    		currentRow += 1;
    		currentCol -= 1;
    		break;
    	case DOWN_RIGHT:
    		currentRow += 1;
    		currentCol += 1;
    		break;
    	default:
    		break;
    	}
    }
    
    //
    // Private Methods, if you need them
    //
    boolean isTileValid(char destTile){
    	switch(destTile){
    	case 'S':
    		return true;
    	case 'T':
    		return false;
    	case 'F':
    		return false;
    	case 'D':
    		return false;
    	case '-':
    		return true;    		
    	default:
    		return true;
    	}	
    }
    
    char getDestTile(eMove move){
    	char destTile = ' ';
    	
    	switch(move){
    	case UP:
    		destTile = field[currentRow - 1][currentCol];
    		break;
    	case DOWN:
    		destTile = field[currentRow + 1][currentCol];
    		break;
    	case LEFT:
    		destTile = field[currentRow][currentCol - 1];
    		break;
    	case RIGHT:
    		destTile = field[currentRow][currentCol + 1];
    		break;
    	case UP_LEFT:
    		destTile = field[currentRow - 1][currentCol - 1];
    		break;
    	case UP_RIGHT:
    		destTile = field[currentRow - 1][currentCol + 1];
    		break;
    	case DOWN_LEFT:
    		destTile = field[currentRow + 1][currentCol - 1];
    		break;
    	case DOWN_RIGHT:
    		destTile = field[currentRow + 1][currentCol + 1];
    		break;
    	default:
    		break;
    	}
    	return destTile;
    }
    
    boolean isOnBoard(eMove move){
    	//Given eMove switch to get content of potential destination tile
    	
    	switch(move){
    	case UP:
    		if(currentRow != 0){
    			return true;
    		}else {
    			return false;
    		}
    	case DOWN:
    		if(currentRow != field.length - 1){	    			
    			return true;
    		}else {
    			return false;
    		}
    	case LEFT:
    		if(currentCol != 0){	    			
    			return true;
    		}else {
    			return false;
    		}
    	case RIGHT:
    		if(currentCol != field[currentRow].length - 1){	    			
    			return true;
    		}else {
    			return false;
    		}
    	case UP_LEFT:
    		if(currentCol != 0 && currentRow != 0){	    			
    			return true;
    		}else {
    			return false;
    		}
    	case UP_RIGHT:
    		if(currentCol != field[currentRow].length - 1 && currentRow != 0){	    			
    			return true;
    		}else {
    			return false;
    		}
    	case DOWN_LEFT:
    		if(currentCol != 0 && currentRow != field.length - 1){	    			
    			return true;
    		}else {
    			return false;
    		}
    	case DOWN_RIGHT:
    		if(currentRow != field.length - 1 && currentCol != field[currentRow].length - 1){	    			
    			return true;
    		}else {
    			return false;
    		}
    	default:
    		return false;
    	}
    }
    
}

