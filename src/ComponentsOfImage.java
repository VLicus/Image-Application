package oopapp;
	

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ComponentsOfImage extends JComponent{
		private BufferedImage image;
		private String name;
		private String imagePath;
		private long size;
		private FileTime date;
		private BasicFileAttributes metadata;
		private Dimension imageDimension;
		
		public ComponentsOfImage() {
			setMinimumSize(new Dimension(500, 200));
		}
		
		public void update(File imageFile) {
	        try {
	            this.image = ImageIO.read(imageFile); 
	            this.imageDimension = new Dimension(this.image.getWidth(), this.image.getHeight());
	            this.setDate();
	            Frame[] masterVentana = JFrame.getFrames(); 
	            setMinimumSize(imageDimension);
	            setPreferredSize(imageDimension);
	            setMaximumSize(imageDimension);
	            masterVentana[0].setSize(new Dimension(this.image.getWidth(), this.image.getHeight() + 115));
	            repaint();
	        } catch (IOException x) {
	            x.printStackTrace();
	            }
    }
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g = g.create();
        int margin = 0;
        int w = getWidth();
        int h = getHeight();
        g.drawImage(this.image, margin, margin, w, h, this);
    }
	
	public BufferedImage getImage() {return this.image;
	}
	
	public String getName() {return this.name;
	}
	
	public String getImagePath() {return this.imagePath;
	}
	
	public long getImageSize() {return this.size;
	}
	
	public FileTime getDateNTime () {return this.date;
	}
	
	public BasicFileAttributes getMetadata() {return this.metadata;
	}
	
	public Dimension getImageDimension() {return this.imageDimension;
	}
	
	public void setName(String Name) {this.name = Name;
	}
	
	public void setPath(String Path) {this.imagePath = Path;
	}
	
	public void setSize(File file) {this.size = file.length();
	}
	
	public void setMetadata(File file) throws IOException {
		Path f = Paths.get(this.getImagePath());
		this.metadata = Files.readAttributes(f, BasicFileAttributes.class);
	}
	
	public void setDate() {this.date = this.metadata.creationTime();
	}
}
