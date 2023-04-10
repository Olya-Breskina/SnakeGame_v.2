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
        do {// создать рандом координаты в предлах поля
            super.x = new Random().nextInt(20) * gameField.getDotSize();
            super.y = new Random().nextInt(20) * gameField.getDotSize();
        }
        while (gameField.isFieldEmpty(x, y));
        // вызвать метод, что поле не занято: если поле занято перегенерируем, если нет вызываем методы сеттер у Dоts и ставим новые координаты
       setX(x);
       setY(y);
    }
}

