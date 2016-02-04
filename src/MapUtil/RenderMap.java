package MapUtil;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
	
	public File generateMap() throws IOException {
		
		File mapa = new File("mapa.png"); //plik do ktorego zostanie zapisana mapa
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); //canvas na kt�rym pracuje
	    Graphics g = bi.createGraphics();//tworze obiekt na kt�rym mo�na rysowa�
	    int leveHeight; // wysoko��
        for (int dx = 0; dx < width; dx++) {
            for (int dy = 0; dy < height; dy++) {
            	int ix = dx;
            	int jy = dy;
            	
            	leveHeight = mapToPrint.getMatrix()[dx+x][dy+y].getCord().getZ(); //pobieram wysokosc komorki
            	//if(leveHeight<25&&leveHeight>0){
            	if(leveHeight<17&&leveHeight>0){
            		BufferedImage image = ImageIO.read(new File(graphLocation+"\\113.png"));
            		g.drawImage(image, ix, jy, null);
            		chooseGraph(dx, dy, g);
            		//g.setColor(new Color(leveHeight*10,255,0));
            		//g.fillRect(ix, jy, 40,40);
            	}else if(leveHeight>=17){
            		BufferedImage image = ImageIO.read(new File(graphLocation+"\\213.png"));
            		g.drawImage(image, ix, jy, null);
            		chooseGraph(dx, dy, g);
            	}else if(leveHeight==50){
            		g.setColor(new Color(255,0,0)); 
            		g.fillRect(ix, jy, 50,50);
            	}else if(mapToPrint.getMatrix()[dx][dy].retId()==3564){
                	g.setColor(Color.BLUE);
                	g.fillRect(ix, jy, 50,50);
                }else if (mapToPrint.getMatrix()[dx][dy].retId()==0) {  
                	g.setColor(Color.BLUE); 
                	g.fillRect(ix, jy, 50,50);        
                }else {
                	g.setColor(Color.BLUE); 
                	g.fillRect(ix, jy, 50,50);
                }
            	Random random = new Random();
            	if(mapToPrint.getMatrix()[dx+x][dy+y].getAllObjects().contains(new Tree(89,3))){
            		BufferedImage image = ImageIO.read(new File(graphLocation+"\\30"+random.nextInt(8)+".png"));
            		g.drawImage(image, ix, jy, null);
            	}
            }
        }
        
        try {
			ImageIO.write(bi, "PNG", mapa);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return mapa;
	}
	
	public int checkHeight(int dx, int dy){
		if(mapToPrint.getMatrix()[dx][dy].getCord().getZ()>=17)
		return 2;
		else return 1;
	}

	public void chooseGraph(int i,int j,Graphics g){
		File file;
		if(mapToPrint.getMatrix()[x+i][y+j-1].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"01.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(mapToPrint.getMatrix()[x+i+1][y+j].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"02.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(mapToPrint.getMatrix()[x+i+1][y+j+1].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"03.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(mapToPrint.getMatrix()[x+i-1][y+j].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"04.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(mapToPrint.getMatrix()[x+i-1][y+j-1].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"09.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(mapToPrint.getMatrix()[x+i+1][y+j-1].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"10.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(mapToPrint.getMatrix()[x+i+1][y+j+1].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"11.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(mapToPrint.getMatrix()[x+i-1][y+j+1].getCord().getZ() > mapToPrint.getMatrix()[x+i][y+j].getCord().getZ()){
			try {
				BufferedImage image =ImageIO.read(new File(graphLocation+"\\"+checkHeight(x+i,y+j)+"12.png"));
				g.drawImage(image,i*50,j*50,null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String []args) throws IOException{
		WorldMap2 map = new WorldMap2(300,300);
		map.create();
		RenderMap mapa = new RenderMap(0,0, 300, 300, map);
		mapa.generateMap();
		
	}
}
