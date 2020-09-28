package _06_gridworld;

import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class Gridworld {
	
	
	public static void main(String[] args) {
		//Random ran = new Random();
		Color blue = new Color(0, 0, 250);
		Color red = new Color(250, 0, 0);
		Color white = new Color(250, 250, 250);
		World world = new World();
		/*Bug redBug = new Bug();
		Bug blueBug = new Bug(blue);
		Flower pinkFlower = new Flower();*/
		Flower whiteFlower = new Flower(white);
		Flower redFlower = new Flower(red);
		Flower americanFlower = redFlower;
		
		/*Location redBugLocation = new Location(0,0);
		Location blueBugLocation = new Location(ran.nextInt(9)+1,ran.nextInt(9)+1);
		Location pinkFlowerLocation = new Location(blueBugLocation.getRow(), blueBugLocation.getCol()-1);
		Location blueFlowerLocation = new Location(blueBugLocation.getRow(), blueBugLocation.getCol()+1);*/
		
		
		world.show();
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				world.add(new Location(i,j), americanFlower);
			}
			
			if (i%2 == 0) {
				americanFlower = whiteFlower;
			} else {
				americanFlower = redFlower;
			}
		}
		
		
		/*world.add(redBugLocation, redBug);
		world.add(blueBugLocation, blueBug);
		world.add(pinkFlowerLocation, pinkFlower);
		world.add(blueFlowerLocation, blueFlower);
		
		blueBug.setDirection(90);
		*/
		
		
		
		
		
	}
}
