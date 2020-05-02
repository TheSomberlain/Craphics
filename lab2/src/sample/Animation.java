package sample;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.util.Collection;
import javax.swing.Timer;
import javax.swing.*;
@SuppressWarnings("serial")
public class Animation extends JPanel implements ActionListener {
    private static  int maxWidth;
    private  static int maxHeight;
    private static double scale = 1;
    private static double delta = 0.01;
    Timer timer;
    private  double angle = 0;
    public Animation(){
        timer = new Timer(10, this);
        timer.start();

    }
    public void paint (Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        g2d.setBackground(Color.green);
        g2d.clearRect(0,0, maxWidth, maxHeight);
        g2d.translate(0, 0);
        GradientPaint gp = new GradientPaint(5,25, Color.yellow, 20, 2, Color.blue, true );
        g2d.setPaint(gp);
        int rad = 800;
        g2d.fillOval(500 - rad/2,500 - rad/2,rad,rad);
        g2d.setColor(Color.white);
        rad = 700;
        g2d.fillOval(500 - rad/2,500 - rad/2,rad,rad);
        g2d.setColor(Color.black);
        g2d.drawArc(500 - rad/2,500 - rad/2,rad,rad, 60,30);
        g2d.setPaint(Color.yellow);
        rad = 80;

        g2d.setColor(Color.yellow);
        g2d.fillOval(500 - rad/2,210 - rad/2,rad,rad);
        g2d.fillOval(210 - rad/2,500 - rad/2,rad,rad);
        g2d.fillOval(790 - rad/2,500 - rad/2,rad,rad);
        g2d.fillOval(500 - rad/2,790 - rad/2,rad,rad);


        int[] xpoints = new int[]{450, 550,750,550};
        int[] ypoints = new int[]{500, 450,500, 550};
     g2d.setColor(Color.BLACK);
        g2d.rotate(angle,500,500);
        Polygon pol1 = new Polygon(xpoints,ypoints,4);
        g2d.fillPolygon(pol1);
        ypoints = new int[] {500, 470, 500, 530};
        g2d.setColor(Color.white);
        g2d.fillPolygon(new Polygon(xpoints, ypoints, 4));
        xpoints = new int[]{500, 480, 500, 520};
        ypoints = new int[]{520, 490, 170, 490};
        g2d.setColor(Color.black);
        g2d.rotate(-1.89*angle,500,500);
        g2d.rotate(angle,500,500);

        g2d.fillPolygon(new Polygon(xpoints, ypoints, 4));

        g2d.setColor(Color.red);
        rad = 20;
        g2d.scale(scale,0.99);
        g2d.fillOval(500 - rad/2,490 - rad/2,rad,rad);



    }
    public  static  void main (String[] args) {
        JFrame frame = new JFrame("Lab2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.add(new Animation());
        frame.setVisible(true);

        Dimension size = frame.getSize();
        Insets insets = frame.getInsets();
        maxWidth = size.width - insets.left - insets.right -1;
        maxHeight =  size.height - insets.top - insets.bottom -1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 0.01;
        if (scale < 0.01) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }

        scale += delta;
        repaint();
    }
}
