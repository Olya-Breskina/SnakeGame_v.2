import Observer.Manager;
import Observer.ManagerImpl;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //  MainWindow mw = new MainWindow();
        ManagerImpl manager=new ManagerImpl();
        // создать поле, яблоки, змею
        GameField gameField = new GameField(10, 320, 320);
        //присмоить яблоки и змею полю
        Snake snake = new Snake(160, 160, manager);
        Apple apple = new Apple(100, 160);
        snake.setGameField(gameField);
        apple.setGameField(gameField);

        gameField.setSnakeList(snake.snakeBody());
        gameField.setAppleList(Collections.singletonList(apple));

        // игра старт и стоп( поточные)
        GameProcess gameProcess=new GameProcess(List.of(apple),snake);
        gameProcess.gameStart();
    }
}

