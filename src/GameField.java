import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameField  {

    private final int dotSize;
    private  final int width;
    private  final int heeight;
    private ArrayList<Dots> appleList; //список точек яблок
    private LinkedList<Dots> snakeList; //linkedList змея
    //конструктор на все
    public GameField(int dotSize, int width, int heeight) {
        this.dotSize = dotSize;
        this.width = width;
        this.heeight = heeight;
    }
    public GameField(ArrayList<Dots> appleList) {
        this.appleList = appleList;
    }

    public GameField(LinkedList<Dots> snakeList) {
        this.snakeList = snakeList;
    }

    public int getDotSize() {
        return dotSize;
    }

    public int getWidth() {
        return width;
    }

    public int getHeeight() {
        return heeight;
    }

    public ArrayList<Dots> getAppleList() {
        return appleList;
    }

    public void setAppleList(ArrayList<Dots> appleList) {
        this.appleList = appleList;
    }

    public LinkedList<Dots> getSnakeList() {
        return snakeList;
    }

    public void setSnakeList(LinkedList<Dots> snakeList) {
        this.snakeList = snakeList;
    }

   public boolean isFieldEmpty(){ // метод пустое поле или нет
       return true;
   }
public Dots putDotOnField(){//метод заданная точка в пределах поля? х не выходит за пределы высоты, у за пределы ширины

        return new Dots(x,y);
}



    // определить кто тут (яблоко или змея?)
    //метод добавть 1 точку-яблоко, проверка на пустое поле
    // метод setter для змеи, проверка на пустое поле

}
