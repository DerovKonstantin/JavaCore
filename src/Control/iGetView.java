package Control;

import java.util.HashMap;
import java.util.List;

import Model.Animal;

/** 
 * Интерфейс - получить вид (набор методов для отображения списка животных и их характерисик)
 * @author --
 * @version 1.0
*/
public interface iGetView {

    /**
     * Метод - выводит на печать список всех животных
     * @param students - список животных
     */
    void printAllAnimals(List<Animal> animal);

    /**
     * Метод - загружает языковую группу выводимых сообщений
     * @param language - загружаемый текст
     */
    public void  setText(HashMap<String, String[]> language);


    
}
