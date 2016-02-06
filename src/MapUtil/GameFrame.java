package MapUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

/**
 * Created by Adam Zadora on 2016-02-06.
 */
public class GameFrame extends Canvas {
    private SpriteCache spriteCache;
    private BufferStrategy bufferStrategy;
    private Player player;
    private double width = 1550;
    private double height = 1050;
    private WorldMap2 worldMap2;
    public GameFrame (){
        spriteCache = new SpriteCache();
        JFrame frame = new JFrame(".:Gra:.");
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        createBufferStrategy(2);
        bufferStrategy = getBufferStrategy();
        requestFocus();
    }

    public void init(){
        worldMap2 = new WorldMap2(300, 300);
        worldMap2.create();

    }

    public boolean play(){
        init();
        while(true){
            paintWorld(player);
        }
    }

    private void paintWorld(Player player) {
        Graphics2D g2 = (Graphics2D)bufferStrategy.getDrawGraphics();
        int x = player.getPozX()/100;
        int y = player.getPozY()/100;
        Cell matrix[][] = worldMap2.getMatrix();
        Cell cell = null;
        int pozX;
        int pozY;
        for(int i =x; i<x+31; i++){
            for(int j=y; j<y+21; j++){
                cell = matrix[i][j];
                ArrayList<MapObject> allObjects = cell.getAllObjects();
                pozX =(int) cell.getCord().getX();
                pozY =(int) cell.getCord().getY();
                g2.drawImage(spriteCache.getSprite(cell.getSpriteName()), pozX, pozY, this);
                for(MapObject ob : allObjects){
                    g2.drawImage(spriteCache.getSprite(ob.get));
                }
            }
        }
    }

}
