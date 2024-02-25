package main.java.lesson1;

import java.util.ArrayList;
import java.util.List;

import main.java.lesson1.Model.*;
import main.java.lesson1.Control.*;
import main.java.lesson1.View.*;
// import main.java.lesson1.Model.Animal;
// import main.java.lesson1.Control.Controller;
// import main.java.lesson1.Control.iGetModel;
// import main.java.lesson1.Control.iGetView;
// import main.java.lesson1.Model.AnimalList;
// import main.java.lesson1.Model.Cat;
// import main.java.lesson1.Model.Dog;
// import main.java.lesson1.Model.Donkey;
// import main.java.lesson1.Model.Mull;
// import main.java.lesson1.View.AWTview;
// import main.java.lesson1.View.View;

public class App {
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

       List< Animal>  animals = new ArrayList< Animal>();

       Animal a1 = new Cat("Сергей",  21, 101, "домашний");
       Animal a2 = new Dog("Андрей",  22, 111, "домашний");
       Animal a3 = new Donkey("Иван", 22, 121, "вьючный");
       Animal a4 = new Mull("Игорь", 23, 301, "вьючный");
       Animal a5 = new Cat("Даша",  25, 171, "домашний");
       Animal a6 = new Dog("Лена",  23, 104, "домашний");

       animals.add(a1);
       animals.add(a2);
       animals.add(a3);
       animals.add(a4);
       animals.add(a5);
       animals.add(a6);
    

       iGetModel model = new AnimalList(animals);
       iGetView view = new View();
       Controller control = new Controller(model, view);
       control.run();

       //AWTview v = new AWTview();
       //v.setVisible(true);
    }
}