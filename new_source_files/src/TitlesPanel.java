import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * a class in which we describe the basic properties of the form, animation and start drawing the figure
 * клас, в котором мы описиваем основные свойства формы, анимацию и запускаем рисование фигуры
 */
public class TitlesPanel extends JPanel implements ActionListener {
    private Graphics2D g2d;
    private Timer animation;
    private boolean is_done = true;
    private int start_angle = 0;
    private int shape ;

    /**
     * the method assigns a timer to animate our shape
     * метод присваивает таймер для анимации нашей фигуры
     */

    public TitlesPanel(int _shape) {
        this.shape = _shape;
        this.animation = new Timer(50, this);
        this.animation.setInitialDelay(50);
        this.animation.start();
    }

    /**
     * makes animation repeat
     * делает повторение анимации
     */

    public void actionPerformed(ActionEvent arg0) {
        if (this.is_done) {
            this.repaint();
        }

    }

    /**
     * a method for drawing a shape, in which a shape is created by size, thickness, etc.
     * метод для рисования фигуры, в котором создаётся фигура по размерам, толщине и тд.
     * @param g
     */
    private void doDrawing(Graphics g) {
        this.is_done = false;
        this.g2d = (Graphics2D)g;
        this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Dimension size = this.getSize();
        Insets insets = this.getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        ShapeFactory shape = new ShapeFactory(this.shape);
        this.g2d.setStroke(shape.stroke);
        this.g2d.setPaint(shape.paint);
        double angle = (double)(this.start_angle++);
        if (this.start_angle > 360) {
            this.start_angle = 0;
        }

        double dr = 90.0D / ((double)w / ((double)shape.width * 1.5D));

        for(int j = shape.height; j < h; j = (int)((double)j + (double)shape.height * 1.5D)) {
            for(int i = shape.width; i < w; i = (int)((double)i + (double)shape.width * 1.5D)) {
                angle = angle > 360.0D ? 0.0D : angle + dr;
                AffineTransform transform = new AffineTransform();
                transform.translate((double)i, (double)j);
                transform.rotate(Math.toRadians(angle));
                this.g2d.draw(transform.createTransformedShape(shape.shape));
            }
        }

        this.is_done = true;
    }

    /**
     * start drawing
     * запуск рисования
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.doDrawing(g);
    }
}
