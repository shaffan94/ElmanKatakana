/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.image;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author nana
 */
public class ImagePreprocessing {
    
    private ArrayList<Point> points = new ArrayList<>(); 
    private int thinning[][];
    private boolean sign;
    private int[][] imgArr;
    private ArrayList<int[]> koordinatMarks;
     
    public ImagePreprocessing(){
        
        
    }
   
    public void thresholding(KatakanaImage ki){
        int th, total, i, j;
        int[] histogram;
        float tMean,variance, maxVariance,firstCM,zerothCM;

        th = 0;
        total = ki.getHeight()*ki.getWidth();

        tMean = 0;
        maxVariance = 0;
        firstCM = zerothCM = 0;
        
        histogram = new int[256];

        for(i=0; i<histogram.length; i++){
            histogram[i] = 0;
        }

        for(i=0; i<ki.getWidth(); i++){
            for(j=0; j<ki.getHeight(); j++){
                histogram[ki.getPixel(i,j)]++;
            }
        }

        for (i = 0; i < 256; i++)
            tMean += i * histogram[i] / (total);

        for (i = 0; i < 256; i++) {
            zerothCM += histogram[i] / (total);
            firstCM += i * histogram[i] / (total);
            variance = (tMean * zerothCM - firstCM);
            variance *= variance;

            variance /= zerothCM * (1 - zerothCM);
            if (maxVariance < variance){
                maxVariance = variance;
                th = i;
            }
        }
        
        for(i=0; i<ki.getHeight();i++){
            for(j=0; j<ki.getWidth(); j++){
                if(ki.getPixel(i, j) >= th){
                    ki.setPixel(i, j, 255);
                }else if (ki.getPixel(i, j) < th){
                    ki.setPixel(i, j, 0);
                }
            }
        }
   
    }
    
    public void setImgArr(int[][] binerArr){
        int i, j;

        imgArr = new int[binerArr.length][binerArr[0].length];

        for(i=0; i<binerArr.length; i++){
            for(j=0; j<binerArr[i].length; j++){
                imgArr[i][j] = binerArr[i][j];
            }
        }
    }
    
    public void HitungSkeletonizeTahap1(){
        int i, j, k, l, height, width, kondisi1, kondisi2, kondisi3, kondisi4;
        int[][] subBinerArr;
        int[] koordinat;

        height = imgArr.length;
        width = imgArr[0].length;
        koordinatMarks = new ArrayList<>();

        for(i=0; i<height; i++){
            for(j=0; j<width; j++){
                if(i != 0 && i!=height-1 && j != 0 && j!=width-1){
                    if(imgArr[i][j] == 0){
                        subBinerArr = new int[3][3];
                        kondisi1 = kondisi2 = kondisi3 = kondisi4 = 0;

                        //kondisi 1 merupakan syarat untuk skeletonisasi pertama
                        //kondisi 2 merupakan syarat untuk skeletonisasi kedua
                        //kondisi 3 merupakan syarat untuk skeletonisasi ketiga
                        //kondisi 4 merupakan syarat untuk skeletonisasi keempat
                        //subBinerArr merupakan matriks yang menunjukkan bagian image yang akan dianalisis ketetanggaannya
                        subBinerArr[0][0] = imgArr[i-1][j-1];
                        subBinerArr[0][1] = imgArr[i-1][j];
                        subBinerArr[0][2] = imgArr[i-1][j+1];
                        subBinerArr[1][0] = imgArr[i][j-1];
                        subBinerArr[1][1] = imgArr[i][j];
                        subBinerArr[1][2] = imgArr[i][j+1];
                        subBinerArr[2][0] = imgArr[i+1][j-1];
                        subBinerArr[2][1] = imgArr[i+1][j];
                        subBinerArr[2][2] = imgArr[i+1][j+1];

                        for(k=0; k<subBinerArr.length; k++){
                            for(l=0; l<subBinerArr[k].length;l++){
								//penghitungan untuk mendapatkan syarat pertama dari skeletonisasi
                                if(subBinerArr[k][l] == 0 && (k!=1 || l!=1)){
                                    kondisi1 += 1;
                                }

								//penghitungan untuk mendapatkan syarat kedua dari skeletonisasi
                                if(k==0 && l!=2){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k][l+1] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                                if(l==2 && k!= 2){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k+1][l] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                                if(k == 2 && l!=0){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k][l-1] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                                if(l==0 && k!=0){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k-1][l] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                            }
                        }

						//penghitungan untuk mendapatkan syarat ketiga dari skeletonisasi
                        if(subBinerArr[0][1]==255 || subBinerArr[1][2]==255 || subBinerArr[2][1]==255){
                            kondisi3 = 1;
                        }

						//penghitungan untuk mendapatkan syarat keempat dari skeletonisasi
                        if(subBinerArr[1][2]==255 || subBinerArr[2][1]==255 || subBinerArr[1][0]==255){
                            kondisi4 = 1;
                        }

						//pemberian mark atau tanda pada matriks subBinerArr yang memenuhi kondisi atau persyaratan
                        if(kondisi1>= 2 && kondisi1<=6 && kondisi2==1 && kondisi3==1 && kondisi4==1){
                            koordinat = new int[2];
                            koordinat[0] = i;
                            koordinat[1] = j;
                            koordinatMarks.add(koordinat);
                        }
                    }
                }
            }
        }

		//pergantian dari pixel hitam ke putih untuk pixel yang ditandai atau diberikan mark pada matriks subBinerArr
        for(i=0; i<koordinatMarks.size(); i++){
            imgArr[koordinatMarks.get(i)[0]][koordinatMarks.get(i)[1]] = 255;
        }
    }
    
