package main.java.lesson1.Control;

import java.util.Scanner;

/** 
 * Класс - ввод данных (кроверка корректности)
 * @author --
 * @version 1.0
*/
public class InputData {

    /**
     * Конструктор - создание нового объекта (ввод данных)
     */
    public InputData() {
        //Scanner input = new Scanner(System.in);
        //this.inputText = input.nextLine();
    }

    /**
     * Проверка корректности ввода числа
     * @param text1 - текст -=
     * @param text2 - текст -=
     */
    public int Number(String text1, String text2) { 
        // "Введите id."
        // "Введены неверные данные, введите число: - "
        System.out.println(text1);
        Scanner input = new Scanner(System.in);
        String inputText = input.nextLine();
        while (!inputText.matches("\\d*")){
            System.out.print(text2);
            inputText = input.nextLine();
        }
        return Integer.parseInt (inputText); 
    }

    /**
     * Метод - считывает введеную строку и возвращяет ее без проверок
     * @param text - текст - запрос ввода данных
     */
    public String Text(String text) {
        System.out.print(text);
        Scanner input = new Scanner(System.in);
        return input.nextLine(); 
    }
    
}