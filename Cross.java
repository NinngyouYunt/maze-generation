
public class Cross {
	// Top Bottom Left Right
	private boolean rightWall = false;
	private boolean bottomWall = false;

	public Cross() {

	}

	public boolean getWalls() {
		return false;
	}

	public void buildVertical() {
		bottomWall = true;
	}

	public void buildHorizontal() {
		rightWall = true;
	}

	public boolean getVertical() {
		return bottomWall;
	}

	public boolean getHorizontal() {
		return rightWall;
	}

	public void breakVertical() {
		bottomWall = false;
	}

	public void breakHorizontal() {
		rightWall = false;

	}

}
