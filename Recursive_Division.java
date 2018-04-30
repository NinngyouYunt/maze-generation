
public class Recursive_Division {
	private Cross[][] grid;
	private int width, height;

	public Recursive_Division(int w, int h) {
		width = w;
		height = h;
		grid = new Cross[w][h];
		for (int i = 0; i < grid.length; i++) {
			for (int k = 0; k < grid[i].length; k++) {
				grid[i][k] = new Cross();
			}
		}

		generate(0, 0, width - 1, height - 1);
	}

	public void generate(int x1, int y1, int x2, int y2) {
		boolean vertical = false, horizontal = false;
		if (x1 > x2 || y1 > y2 || x2 < 0 || y2 < 0 || x1 > grid.length || y1 > grid[0].length) {
			return;
		}
		if (x2 - x1 + 1 < 2 || y2 - y1 + 1 < 2)
			return;
		// if ((x1 == x2 && y1 == y2) || (x1 == 0 && 0 == x2 && y1 == 0 && y2 ==
		// 0)) {
		// return;
		// }
		// if ((x1 == x2 && y1 == 0) || (y1 == y2 && x1 == 0))
		// return;
		if (x2 - x1 + 1 == y2 - y1 + 1) {
			// Width==Height
			if (random(0, 1) == 0) {
				vertical = true;
			} else {
				horizontal = true;
			}
		}
		if (x2 - x1 + 1 > y2 - y1 + 1 || vertical) {
			// Width>Height Cut in x
			// x!=0
			int xTemp = random(x1 == 0 ? x1 + 1 : x1, x2);
			int hole = random(y1, y2);
			buildCutVertical(xTemp, y1, y2, hole);
			generate(x1, y1, xTemp - 1, y2);
			generate(xTemp + 1, y1, x2, y2);
		} else if (x2 - x1 + 1 < y2 - y1 + 1 || horizontal) {
			// Width<Height Cut in y
			// y!=0
			int yTemp = random(y1 == 0 ? y1 + 1 : y1, y2);
			int hole = random(x1, x2);
			buildCutHorizontal(yTemp, x1, x2, hole);
			generate(x1, y1, x2, yTemp - 1);
			generate(x1, yTemp + 1, x2, y2);
		}

	}

	// Build the wall at x from y1 to y2 and break the wall at hole
	public void buildCutVertical(int x, int y1, int y2, int hole) {
		System.out.println("From (" + x + "," + y1 + ") to (" + x + "," + y2 + ") at (" + x + "," + hole + ")");
		for (int i = y1; i <= y2; i++) {
			grid[x][i].buildVertical();
		}
		grid[x][hole].breakVertical();
	}

	// Build the wall at y from x1 to x2 and break the wall at hole
	public void buildCutHorizontal(int y, int x1, int x2, int hole) {
		System.out.println("From (" + x1 + "," + y + ") to (" + x2 + "," + y + ") at (" + hole + "," + y + ")");
		for (int i = x1; i <= x2; i++) {
			grid[i][y].buildHorizontal();
		}
		grid[hole][y].breakHorizontal();
	}

	public Cross[][] getGrid() {
		return grid;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// Random Generate a number (inclusive) if the input is the same, return the
	// number
	public int random(int from, int to) {
		if (from >= to)
			return from;
		return (int) (Math.random() * (to - from + 1)) + from;
	}
}
