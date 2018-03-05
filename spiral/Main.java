import ecs100.*;
import java.awt.Color;
import java.io.*;
import java.util.*;
import javax.swing.JColorChooser;

public class Main{
    int[] spiral = new int[10];

    public static final int width = 20;
    public static final int height = 20;
    public Main(){
        UI.addButton("Line", this::Line);
        UI.addButton("Square", this::Square);
        UI.addButton("Spiral", this::Spiral);
        UI.addButton("clear", UI::clearGraphics);
        UI.addButton("Quit", UI::quit);
    }

    public void Line(){
        int left = 20;
        int top = 20;
        int count = 0;

        //UI.setColor(Color.blue);
        //UI.setColor(new Color(0,0,25*spiral[count]));
        //col = new Color(255,255,(25*spiral[count]));
        while(left <= spiral.length*20){

            int blue = (25*count);
            Color col = new Color(0,0,blue);
            UI.setColor(col);

            UI.fillRect(left, top, width, height);
            UI.setColor(Color.white);
            UI.drawString(String.valueOf(count+1), left , top + 20);
            left+=20;
            count++;
            blue--;
        }
    }

    public void Square(){
        int left = 20;
        int top = 20;
        int count = 1;
        for(int i = 0; i < spiral.length; i++){
            top += 20;
            left = 20;
            for(int j = 0; j <spiral.length; j++){
                int blue = (2*count);
                Color col = new Color(0,0,blue);
                UI.setColor(col);
                UI.fillRect(left, top, width, height);

                UI.setColor(Color.white);
                UI.drawString(String.valueOf(count), left , top + 20);
                left+=20;
                count++;
            }
        }
    }

    public void Spiral(){
        int left = 20;
        int top = 20;
        int countMain = 9;
        int count = 1;
        UI.setColor(Color.blue);
        while (countMain > 0){
            for (int i = 0; i < countMain; i++){
                int blue = (2*count);
                Color col = new Color(0,0,blue);
                UI.setColor(col);
                UI.fillRect(left, top, width, height);

                UI.setColor(Color.white);
                UI.drawString(String.valueOf(count), left , top + 20);
                count++;
                left+=20;
            } 
            for (int i = 0; i < countMain; i++){
               int blue = (2*count);
                Color col = new Color(0,0,blue);
                UI.setColor(col);
                UI.fillRect(left, top, width, height);

                UI.setColor(Color.white);
                UI.drawString(String.valueOf(count), left , top + 20);
                count++;
                top+=20;
            }
            for (int i = 0; i < countMain; i++){
                int blue = (2*count);
                Color col = new Color(0,0,blue);
                UI.setColor(col);
                UI.fillRect(left, top, width, height);

                UI.setColor(Color.white);
                UI.drawString(String.valueOf(count), left , top + 20);
                count++;
                left-=20;
            }
            for (int i = 0; i < countMain; i++){
                int blue = (2*count);
                Color col = new Color(0,0,blue);
                UI.setColor(col);
                UI.fillRect(left, top, width, height);

                UI.setColor(Color.white);
                UI.drawString(String.valueOf(count), left , top + 20);
                count++;
                top-=20;
            }
            countMain-=2;
            left+=20;
            top+=20;
        }
    }

}