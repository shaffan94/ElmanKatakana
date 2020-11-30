/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package katakana.elmanRNN;

import static java.lang.Math.exp;
import static java.lang.Math.pow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import katakana.GUI.FormTesting;
import katakana.image.KatakanaImage;
import katakana.image.KatakanaImageCollection;
import katakana.koneksi.KoneksiDatabase;

/**
 *
 * @author nana
 */
public class ERNNController {
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    KoneksiDatabase koneksi = new KoneksiDatabase();
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    FormTesting ft = new FormTesting();
    public String outputs = "";
    
    double xi[] = new double[10]; //input layer
    double ci[] = new double[20]; //Context Layer
    double zj[] = new double[20]; //Hidden Layer
    double yk[] = new double[6];  //Output Layer
    double[] t=new double[6];   
    
    double alpha; //Kecepatan belajar
    double E ; //Batas Toleransi error yang telah ditetapkan
    double Erh; //Eror hitung yang akan dicari.
    
    double Zinj[]= new double[zj.length]; //Hasil dari sigma perkalian input dan bobot
    double Cinl[]= new double[ci.length];
    double Yink[]= new double[yk.length]; //Hasil dari sigma perkalian hidden dan bobot
    
    int N; //Indeks iterasi
    int Nmaks = 1000; //jumlah maksimum iterasi
    double sum;
    
    double deltaK[]= new double[yk.length]; // error output - hidden
    double deltaJ[]= new double[zj.length]; // error hidden - input
    
    double deltaVij[][] = new double[xi.length][zj.length]; //(perbaikan bobot layer input ke layer hidden)
    double deltaWjk[][] = new double[zj.length][yk.length]; // (perbaikan bobot layer hidden ke layer output)
    double deltaCji[][] = new double[zj.length][ci.length]; // (perbaikan bobot layer hidden ke layer output)
    
    double Vij[][] = new double[xi.length][zj.length];
    double Clj[][] = new double[zj.length][ci.length];
    double Wjk[][] = new double[zj.length][yk.length];
    double targett[]= new double[6];
    
    public ERNNController() {
       
    }
    
    public void parameter(double alpha, double error){
        this.alpha=alpha;
        this.E=error;
        
    }
    
