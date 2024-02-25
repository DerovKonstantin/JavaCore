package main.java.lesson1.Model;

import java.util.HashMap;



/** 
 * Класс - осел, наследник класса Animal, использует интерфейс сравнения Comparable<Animal>
 * @author --
 * @version 1.0
*/
public class Donkey extends Animal implements Comparable<Donkey> {

    /** поле - идентификатор осла */
    private int id;
    /** поле - статус - домашние или вьючные животные */
    private String status;

    /**
     * Конструктор - создание нового объекта (осел)
     * @param name - имя осла
     * @param age - возраст осла
     * @param id - идентификатор осла
     */
    public Donkey(String name, int age, int id, String status) {
        super(name, age);
        this.id = id;
        this.status = status;
    }

    /**
     * Получение значения поля - идентификатор осла
     */
    public int getId() {
        return id;
    }

    /**
     * Определения значения поля - идентификатор осла
     * @param id - идентификатор собаки
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Получение значения поля - статус - домашние или вьючные животные
     */
    public String getStatus() {
        return status;
    }

    /**
     * Определения значения поля - статус - домашние или вьючные животные
     * @param status - статус - домашние или вьючные животные
     */
    public void setStatus(String status) {
        this.status = status;
    }

    // /**
    //  * Определения значения поля - текст
    //  * @param text - поле - текст используемый в классе
    //  */
    @Override
    public void setText(HashMap<String, String[]> language) {
        super.setExtendsСlassText(language.get("Donkey"));
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format(super.getText()[0], super.getName(), super.getAge(), id, status);
    }

    @Override
    public int compareTo(Donkey donkey) {
        System.out.printf(super.getText()[1],super.getName(), donkey.getName());
        if(super.getAge() == donkey.getAge())
        {
            if (id == donkey.id) return 0 ;
            if (id > donkey.id) return 1;
            else return -1;
        }

        if(super.getAge() > donkey.getAge())
        return 1;
        else
        return -1;        
    }
    
}