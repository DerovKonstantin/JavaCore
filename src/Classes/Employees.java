package Classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 
 * Класс - Список сотрудников, использует интерфейс перечесления
 * @author --
 * @version 1.0
*/
public class Employees implements Iterable<Person> {
    /** поле список сотрудников */
    private List<Person> employeesList;

    /**
     * Конструктор - создание нового объекта (список сотрудников)
     */
    public Employees() {
        this.employeesList = new ArrayList<Person>();
    }

    /**
     * Получения значения поля список сотрудников
     */
    public List<Person> getEmployees() {
        return employeesList;
    }

    /**
     * Определение значения поля список сотрудников
     * @param employeesList - поле список сотрудников
     */
    public void setEmployees(List<Person> employeesList) {
        this.employeesList = employeesList;
    }

    /**
     * Добавление нового человека в список сотрудников
     * @param person - новый человек
     */
    public void addPerson(Person person) {
        this.employeesList.add(person);
    }

    /**
     * Получения списка всех имеющихся идентификационных номеров сотрудников
     */
    public List<Integer> getIdList() {
        List<Integer> idList = new ArrayList<Integer>();
        for (Person personr : employeesList) {
            idList.add(personr.getId());
        } return idList;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список сотрудников...\n");
        for (Person person : employeesList) {
            sb.append(String.format("%s.\n", person.toString()));
        } sb.append("   ...");
        return sb.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new Iterator<Person>() {
            private int counter;

            @Override
            public boolean hasNext() {
                if (counter < employeesList.size()) {
                    return true;
                } else {
                    return false;
                }            
            }

            @Override
            public Person next() {            
                return employeesList.get(counter++);
            }
        };
    }

}