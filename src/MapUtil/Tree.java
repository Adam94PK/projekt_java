package MapUtil;

import java.io.Serializable;
import java.time.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Implementation of Tree object on the game environment.
 * @author Artir2d2
 *
 */
public class Tree extends MapObject implements Serializable{
	private int growthStage = 4;
	private int logNum = 20;
	private int branchNum = 40;
	private String spriteName;
	/**
	 * When the tree is constructed, the exist marker is turned true, exist flag is a message to remove an object from the map
	 * Every tree should be at growth stage 4 at the begining... 
	 * @param id
	 * @param growthStage
	 */
	public Tree(int id, int growthStage, String spriteName){
		this.id = id;
		this.exist = true;
		this.growthStage = growthStage;
		this.spriteName = spriteName;
		switch(growthStage){
		case 1:
			logNum = 1;
			branchNum = 5;
			break;
		case 2:
			logNum = 5;
			branchNum = 10;
			break;
		case 3:
			logNum = 10;
			branchNum = 20;
			break;
		case 4:
			logNum = 20;
			branchNum = 30;
			break;
		}
	}
	
	@Override
	public void placeObject(Cell cell) {
		cell.addObject(this);
	}

	@Override
	public void removeObject(Cell cell) {
		// TODO Auto-generated method stub
		cell.removeObject(this);
	}

	@Override
	public void interact(Character character, String arg) {
		// TODO Auto-generated method stub
		switch(arg){
		case "getLog":
			getLog(character);
			break;
		}
	}
	/**
	 * This method is getting a log from a tree and transforms it to the character inventory.
	 * This method checks if character has enough space in inventory to carry the log.
	 * If the tree is out of logs, then it dissapears, so the exist marker is turned to false.
	 * At the same time, all listeners of change flag ill be informed about that event
	 * @param character
	 */
	private void getLog(Character character){
		if(logNum>0){
			/*
			 * heres the action of adding  resource to players equipment
			 */
		}
		else{
			exist = false;
			throwExist(); //returns false flag to every listener on listeners array
		}
	}
	/**
	 * Equals method. One tree is equals to other when every field is equal. That includes: id, exist, growthStage, branchNum, logNum
	 */
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean same = false;
		if(obj!=null &&obj instanceof Tree){
			same = (this.id ==((Tree)obj).id &&
					this.exist ==((Tree)obj).exist &&
					this.growthStage ==((Tree)obj).growthStage &&
					this.branchNum ==((Tree)obj).branchNum &&
					this.logNum ==((Tree)obj).logNum);
		}
		return same;
	}
}