    public void initTarget(String target){
        if("a".equals(target)){
            t=new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 
        } 
        else if( "i".equals(target)){
            t=new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0}; 
        }
        else if( "u".equals(target)){
            t=new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0}; 
        }
        else if( "e".equals(target)){
            t=new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0}; 
        }
        else if( "o".equals(target)){
            t=new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0}; 
        }
        else if( "ka".equals(target)){
            t=new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0}; 
        }
        else if( "ki".equals(target)){
            t=new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 
        }
        else if( "ku".equals(target)){
            t=new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
        }
        else if( "ke".equals(target)){
            t=new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0};
        }
        else if( "ko".equals(target)){
            t=new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0};
        }
        else if( "sa".equals(target)){
            t=new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
        }
        else if( "shi".equals(target)){
            t=new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0};
        }
        else if( "su".equals(target)){
            t=new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0};
        }
        else if( "se".equals(target)){
            t=new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0};
        }
        else if( "so".equals(target)){
            t=new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0};
        }
        else if( "ta".equals(target)){
            t=new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0};
        }
        else if( "chi".equals(target)){
            t=new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0};
        }
        else if( "tsu".equals(target)){
            t=new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0};
        }
        else if( "te".equals(target)){
            t=new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 0.0};
        }
        else if( "to".equals(target)){
            t=new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        }
        else if( "na".equals(target)){
            t=new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0};
        }
        else if( "ni".equals(target)){
            t=new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
        }
        else if( "nu".equals(target)){
            t=new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0};
        }
        else if( "ne".equals(target)){
            t=new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0};
        }
        else if( "no".equals(target)){
            t=new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0};
        }
        else if( "ha".equals(target)){
            t=new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0};
        }
        else if( "hi".equals(target)){
            t=new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 1.0};
        }
        else if( "fu".equals(target)){
            t=new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 1.0};
        }
        else if( "he".equals(target)){
            t=new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0};
        }
        else if( "ho".equals(target)){
            t=new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0};
        }
        else if( "ma".equals(target)){
            t=new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0};
        }
        else if( "mi".equals(target)){
            t=new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        }
        else if( "mu".equals(target)){
            t=new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0};
        }
        else if( "me".equals(target)){
            t=new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 1.0};
        }
        else if( "mo".equals(target)){
            t=new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0};
        }
        else if( "ya".equals(target)){
            t=new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 0.0};
        }
        else if( "yu".equals(target)){
            t=new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 1.0};
        }
        else if( "yo".equals(target)){
           t=new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0};
        }
        else if( "ra".equals(target)){
           t=new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0};
        }
        else if( "ri".equals(target)){
           t=new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0};
        }
        else if( "ru".equals(target)){
           t=new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0};
        }
        else if( "re".equals(target)){
           t=new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0};
        }
        else if( "ro".equals(target)){
           t=new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0};
        }
        else if( "wa".equals(target)){
           t=new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 1.0};
        }
        else if( "wo".equals(target)){
           t=new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0};
        }
        else if( "n".equals(target)){
           t=new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0};
        }
    }
    
     //-----------Fungsi - Fungsi Khusus-----------
     
     double Aktivasi(double x)
     { //sigmoid biner
       return 1.0/(1.0+(Math.exp(-x)));
      }

     double AktivasiAksen(double x)
     {
       return Aktivasi(x)*(1.0-(Aktivasi(x)));
     }
     
     public double random()
     {
        Random rand = new Random();
        double scaled = -5+rand.nextDouble()*10;
        return scaled;
            
     }
    
    public void initBobot(){
        int i, j, k, l;
       
        for(i=0; i<xi.length; i++){
            for(j=0; j<zj.length; j++){
                InisialisasiBobotIH(random(), i, j);
            }
        }
        for(l=0; l<zj.length; l++){
            for(j=0; j<ci.length; j++){
                InisialisasiBobotCH(random(), l, j);
            }
        }

        for(j=0; j<zj.length; j++){
            for(k=0; k<yk.length; k++){
                InisialisasiBobotHO(random(), j, k);
            }
        } 
    }
    
    public void InisialisasiBobotIH(double Vij,int i,int j)
    {
        this.Vij[i][j]=Vij;
    }
    
    public void InisialisasiBobotCH(double Clj,int l,int j)
    {
        this.Clj[l][j]=Clj;
    }
    
    public void InisialisasiBobotHO(double Wjk,int j,int k)
    {
        this.Wjk[j][k]=Wjk;
    }
    
    public void InitContext(){
        int i;
        
        for(i=0; i<ci.length; i++){
            ci[i] = 0.0;
        }
    }
    
    public void HitungHidden(){ 
        int i, j;
        
        for(i=0; i<zj.length; i++){
            Zinj[i] = 0;
            Cinl[i] = 0;
        }
        
        for(j=0; j<zj.length; j++){
            for(i=0; i<xi.length; i++){
                Zinj[j] = Zinj[j] + (xi[i] * Vij[i][j]); 
            }
            
            for(i=0; i<this.ci.length; i++){
                Cinl[j] = Cinl[j] + (ci[i] * Clj[i][j]); 
            }

            zj[j] = Aktivasi(Zinj[j]+Cinl[j]);
        }
     }
    
    public void HitungContext(){
        for(int j=0; j<this.ci.length; j++){
            this.ci[j]=this.zj[j];
        }
    }
    
    public void HitungOutput(){
        int j, k;
        
        for(k=0; k<yk.length; k++){ 
            Yink[k] = 0;
            for(j=0; j<zj.length; j++){
                Yink[k] = Yink[k] + (zj[j] * this.Wjk[j][k]);
            }
           yk[k] = Aktivasi(Yink[k]);
        }
    }
    
    public void feedforward(){
        HitungHidden();
        HitungContext();
        HitungOutput();
    }
     
    public void HitungError(){
        double temp;
        int i, j;
        
        for(int k=0; k<yk.length; k++){
            sum = sum +  pow((this.t[k]-yk[k]),2);
        }
    }
    
    public void KoreksiErrorOutput(){  
        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++){ 
                deltaK[k] = (this.t[k]-yk[k])*AktivasiAksen(Yink[k]);
            }
        }
     }
    
    
    public void KoreksiErrorHidden(){
        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++){
                deltaJ[j] = deltaJ[j] + (deltaK[k] * this.Wjk[j][k]) * AktivasiAksen(Zinj[j]);
            }
        }     
    }
    
    public void DeltaBobotOuput(){
        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++){
                deltaWjk[j][k] = alpha * deltaK[k] * zj[j];
            }
        }
    }
    
    public void DeltaBobotHidden(){
        for(int i=0; i<xi.length; i++){
            for(int j=0; j<zj.length; j++){
                deltaVij[i][j] = alpha * deltaJ[j] * xi[i];
            }
        }  
    }
    
    public void DeltaBobotContext(){
        for(int i=0; i<zj.length; i++){
            for(int j=0; j<ci.length; j++){
                deltaCji[i][j] = alpha * deltaJ[j] * ci[j];
            }
        }  
    }
     
    public void UpdateBobotOutput(){
        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++){
                Wjk[j][k] = Wjk[j][k] + deltaWjk[j][k];
            }
        }
    }
      
    public void UpdateBobotHidden(){
        for(int i=0; i<xi.length; i++){
            for(int j=0; j<zj.length; j++){
                Vij[i][j] = Vij[i][j] + deltaVij[i][j];
            }
        }
    }
    
    public void UpdateBobotContext(){
        for(int i=0; i<zj.length; i++){
            for(int j=0; j<ci.length; j++){
                Clj[i][j] = Clj[i][j] + deltaCji[i][j];
            }
        }  
    }

     public void training(double[][] input, KatakanaImageCollection ki_collection){
        double error;
        int n, s, i, j, k, l, x;
        System.out.println("masuk ERNN");
        
        initBobot();
        InitContext();
         
        n=1;
        do{
            sum = 0;
            for (i = 0; i < input.length; i++){
                for(x=0; x<this.xi.length; x++){
                    xi[x]=input[i][x];
                }

                initTarget(ki_collection.getHandWriting(i).getKelas());

                feedforward();
                HitungError();
                
                KoreksiErrorOutput();
                KoreksiErrorHidden();
                DeltaBobotOuput();
                DeltaBobotHidden();
                DeltaBobotContext();
                UpdateBobotOutput();
                UpdateBobotHidden();
                UpdateBobotContext();
            }
            
            Erh = Math.sqrt(sum)/input.length;
            
            ++n;
        }while(Erh >= E && n <= Nmaks );
        
        System.out.println("Nilai error : "+Erh);
         
        System.out.println("Simpan bobot input hidden");
        for(i=0; i<xi.length; i++){
            for(j=0; j<zj.length; j++)
            {
                saveWeight(i,j,"'input_hidden'", "-", Vij[i][j]);
            }
        }
        
         System.out.println("Simpan bobot context hidden");
         for(l=0; l<ci.length; l++){
           for(j=0; j<zj.length; j++)
           {
                saveWeight(l,j,"'context_hidden'", "-", Clj[l][j]);
           }
         } 
        
        System.out.println("Simpan bobot hidden output");
        for(j=0; j<zj.length; j++){
            for( k=0; k<yk.length; k++)
           {
                saveWeight(j,k,"'hiden_output'", "-", Wjk[j][k]);
           }
        }
     }
     
    public void testing(double[] input) throws SQLException{
        int i, y, index;
        String huruf;
        double min;
        double[] output;
        
        index=0;
        output=new double[46];
        
        xi=input;
        setWeights("-");
     
        for(i=0; i<output.length;i++){
            feedforward();
            initTarget(getTarget(i));
            output[i]=calculateDistance();
        }
        
        min=output[0];
        for(y=0;y<output.length;y++){
            if(min>output[y]){
                min=output[y];
                index=y;
            }
        }

        setLabelOutput(index);
    }

    public void saveWeight(int indexI, int indexJ, String layer, String target, double bobot){
       String sql;
       try {
           conn = koneksi.getConnection();
           sql = "SELECT id_bobot FROM bobot WHERE indexI=" + indexI + " AND indexJ=" + indexJ + " AND layer=" + layer + " AND target='"+ target +"'";
           st = conn.createStatement();
           rs = st.executeQuery(sql);
           if (rs.first())
           {
               sql = "UPDATE bobot SET bobot=" + bobot + " WHERE id_bobot=" + rs.getInt("id_bobot");
               st = conn.createStatement();
               st.executeUpdate(sql);
           }
           else
           {
               sql = "INSERT INTO bobot(bobot, layer, target, indexI, indexJ) VALUES(" + bobot + ", " + layer + ",'" + target + "', " + indexI + ", " + indexJ + ")";
               st = conn.createStatement();
               st.executeUpdate(sql);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
 
    private boolean setWeights(String target) throws SQLException
    {
        ArrayList<String[]> weights = koneksi.getWeights(target);
        int indexI, indexJ;
        boolean ada;
        double w;
        
        ada = false;
        for (String[] weight: weights)
        {
            indexI = Integer.parseInt(weight[2]);
            indexJ = Integer.parseInt(weight[3]);
            
            w = Double.valueOf(weight[1]);
            
            
            if (weight[0].equals("input_hidden"))
            {   
                this.Vij[indexI][indexJ] = w;
            }
            else if (weight[0].equals("context_hidden"))
            {   
                this.Clj[indexI][indexJ] = w;
            }
            else if (weight[0].equals("hiden_output"))
            {   
                this.Wjk[indexI][indexJ] = w;
            }
        }
        
        if(!weights.isEmpty()){
            ada = true;
        }
        
        return ada;
    }
    public String getTarget(int i){
        String target = null;
        if(i==0){
            target= "a";
        }else if(i==1){
            target="i";
        }else if(i==2){
            target="u";
        }else if(i==3){
            target="e";
        }else if(i==4){
            target="o";
        }else if(i==5){
            target="ka";
        }else if(i==6){
            target="ki";
        }else if(i==7){
            target="ku";
        }else if(i==8){
            target="ke";
        }else if(i==9){
            target="ko";
        }else if(i==10){
            target= "sa";
        }else if(i==11){
            target="shi";
        }else if(i==12){
            target="su";
        }else if(i==13){
            target="se";
        }else if(i==14){
            target="so";
        }else if(i==15){
            target="ta";
        }else if(i==16){
            target="chi";
        }else if(i==17){
            target="tsu";
        }else if(i==18){
            target="te";
        }else if(i==19){
            target="to";
        }else if(i==20){
            target="na";
        }else if(i==21){
            target="ni";
        }else if(i==22){
            target="nu";
        }else if(i==23){
            target="ne";
        }else if(i==24){
            target="no";
        }else if(i==25){
            target="ha";
        }else if(i==26){
            target="hi";
        }else if(i==27){
            target="fu";
        }else if(i==28){
            target="he";
        }else if(i==29){
            target="ho";
        }else if(i==30){
            target="ma";
        }else if(i==31){
            target="mi";
        }else if(i==32){
            target="mu";
        }else if(i==33){
            target="me";
        }else if(i==34){
            target="mo";
        }else if(i==35){
            target="ya";
        }else if(i==36){
            target="yu";
        }else if(i==37){
            target="yo";
        }else if(i==38){
            target="ra";
        }else if(i==39){
            target="ri";
        }else if(i==40){
            target="ru";
        }else if(i==41){
            target="re";
        }else if(i==42){
            target="ro";
        }else if(i==43){
            target="wa";
        }else if(i==44){
            target="wo";
        }else if(i==45){
            target="n";
        }
        
        return target;
    }
    
    public double calculateDistance(){
        int i;
        double sum, d;
        double[] output;

        sum = 0.0;
        output = new double[yk.length];
        
        for(i=0; i<yk.length ;i++) {    
            sum += Math.pow((t[i]-yk[i]),2.0);
        }
        
        d = Math.sqrt(sum);
                
        return d;
    }
     
     public void saveoutput(int indexI, String namatarget, double output) 
    {
       String sql;
       try {
           conn = koneksi.getConnection();
           sql = "SELECT id_output FROM output_target WHERE indexI=" + indexI + "  AND target='"+ namatarget +"'";
           st = conn.createStatement();
           rs = st.executeQuery(sql);
           if (rs.first())
           {
               sql = "UPDATE output_target SET output_ernn=" + output + " WHERE id_output=" + rs.getInt("id_output");
               st = conn.createStatement();
               st.executeUpdate(sql);
           }
           else
           {
               sql = "INSERT INTO output_target(target, indexI, output_ernn) VALUES('" + namatarget + "', " + indexI + ", " + output + ")";
               st = conn.createStatement();
               st.executeUpdate(sql);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
     
    private void settarget(String target) throws SQLException
    {
        ArrayList<String[]> outputs = koneksi.getoutputtarget(target);
        int indexI;
        double o;
        
        for (String[] output: outputs)
        {
            indexI = Integer.parseInt(output[1]);
            
            o = Double.valueOf(output[0]);
            
            this.targett[indexI] = o;
        }
    }
    
    public void setLabelOutput(int y){
        if(y==0){
            outputs="a";
        }else if(y==1){
            outputs="i";
        }else if(y==2){
            outputs="u";
        }else if(y==3){
            outputs="e";
        }else if(y==4){
            outputs="o";
        }else if(y==5){
            outputs="ka";
        }else if(y==6){
            outputs="ki";
        }else if(y==7){
            outputs="ku";
        }else if(y==8){
            outputs="ke";
        }else if(y==9){
            outputs="ko";
        }else if(y==10){
            outputs= "sa";
        }else if(y==11){
            outputs="shi";
        }else if(y==12){
            outputs="su";
        }else if(y==13){
            outputs="se";
        }else if(y==14){
            outputs="so";
        }else if(y==15){
            outputs="ta";
        }else if(y==16){
            outputs="chi";
        }else if(y==17){
            outputs="tsu";
        }else if(y==18){
            outputs="te";
        }else if(y==19){
            outputs="to";
        }else if(y==20){
            outputs="na";
        }else if(y==21){
            outputs="ni";
        }else if(y==22){
            outputs="nu";
        }else if(y==23){
            outputs="ne";
        }else if(y==24){
            outputs="no";
        }else if(y==25){
            outputs="ha";
        }else if(y==26){
            outputs="hi";
        }else if(y==27){
            outputs="fu";
        }else if(y==28){
            outputs="he";
        }else if(y==29){
            outputs="ho";
        }else if(y==30){
            outputs="ma";
        }else if(y==31){
            outputs="mi";
        }else if(y==32){
            outputs="mu";
        }else if(y==33){
            outputs="me";
        }else if(y==34){
            outputs="mo";
        }else if(y==35){
            outputs="ya";
        }else if(y==36){
            outputs="yu";
        }else if(y==37){
            outputs="yo";
        }else if(y==38){
            outputs="ra";
        }else if(y==39){
            outputs="ri";
        }else if(y==40){
            outputs="ru";
        }else if(y==41){
            outputs="re";
        }else if(y==42){
            outputs="ro";
        }else if(y==43){
            outputs="wa";
        }else if(y==44){
            outputs="wo";
        }else if(y==45){
            outputs="n";
        }

        ft.outputfinal.add(outputs);
    }
}


