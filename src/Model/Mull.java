package Model;

import java.util.HashMap;


/** 
 * Класс - мулл, наследник класса Animal, использует интерфейс сравнения Comparable<Animal>
 * @author --
 * @version 1.0
*/
public class Mull extends Animal implements Comparable<Mull> {

    /** поле - идентификатор осла */
    private int id;
    /** поле - статус - домашние или вьючные животные */
    private String status;

    /**
     * Конструктор - создание нового объекта (мулл)
     * @param name - имя мула
     * @param age - возраст мула
     * @param id - идентификатор мула
     */
    public Mull(String name, int age, int id, String status) {
        super(name, age);
        this.id = id;
        this.status = status;
    }

    /**
     * Получение значения поля - идентификатор мула
     */
    public int getId() {
        return id;
    }

    /**
     * Определения значения поля - идентификатор мула
     * @param id - идентификатор мула
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
        super.setExtendsСlassText(language.get("Mull"));
    }

    @Override
    public String toString() {
        return String.format(super.getText()[0], super.getName(), super.getAge(), id, status);
    }

    @Override
    public int compareTo(Mull mull) {
        System.out.printf(super.getText()[1],super.getName(), mull.getName());
        if(super.getAge() == mull.getAge())
        {
            if (id == mull.id) return 0 ;
            if (id > mull.id) return 1;
            else return -1;
        }

        if(super.getAge() > mull.getAge())
        return 1;
        else
        return -1;        
    }
    
}
