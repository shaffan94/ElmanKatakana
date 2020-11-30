/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.image;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author nana
 */
public class KatakanaImageViewer {
    
    KatakanaImage img;
    JLabel jblViewer;
    
    public KatakanaImageViewer() 
    {
        
    }
    
   
    
    public void setImage(KatakanaImage myimg)
    {
        this.img = myimg;
    }
    
    public void setViewer(JLabel lblviewer)
    {
        this.jblViewer = lblviewer;
                
    }
    
   
     public void viewImageOutput()
    {
        int w = img.getWidth();
        int h = img.getHeight();   
        BufferedImage image = new BufferedImage(w , h , BufferedImage.TYPE_INT_RGB); 
        for(int i=0; i<w;i++){
            for(int j=0;j<h;j++){
                int pxl= img.getPixel(j, i);
                Color c = new Color(pxl);
                int alpha= c.getAlpha();
                int newpixel= colorToRGB(alpha, pxl, pxl, pxl);
                image.setRGB(i, j, newpixel);
            }
        }

        jblViewer.setText("");     
        jblViewer.setIcon(new ImageIcon(image.getScaledInstance(jblViewer.getWidth(), jblViewer.getHeight(), Image.SCALE_DEFAULT)));
            
    }
     
     public static int colorToRGB(int alpha, int red, int green, int blue) {
 
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red; newPixel = newPixel << 8;
        newPixel += green; newPixel = newPixel << 8;
        newPixel += blue;
 
        return newPixel;
 
    }

}