    public void HitungSkeletonizeTahap2(){
        int i, j, k, l, height, width, kondisi1, kondisi2, kondisi3, kondisi4;
        int[][] subBinerArr;
        int[] koordinat;

        height = imgArr.length;
        width = imgArr[0].length;
        koordinatMarks = new ArrayList<>();

        for(i=0; i<height; i++){
            for(j=0; j<width; j++){
                if(i != 0 && i!=height-1 && j != 0 && j!=width-1){
                    if(imgArr[i][j] == 0){
                        subBinerArr = new int[3][3];
                        kondisi1 = kondisi2 = kondisi3 = kondisi4 = 0;

                        subBinerArr[0][0] = imgArr[i-1][j-1];
                        subBinerArr[0][1] = imgArr[i-1][j];
                        subBinerArr[0][2] = imgArr[i-1][j+1];
                        subBinerArr[1][0] = imgArr[i][j-1];
                        subBinerArr[1][1] = imgArr[i][j];
                        subBinerArr[1][2] = imgArr[i][j+1];
                        subBinerArr[2][0] = imgArr[i+1][j-1];
                        subBinerArr[2][1] = imgArr[i+1][j];
                        subBinerArr[2][2] = imgArr[i+1][j+1];

                        for(k=0; k<subBinerArr.length; k++){
                            for(l=0; l<subBinerArr[k].length;l++){
                                if(subBinerArr[k][l] == 0 && (k!=1 || l!=1)){
                                    kondisi1 += 1;
                                }

                                if(k==0 && l!=2){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k][l+1] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                                if(l==2 && k!= 2){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k+1][l] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                                if(k == 2 && l!=0){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k][l-1] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                                if(l==0 && k!=0){
                                    if(subBinerArr[k][l] == 255 && subBinerArr[k-1][l] == 0){
                                        kondisi2 += 1;
                                    }
                                }

                            }
                        }

                        if(subBinerArr[0][1]==255 || subBinerArr[1][2]==255 || subBinerArr[1][0]==255){
                            kondisi3 = 1;
                        }

                        if(subBinerArr[0][1]==255 || subBinerArr[2][1]==255 || subBinerArr[1][0]==255){
                            kondisi4 = 1;
                        }

                        if(kondisi1>= 2 && kondisi1<=6 && kondisi2==1 && kondisi3==1 && kondisi4==1){
                            koordinat = new int[2];
                            koordinat[0] = i;
                            koordinat[1] = j;
                            koordinatMarks.add(koordinat);
                        }
                    }
                }
            }
        }

        for(i=0; i<koordinatMarks.size(); i++){
            imgArr[koordinatMarks.get(i)[0]][koordinatMarks.get(i)[1]] = 255;
        }
    }
    
    
    public boolean isTandaMasihAda(){
        boolean mark = false;

        if(!koordinatMarks.isEmpty()){
            mark = true;
        }

        return mark;
    }
    
