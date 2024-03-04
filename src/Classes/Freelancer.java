package Classes;

import java.util.List;

/** 
 * Класс - Повременщик, наследник абстрактного класса Человек
 * @author --
 * @version 1.0
*/
public class Freelancer extends Person {

    /** поле почасовая ставка */
    int rate;

    /**
     * Конструктор - создание нового объекта (Повременщик)
     * @param name - имя работника
     * @param age - возраст работника
     * @param id - идентификатор работника
     * @param rate - почасовая ставка
     */
    protected Freelancer(String name, int age, int id, int rate) {
        super(name, age, id);
        this.rate = rate;
    }

    /**
     * Получение значения поля почасовая ставка
     */
    public int getRate() {
        return rate;
    }

    /**
     * Определение значения поля почасовая ставка
     * @param hourRate - почасовая ставка
     */
    public void setRate(int rate) {
        this.rate = rate;
        // updateRate(rate);
    }

    // private void updateRate(int rate) {
    //     if ( 0 > id || id < 1000000000 ) {
    //         throw new RuntimeException("Некорректные данные почасовой ставкаи.");
    //     }
    //     this.rate = rate;
    // }

    /**
     * Статический метод создания нового объекта (Повременщик), с предварительной проверкой корректности заполнения полей
     * @param name - имя работника
     * @param age - возраст работника
     * @param id - идентификатор работника
     * @param rate - почасовая ставка
     * @param idList - список занятых идентификаторов
     * @return 
     */
    public static Freelancer create(String name, int age, int id, int rate, List<Integer> idList) { //Freelancer
        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека.");
        }

        if (name == null || name.length() < 3){
            throw new RuntimeException("Некорректное имя человека.");
        }
        
        if ( 0 > id || idList.contains(id)) { //  
            throw new RuntimeException("Некорректный идентификатор человека.");
        }
        if ( 1000 > rate ) {
            throw new RuntimeException("Некорректный данные зарплаты человека.");
        }
        return new Freelancer(name, age, id, rate);
    }

    @Override
    public int calcSalary() {
        return (int) (20.8 * 8 * rate);
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Person [ name = %s, age = %d, id = %d, rate = %d, salary = %d ]", name, age, id, rate, calcSalary());
    }

}
