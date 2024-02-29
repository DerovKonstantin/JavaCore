//package ru.geekbrains.core.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '.';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int WIN_COUNT; // Выигрышная комбинация

    /**
     * Инициализация объектов игры
     */
    static void initialize(int fieldSizeX, int fieldSizeY) {
        // fieldSizeX = 3;
        // fieldSizeY = 3;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
                //System.out.println(field[x][y]);
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField(){
        // System.out.print("+");
        // for (int i = 0; i < fieldSizeX; i++){
        //     System.out.print("-" + (i + 1));
        // }
        // System.out.println("-");

        // for (int x = 0; x < fieldSizeX; x++){
        //     System.out.print(x + 1 + "|");
        //     for (int y = 0; y < fieldSizeY; y++){
        //         System.out.print(field[x][y] + "|");
        //     }
        //     System.out.println();
        // }

        // for (int i = 0; i < fieldSizeX * 2 + 2; i++){
        //     System.out.print("-");
        // }
        // System.out.println();
        System.out.println(fieldToString());
    }

    static String fieldToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fieldSizeX; i++) {
            sb.append(String.format("%d-", i + 1));
        } sb.replace(0, sb.length(), String.format("+-%s\n", sb.toString()));

        for (int x = 0; x < fieldSizeX; x++) {
            int startlengt = sb.length();
            for (int y = 0; y < fieldSizeY; y++){
                sb.append(String.format("%s%s", Character.toString(field[x][y]), "|"));
            } sb.replace(startlengt, sb.length(), String.format("%d|%s\n", x + 1, (sb.toString()).substring(startlengt)));
        } 

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            sb.append("-");
        } 
        return sb.toString();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn(int fieldSizeX){
        int x;
        int y;
        do {
            System.out.print(String.format("Введите координаты хода X и Y\n(от 1 до %d) через пробел: ", fieldSizeX));
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn(){
        int x;
        int y;

        int[] moveAi= new int[2];
        boolean defenseMove = false;

        if (!fieldToString().contains(Character.toString(DOT_AI))){  // если поле не содежит фишку AI
            int tryCount = (fieldSizeX * fieldSizeY)/2; // колличество попыток рондомного определения перспектив хода 
            do{ // рондомного определения перспектив хода
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
                tryCount--;
            } while (!isCellValid(x, y) || !aiCheckPerspective(x, y, DOT_EMPTY,  WIN_COUNT) || tryCount > 0);

            do{ // рондомное заполнение свободной ячейки
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            } while (!isCellValid(x, y) || !isCellEmpty(x, y) );
            field[x][y] = DOT_AI;
        }
        
        else {
            for (x = 0; x < fieldSizeX; x++){
                for (y = 0; y < fieldSizeY; y++){
                    if (field[x][y] == DOT_HUMAN && aiCheckPerspectiveLos(x, y, DOT_HUMAN, WIN_COUNT)[0] > 0) {
                        moveAi = aiCheckPerspectiveLos(x, y, DOT_HUMAN, WIN_COUNT);
                        defenseMove = true;
                    }
                }
            } 
            if (defenseMove) {
                field[moveAi[0]][moveAi[1]] = DOT_AI;
                System.out.print(moveAi[0] + moveAi[1]);///////////////
            }
            else { // рондомного определения перспектив хода
                int tryCount = (fieldSizeX * fieldSizeY)/2; // колличество попыток рондомного определения перспектив хода 
                do{ // рондомного определения перспектив хода
                    x = random.nextInt(fieldSizeX);
                    y = random.nextInt(fieldSizeY);
                    tryCount--;
                } while (!isCellValid(x, y) || !aiCheckPerspective(x, y, DOT_EMPTY,  WIN_COUNT) || tryCount > 0);

                do{ // рондомное заполнение свободной ячейки
                    x = random.nextInt(fieldSizeX);
                    y = random.nextInt(fieldSizeY);
                } while (!isCellValid(x, y) || !isCellEmpty(x, y) );
                field[x][y] = DOT_AI;
            }
        }
        
    }

    /**
     * Проверка перспектив хода
     * @param x координата
     * @param y координата
     * @param DOT_EMPTY
     * @param WIN_COUNT выигрышная комбинация
     * @return результат проверки
     */
    static boolean aiCheckPerspective(int x, int y, char DOT_EMPTY, int WIN_COUNT) {
        if (check1(x, y, DOT_EMPTY, WIN_COUNT-1) || (check2(x, y, DOT_EMPTY, WIN_COUNT-1)) 
        || (check3(x, y, DOT_EMPTY, WIN_COUNT-1)) || (check3(x, y, DOT_EMPTY, WIN_COUNT-1))) {
            return true;
        } return false;
    }

    static int[] aiCheckPerspectiveLos(int x, int y, char DOT_HUMAN, int WIN_COUNT) {
        int[] coord = new int[2];
        // проверка расположения |Х|.|Х|
        if ( field[x][y + 2] == DOT_HUMAN ) { // y < fieldSizeY-2 && field[x][y + 2] == DOT_HUMAN
            coord[0] = x; coord[1] = y + 1; 
            return coord;
        }
        if ( field[x + 2][y + 2] == DOT_HUMAN ) { //x < fieldSizeX-2 && y < fieldSizeY-2 && field[x + 2][y + 2] == DOT_HUMAN
            coord[0] = x + 1; coord[1] = y + 1; 
            return coord;
        }
        if ( field[x + 2][y] == DOT_HUMAN ) { // x < fieldSizeX-2 && field[x + 2][y] == DOT_HUMAN
            coord[0] = x + 1; coord[1] = y; 
            return coord;
        }
        if ( field[x + 2][y - 2] == DOT_HUMAN ) { // field[x + 2][y - 2] == DOT_HUMAN
            coord[0] = x + 1; coord[1] = y - 1; 
            return coord;
        }
        if ( field[x][y - 2] == DOT_HUMAN ) { // y > 2 && field[x][y - 2] == DOT_HUMAN
            coord[0] = x; coord[1] = y - 1; 
            return coord;
        }
        if ( field[x - 2][y - 2] == DOT_HUMAN ) { // x > 2 && y > 2 && field[x - 2][y - 2] == DOT_HUMAN
            coord[0] = x - 1; coord[1] = y - 1; 
            return coord;
        }
        if ( field[x - 2][y] == DOT_HUMAN ) { // x > 2 && field[x - 2][y] == DOT_HUMAN
            coord[0] = x - 1; coord[1] = y; 
            return coord;
        }
        if ( field[x - 2][y + 2] == DOT_HUMAN ) { // x > 2 && y < fieldSizeY-2 && field[x - 2][y + 2] == DOT_HUMAN
            coord[0] = x - 1; coord[1] = y + 1; 
            return coord;
        }

        // проверка расположения |.|Х|Х|
        if (check1(x, y, DOT_HUMAN, WIN_COUNT-2)) {
            if (y > 0) { coord[0] = x; coord[1] = y - 1; return coord;}
            do { 
                y++;
            } while (!isCellEmpty(x, y) && y < fieldSizeY );
            coord[0] = x; coord[1] = y;
            return coord;
        }
        if (check2(x, y, DOT_HUMAN, WIN_COUNT-2)) {
            if (x > 0 && y > 0) { coord[0] = x -1; coord[1] = y - 1; return coord;}
            do { 
                x++; y++;
            } while (!isCellEmpty(x, y) && x < fieldSizeX && y < fieldSizeY );
            coord[0] = x; coord[1] = y;
            return coord;
        }
        if (check3(x, y, DOT_HUMAN, WIN_COUNT-2)) {
            if (x > 0) { coord[0] = x - 1; coord[1] = y; return coord;}
            do { 
                x++;
            } while (!isCellEmpty(x, y) && x < fieldSizeX );
            coord[0] = x; coord[1] = y;
            return coord;
        }
        if (check4(x, y, DOT_HUMAN, WIN_COUNT-2)) {
            if (x < fieldSizeX && y < fieldSizeY) { coord[0] = x + 1; coord[1] = y + 1; return coord;}
            do { 
                x--; y--;
            } while (!isCellEmpty(x, y) && x > 0 && y > 0 );
            coord[0] = x; coord[1] = y;
            return coord;
        }
        // если не обнаружил угроз проигрыша
        coord[0] = -1; coord[1] = -1;
        return coord;

    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     * @return
     */
    static boolean checkDraw(){
        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(char dot, int WIN_COUNT){
        // Проверка по трем горизонталям
        // if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
        // if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
        // if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;

        // // Проверка по трем вертикалям
        // if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
        // if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
        // if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;

        // // Проверка по двум диагоналям
        // if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
        // if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;

        for (int x = 0; x < fieldSizeX; x++){
            for (int y = 0; y < fieldSizeY; y++){
                if (field[x][y] == dot) {
                    if (check1(x, y, dot, WIN_COUNT-1)) return true;
                    if (check2(x, y, dot, WIN_COUNT-1)) return true;
                    if (check3(x, y, dot, WIN_COUNT-1)) return true;
                    if (check4(x, y, dot, WIN_COUNT-1)) return true;
                }
            }
        } return false;
    }

    static boolean check1(int x, int y, char dot, int WIN_COUNT) {
        while( y < fieldSizeY-1 && field[x][y + 1] == dot ) {
            WIN_COUNT--; y++;
            if ( WIN_COUNT == 0 ) return true;
        } return false;
    }

    static boolean check2(int x, int y, char dot, int WIN_COUNT) {
        while( x < fieldSizeX-1 && y < fieldSizeY-1 && field[x + 1][y + 1] == dot ) {
            WIN_COUNT--; x++; y++;
            if ( WIN_COUNT == 0 ) return true;
        } return false;
    }

    static boolean check3(int x, int y, char dot, int WIN_COUNT) {
        while( x < fieldSizeX-1 && field[x + 1][y] == dot ) {
            WIN_COUNT--; x++;
            if ( WIN_COUNT == 0 ) return true;
        } return false;
    }

    static boolean check4(int x, int y, char dot, int WIN_COUNT){
        while( x < fieldSizeX-1 && y > 1 && field[x + 1][y - 1] == dot ) {
            WIN_COUNT--; x++; y--;
            if ( WIN_COUNT == 0 ) return true;
        } return false;
    }


    /**
     * Проверка состояния игры
     * @param dot фишка игрока
     * @param s победный слоган
     * @return состояние игры
     */
    static boolean checkState(char dot, int WIN_COUNT, String s){
        if (checkWin(dot, WIN_COUNT)){
            System.out.println(s);
            return true;
        }
        else if (checkDraw()){
            System.out.println("Ничья!");
            return true;
        }
        // Игра продолжается
        return false;
    }

    public static void main(String[] args) {
        WIN_COUNT = 3;  
        fieldSizeX = 5; // задать определение
        fieldSizeY = 5;
        while (true) {
            initialize(fieldSizeX, fieldSizeY);
            printField();
            while (true) {
                humanTurn(fieldSizeX);
                printField();
                if (checkState(DOT_HUMAN, WIN_COUNT, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, WIN_COUNT, "Вы победили!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if(!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

}
