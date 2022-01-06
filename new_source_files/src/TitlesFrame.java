import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
    //метод создает форму в которой будет воспроизводится анимация с нашею фигурой/фигурами
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);//включаем видимость нашей формы
            }
        });
    }
}
