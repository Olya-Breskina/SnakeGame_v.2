import java.util.LinkedList;

public class Snake implements Runnable {
    private GameField gameField;
    private LinkedList<Dots> snake;// тело linkedList

    private void isItTail(LinkedList<Dots> list) {  //метод хвост
        list.getLast();
    }

    private void isItHead(LinkedList<Dots> list) { // метод голова
        list.getFirst();
    }

    private void addBody(LinkedList<Dots> list, Dots dots) {//метод добавить кусочек тела
        list.addLast(dots);
    }


    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }

    @Override
    public void run() {
//двигаемся  ( прибавляя к координатам размер ячейки)
        for (int i = snake.size(); i > 0; i--) {

        }
        //если встретили яблоко-едим его и увеличиваемся на 1
        if (isItHead(snake) == Apple(x, y)) {
            snake.add(Apple(x, y));
        }
        //если встретились с краем/хвостом конец игры
        if (isItHead(snake).equels (isItTail(snake))){
            gameField.gameOver();
        }


    }
}