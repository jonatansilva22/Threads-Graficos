//Jonatan Eduardo Silva Fragoso
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Grafica extends JComponent implements Runnable {

    Thread generate;
    double angle0 = 0;
    double a, b, c, d, angle1, angle2, angle3, angle4, angle5, angle6, angle7, total;

    public static double getGenerate() {
        return ((Math.random() * (1500 - 100)) + 100);
    }

    public Grafica() {
        generate = new Thread(this);
        generate.start();
    }

    public void paintComponent(Graphics g) {
        Graphics2D color = (Graphics2D) g;

        Arc2D.Double ang = new Arc2D.Double(Arc2D.PIE);
        ang.setFrame(getWidth() / 4, getHeight() / 4, 150, 150);

        ang.setAngleStart(angle0);
        ang.setAngleExtent(angle1);
        color.setColor(Color.cyan);
        color.draw(ang);
        color.fill(ang);

        ang.setAngleStart(angle2);
        ang.setAngleExtent(angle3);
        color.setColor(Color.orange);
        color.draw(ang);
        color.fill(ang);

        ang.setAngleStart(angle4);
        ang.setAngleExtent(angle7);
        color.setColor(Color.yellow);
        color.draw(ang);
        color.fill(ang);

        ang.setAngleStart(angle6);
        ang.setAngleExtent(angle7);
        color.setColor(Color.green);
        color.draw(ang);
        color.fill(ang);
    }

    public void run() {
        while (true) {
            a = getGenerate();
            b = getGenerate();
            c = getGenerate();
            d = getGenerate();
            total = a + b + c + d;
            angle1 = (a / total) * 360;
            angle3 = (b / total) * 360;
            angle5 = (c / total) * 360;
            angle7 = (d / total) * 360;
            angle2 = angle0 + angle1;
            angle4 = angle2 + angle3;
            angle6 = angle4 + angle5;
            repaint();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("Gráfica de las ventas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(300, 300);

        Grafica grafica = new Grafica();
        frame.add(grafica);
        frame.setVisible(true);
    }
}