
public class Cell {
	// Top Bottom Left Right
	private boolean[] walls = new boolean[4];
	private boolean checked;

	public Cell(boolean hasWall) {
		for (int i = 0; i < walls.length; i++) {
			walls[i] = hasWall;
		}

		checked = false;
	}

	public void visit() {
		checked = true;
	}

//	public boolean[] getWalls() {
//		boolean[] copy = new boolean[walls.length];
//		for (int i = 0; i < walls.length; i++) {
//			copy[i] = walls[i];
//		}
//		return copy;
//	}

	public boolean visisted() {
		return checked;
	}

	public boolean getUp() {
		return walls[0];
	}

	public boolean getDown() {
		return walls[1];
	}

	public boolean getLeft() {
		return walls[2];
	}

	public boolean getRight() {
		return walls[3];
	}

	public void goUp() {
		walls[0] = false;
	}

	public void goDown() {
		walls[1] = false;
	}

	public void goLeft() {
		walls[2] = false;
	}

	public void goRight() {
		walls[3] = false;
	}
}
