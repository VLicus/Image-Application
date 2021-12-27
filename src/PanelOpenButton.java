package oopapp;

import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

@SuppressWarnings("serial")

public class PanelOpenButton extends JPanel {
	private JButton Button = new JButton("Open");
	private JFileChooser fileChooser = new JFileChooser();
	private ComponentsOfImage CompOfIm;

	public PanelOpenButton(ComponentsOfImage CompOfIm, PanelCheckBox ChBx) {
		this.CompOfIm = CompOfIm;
		add(Button); 
		Button.addActionListener((ev) -> updateComponent(this.fileChooser, ChBx));
		}	

	public String getPath(JFileChooser fileChooser) {
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().getAbsolutePath();
		} else {
			return "";
		}
	}

	public void updateComponent(JFileChooser FChooser, PanelCheckBox ChBx) { 
		File updfile = new File(this.getPath(FChooser)); 
		this.CompOfIm.setPath(FChooser.getSelectedFile().getAbsolutePath()); 
		try { 
			this.CompOfIm.setMetadata(updfile); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.CompOfIm.setName(FChooser.getSelectedFile().getName());
		this.CompOfIm.setSize(updfile); 
		this.CompOfIm.update(updfile);
	}

}
