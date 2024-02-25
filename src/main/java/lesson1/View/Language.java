package main.java.lesson1.View;

import java.util.HashMap;

import main.java.lesson1.Control.*;
// import main.java.lesson1.Control.InputData;

/** 
 * Класс - язык (содержит весь выводимый текс программы в разных языках)
 * @author --
 * @version 1.0
*/
public class Language {

    /** поле -  Языковой набор */
    // private HashMap<String, HashMap<String, String[]>> setLanguage;
    /** поле -  Набор вариантов Русского текста */
    private HashMap<String, String[]> setRusTextOptions;
    /** поле -  Набор вариантов Английского текста */
    private HashMap<String, String[]> setEngTextOptions;

    //private HashMap<String, String[]> choiceLanguageTextOptions;

    //private HashMap<String, String[]> alphabetlanguage;

    private HashMap<String, HashMap<String, String[]>> language;

    private String selectedLanguage;

    /**
     * Конструктор - создание нового объекта (язык)
     * @param animals - Набор вариантов текста
     */
    public Language() {
        this.setRusTextOptions = new HashMap<>();
        setRusTextOptions.put("Animal", new String[] {"Животное [имя = %s, возраст = %d]", " "});
        setRusTextOptions.put("AnimalList", new String[] {"Введите id животного для удаления.", "Введены неверные данные, введите число: - ", "Номер id %d не найден. \n",
        "Выберите тип животного...\n   C - Кот\n   D - Собака\n   O - Ослик\n   M - Мул\n...", "Напишите имя животного...", "Напишите возраст животного...",
        "Выберите статус животного...\n   Y - домашнее\n   N - вьючное\n...", "Домашнее", "Вьючное", "Операция не распознана. Повторите ввод.", "Животное %s с номером id %d удалено. \n"});
        setRusTextOptions.put("Cat", new String[] {"Кот [имя = %s, возраст = %d, id = %d, статус = %s]", "Коты [%s - %s]"});
        setRusTextOptions.put("Dog", new String[] {"Собака [имя = %s, возраст = %d, id = %d, статус = %s]", "Собаки [%s - %s]"});
        setRusTextOptions.put("Donkey", new String[] {"Осел [имя = %s, возраст = %d, id = %d, статус = %s]", "Ослы [%s - %s]"});
        setRusTextOptions.put("Mull", new String[] {"мул [имя = %s, возраст = %d, id = %d, статус = %s]", "мулы [%s - %s]"});
        setRusTextOptions.put("View", new String[] {"список животных.................", "..............................."});
        setRusTextOptions.put("Controller", new String[] {"Список животных пуст!", "Введите команду(одна буква)...\n   E - ВЫХОД\n   L - СПИСОК\n   A - ДОБАВЛЯТЬ\n   D - УДАЛИТЬ\n...",
                                                              "Выход из программы, данные были сохранены!", "Операция не распознана. Повторите ввод."});
        setRusTextOptions.put("Alphabet", new String[] {"А","Б","К","Д","Э","Ф","Г","Х","И","Ж","КС","Л","М","Н","О","П","К","Р","С","Т","У","В","В","К","Й","З",
        "а","б","к","д","э","ф","г","х","и","ж","кс","л","м","н","о","п","к","р","с","т","у","в","в","к","й","з"}); //,"ь"                 

        this.setEngTextOptions = new HashMap<>();
        setEngTextOptions.put("Animal", new String[] {"Animal [name = %s, age = %d]", " "});
        setEngTextOptions.put("AnimalList", new String[] {"Enter the id of the animal to delete.", "Invalid data entered, please enter a number: - ", "Number ID %d not found. \n",
        "Select animal type...\n   C - Cat\n   D - Dog\n   O - Donkey\n   M - Mull\n...", "Write the name of the animal...", "Write the age of the animal...",
        "Select animal status...\n   Y - pet\n   N - beast of burden\n...", "Pet", "Beast of burden", "The operation was not recognized. Please re-enter.", "Animal %s with id number %d has been deleted. \n"});
        setEngTextOptions.put("Cat", new String[] {"Cat [name = %s, age = %d, id = %d, status = %s]", "Cats [%s - %s]"});
        setEngTextOptions.put("Dog", new String[] {"Dog [name = %s, age = %d, id = %d, status = %s]", "Dogs [%s - %s]"});
        setEngTextOptions.put("Donkey", new String[] {"Donkey [name = %s, age = %d, id = %d, status = %s]", "Donkys [%s - %s]"});
        setEngTextOptions.put("Mull", new String[] {"Mull [name = %s, age = %d, id = %d, status = %s]", "Mules [%s - %s]"});
        setEngTextOptions.put("View", new String[] {"list of animals.................", "..............................."});
        setEngTextOptions.put("Controller", new String[] {"Animal list is empty!", "Enter the command (one letter)...\n   E - EXIT\n   L - LIST\n   A - ADD\n   D - DELETE\n...",
                                                              "Exit the program, the data has been saved!", "The operation was not recognized. Please re-enter."});
        setEngTextOptions.put("Alphabet", new String[] {"A","B","C","D","E","F","G","H","I","J","X","L","M","N","O","P","Q","R","S","T","U","V","W","K","Y","Z",
        "a","b","c","d","e","f","g","h","i","j","x","l","m","n","o","p","q","r","s","t","u","v","w","k","y","z"}); //,""

        this.language = new HashMap<>();
        language.put("Rus", setRusTextOptions);
        language.put("Eng", setEngTextOptions);

    }


     /**
     * Получение значения поля - Набор вариантов Русского текста
     */
    public HashMap<String, String[]> getLanguageTextOptions() {
        //return choiceLanguageTextOptions;
        return this.language.get(selectedLanguage);
    }

    public HashMap<String, HashMap<String, String[]>> getLanguage() {
        return this.language;
    }

    public String getSelectedLanguage() {
        return this.selectedLanguage;
    }
    // public HashMap<String, String[]> getalphabetlanguage() {
    //     return alphabetlanguage;
    // }

    public HashMap<String, String[]> choiceLanguageTextOptions() {

        //System.out.println("Выберите тип животного...\n   C - Кот\n   D - Собака\n   O - Ослик\n   M - Мул\n...");
        InputData inputData = new InputData();
        String command = inputData.Text("Select language group(Выберите языковую группу)...\n   R - Russian(Русский)\n   E - English(Английский)\n..."); 
            switch(command.toUpperCase())
            {
                case "R":
                    //choiceLanguageTextOptions = setRusTextOptions;
                    this.selectedLanguage = "Rus";
                    System.out.println("Вы выбрали русский язык...\n...");
                    break;
                case "E":
                    //choiceLanguageTextOptions = setEngTextOptions;
                    this.selectedLanguage = "Eng";
                    System.out.println("You have chosen English...\n...");
                    //model.setText()
                    break;
                default:
                    System.out.println("The operation was not recognized. Please re-enter(Операция не распознана. Повторите ввод).");
            }

        return setRusTextOptions;
    }
    
}
