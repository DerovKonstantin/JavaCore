package Model;

import java.util.List;

import java.util.HashMap;
import java.util.Iterator;

import Control.InputData;
import Control.iGetModel;


/** 
 * Класс - список животных, использует интерфейс iGetModel(возвращяет список)
 * @author --
 * @version 1.0
*/
public class AnimalList  implements iGetModel, Iterable<Animal>  {

    /** поле - список животных*/
    private List<Animal> animals;
    /** поле - текст */
    private String[] text;

    private HashMap<String, String[]> language;

    /**
     * Конструктор - создание нового объекта (список животных)
     * @param animals - список животных
     */
    public AnimalList(List<Animal> animals) {
        this.animals = animals;
        this.text = new String[3];
    }

    @Override
    public void setText(HashMap<String, String[]> language) {
        this.text = language.get("AnimalList");
        this.language = language;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animals;
    }

    @Override
    public void delAnimal() {
        // text[0] - "Введите id студента для удаления."
        // text[1] - "Введены неверные данные, введите число: - "
        // text[2] - "Номером id %d не найден. \n"
        InputData inputData = new InputData();
        int id = inputData.Number(text[0], text[1]);
        boolean deleted = false;
        Iterator<Animal> animal = animals.iterator();
        while(animal.hasNext()) {
            Animal a = animal.next();
            if (a instanceof Cat && ((Cat)a).getId() == id)  {
                    System.out.printf(text[10], a.getName(), ((Cat)a).getId()); // "Животное %s с номером id %d удалено. \n"
                    animal.remove();
                    deleted = true;
            } else if (a instanceof Dog && ((Dog)a).getId() == id) {
                    System.out.printf(text[10], a.getName(), ((Dog)a).getId());
                    animal.remove();
                    deleted = true;
            } else if (a instanceof Donkey && ((Donkey)a).getId() == id) {
                    System.out.printf(text[10], a.getName(), ((Donkey)a).getId());
                    animal.remove();
                    deleted = true;
            } else if (a instanceof Mull  && ((Mull)a).getId() == id) {
                    System.out.printf(text[10], a.getName(), ((Mull)a).getId());
                    animal.remove();
                    deleted = true;
            }
        }
        if (!deleted){
            System.out.printf(text[2], id);
        }
    }

    @Override
    public void setAnimal() {
        InputData inputData = new InputData();
        String command = inputData.Text(text[3]);  // "Выберите тип животного...\n   C - Cat\n   D - Dog\n   O - Donkey\n   M - Mull\n..."
        String name = inputData.Text(text[4]); // "Напишите имя животного..."
        int age = inputData.Number(text[5], text[1]); // "Напишите возраст животного..."
        int id = 0;
        for (Animal animal : animals) {
            if (animal instanceof Cat && id < ((Cat)animal).getId()) {
                    id = ((Cat)animal).getId();
            } else if (animal instanceof Dog && id < ((Dog)animal).getId()) {
                    id = ((Dog)animal).getId();
            } else if (animal instanceof Donkey && id < ((Donkey)animal).getId()) {
                    id = ((Donkey)animal).getId();
            } else if (animal instanceof Mull && id < ((Mull)animal).getId()) {
                    id = ((Mull)animal).getId();
            }
        } id ++;
        String status = inputData.Text(text[6]);// "Выберите статус животного...\n   Y - домашнее\n   N - вьючное\n..."
        switch(status.toUpperCase()) {
            case "Y":
                status = text[7]; // "Домашнее"
                break;
            case "N":
                status = text[8]; // "Вьючное"
                break;
            default:
                System.out.println(text[9]); //"Операция не распознана. Повторите ввод."
        }
        switch(command.toUpperCase()) {
            case "C":
                Animal a = new Cat(name, age, id, status);
                a.setText(language);
                animals.add(a);
                break;
            case "D":
                this.animals.add(new Dog(name, age, id, status));
                break;
            case "O":
                this.animals.add(new Donkey(name, age, id, status));
                break;
            case "M":
                this.animals.add(new Mull(name, age, id, status));
                break;
            default:
                System.out.println(text[9]);
        }
    }
    
    @Override
    public Iterator<Animal> iterator() {
        return new Iterator<Animal>() {
            private int counter;

            @Override
            public boolean hasNext() {
                if(counter < animals.size()){
                    return true;
                }
                else{
                    return false;
                }            
            }

            @Override
            public Animal next() {            
                return animals.get(counter++);
            }
        };
    }
    
}
