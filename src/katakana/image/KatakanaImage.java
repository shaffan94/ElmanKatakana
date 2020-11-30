/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.image;

import java.awt.Color;

/**
 *
 * @author nana
 */
public class KatakanaImage {
    private int widthOri;
    private int heightOri;
    private int pixelori[][];
    private int pixeloutput[][];
    private double realpixelori[][];
    private double imgpixelori[][];
    private double pixelwave[][];
    private double pixeltrain[];
    private String name;
    private String kelas;
  
    public KatakanaImage() 
    {


    }
    public KatakanaImage(int widthOri, int heightOri) 
    {
        this.widthOri = widthOri;
        this.heightOri = heightOri;
        pixelori = new int[heightOri][widthOri];
        pixeloutput = new int[heightOri][widthOri];
        realpixelori =new double[heightOri][widthOri];
        pixelwave= new double[heightOri][widthOri];
        pixeltrain= new double[900];

    }
    public void SetName(String name)
    {
        this.name = name;
    }
  
    public String getName()
    {
        return name;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setPixelOri(int[][] pixelori) 
    {
        this.pixelori = pixelori;
    }

    public int[][] getPixelori() 
    {
        return pixelori;
    }

    public int getHeight() 
    {
        return heightOri;
    }

    public int getWidth() {
        return widthOri;
    }

    public void setPixel(int h,int w,int pixel) {
        this.pixelori[h][w] = pixel;
    }

    public int getPixel(int h,int w) 
    {
        return pixelori[h][w];
    }
    
    public void setPixelOutput(int h,int w,int output)
    {
        pixeloutput[h][w]=output;
    }
    
    public int getPixelBiner(int h,int w)
    {
        return  (pixelori[h][w]==0)?1:0;
    }
    
    public int getPixelOutput(int h,int w)
    {
        return  pixeloutput[h][w];
    }
    
    public void setPixelReal(double[][] realpixel)
    {
        realpixelori=realpixel;
    }
    
    public double getPixelReal( int i, int j){
        return realpixelori[i][j];
    }
    
    public double[][] getPixelwave() {
        return pixelwave;
    }

    public void setPixelwave(int h, int w, int pixelw) {
        pixelwave [h][w]= pixelw;
        
    }
    public void setPixeltrain(double[] trainpixel)
    {
        pixeltrain=trainpixel;
    }
    
    public double getPixeltrainx(int x){
        return pixeltrain[x];
    }
    
    public double[] getPixeltrain(){
        return pixeltrain;
    }
    
   
//    public static int[] OneDimensionalPixelBinary(double[][] twodpixel){
//       int[] onedpixel = new int[twodpixel.length*twodpixel[0].length];
//       int i=0;
//       for(int baris=0;baris<twodpixel.length;baris++){
//           for(int kolom=0;kolom<twodpixel[0].length;kolom++){
//               int pix = (int)twodpixel[baris][kolom];
//               if (pix<0){
//                   pix=255;
//               }else if (pix > 255){
//                   pix = 0;
//               }
//               Color c = new Color(pix,pix,pix,0);
//               onedpixel[i] = c.getRGB();
//               i++;
//
//           }
//       }
//       return onedpixel;
//   }
//    
//    
//      public int[] toOneDimensionalPixelGray(){
//       int[] onedpixel = new int[pixelori.length*pixelori[0].length];
//       int i=0;
//       for(int baris=0;baris<pixelori.length;baris++){
//           for(int kolom=0;kolom<pixelori[0].length;kolom++){
//                 int gray = pixelori[baris][kolom];  
//                   
//                   onedpixel[i] =gray;
//                 i++;
//
//           }
//       }
//       return onedpixel;
//   }
//  
//    
//      public int[] toOneDimensionalPixelGrayReal(){ //untuk nampilin hasil grayscale ke viewer
//       int[] onedpixel = new int[pixelori.length*pixelori[0].length];
//       int i=0;
//       for(int baris=0;baris<pixelori.length;baris++){
//           for(int kolom=0;kolom<pixelori[0].length;kolom++){
//                 int gray = pixelori[baris][kolom]; 
//                 Color c = new Color(gray, gray, gray,255 );
//                 onedpixel[i] =c.getRGB();
//                 i++;
//
//           }
//       }
//       return onedpixel;
//   }
//  
//     public double[] toOneDimensionalPixelDReal(){
//       double[] onedpixel = new double[pixelori.length*pixelori[0].length];
//       int i=0;
//       for(int baris=0;baris<pixelori.length;baris++){
//           for(int kolom=0;kolom<pixelori[0].length;kolom++){
//                 double gray = pixelori[baris][kolom];                  
//                 onedpixel[i] =gray;
//                 i++;
//
//           }
//       }
//       return onedpixel;
//   }

    
     
    
 }
