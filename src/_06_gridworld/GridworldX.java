package _06_gridworld;

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class GridworldX {
	public static void main(String[] args) {
		World world = new World();
		Bug redBug = new Bug();
		
		for (int i = 0; i < 10; i++) {
			world.add(new Location(i, i), redBug);
			world.add(new Location(i, 9-i), redBug);
		}
		world.show();
	}
}
