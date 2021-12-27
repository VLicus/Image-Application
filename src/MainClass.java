package oopapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class MainClass extends JFrame {
	
	private PanelOfImage PaOfIm = new PanelOfImage(); 
	private ComponentsOfImage CoOfIm = PaOfIm.getComponentsOfImage(); 
	private PanelCheckBox CheckBoxes = new PanelCheckBox(CoOfIm);
	private PanelOpenButton OpenButton = new PanelOpenButton(CoOfIm, CheckBoxes);
	
	public MainClass() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		setTitle("Image Information");
		setPreferredSize(new Dimension(400, 115));	
		setMinimumSize(new Dimension(400, 115)); 
		setLayout(new BorderLayout());	
		add(CheckBoxes, BorderLayout.NORTH);
		add(OpenButton, BorderLayout.SOUTH);
		add(CoOfIm, BorderLayout.CENTER); 
		pack();
		setVisible(true);
	}

	public static void launch() {
		new MainClass();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> launch());
	}

}
