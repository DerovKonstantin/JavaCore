package View;

import java.util.HashMap;
import java.util.List;

import Control.iGetView;
import Model.Animal;
import Model.Cat;
import Model.Dog;
import Model.Donkey;
import Model.Mull;

/** 
 * Класс - вид(отображает список животных и харрактеристики), использует интерфейс iGetView
 * @author --
 * @version 1.0
*/
public class View implements iGetView  {

    /** поле - текст используемый в классе */
    private String[] text;

    @Override
    public void setText(HashMap<String, String[]> language) {
        this.text = language.get("View");
    }

    @Override
    public void printAllAnimals(List<Animal> animals)
    {
        System.out.println(text[0]);
        for(Animal animal : animals)
        {
            if (animal instanceof Cat) {
                System.out.println((Cat)animal);  
            } else if (animal instanceof Dog) {
                System.out.println((Dog)animal);
            } else if (animal instanceof Donkey) {
                System.out.println((Donkey)animal);
            } else {
                System.out.println((Mull)animal);
            }
        }
        System.out.println(text[1]);
    }
}
