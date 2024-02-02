package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Model.Animal;
import Model.Cat;
import Model.Dog;
import Model.Donkey;
import Model.ModelFile;
import Model.Mull;
import View.Language;

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
