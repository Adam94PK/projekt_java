package MapUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;

/**
 * Created by Adam Zadora on 2016-02-06.
 */
public class GameFrame extends Canvas {
    private SpriteCache spriteCache;
    private BufferStrategy bufferStrategy;
    private Player player;
    private double width = 1500;
    private double height = 1050;
    public GameFrame (){
        spriteCache = new SpriteCache();
        JFrame frame = new JFrame(".:Gra:.");
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
    }

    public void init(){
        WorldMap2 worldMap2 = new WorldMap2(300, 300);
        worldMap2.create();

    }

    public boolean play(){
        init();
        while(true){
            paintWorld(player);
        }
    }

    private void paintWorld(Player player) {
        Rectangle2D visibleWorld = new Rectangle2D.Double( width, height, (player.getPozX()-(width/2)), ((player.getPozY()-height/2)) );



    }

}
