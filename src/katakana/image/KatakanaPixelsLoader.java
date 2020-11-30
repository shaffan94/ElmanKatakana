/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.image;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author nana
 */
public class KatakanaPixelsLoader {
    
    KatakanaImage img; //menciptakan parameter global bisa d pakai diberbagai clss dalam package
    public KatakanaPixelsLoader() 
    {
        img = new KatakanaImage();
    }
   //buffereedimage cuma untuk menampung saja image nya     
    public void loadPixelsFrom(BufferedImage bi){
        img = new KatakanaImage(bi.getWidth(), bi.getHeight()); 
        int pixels[];
        int pixelasli[][];

        int h= 32;
        int w= 32;

        Image imgg = bi.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
        bi=new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        bi.getGraphics().drawImage(imgg, 0, 0, null);
        img = new KatakanaImage(bi.getWidth(), bi.getHeight());

        pixelasli  = new int [img.getHeight()][img.getWidth()];
        int wpx = 0;
        int hpx = 0;

        for(int i=0;i<img.getWidth();i++)
        {
            for(int j=0;j<img.getHeight();j++)
            {
                int pxl = bi.getRGB(i, j);
                //System.out.print("Nilai Asli  i-" + i + "->" +pxl + "\t");
                Color c = new Color(pxl);
                int merah = c.getRed();
                int hijau = c.getGreen();
                int biru = c.getBlue();
                int gray = (merah+hijau+biru)/3 ;

                pixelasli[j][i]= gray;

                wpx++;
                if (wpx==img.getWidth())
                {
                   wpx=0;
                   hpx++;
                }
            }
        }
    
//    for(int i=0;i<img.getWidth();i++)
//    {
//         for(int j=0;j<img.getHeight();j++)
//        {
//            System.out.print(" "+pixelasli[j][i]);
//        }
//         System.out.println(" ");
//    }


        img.setPixelOri(pixelasli);
             
           
         //  System.out.println("Sukses");
    }




    public KatakanaImage getMyImage() {
        return img;
    }
}
