import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph_RB extends JFrame {
	private int width, height;
	private final int size = 15, wall = 2;
	private Cell[][] map;

	private JPanel panel = new JPanel(null) {
		public void paint(Graphics g) {
			g.setColor(Color.black);
			// g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
			for (int x = 0; x < map.length; x++) {
				for (int y = 0; y < map[x].length; y++) {
					g.setColor(Color.black);
					if (map[x][y].getUp()) {
						g.fillRect(size * x, size * y, size, wall);
					}
					if (map[x][y].getDown()) {
						g.fillRect(size * x, size * (y + 1) - wall, size, wall);
					}
					if (map[x][y].getLeft()) {
						g.fillRect(size * x, size * y, wall, size);
					}
					if (map[x][y].getRight()) {
						g.fillRect(size * (x + 1) - wall, size * y, wall, size);
					}
				}
			}

		}
	};
	//General GUI setWting with a change of frame size based on maze size
	public Graph_RB(Cell[][] g) {
		super(" M A Z E ");
		map = g;
		width = map.length;
		height = map[0].length;
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		panel.setBounds(10, 10, size * width, size * height);
		this.setBounds(100, 100, panel.getWidth() + 35, panel.getHeight() + 60);
		this.setBackground(Color.black);

		this.add(panel);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		//Recursive_Backtrack g = new Recursive_Backtrack((int) (1 + Math.random() * 100), (int) (1 + Math.random() * 100));
			//Graph_RB graph = new Graph_RB(g.getGrid());
		Recursive_Backtrack g = new Recursive_Backtrack((88), (8));
			Graph_RB graph = new Graph_RB(g.getGrid());
		for (int i = 0; i < g.getGrid().length; i++) {
			for (int k = 0; k < g.getGrid()[i].length; k++) {
				print(i, k, g);
			}
		}
	}
	//Just to see all the available direction for all the cells
	public static void print(int x, int y, Recursive_Backtrack g) {
		System.out.print(x + " " + y + ": ");
		System.out.print(g.getGrid()[x][y].getUp() ? "up\t" : "\t");
		System.out.print(g.getGrid()[x][y].getDown() ? "down\t" : "\t");
		System.out.print(g.getGrid()[x][y].getLeft() ? "left\t" : "\t");
		System.out.println(g.getGrid()[x][y].getRight() ? "right\t" : "\t");
	}

}