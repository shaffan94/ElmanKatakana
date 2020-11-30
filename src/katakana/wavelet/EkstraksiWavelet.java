/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katakana.wavelet;

import javax.swing.JOptionPane;
import katakana.image.KatakanaImage;

/**
 *
 * @author nana
 */
public class EkstraksiWavelet {
    
    private double[] inputneuron= new double[30];
    double llllll, lllllh, llllhl, llllhh, lllh, llhl, llhh, lh, hl, hh;
    
    public EkstraksiWavelet(){
        
    }
    
    public static double[][] doHaar2DFWTransform(KatakanaImage ki, int cycles) {
        int w = ki.getWidth();
        int h = ki.getHeight();
        int maxCycle = getHaarMaxCycles(w);
        for(int x=0; x<ki.getHeight();x++){
            for(int j=0; j<ki.getWidth();j++){
                ki.setPixelwave(x, j, ki.getPixelBiner(j, x));
            }
        }
        double[][] pixel=ki.getPixelwave();
        
        boolean isCycleAllowed = isCycleAllowed(maxCycle, cycles);
        if (isCycleAllowed) {
            double[][] ds = new double[h][w];
            double[][] tempds = new double[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    ds[i][j] = pixel[i][j];
                }
            }
            for (int i = 0; i < cycles; i++) {
                w /= 2;
                for (int j = 0; j < h; j++) {
                    for (int k = 0; k < w; k++) {
                        double a = ds[j][2 * k];
                        double b = ds[j][2 * k + 1];
                        double add = a + b;
                        double sub = a - b;
                        double avgAdd = add / 2;
                        double avgSub = sub / 2;
                        tempds[j][k] = avgAdd;
                        tempds[j][k + w] = avgSub;
                    }
                }
                for (int j = 0; j < h; j++) {
                    for (int k = 0; k < w; k++) {
                        ds[j][k] = tempds[j][k];
                        ds[j][k + w] = tempds[j][k + w];
                    }
                }
                h /= 2;
                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < h; k++) {
                        double a = ds[2 * k][j];
                        double b = ds[2 * k + 1][j];
                        double add = a + b;
                        double sub = a - b;
                        double avgAdd = add / 2;
                        double avgSub = sub / 2;
                        tempds[k][j] = avgAdd;
                        tempds[k + h][j] = avgSub;
                    }
                }
                for (int j = 0; j < w; j++) {
                    for (int k = 0; k < h; k++) {
                        ds[k][j] = tempds[k][j];
                        ds[k + h][j] = tempds[k + h][j];
                    }
                }
            }
            return ds;
        }
        return null;
    }
    
    private static int getHaarMaxCycles(int hw) {
        int cycles = 0;
        while (hw > 1) {
            cycles++;
            hw /= 2;
        }
        return cycles;
    }
 
    private static boolean isCycleAllowed(int maxCycle, int cycles) {
        return cycles <= maxCycle;
    }
    
    public double meanDeviation(double[] input){
        double hasil, temp=0;
        double x;
        for(int i=0; i<input.length; i++){
            temp= temp+input[i];
        }
        x=temp/input.length;
        temp=0;
        for(int i=0; i<input.length; i++){
            temp= temp+Math.abs(input[i]-x);
        }

        hasil = temp/input.length;
        return hasil;
    }
    
    public double [] main(KatakanaImage ki) {
        double[] hasilhaar= new double[10];
        double[][] haar2DFWTransform = doHaar2DFWTransform(ki, 3);
            ki.setPixelReal(haar2DFWTransform);
            
            int h= ki.getHeight();
            int w = ki.getWidth();
            
            double[] temphl = new double[256];
            int n=0;
            for(int i= 0; i<h/2; i++){
                for(int j=w/2; j<w; j++){
                    temphl[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.hl=this.meanDeviation(temphl);
            hasilhaar[0]=this.hl;
            
            double[] templh = new double[256];
            n=0;
            for(int i= h/2; i<h; i++){
                for(int j=0; j<w/2; j++){
                    templh[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.lh=this.meanDeviation(templh);
            hasilhaar[1]=this.lh;
            
            double[] temphh = new double[256];
            n=0;
            for(int i= h/2; i<h; i++){
                for(int j=w/2; j<w; j++){
                    temphh[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.hh=this.meanDeviation(temphh);
            hasilhaar[2]=this.hh;
            
            double[] templlllll = new double[64];
            n=0;
            for(int i= 0; i<((h/2)/2)/2; i++){
                for(int j=0; j<((w/2)/2)/2; j++){
                    templlllll[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.llllll=this.meanDeviation(templlllll);
            hasilhaar[3]=this.llllll;
            
            double[] templlllhl = new double[64];
            n=0;
            for(int i= 0; i<((h/2)/2)/2; i++){
                for(int j=((w/2)/2)/2; j<(w/2)/2; j++){
                    templlllhl[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.llllhl=this.meanDeviation(templlllhl);
            hasilhaar[4]=this.llllhl;
            
            double[] templllllh = new double[64];
            n=0;
            for(int i= ((h/2)/2)/2; i<(h/2)/2; i++){
                for(int j=0; j<((w/2)/2)/2; j++){
                    templllllh[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.lllllh=this.meanDeviation(templllllh);
            hasilhaar[5]=this.lllllh;
            
            double[] templlllhh = new double[64];
            n=0;
            for(int i= ((h/2)/2)/2; i<(h/2)/2; i++){
                for(int j=((w/2)/2); j<(w/2)/2; j++){
                    templlllhh[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.llllhh=this.meanDeviation(templlllhh);
            hasilhaar[6]=this.llllhh;
            
            double[] templlhl = new double[64];
            n=0;
            for(int i= 0; i<(h/2)/2; i++){
                for(int j=(w/2)/2; j<w/2; j++){
                    templlhl[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.llhl=this.meanDeviation(templlhl);
            hasilhaar[7]=this.llhl;
            
            double[] templllh = new double[64];
            n=0;
            for(int i= (h/2)/2; i<(h/2); i++){
                for(int j=0; j<(w/2)/2; j++){
                    templllh[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.lllh=this.meanDeviation(templllh);
            hasilhaar[8]=this.lllh;
            
            double[] templlhh = new double[64];
            n=0;
            for(int i= (h/2)/2; i<(h/2); i++){
                for(int j=(w/2)/2; j<w/2; j++){
                    templlhh[n]=ki.getPixelReal(i, j);
                    n++;
                }
            }
            this.llhh=this.meanDeviation(templlhh);
            hasilhaar[9]=this.llhh;
            
            return hasilhaar;
    }
}
