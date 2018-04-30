
public class Recursive_Backtrack {
	// y,x
	private Cell[][] grid;

	public Recursive_Backtrack(int width, int height) {
		grid = new Cell[width][height];
		//Initialize
		for (int i = 0; i < grid.length; i++) {
			for (int k = 0; k < grid[i].length; k++) {
				grid[i][k] = new Cell(true);
			}
		}
		//Choose the exit and entrace
		if (width > height) {
			grid[0][(int) (Math.random() * height)].goLeft();
			grid[width - 1][(int) (Math.random() * height)].goRight();
		} else {
			grid[(int) (Math.random() * width)][0].goUp();
			grid[(int) (Math.random() * width)][height - 1].goDown();
		}
		// generate((int) (Math.random() * width), (int) (Math.random() *
		// height));
		generate(0, 0);
	}

	private void generate(int x, int y) {
		grid[x][y].visit();
		// Random a direction of going
		int direction = goWhere(x, y);
		//Go all possible direction until none left
		while (direction != -1) {
			if (direction == 0) {
				grid[x][y].goUp();
				grid[x][y - 1].goDown();
				generate(x, y - 1);
			} else if (direction == 1) {
				grid[x][y].goDown();
				grid[x][y + 1].goUp();
				generate(x, y + 1);
			} else if (direction == 2) {
				grid[x][y].goLeft();
				grid[x - 1][y].goRight();
				generate(x - 1, y);
			} else if (direction == 3) {
				grid[x][y].goRight();
				grid[x + 1][y].goLeft();
				generate(x + 1, y);
			}
			direction = goWhere(x, y);
		}
	}
	//Take in the location of a cell, determine the possible direction it can go can randomly choose one from it.
	private int goWhere(int x, int y) {
		int count = 0;
		int[] avalible = { -1, -1, -1, -1 };
		// Up - 0
		if (y - 1 >= 0 && grid[x][y - 1].visisted() == false) {
			avalible[0] = 0;
			count++;
		}
		// Down - 1
		if (y + 1 < grid[0].length && grid[x][y + 1].visisted() == false) {
			avalible[1] = 0;
			count++;
		}
		// Left - 2
		if (x - 1 >= 0 && grid[x - 1][y].visisted() == false) {
			avalible[2] = 0;
			count++;
		}
		// Right - 3
		if (x + 1 < grid.length && grid[x + 1][y].visisted() == false) {
			avalible[3] = 0;
			count++;
		}
		int rand = (int) (Math.random() * count);
		for (int i = 0; i < avalible.length; i++)
			if (avalible[i] != -1) {
				if (rand == 0) {
					return i;
				} else {
					rand--;
				}
			}
		return -1;
	}
	//return the grid for graph
	//Better not to return the field
	public Cell[][] getGrid() {
		return grid;
	}
}