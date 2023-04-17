import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //  MainWindow mw = new MainWindow();
        // создать поле, яблоки, змею
        GameField gameField = new GameField(16, 320, 320);
        //присмоить яблоки и змею полю
        Snake snake = new Snake(160, 160);
        Apple apple = new Apple(16, 32);
        snake.setGameField(gameField);
        apple.setGameField(gameField);

        gameField.setSnakeList(snake.snakeBody());
        gameField.setAppleList(Collections.singletonList(apple));

        // игра старт и стоп( поточные)
        Thread threadSnake = new Thread(snake);
        threadSnake.start();
        Thread threadApple = new Thread(apple);
        threadApple.start();
    }
}

