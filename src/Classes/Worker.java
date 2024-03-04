package Classes;

import java.util.List;

/** 
 * Класс - Работник, наследник абстрактного класса Человек
 * @author --
 * @version 1.0
*/
public class Worker extends Person {

    /** поле фиксированная месячная оплата */
    int salary;

    /**
     * Конструктор - создание нового объекта (Работник)
     * @param name - имя работника
     * @param age - возраст работника
     * @param id - идентификатор работника
     * @param rate - фиксированная месячная оплата
     */
    protected Worker(String name, int age, int id, int salary) {
        super(name, age, id);
        this.salary = salary;
    }

    /**
     * Получение значения поля фиксированная месячная оплата
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Определение значения поля фиксированная месячная оплата
     * @param hourRate - фиксированная месячная оплата
     */
    public void setSalary(int salary) {
        updateSalary(salary);
    }

    private void updateSalary(int salary) {
        if ( 19000 > id ) {
            throw new RuntimeException("Некорректные данные фиксированная месячная оплата.");
        }
        this.salary = salary;
    }

    public static Worker create(String name, int age, int id, int salary, List<Integer> idList) {
        if (age < 18){
            throw new RuntimeException("Некорректный возраст человека.");
        }

        if (name == null || name.length() < 3){
            throw new RuntimeException("Некорректное имя человека.");
        }
        
        if ( 0 > id || idList.contains(id)) {
            throw new RuntimeException("Некорректный идентификатор человека.");
        }
        if ( 19000 > salary ) {
            throw new RuntimeException("Некорректный данные зарплаты человека.");
        }
        return new Worker(name, age, id, salary);
    }

    @Override
    public int calcSalary() {
        return salary;
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("Person [ name = %s, age = %d, id = %d, salary = %d ]", name, age, id, calcSalary());
    }

    
    
}
