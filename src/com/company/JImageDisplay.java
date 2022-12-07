package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;        //управляет изображением, содержимое которого можно записать

public class JImageDisplay extends JComponent {

    private BufferedImage forImageD;        //экземпляр класса

    public BufferedImage getImage() {
        return forImageD;
    }

    public JImageDisplay (int width, int height){       //конструктор
        forImageD = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Dimension dimensionImg = new Dimension(width, height);

        super.setPreferredSize(dimensionImg);

    }       //компонент будет включен в пользовательский интерфейс, отобразит все изображения на экране

    public void paintComponent(Graphics g){     //защищенный метод, выводит на экран изображения
        super.paintComponent(g);        //правильное отображение
        g.drawImage (forImageD, 0, 0, forImageD.getWidth(), forImageD.getHeight(), null);       //рисование изображения в компоненте

    }

    public void clearImage(){       //устанавливает все пиксели в черный цвет
        int[] sizeImageArray = new int[getWidth()*getHeight()];

        forImageD.setRGB(0, 0, getWidth(), getHeight(), sizeImageArray, 0, 1);

    }

    public void drawPixel(int x, int y, int rgbColor){      //устанавливает пиксель в опрееленный цвет

        forImageD.setRGB(x, y, rgbColor);
    }
}