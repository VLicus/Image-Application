package oopapp;

import javax.swing.JPanel;
@SuppressWarnings("serial")
public class PanelOfImage extends JPanel{
	private ComponentsOfImage ComIm;
	
	public PanelOfImage() {
		this.ComIm = new ComponentsOfImage();
		add(this.ComIm);
	}
	public ComponentsOfImage getComponentsOfImage() {return this.ComIm;} 
}
