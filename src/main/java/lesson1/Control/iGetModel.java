package main.java.lesson1.Control;

import java.util.HashMap;
import java.util.List;

import main.java.lesson1.Model.*;
// import main.java.lesson1.Model.Animal;

/** 
 * Интерфейс - получить модель (получение списка животных, добавление/удаление)
 * @author --
 * @version 1.0
*/
public interface iGetModel  {

    /**
     * Метод - получение списка животных и характеристик
     */
    public List<Animal> getAllAnimals();

    /**
     * Метод - добавление животного в список
     */
    public void setAnimal();

    /**
     * Метод - удаления животных из списка
     * @param id - идентификатор животного
     */
    public void delAnimal();
    
    /**
     * Метод - загружает языковую группу выводимых сообщений
     * @param language - загружаемый текст
     */
    public void  setText(HashMap<String, String[]> language);
    
}
