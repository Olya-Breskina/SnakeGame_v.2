import Observer.Listener;
import event.EatApplyEvent;
import event.Event;
import event.SnakeDieEvent;

import java.util.List;

public class GameProcess implements Listener {
    private final List<Apple> appleList; //список точек яблок
    private final Snake snake; //linkedList змея
    private Thread threadSnake;
    private Thread threadApple;
    public GameProcess(List<Apple> appleList, Snake snake) {
        this.appleList = appleList;
        this.snake = snake;
    }

    public void gameStart() {
        // игра старт и стоп( поточные)
        threadSnake = new Thread(snake);
        threadSnake.start();
        for (Apple apple : appleList) {
            threadApple = new Thread(apple);
            threadApple.start();

        }

    }
    public void gameOver() {
        System.out.println(">------------GAME-OVER------------<");
        System.out.println("> Your score: " + snake.snakeBody().size());
        System.out.print("> ");
        for (Dots dots: snake.snakeBody()) {
            System.out.print("{X: " + dots.getX() + "; Y: " + dots.getY() + "}");
        }
        System.out.println();
        System.out.println(">---------------------------------<");
        threadApple.interrupt();
        threadSnake.interrupt();
    }

    @Override
    public void handleEvent(Event event) {
        if (event instanceof EatApplyEvent){
            //удалить старое яблоко и создать новое
            System.out.println(">---метод handleEvent---<");
            threadApple.interrupt();
            threadApple.start();
        }
        else if (event instanceof SnakeDieEvent){
            gameOver();
        }
    }
}
