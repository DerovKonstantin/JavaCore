package main.java.lesson1.Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.java.lesson1.Model.*;
import main.java.lesson1.View.*;
// import main.java.lesson1.View.Language;
// import main.java.lesson1.Model.Cat;
// import main.java.lesson1.Model.Dog;
// import main.java.lesson1.Model.Donkey;
// import main.java.lesson1.Model.ModelFile;
// import main.java.lesson1.Model.Mull;


/** 
 * Класс - контроллер(сбор данных и вывод на печать, через интерфейсы iGetModel и iGetView)
 * @author --
 * @version 1.0
*/
public class Controller implements iGetView {
    
    /** поле - интерфейс - получить модель */
    private iGetModel model;
    /** поле - интерфейс - получить вид */
    private iGetView view;
    /** поле - список животных(используется внутри класса контролер для осуществления проверок)*/
    private List<Animal> animals = new ArrayList<>();
    /** поле - язык (содержит весь выводимый текс программы) */
    private Language language = new Language();
    /** поле - файл модели(лог файл) */
    ModelFile fModel = new ModelFile("AnimalDB.txt");
    /** поле - текст используемый в классе */
    private String[] text; 
    /** поле - ввод данных (кроверка корректности) */
    InputData inputData = new InputData();

    /**
     * Конструктор - создание нового объекта (контроллер)
     * @param model - интерфейс - получить модель
     * @param view - интерфейс - получить вид
     */
    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Метод - осуществляет проверку наличия элементов в списке
     * @param students - список студентов
     */
    private boolean testData(List<Animal> animals) {
        if(animals.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Метод - выводит на печать список студентов(при наличии элементов списка) 
     */
    public void update() {
        animals = model.getAllAnimals();
        if(testData(animals)) {
           view.printAllAnimals(animals);
        }
        else {
            System.out.println(text[0]);
        }
    }

    @Override
    public void setText(HashMap<String, String[]> language) {
        this.text = language.get("Controller");
    }


    /**
     * Метод - запускает цикл ввода команд 
     */
    public void run() {
        //fModel.getAllAnimals();
        language.choiceLanguageTextOptions(); // Выбираем язык
        model.setText(language.getLanguageTextOptions()); // Загружаем текст во все классы
        view.setText(language.getLanguageTextOptions());
        this.text = language.getLanguageTextOptions().get("Controller");
        for (Animal animal : model.getAllAnimals()) {
            if (animal instanceof Cat) {
                ((Cat)animal).setText(language.getLanguageTextOptions());
            } else if (animal instanceof Dog) {
                ((Dog)animal).setText(language.getLanguageTextOptions());
            } else if (animal instanceof Donkey) {
                ((Donkey)animal).setText(language.getLanguageTextOptions());
            } else if (animal instanceof Mull) {
                ((Mull)animal).setText(language.getLanguageTextOptions());
            }
        }
//////////////////////////
        String statusCopy; // ///////////
        for (Animal animal : model.getAllAnimals()) { // заменяем текст статуса на текст выбранного языка 
            if (language.getSelectedLanguage().equals("Rus")){
                if (animal instanceof Cat) {
                    statusCopy = ((Cat)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("pet", "домашнее");
                    statusCopy = statusCopy.replaceAll("beast of burden", "вьючное");
                    ((Cat)animal).setStatus(statusCopy);
                } else if (animal instanceof Dog) {
                    statusCopy = ((Dog)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("pet", "домашнее");
                    statusCopy = statusCopy.replaceAll("beast of burden", "вьючное");
                    ((Dog)animal).setStatus(statusCopy);
                } else if (animal instanceof Donkey) {
                    statusCopy = ((Donkey)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("pet", "домашнее");
                    statusCopy = statusCopy.replaceAll("beast of burden", "вьючное");
                    ((Donkey)animal).setStatus(statusCopy);
                } else if (animal instanceof Mull) {
                    statusCopy = ((Mull)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("pet", "домашнее");
                    statusCopy = statusCopy.replaceAll("beast of burden", "вьючное");
                    ((Mull)animal).setStatus(statusCopy);
                }
            } else {
                if (animal instanceof Cat) {
                    statusCopy = ((Cat)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("домашнее", "pet");
                    statusCopy = statusCopy.replaceAll("вьючное", "beast of burden");
                    ((Cat)animal).setStatus(statusCopy);
                } else if (animal instanceof Dog) {
                    statusCopy = ((Dog)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("домашнее", "pet");
                    statusCopy = statusCopy.replaceAll("вьючное", "beast of burden");
                    ((Dog)animal).setStatus(statusCopy);
                } else if (animal instanceof Donkey) {
                    statusCopy = ((Donkey)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("домашнее", "pet");
                    statusCopy = statusCopy.replaceAll("вьючное", "beast of burden");
                    ((Donkey)animal).setStatus(statusCopy);
                } else if (animal instanceof Mull) {
                    statusCopy = ((Mull)animal).getStatus();
                    statusCopy = statusCopy.replaceAll("домашнее", "pet");
                    statusCopy = statusCopy.replaceAll("вьючное", "beast of burden");
                    ((Mull)animal).setStatus(statusCopy);
                }
            }
        }
/////////////////////////////
        for (Animal animal : model.getAllAnimals()) { // заменям буквы имен на буквы выбранного языка
            String nameCopy = animal.getName();
            if (language.getSelectedLanguage().equals("Rus")){
                // language.getSelectedLanguage() - текстовое обозначение выбранного языка
                for(int i=0; i < language.getLanguage().get("Eng").get("Alphabet").length; i++) { 
                    // language.getLanguage().get("Eng").get("Alphabet") - массив Английских букв
                    nameCopy = nameCopy.replaceAll(language.getLanguage().get("Eng").get("Alphabet")[i], language.getLanguage().get("Rus").get("Alphabet")[i]);
                }
            } else {
                for(int i=0; i < language.getLanguage().get("Rus").get("Alphabet").length; i++) { 
                    nameCopy = nameCopy.replaceAll(language.getLanguage().get("Rus").get("Alphabet")[i], language.getLanguage().get("Eng").get("Alphabet")[i]);
                }
            }
            animal.setName(nameCopy);
        }

        boolean getNewIteration = true;
        while (getNewIteration) {
            String command = inputData.Text(text[1]);  // "Введите команду...\n   E) EXIT\n   L) LIST\n   D) DELETE\n..."
            switch(command.toUpperCase())
            {
                case "E":
                    fModel.saveAllAnimalToFile(model.getAllAnimals());
                    getNewIteration = false;
                    System.out.println(text[2]); // "Выход из программы!"
                    break;
                case "L":
                    view.printAllAnimals(model.getAllAnimals());
                    break;
                case "A":
                    model.setAnimal();
                    break;
                case "D":
                    model.delAnimal();
                    break;
                default:
                    System.out.println("Операция не распознана. Повторите ввод.");
            }
        }
    }

    @Override
    public void printAllAnimals(List<Animal> animal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'printAllAnimals'");
    }
}
