package main.java.lesson1.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.java.lesson1.Control.*;
// import main.java.lesson1.Control.iGetModel;

/** 
 * Класс - файл модели(лог файл), использует интерфейс iGetModel(возвращяет список)
 * @author --
 * @version 1.0
*/
public class ModelFile  implements iGetModel{

    /** поле - имя файла*/
    private String fileName;

    /**
     * Конструктор - создание нового объекта (лог файл)
     * @param fileName - имя файла
     */
    public ModelFile(String fileName) {
        this.fileName = fileName;
        // проверяем существует ли наш файл
        try(FileWriter fw = new FileWriter(fileName, false)) {
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Запись данных(животных) в лог файл
     * @param animals - список животных
     */
    public void saveAllAnimalToFile(List<Animal> animals) {
        try(FileWriter fw = new FileWriter(fileName, true)) {
            for(Animal animal : animals) {
                if (animal instanceof Cat) {
                    Cat cat = (Cat)animal;
                    fw.write(String.format("Cat %s %d %d %s", cat.getName(), cat.getAge(), cat.getId(), cat.getStatus()));
                    fw.append('\n');
                } else if (animal instanceof Dog) {
                    Dog dog = (Dog)animal;
                    fw.write(String.format("Dog %s %d %d %s", dog.getName(), dog.getAge(), dog.getId(), dog.getStatus()));
                    fw.append('\n');
                } else if (animal instanceof Donkey) {
                    Donkey donkey = (Donkey)animal;
                    fw.write(String.format("Donkey %s %d %d %s", donkey.getName(), donkey.getAge(), donkey.getId(), donkey.getStatus()));
                    fw.append('\n');
                } else {
                    Mull mull = (Mull)animal;
                    fw.write(String.format("Mull %s %d %d %s", mull.getName(), mull.getAge(), mull.getId(), mull.getStatus()));
                    fw.append('\n');
                }
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    /** 
     * @return List<Animal>
     */
    @Override
    public List<Animal> getAllAnimals() {
        List<Animal> animals  = new ArrayList<Animal>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null) {
                String[] param = line.split(" ");
                if (param[0].equals("Cat")) {
                    Cat pers = new Cat(param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), param[4]);
                    animals.add(pers);
                } else if (param[0].equals("Dog")) {
                    Dog pers = new Dog(param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), param[4]);
                    animals.add(pers);
                } else if (param[0].equals("Donkey")) {
                    Donkey pers = new Donkey(param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), param[4]);
                    animals.add(pers);
                } else {
                    Mull pers = new Mull(param[1], Integer.parseInt(param[2]), Integer.parseInt(param[3]), param[4]);
                    animals.add(pers);
                } 
                line = reader.readLine();
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return animals;
    }

    @Override
    public void delAnimal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delStudents'");
    }

    @Override
    public void setAnimal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAnimal'");
    }

    @Override
    public void setText(HashMap<String, String[]> language) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setText'");
    }
    
}