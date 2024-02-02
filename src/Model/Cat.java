package Model;

import java.util.HashMap;



/** 
 * Класс - Кошка, наследник класса Animal, использует интерфейс сравнения Comparable<Animal>
 * @author --
 * @version 1.0
*/
public class Cat extends Animal implements Comparable<Cat>  {

    /** поле - идентификатор кошки*/
    private int id;
    /** поле - статус - домашние или вьючные животные */
    private String status;

    /**
     * Конструктор - создание нового объекта (кошка)
     * @param name - имя кошки
     * @param age - возраст кошки
     * @param id - идентификатор кошки
     */
    public Cat(String name, int age, int id, String status) {
        super(name, age);
        this.id = id;
        this.status = status;
    }

    /**
     * Получение значения поля - идентификатор кошки
     */
    public int getId() {
        return id;
    }

    /**
     * Определения значения поля - идентификатор кошки
     * @param id - идентификатор кошки
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

   @Override
    public void setText(HashMap<String, String[]> language) {
        super.setExtendsСlassText(language.get("Cat"));
    }

    @Override
    public String toString() {
        // "Cat [name = %s, age = %d, id = %d, status = %s]"
        return String.format(super.getText()[0], super.getName(), super.getAge(), id, status);
    }

    @Override
    public int compareTo(Cat cat) {
        // "Cats [%s - %s]"
        System.out.printf(super.getText()[1],super.getName(), cat.getName());
        if(super.getAge() == cat.getAge())
        {
            if (id == cat.id) return 0 ;
            if (id > cat.id) return 1;
            else return -1;
        }

        if(super.getAge() > cat.getAge())
        return 1;
        else
        return -1;        
    }

}
