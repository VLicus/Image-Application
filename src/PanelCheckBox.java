package oopapp;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class PanelCheckBox extends JPanel {

	private JCheckBox ch1 = new JCheckBox("Name");
	private JCheckBox ch2 = new JCheckBox("Path");
	private JCheckBox ch3 = new JCheckBox("Size");
	private JCheckBox ch4 = new JCheckBox("Date");
	private JCheckBox ch5 = new JCheckBox("Dimensions");
	private ComponentsOfImage COI; 

	public PanelCheckBox(ComponentsOfImage CoOfIm) {
		COI = CoOfIm;
		CListener listener = new CListener(CoOfIm);
		ch1.addActionListener(listener);
		ch2.addActionListener(listener);
		ch3.addActionListener(listener);
		ch4.addActionListener(listener);
		ch5.addActionListener(listener);
		add(ch1);
		add(ch2);
		add(ch3);
		add(ch4);
		add(ch5); 
	}

	public class CListener implements ActionListener { 
		private ComponentsOfImage COI;
		private Graphics graf;
		private boolean fl, fl1, fl2, fl3, fl4; 
		
		public void chfl() {
			if (this.fl) {
				this.graf = this.COI.getImage().getGraphics();
				this.graf.setFont(graf.getFont().deriveFont(20f));
				this.graf.setColor(java.awt.Color.orange);
				this.graf.drawString("Name: " + this.COI.getName(), 15, 20);
				this.COI.repaint();
			}
			if(this.fl1) {
				this.graf = this.COI.getImage().getGraphics();
				this.graf.setFont(graf.getFont().deriveFont(20f));
				this.graf.setColor(java.awt.Color.orange);
				this.graf.drawString("Path: " + this.COI.getImagePath(), 15, 45);
				this.COI.repaint();
			}
			if(this.fl2) {
				this.graf = this.COI.getImage().getGraphics();
				this.graf.setFont(graf.getFont().deriveFont(20f));
				this.graf.setColor(java.awt.Color.orange);
				this.graf.drawString("Size: " + this.COI.getImageSize(), 15, 70);
				this.COI.repaint();
			}
			if(this.fl3) {
				this.graf = this.COI.getImage().getGraphics();
				this.graf.setFont(graf.getFont().deriveFont(20f));
				this.graf.setColor(java.awt.Color.orange);
				this.graf.drawString("Date: " + this.COI.getDateNTime(), 15, 90);
				this.COI.repaint();
			}
			if(this.fl4) {
				this.graf = this.COI.getImage().getGraphics();
				this.graf.setFont(graf.getFont().deriveFont(20f));
				this.graf.setColor(java.awt.Color.orange);
				this.graf.drawString("Dimensions: " + this.COI.getImageDimension(), 15, 115);
				this.COI.repaint();
			}
		}

		public CListener(ComponentsOfImage CoOfIm) {
			this.COI = CoOfIm;
		} 
		
		@Override
		public void actionPerformed(ActionEvent e) { 
			JCheckBox CB = (JCheckBox) e.getSource();
			if (this.COI.getImage() != null) {
				if (CB == ch1) {
					if (CB.isSelected()) {
						this.fl = true;
						this.graf = this.COI.getImage().getGraphics();
						this.graf.setFont(graf.getFont().deriveFont(20f));
						this.graf.setColor(java.awt.Color.orange);
						this.graf.drawString("Name: " + this.COI.getName(), 15, 20);
						this.COI.repaint();
					} else {
						this.fl = false;
						this.COI.update(new File(this.COI.getImagePath()));
						this.chfl();
					}
				} else if (CB == ch2) {
					if (CB.isSelected()) {	
						this.fl1 = true;
						this.graf = this.COI.getImage().getGraphics();	
						this.graf.setFont(graf.getFont().deriveFont(20f));
						this.graf.setColor(java.awt.Color.orange);											 
						this.graf.drawString("Path: " + this.COI.getImagePath(), 15, 45);					
						this.COI.repaint();																	
					} else {																						 
						this.fl1 = false;																	
						this.COI.update(new File(this.COI.getImagePath()));
						this.chfl();
					}
				} else if (CB == ch3) {
					if (CB.isSelected()) {
						this.fl2 = true;
						this.graf = this.COI.getImage().getGraphics();
						this.graf.setFont(graf.getFont().deriveFont(20f));
						this.graf.setColor(java.awt.Color.orange);
						this.graf.drawString("Size: " + this.COI.getImageSize(), 15, 70);
						this.COI.repaint();
					} else {
						this.fl2 = false;
						this.COI.update(new File(this.COI.getImagePath()));
						this.chfl();
					}
				} else if (CB == ch4) {
					if (CB.isSelected()) {
						this.fl3 = true;
						this.graf = this.COI.getImage().getGraphics();
						this.graf.setFont(graf.getFont().deriveFont(20f));
						this.graf.setColor(java.awt.Color.orange);
						this.graf.drawString("Date: " + this.COI.getDateNTime(), 15, 90);
						this.COI.repaint();
					} else {
						this.fl3 = false;
						this.COI.update(new File(this.COI.getImagePath()));
						this.chfl();
					}
				} else if (CB == ch5) {
					if (CB.isSelected()) {
						this.fl4 = true;
						this.graf = this.COI.getImage().getGraphics();
						this.graf.setFont(graf.getFont().deriveFont(20f));
						this.graf.setColor(java.awt.Color.orange);
						this.graf.drawString("Dimensions: " + this.COI.getImageDimension(), 15, 115);
						this.COI.repaint();
					} else {
						this.fl4 = false;
						this.COI.update(new File(this.COI.getImagePath()));
						this.chfl();
					}
				}
			}
		}
	}
}
