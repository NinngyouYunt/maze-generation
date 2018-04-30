import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph_RD extends JFrame {
	private int width, height;
	private final int size = 15;
	private Cross[][] grid;
	private JPanel panel = new JPanel(null) {
		public void paint(Graphics g) {
			g.setColor(Color.black);
			// g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
			g.drawLine(size, size, size + size * width, size);
			g.drawLine(size, size, size, size + size * height);
			g.drawLine(size, size + size * height, size + size * width, size + size * height);
			g.drawLine(size + size * width, size, size + size * width, size + size * height);
			for (int x = 0; x < grid.length; x++) {
				for (int y = 0; y < grid[x].length; y++) {
					if (grid[x][y].getVertical())
						g.drawLine(size + size * x, size + size * y, size + size * x, size + size * (y + 1));
					if (grid[x][y].getHorizontal())
						g.drawLine(size + size * x, size + size * y, size + size * (x + 1), size + size * y);
				}
			}
		}
	};

	public Graph_RD(Recursive_Division rd) {
		super(" M A Z E ");
		grid = rd.getGrid();
		width = rd.getWidth();
		height = rd.getHeight();
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setResizable(false);
		 panel.setBounds(10, 10, size * (width + 3), size * (height + 3));
//		panel.setBounds(0, 0, 1000, 1000);
		this.setBounds(100, 100, panel.getWidth() + size, panel.getHeight() + 40);
		this.setBackground(Color.black);

		this.add(panel);

		this.setVisible(true);
	}

	public static void main(String[] args) {
		Recursive_Division rd = new Recursive_Division(50,50);
		Graph_RD g = new Graph_RD(rd);
	}

}
