import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import Classes.Employees;
import Classes.Freelancer;
import Classes.Person;
import Classes.PersonComparator;
import Classes.Worker;

public class App {
    public static void main(String[] args) throws Exception {
        
        // Создаем список сотрудников
        Employees employees  = new Employees();
        employees.addPerson(Freelancer.create("Иван", 25, 121, 1000, employees.getIdList()));
        employees.addPerson(Freelancer.create("Игорь", 31, 301, 1500, employees.getIdList()));
        employees.addPerson(Worker.create("Даша",  23, 171, 30000, employees.getIdList()));
        employees.addPerson(Worker.create("Лена",  21, 104, 35000, employees.getIdList()));
        employees.addPerson(Worker.create("Костя", 35, 302, 300000, employees.getIdList()));

        //Производим сортировку списков
        System.out.println("...До сортировки..................................................");
        System.out.println(employees.toString());
        Collections.sort(employees.getEmployees());
        System.out.println("...После сортировки...............................................");
        System.out.println(employees.toString());

        // Сравнение двух сотрудников
        PersonComparator<Person> PersComp = new PersonComparator<Person>();
        System.out.println(PersComp.compare(employees.getEmployees().get(4), employees.getEmployees().get(0)));

    }
}
