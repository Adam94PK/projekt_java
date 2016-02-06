package MapUtil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

import javax.imageio.ImageIO;

public class RenderMap {

	private String graphLocation = "D:\\projekt_java\\out\\grafiki"; //sciezka dostepu do folderu z grafik�
	WorldMap2 mapToPrint = null;
	int x;
	int y;
	int width;
	int height;

	public RenderMap(int x, int y, int width, int height, WorldMap2 mapToPrint) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.mapToPrint = mapToPrint;
	}


	
	public static void main(String []args) throws IOException, ClassNotFoundException {
		SpriteCache spriteCache = new SpriteCache();
		spriteCache.getSprite("101.png");
		WorldMap2 map = new WorldMap2(300,300);
		map.create();
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(".\\mapa.dat"));
		outputStream.writeObject(map);
		outputStream.close();
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(".\\mapa.dat"));
		WorldMap2 mapToRender = (WorldMap2) inputStream.readObject();
		inputStream.close();
		RenderMap renderer = new RenderMap(0,0,300,300,mapToRender);

	}
}
