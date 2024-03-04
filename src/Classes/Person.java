package Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 
 * Абстрактный класс - Человек, использует интерфейс сравнения
 * @author --
 * @version 1.0
*/
public abstract class Person implements Comparable<Person> {
    /** поле имя */
    protected String name;
    /** поле возраст */
    protected int age;
    /** поле идентификатор */
    protected int id;
    
    /**
     * Конструктор - создание нового объекта (человек)
     * @param name - имя человека
     * @param age - возраст человека
     * @param id - идентификатор человека
     */
    protected Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    /**
     * Получение значения поля имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Определения значения поля имя человека
     * @param name - поле имя человека
     */
    public void setName(String name) {
        this.name = name;
        // updateName(name);
    }

    /**
     * Получение значения поля возраст
     */
    public int getAge() {
        return age;
    }

    /**
     * Определение значения поля возраст
     * @param age - поле возраст
     */
    public void setAge(int age) {
        this.age = age;
        // updateAge(age);
    }

    /**
     * Получение значения поля идентификатор
     */
    public int getId() {
        return id;
    }

    /**
     * Определение значения поля идентификатор
     * @param id - поле идентификатор
     */
    public void setId(int id) {
        this.id = id;
        // updateId(id);
    }

    // private void updateAge(int age) {
    //     if (age < 18){
    //         throw new RuntimeException("Некорректный возраст человека.");
    //     }
    //     this.age = age;
    // }

    // private void updateName(String name) {
    //     if (name == null || name.length() < 3){
    //         throw new RuntimeException("Некорректное имя человека.");
    //     }
    //     this.name = name;
    // }

    // private void updateId(int id) {
    //     if ( 0 > id || id < 1000000000 ) {
    //         throw new RuntimeException("Некорректный идентификатор человека.");
    //     }
    //     this.id = id;
    // }

    public abstract int calcSalary();

    public abstract void printInfo();

    @Override
    public String toString() {
        return String.format("Person [ name = %s, age = %d, id = %d ]", name, age, id );
    }

    @Override
    public int compareTo(Person o) {
        // System.out.println(String.format("Comparison person [ %s - %s ]", name, o.getName()));
        if(id == o.getId()) {
            if (age == o.getAge()) return 0;
            if (age > o.getAge()) return 1;
            else return -1;
        }

        if(id > o.getId()) return 1;
        else return -1;
    }
     
}
