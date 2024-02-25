package main.java.lesson1.View;

import java.awt.*;
import java.awt.event.*;

public class AWTview extends Frame  {
//class framedemo extends Frame {
    
    // Constructor of framedemo class
    public AWTview() {
    //framedemo() {

        //Close window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        // Расположение кнопок(\ШПАРГАЛКА\JAVA\Учебник\ВИЗУАЛИЗАЦИЯ\AWT,SWING\Layout Manager)
        setLayout(null);

        //GUI Logic

        // Addong Components

        // Create Button
        Button b1 = new Button("Ok");
        Button b2 = new Button("Cancel");
        // Set the position of Button
        b1.setBounds(100, 100, 100, 50);
        b2.setBounds(200, 100, 100, 50);
        // Add the button to Frame
        add(b1); add(b2);
        
        //Control the Frame
        //super.setVisible(true);
        super.setSize(500,500);
        super.setTitle("Demo Frame");

    }
}
