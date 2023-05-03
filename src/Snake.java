import Observer.Manager;
import Observer.Producer;
import event.EatApplyEvent;
import event.Event;
import event.SnakeDieEvent;

import java.util.LinkedList;

public class Snake implements Runnable, Producer {
    private final Manager manager;
    private final LinkedList<Dots> body;// тело linkedList
    private final Direction direction;//направление змейки
    private GameField gameField;

    public Snake(int x, int y, Manager manager) {
        this.manager = manager;// размер змейки
        this.body = new LinkedList<>();
        body.add(new Dots(x, y));
        direction = Direction.LEFT;
        System.out.println("[Snake - " + Thread.currentThread().getName()
                + "]: Hello! I'm Snake! My position - X: " + getItHead().getX() + ", Y: " + getItHead().getY());
    }

    private Dots isItTail() {  //метод хвост
        return body.getLast();
    }

    private Dots getItHead() { // метод голова
        return body.getFirst();
    }

    public LinkedList<Dots> snakeBody() {
        return body;
    }

    private void eatApple() {
        createEvent(new EatApplyEvent());
        System.out.println("[Snake - " + Thread.currentThread().getName() + "]: Eating apple...");
        Dots newTail = new Dots(isItTail().getX(), isItTail().getY());
        switch (direction) {
            case UP:
                moveDown(newTail);
                break;
            case DOWN:
                moveUp(newTail);
                break;
            case LEFT:
                moveRight(newTail);
                break;
            case RIGHT:
                moveLeft(newTail);
                break;
            default:
                break;
        }
        body.addLast(newTail);
        System.out.println("[Snake - " + Thread.currentThread().getName() + "]: New size of snake: " + body.size());
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void run() {
        try {
            while (!Thread. currentThread().isInterrupted()) {
                Thread.sleep(250);
                move();
            }
        } catch (InterruptedException e) {
            die();
        }
    }

    public void move() {
        // Создаем точку с координатами головы, которая является возможным следующим шагом змейки
        Dots nextDot = new Dots(getItHead().getX(), getItHead().getY());
        // Делаем сдвиг этой точки по направлению змейки
        doMoveByDirection(nextDot);

        // Проверяем эту точку, можем ли мы на неё встать
        if (!gameField.isFieldEmpty(nextDot.getX(), nextDot.getY())) {

            // Если змейка вышла за пределы поля, то она может либо умереть, либо перепрыгнуть на другой конец карты.
            if (!gameField.isDotOnField(nextDot.getX(), nextDot.getY())) {
                die(); // Сейчас умирает
                return;
            }

            int dotOwner = gameField.getDotOwner(nextDot);
            if (dotOwner == 0) {
                System.out.println("[Snake - " + Thread.currentThread().getName() + "]: Found apple here!");
                eatApple();
            } else if (dotOwner == 1) {
                System.out.println("[Snake - " + Thread.currentThread().getName() + "]: Found snake here! Let me die...");
                die();
                return;
            }
            //throw new IllegalStateException();//если змейка- исключение
        }
        //двигаемся (прибавляя к координатам размер ячейки)
        for (Dots dots : body) {
            doMoveByDirection(dots);
        }
        System.out.println("[Snake - " + Thread.currentThread().getName()
                + "]: Moved to X: " + getItHead().getX() + ", Y: " + getItHead().getY());
    }

    /**
     * Делает "Движение" для точки (тела змейки) в зависимости от текущего направления.
     *
     * @param dots - точка, которую необходимо сдвинуть
     */
    private void doMoveByDirection(Dots dots) {
        switch (direction) {
            case UP:
                moveUp(dots);
                break;
            case DOWN:
                moveDown(dots);
                break;
            case LEFT:
                moveLeft(dots);
                break;
            case RIGHT:
                moveRight(dots);
                break;
            default:
                break;
        }
    }

    /**
     * Действия, которые выполняются, когда змейка умирает
     */
//    будем выдовать событие
    private void die() {
        createEvent(new SnakeDieEvent());
        System.out.println("[Snake - " + Thread.currentThread().getName()
                + "]: I'm dying... Bye!");
        Thread.currentThread().interrupt();
    }

    // |--------------------------------|
    // | Базовые методы движения Змейки |
    // |--------------------------------|

    public void moveUp(Dots dots) {
        int y = dots.getY();
        y += gameField.getDotSize();
        dots.setY(y);
    }

    public void moveDown(Dots dots) {
        int y = dots.getY();
        y -= gameField.getDotSize();
        dots.setY(y);
    }

    public void moveLeft(Dots dots) {
        int x = dots.getX();
        x -= gameField.getDotSize();
        dots.setX(x);
    }

    public void moveRight(Dots dots) {
        int x = dots.getX();
        x += gameField.getDotSize();
        dots.setX(x);
    }

    @Override
    public void createEvent(Event event) {
        manager.handleEvent(event);
    }
}