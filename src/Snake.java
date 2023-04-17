import java.util.LinkedList;

public class Snake implements Runnable {
    private final LinkedList<Dots> snake;// тело linkedList
    private final Direction direction;//направление змейки
    private GameField gameField;

    public Snake(int x, int y) {// размер змейки
        this.snake = new LinkedList<>();
        snake.add(new Dots(x, y));
        direction = Direction.LEFT;
        System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
    }

    private Dots isItTail() {  //метод хвост
        return snake.getLast();
    }

    private Dots getItHead() { // метод голова
        return snake.getFirst();
    }

    public LinkedList<Dots> snakeBody() {
        return snake;
    }

    private void eatApple() {//метод добавить кусочек тела
        Dots newTail = new Dots(isItTail().getX(), isItTail().getY());
        switch (direction) {
            case UP:
                moveDown(newTail);
                System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                break;
            case DOWN:
                moveUp(newTail);
                System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                break;
            case LEFT:
                moveRight(newTail);
                System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                break;
            case RIGHT:
                moveLeft(newTail);
                System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                break;
            default:
                break;
        }
        snake.addLast(newTail);
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(250);
                move();
            } catch (InterruptedException e) {
                gameField.gameOver();
            }
        }
    }

    public void move() {
        //двигаемся  (прибавляя к координатам размер ячейки)
        for (Dots dots : snake) {
            switch (direction) {
                case UP:
                    moveUp(dots);
                    System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                    break;
                case DOWN:
                    moveDown(dots);
                    System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                    break;
                case LEFT:
                    moveLeft(dots);
                    System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                    break;
                case RIGHT:
                    moveRight(dots);
                    System.out.println("змейка: " + snake.getFirst().getX() + " " + snake.getFirst().getY());
                    break;
                default:
                    break;
            }
        }
        //если встретили яблоко-едим его и увеличиваемся на 1
        if (!gameField.isFieldEmpty(getItHead().getX(), getItHead().getY())) {
            int dotOwner = gameField.getDotOwner(getItHead());
            if (dotOwner == 0) {
                eatApple();
                System.out.println("змейка нашла яблоко, змейка : " + snake.getFirst().getX() + " " + snake.getFirst().getY());
            } else if (dotOwner == 1) gameField.gameOver();
            //throw new IllegalStateException();//если змейка- исключение
        }
    }

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
}