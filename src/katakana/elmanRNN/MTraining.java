/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katakana.elmanRNN;

import katakana.image.KatakanaImage;

/**
 *
 * @author SAMSUNG
 */
public class MTraining {
    private double xi[] = new double[900]; //nilai awal input utk tiap karakter
    private int cluster; // target = 46
    private double[] target=new double[46];
    
    private double Vij[][] = new double[1000][1000];
    private double Wjk[][] = new double[1000][1000];
    private double Clj[][] = new double[1000][1000];
    
    private KatakanaImage ki;

//    public MTraining(int input, int cluster, int target) {
//        this.input = input;
//        this.cluster = cluster;
//        this.target = target;
//    }

    public MTraining() {
        
    }

    public double getInput(int i) {
        return xi[i];
    }

    public void SetInput(double[] xi)
    {
        this.xi=xi;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public double getTarget() {
        return target[0];
    }

    public void setTarget(double target) {
        this.target[0] = target;
    }
    
    public void setBobotIH(double Vij,int i,int j)
    {
        this.Vij[i][j]=Vij;
    }
    
    public double getbobotIH(int i, int j){
        return Vij[i][j];
    }
    
    public void setBobotHO(double Wjk,int j,int k)
    {
        this.Wjk[j][k]=Wjk;
        
    }
    
    public double getbobotHO(int j, int k){
        return Wjk[j][k];
    }
    
    public void setBobotCH(double Clj, int l, int j) //contextbobot
    {
        this.Clj[l][j]=Clj;
    }
     
    public double getbobotCH(int i, int j){
        return Clj[i][j];
    }
    
    public void updatebobotIH(double[][] vij, int i, int j){
        this.Vij[i][j]=vij[i][j];
    }
    
    public void updatebobotCH(double[][] clj, int l, int j){
        this.Clj[l][j]=clj[l][j];
    }
    
    public void updatebobotHO(double[][] wjk, int j, int k){
        this.Wjk[j][k]=wjk[j][k];
    }
}
