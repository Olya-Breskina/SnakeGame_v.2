import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
      // GameField gameField = new GameField();
        setTitle("Змейка");//название
        setSize(340, 410);//  размеры окна
        setLocation(400, 100);// располодение на экране

//----Создание панели  и добавление компонентов
        JPanel panel = new JPanel();
        JButton button = new JButton("Старт");
        // button.addActionListener(e -> gameField.start());
        JButton button1 = new JButton("стоп");
        // button1.addActionListener(e -> gameField.stop());
        // JLabel label = new JLabel("количество очков "+gameField.eatenApples());
        panel.add(button);
        panel.add(button1);
        // panel.add(label);
        getContentPane().add(panel, BorderLayout.NORTH);
//------
        //add(gameField);//игровое поле
        setVisible(true);// видимосто окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//действие с окном при нажатие на крестик
    }
}
