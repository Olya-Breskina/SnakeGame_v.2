import java.util.Random;

public class Apple extends Dots implements Runnable {
    private static final Random RANDOM = new Random();
    private GameField gameField;

    public Apple(int x, int y) {
        super(x, y);
        System.out.println("[>Apple - " + Thread.currentThread().getName()
                + "]: Hello! I'm Apple! My position - X: " + getX() + ", Y: " + getY());
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void run() {
        try {
            while (!Thread. currentThread().isInterrupted()) {
                Thread.sleep(10000);
                move();
            }

        } catch (InterruptedException e) {
            System.out.println("[>Apple - " + Thread.currentThread().getName() + "]: Interrupted!");
            Thread.currentThread().interrupt();
        }

    }

    public void move() {
        int newX;
        int newY;
        do {// создать рандом координаты в предлах поля
            newX = RANDOM.nextInt(gameField.getWidth() / gameField.getDotSize()) * gameField.getDotSize();
            newY = RANDOM.nextInt(gameField.getHeeight() / gameField.getDotSize()) * gameField.getDotSize();
        }
        while (gameField.isFieldEmpty(getX(), getY()));
        // вызвать метод, что поле не занято: если поле занято перегенерируем, если нет вызываем методы сеттер у Dоts и ставим новые координаты
        setX(newX);
        setY(newY);
        System.out.println("[>Apple - " + Thread.currentThread().getName()
                + "]: Moved to X: " + getX() + ", Y: " + getY());
    }
}

