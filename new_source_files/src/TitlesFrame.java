import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * a class that creates and launches the main form on which the animation of the given figure will be played. The basic values for choosing the type of figure are set here
 * клас который создаёт и запускает основную форму на которой будет воспроизводится анимация заданой фигуры. Основные значения для выбора типа фигуры задаём здесь
 */
public class TitlesFrame extends JFrame {
    public TitlesFrame() {
        this.initUI();
    }

    private void initUI() {
        this.setTitle("Кривые фигуры");
        this.setDefaultCloseOperation(3);
        this.add(new TitlesPanel(28));//Изменяем значения, что бы получить другую фигуру. Например 28-шестиугольник, 38-пятиугольник, 78-треугольник
        this.setSize(350, 350);//задаём размеры окна
        this.setLocationRelativeTo((Component)null);
    }

    /**
     * the method creates a form in which the animation with our figure / figures will be played. Starting point of the program
     * метод создает форму в которой будет воспроизводится анимация с нашею фигурой/фигурами. Начальная точка програмы
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);//включаем видимость нашей формы
            }
        });
    }
}
