import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MouseEventExample extends JPanel implements MouseListener {

    int x = -1;
    int y = -1;

    public MouseEventExample() {
        addMouseListener(this);
    }

    // Нүкте салу
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (x != -1 && y != -1) {
            g.setColor(Color.RED);
            g.fillOval(x - 5, y - 5, 10, 10); // нүкте
        }
    }

    // Тышқан басылған кезде
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        System.out.println("Координаталар: x = " + x + ", y = " + y);

        repaint(); // қайта салу
    }

    // Қалған әдістер міндетті, бірақ бос
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mouse Event Example");
        MouseEventExample panel = new MouseEventExample();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}