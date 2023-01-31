import java.awt.*;  
 
  
public class MyCanvas extends Canvas{  
	private String imagePath; 
	
	public MyCanvas(String imagePath) {
		super();
		this.imagePath = imagePath;
	}
      
    public void paint(Graphics g) {  
  
        Toolkit t = Toolkit.getDefaultToolkit();  
        Image i = t.getImage(this.imagePath);  
        g.drawImage(i, 0, 0, 550, 278, this);  
          
    }  
   
}
