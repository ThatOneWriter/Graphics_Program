import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class DrawPanel extends JPanel implements MouseListener {

    private boolean[][] grid;
    private BrickLayout brickLayout;

    public DrawPanel() {
        this.addMouseListener(this);
        randomizeGrid();
        brickLayout = new BrickLayout("bricks", 7, false);

    }

    private void randomizeGrid() {
        grid = new boolean[30][40];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length;c++) {
                int chance = (int)(Math.random()*10);
                if (chance < 3) {
                    grid[r][c] = true;
                }
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 10;
        int y = 10;

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLUE);

        for (int columns = 0; columns < 40; columns++) {
            for (int rows = 0; rows < 30; rows++) {
                g.drawRect(x, y, 20, 20);
                if (grid[rows][columns]) {
                    g2.setColor(Color.RED);
                    g2.fillRect(x, y, 20, 20);
                    g2.setColor(Color.BLACK);
                }
                y += 25;
            }
            x += 25;
            y = 10;
        }



    }

    @Override
    public void mouseClicked(MouseEvent e) {
        randomizeGrid();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
