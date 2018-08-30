import java.util.*;

public class Game {
    private static OX ox;
    private static Scanner sc = new Scanner(System.in);
    private static int row , col;
    public  static void input()
    {
        System.out.println(ox.getCurrentPlayer() + " (Col): ");
        col = sc.nextInt();
        System.out.println(ox.getCurrentPlayer() + " (Row): ");
        row = sc.nextInt();
    }
    public static void main(String args[])
    {
        ox = new OX();
        while(true) {
            System.out.println(ox.getTableString());
            input();
            ox.put(col, row);
            ox.switchPlayer();
            if(ox.checkWin())
            {
                System.out.println(ox.getCountX());
                System.out.println(ox.getCountO());
                System.out.println(ox.getCountDraw());
                ox.resetGame();
                input();
            }
        }
    }
}
