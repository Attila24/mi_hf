package hf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Application {
	
	private static BufferedImage[] images = new BufferedImage[5];
	
	public static void loadImages(){
		try {
			for (int i = 0; i < 5 ; i++){
				images[i] = ImageIO.read(new File("img/"+(i+1)+".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static BufferedImage[] getImages(){
		return images;
	}
	
	public static void main(String[] args) {
		
		loadImages();
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				MainFrame mainframe;
				try {
					mainframe = new MainFrame();
					mainframe.setLocationRelativeTo(null);
					mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mainframe.setVisible(true);
				} catch (IOException e) {
					System.err.println(e.getMessage());
					e.printStackTrace();
				}

			}	
		});
		
	}
}
