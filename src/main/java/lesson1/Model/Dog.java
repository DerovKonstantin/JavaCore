package main.java.lesson1.Model;

import java.util.HashMap;



/** 
 * Класс - собака, наследник класса Animal, использует интерфейс сравнения Comparable<Animal>
 * @author --
 * @version 1.0
*/
public class Dog extends Animal implements Comparable<Dog> {

    /** поле - идентификатор собаки */
    private int id;
    /** поле - статус - домашние или вьючные животные */
    private String status;

    /**
     * Конструктор - создание нового объекта (собака)
     * @param name - имя собаки
     * @param age - возраст собаки
     * @param id - идентификатор собаки
     */
    public Dog(String name, int age, int id, String status) {
        super(name, age);
        this.id = id;
        this.status = status;
    }

    /**
     * Получение значения поля - идентификатор собаки
     */
    public int getId() {
        return id;
    }

    /**
     * Определения значения поля - идентификатор собаки
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
        super.setExtendsСlassText(language.get("Dog"));
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return String.format(super.getText()[0], super.getName(), super.getAge(), id, status);
    }

    @Override
    public int compareTo(Dog dog) {
        System.out.printf(super.getText()[1],super.getName(), dog.getName());
        if(super.getAge() == dog.getAge())
        {
            if (id == dog.id) return 0 ;
            if (id > dog.id) return 1;
            else return -1;
        }

        if(super.getAge() > dog.getAge())
        return 1;
        else
        return -1;        
    }
    
}