    public void hitungthinning(KatakanaImage image){
//        thinning = konversi(image.getPixelori(), image);
//        do{
//            sign = false;
//            for(int baris=1;baris<image.getHeight() - 1 ;baris++){
//                for(int kolom=1;kolom<image.getWidth()-1;kolom++){
//                    int a = kondisiA(baris, kolom, thinning);
//                    int b = kondisiB(baris, kolom, thinning);
//                    hapusPikselstep1(a, b, baris, kolom, thinning);
//                }
//            }
//            hapuspiksel(thinning);
//            for(int baris=1;baris<image.getHeight()-1;baris++){
//                for(int kolom=1;kolom<image.getWidth()-1;kolom++){
//                    int a = kondisiA(baris, kolom, thinning);
//                    int b = kondisiB(baris, kolom, thinning);
//                    hapusPikselstep2(a, b, baris, kolom, thinning);
//                }
//            }
//            hapuspiksel(thinning);
//        }while(sign);
//        return thinning = hasilthinning(thinning, image);

        imgArr = image.getPixelori();

        do{
            HitungSkeletonizeTahap1();
            HitungSkeletonizeTahap2();
        }while (isTandaMasihAda());
        
        thinning = imgArr;
    }
    
//    private int[][] konversi(int[][] piksl, KatakanaImage image){
//        int[][] konversi = new int[image.getHeight()][image.getWidth()];
//        for(int baris=0;baris<konversi.length;baris++){
//            for(int kolom=0;kolom<konversi[0].length;kolom++){
//                if(piksl[baris][kolom]==0) {
//                    konversi[baris][kolom] = 1;
//                }
//                else {
//                    konversi[baris][kolom] = 0;
//                }
//            }
//        }
//        return konversi;
//    }
//    
//    public int[][] hasilthinning(int[][] piksel, KatakanaImage image){
//        int[][] hasil = new int[image.getHeight()][image.getWidth()];
//        for(int baris=0;baris<hasil.length;baris++){
//            for(int kolom=0;kolom<hasil[0].length;kolom++){
//                if(piksel[baris][kolom]==0) {
//                    hasil[baris][kolom] = 255;
//                }
//                else {
//                    hasil[baris][kolom] = 0;
//                }
//            }
//        }
//        return hasil;
//    }
//    
//    private int kondisiA(int baris,int kolom,int[][] s){
//        int a = 0;
//        //transisi 1 - 0
//         
//        if(s[baris-1][kolom]==0 && s[baris-1][kolom+1]==1) a++;
//        if(s[baris-1][kolom+1]==0 && s[baris][kolom+1]==1) a++;
//        if(s[baris][kolom+1]==0 && s[baris+1][kolom+1]==1) a++;
//        if(s[baris+1][kolom+1]==0 && s[baris+1][kolom]==1) a++;
//        if(s[baris+1][kolom]==0 && s[baris+1][kolom-1]==1) a++;
//        if(s[baris+1][kolom-1]==0 && s[baris][kolom-1]==1) a++;
//        if(s[baris][kolom-1]==0 && s[baris-1][kolom-1]==1) a++;
//        if(s[baris-1][kolom-1]==0 && s[baris-1][kolom]==1) a++;
//        return a;
//    }
//    
//    private int kondisiB(int baris,int kolom,int[][] s){
//        int b = s[baris-1][kolom]+s[baris-1][kolom+1]+s[baris][kolom+1]
//                    +s[baris+1][kolom+1]+s[baris+1][kolom]+
//                s[baris+1][kolom-1]+s[baris][kolom-1]+s[baris-1][kolom-1];
//        return b;
//    }
//    
//    private void hapusPikselstep1(int a,int b,int baris,int kolom,int[][] s){
//        if(s[baris][kolom]==1 &&
//            2<=b && b<=6 && a==1 )
//        {
//                if(s[baris-1][kolom] == 0 || s[baris][kolom+1] == 0 || s[baris+1][kolom] == 0 // p2, p4, p6 
//                    && s[baris][kolom+1] == 0 || s[baris+1][kolom] == 0 || s[baris][kolom-1] == 0 ){ //p4, p6, p8
//               points.add(new Point(baris, kolom));
//                sign = true;
//        }
//             
//        }
//    }
//    
//    private void hapusPikselstep2(int a,int b,int baris,int kolom, int[][] s){
//         if(s[baris][kolom]==1 &&
//            2<=b && b<=6 && a==1 )
//        {
//                if(s[baris-1][kolom] == 0 || s[baris][kolom+1] == 0 || s[baris][kolom-1] == 0 // p2, p4, p8 
//                    && s[baris-1][kolom] == 0 || s[baris+1][kolom] == 0 || s[baris][kolom-1] == 0){ // p2, p6, p8
//               points.add(new Point(baris, kolom));
//                sign = true;
//        }
//             
//        }
//    }
//    
//    private void hapuspiksel(int[][] s){
//        for(Point p : points){
//            s[p.x][p.y] = 0;
//        }
//        Point p;
//  
//        points.clear();
//    }
    
    
    public void preprocesing(KatakanaImage ki){
        thresholding(ki);
        hitungthinning(ki);
        ki.setPixelOri(thinning);
    }
}
