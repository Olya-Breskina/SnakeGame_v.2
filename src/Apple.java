public class Apple extends Dots implements Runnable{
    private GameField gameField;
    public Apple(int x, int y){
        super(x,y);
    }
    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
    @Override
    public void run() {
        // создать рандом координаты в предлах поля
// вызвать метод, что поле не занято: если поле занято перегенерируем, если нет вызываем методы сеттер у Dоts и ставим новые координаты
    }
}
