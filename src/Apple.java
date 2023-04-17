import java.util.Random;

public class Apple extends Dots implements Runnable {
    private GameField gameField;

    public Apple(int x, int y) {
        super(x, y);
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void run() {
        for (int i=0; i<10;i++) {
            try {
                move();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                gameField.gameOver();
            }
        }
    }

    public void move() {
        System.out.println("яблоко до: "+ getX()+" "+ getY());
        int x;
        int y;
        do {// создать рандом координаты в предлах поля
            x = new Random().nextInt(gameField.getWidth());
            y = new Random().nextInt(gameField.getHeeight());
        }
        while (gameField.isFieldEmpty(x, y));
        // вызвать метод, что поле не занято: если поле занято перегенерируем, если нет вызываем методы сеттер у Dоts и ставим новые координаты
        setX(x);
        setY(y);
        System.out.println("яблоко после: "+ getX()+" "+ getY());
    }
}

