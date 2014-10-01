package hf;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Enumeration;

import javax.swing.*;

public class MainFrame extends JFrame{

	private static BufferedImage selectedImage;
	
	private JLabel selectedImageLabel = new JLabel("Select an image.");
	
	public void changeImage(int num){
		selectedImageLabel.setText(null);
		selectedImageLabel.setIcon((new ImageIcon(Application.getImages()[num])));
		
		selectedImage = Application.getImages()[num];
	}
	
	public MainFrame() throws IOException{
		this.setMinimumSize(new Dimension(800,680));
		JPanel mainpanel = new JPanel(new BorderLayout());	
		
		//buttons
		JButton p1 = new JButton();	JButton p2 = new JButton();	JButton p3 = new JButton();
		JButton p4 = new JButton();	JButton p5 = new JButton();
		
		//buttongroup
		ButtonGroup group = new ButtonGroup();
		group.add(p1); group.add(p2); group.add(p3); group.add(p4); group.add(p5);
		
		//apply stuff to all buttons
		int i = 0;
		for (Enumeration<AbstractButton> e = group.getElements(); e.hasMoreElements();i++){
			JButton b = (JButton) e.nextElement();
			b.setPreferredSize((new Dimension(100,100)));
			b.setBorder(null);
			b.setIcon(
				new ImageIcon(
					(Application.getImages()[i]).getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH)
				)
			);
			b.setActionCommand(((Integer)i).toString());
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					changeImage(Integer.parseInt(e.getActionCommand()));
				}
			});
		}
		
		//buttonpanel
		JPanel bpanel = new JPanel(new FlowLayout());
		bpanel.add(p1); bpanel.add(p2); bpanel.add(p3); bpanel.add(p4); bpanel.add(p5);
		mainpanel.add(bpanel, BorderLayout.PAGE_START);
		
		// main picture panel
		JPanel ppanel = new JPanel();
		ppanel.setPreferredSize(new Dimension(660,480));
		ppanel.add(selectedImageLabel);

		mainpanel.add(ppanel, BorderLayout.LINE_START);
		
		// action buttons panel
		JPanel apanel = new JPanel();
		apanel.setLayout(new BoxLayout(apanel, BoxLayout.Y_AXIS));
		
		JButton b1 = new JButton("Action 1");
		JButton b2 = new JButton("Action 2");
		JButton b3 = new JButton("Action 3");
		
		apanel.add(b1); apanel.add(Box.createRigidArea(new Dimension(0,10)));
		apanel.add(b2); apanel.add(Box.createRigidArea(new Dimension(0,10)));
		apanel.add(b3); 
		
		mainpanel.add(apanel);
		
		// etc
		
		mainpanel.setVisible(true);
		this.add(mainpanel);
	}
	private static final long serialVersionUID = 1L;
}
