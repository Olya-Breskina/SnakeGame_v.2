import java.util.LinkedList;
import java.util.List;

public class GameField {

    private static final int SNAKE = 1;
    private static final int APPLE = 0;
    private final int dotSize;
    private final int width;
    private final int height;
    private List<Apple> appleList; //список точек яблок
    private LinkedList<Dots> snakeList; //linkedList змея

    //конструктор на все
    public GameField(int dotSize, int width, int height) {
        this.dotSize = dotSize;
        this.width = width;
        this.height = height;
    }

    public int getDotSize() {
        return dotSize;
    }

    public int getWidth() {
        return width;
    }

    public int getHeeight() {
        return height;
    }

    public List<Apple> getAppleList() {
        return appleList;
    }

    public void setAppleList(List<Apple> appleList) {
        this.appleList = appleList;
    }

    public LinkedList<Dots> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(LinkedList<Dots> snakeList) {
        this.snakeList = snakeList;
    }

    public boolean isFieldEmpty(int x, int y) { // метод пустое поле или нет

        if (!isDotOnField(x, y)) return false;
        for (Dots apple : appleList) {
            if (apple.getX() == x && apple.getY() == y) return false;
        }
        for (Dots snake : snakeList) {
            if (snake.getX() == x && snake.getY() == y) return false;
        }
        return true;
    }

    public boolean isDotOnField(int x, int y) {//метод заданная точка в пределах поля? х не выходит за пределы высоты, у за пределы ширины
        return (x > 0 && x < getWidth()) && (y > 0 && y < getHeeight());
    }


    public int getDotOwner(Dots dots) {   // определить кто тут (яблоко или змея?)
        //0-яблоко; 1-змея
        for (Dots apple : appleList) {
            if (dots.equals(apple)) {
                System.out.println("[Game Field] <<< Apple here");
                return APPLE;
            }
        }
        for (Dots snake : snakeList) {
            if (dots.equals(snake)){
                System.out.println("[Game Field] <<< Snake here");
                return SNAKE;
            }
        }
        throw new IllegalStateException("Field {x:" + dots.getX() + ", y:"+ dots.getY() + "} is empty!");// если пусто
    }

    public void addApple(Apple apple) { //метод добавть 1 точку-яблоко, проверка на пустое поле
        isFieldEmpty(apple.getX(), apple.getY());
        appleList.add(apple);
    }

    // метод setter для змеи, проверка на пустое поле
//    public void gameOver() {
//        System.out.println(">------------GAME-OVER------------<");
//        System.out.println("> Your score: " + snakeList.size());
//        System.out.print("> ");
//        for (Dots dots: snakeList) {
//            System.out.print("{X: " + dots.getX() + "; Y: " + dots.getY() + "}");
//        }
//        System.out.println();
//        System.out.println(">---------------------------------<");
//    }
}
