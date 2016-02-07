package MapUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.StringJoiner;

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
        setSize((int)width,(int)height);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createBufferStrategy(2);
        bufferStrategy = getBufferStrategy();
        requestFocus();
    }

    public void init(){
        worldMap2 = new WorldMap2(300, 300);
        worldMap2.create();
        player = new Player();
        player.setPozX(150);
        player.setPozY(150);
    }

    public boolean play(){
        init();
        while(true){
            paintWorld(player);
        }
    }
    /*public void chooseGraph(){
        for(int i=1; i<size.getX()-1; i++) {
            for (int j = 1; j < size.getY()-1; j++) {
                if (matrix[i][j - 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "01.png");
                }
                if (matrix[i + 1][j].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "02.png");
                }
                if (matrix[i + 1][j + 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "03.png");
                }
                if (matrix[i - 1][j].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "04.png");
                }
                if (matrix[i - 1][j - 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "09.png");
                }
                if (matrix[i + 1][j - 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "10.png");
                }
                if (matrix[i + 1][j + 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "11.png");
                }
                if (matrix[i - 1][j + 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    matrix[i][j].setSpriteName(checkHeight(i, j) + "12.png");
                }
            }
        }
    }*/

    public int checkHeight(int dx, int dy){
        if(worldMap2.getMatrix()[dx][dy].getCord().getZ()>=17)
            return 2;
        else return 1;
    }

    private void paintWorld(Player player) {
        Graphics2D g2 = (Graphics2D)bufferStrategy.getDrawGraphics();
        g2.clearRect(0,0,1550,1050);
        int x = player.getPozX();
        int y = player.getPozY();
        x-=15;
        y-=10;
        if(x<0) x=0;
        if(y<0) y=0;
        Cell matrix[][] = worldMap2.getMatrix();
        Cell cell = null;
        int screenX = 0;
        int screenY = 0;
        for(int i =x; i<x+31; i++){
            screenY = 0;
            for(int j=y; j<y+21; j++){
                cell = matrix[i][j];
                ArrayList<MapObject> allObjects = cell.getAllObjects();
                g2.drawImage(spriteCache.getSprite( checkHeight(i,j) + "13.png"), screenX*50, screenY*50, this);
                if (j>0 && matrix[i][j - 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "01.png"), screenX*50, screenY*50, this);
                }
                if (matrix[i + 1][j].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "02.png"), screenX*50, screenY*50, this);
                }
                if (matrix[i + 1][j + 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "03.png"), screenX*50, screenY*50, this);
                }
                if (i>0 && matrix[i - 1][j].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "04.png"), screenX*50, screenY*50, this);
                }
                if (i>0 && j>0 && matrix[i - 1][j - 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "09.png"), screenX*50, screenY*50, this);
                }
                if (matrix[i + 1][j - 1].getCord().getZ() > matrix[i][j].getCord().getZ() && j>0) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "10.png"), screenX*50, screenY*50, this);
                }
                if (matrix[i + 1][j + 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "11.png"), screenX*50, screenY*50, this);
                }
                if (i>0 && matrix[i - 1][j + 1].getCord().getZ() > matrix[i][j].getCord().getZ()) {
                    g2.drawImage(spriteCache.getSprite(checkHeight(i,j) + "12.png"), screenX*50, screenY*50, this);
                }
                for(MapObject ob : allObjects){
                    g2.drawImage(spriteCache.getSprite(ob.getSpriteName()), screenX*50, screenY*50, this);
                }

                screenY++;
                System.out.print("y = " + screenY + ", ");
            }
            screenX++;
            System.out.println("x = " + screenX);
        }
        bufferStrategy.show();
    }

    public static void main(String args [] ) {
        GameFrame gra = new GameFrame();
        gra.play();
    }

}
