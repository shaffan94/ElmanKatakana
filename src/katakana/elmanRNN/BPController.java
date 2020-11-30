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
public class BPController {
    

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
    
    private double xi[] = new double[10]; //input layer
    private double zj[] = new double[20]; //Hidden Layer

    private double yk[] = new double[6];  //Output Layer
    
    private double Vij[][] = new double[xi.length][zj.length];
    private double Wjk[][] = new double[zj.length][yk.length];
    private double[] t=new double[6];   
    
    double alpha ; //Kecepatan belajar
    double E ; //Batas Toleransi error yang telah ditetapkan
    double Erh; //Eror hitung yang akan dicari.
    double sum;
    
    double Zinj[]= new double[zj.length]; //Hasil dari sigma perkalian Vij dan input
    double Yink[]= new double[yk.length]; //Hasil dari sigma perkalian Wjk dan input
    int N; //Indeks iterasi
    int Nmaks = 1000; //jumlah maksimum iterasi
    double deltaK[]= new double[yk.length]; // error output - hidden
    double deltaJ[]= new double[zj.length]; // error hidden - input
    double deltaVij[][] = new double[xi.length][zj.length]; //(perbaikan bobot layer input ke layer hidden)
    double deltaWjk[][] = new double[zj.length][yk.length]; // (perbaikan bobot layer hidden ke layer output)
    private double target[]=new double[6];
    
    public BPController() {
    }
    
    public void parameter(double alpha, double error){
        this.alpha=alpha;
        this.E=error;
    }
    
    public void nilaitarget(String target){
        if("a".equals(target)){
                this.t=new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 
            } 
            else if( "i".equals(target)){
                this.t=new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0}; 
            }
            else if( "u".equals(target)){
                this.t=new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0}; 
            }
            else if( "e".equals(target)){
                this.t=new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0}; 
            }
            else if( "o".equals(target)){
                this.t=new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0}; 
            }
            else if( "ka".equals(target)){
                this.t=new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0}; 
            }
            else if( "ki".equals(target)){
                this.t=new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0}; 
            }
            else if( "ku".equals(target)){
                this.t=new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
            }
            else if( "ke".equals(target)){
                this.t=new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0};
            }
            else if( "ko".equals(target)){
                this.t=new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0};
            }
            else if( "sa".equals(target)){
                this.t=new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0};
            }
            else if( "shi".equals(target)){
                this.t=new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0};
            }
            else if( "su".equals(target)){
                this.t=new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0};
            }
            else if( "se".equals(target)){
                this.t=new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 0.0};
            }
            else if( "so".equals(target)){
                this.t=new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0};
            }
            else if( "ta".equals(target)){
                this.t=new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0};
            }
            else if( "chi".equals(target)){
                this.t=new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0};
            }
            else if( "tsu".equals(target)){
                this.t=new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0};
            }
            else if( "te".equals(target)){
                this.t=new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 0.0};
            }
            else if( "to".equals(target)){
                this.t=new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0};
            }
            else if( "na".equals(target)){
                this.t=new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0};
            }
            else if( "ni".equals(target)){
                this.t=new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
            }
            else if( "nu".equals(target)){
                this.t=new double[]{1.0, 1.0, 1.0, 1.0, 0.0, 1.0};
            }
            else if( "ne".equals(target)){
                this.t=new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0};
            }
            else if( "no".equals(target)){
                this.t=new double[]{1.0, 1.0, 0.0, 1.0, 1.0, 1.0};
            }
            else if( "ha".equals(target)){
                this.t=new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0};
            }
            else if( "hi".equals(target)){
                this.t=new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 1.0};
            }
            else if( "fu".equals(target)){
                this.t=new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 1.0};
            }
            else if( "he".equals(target)){
                this.t=new double[]{1.0, 0.0, 0.0, 1.0, 1.0, 1.0};
            }
            else if( "ho".equals(target)){
                this.t=new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 1.0};
            }
            else if( "ma".equals(target)){
                this.t=new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 1.0};
            }
            else if( "mi".equals(target)){
                this.t=new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
            }
            else if( "mu".equals(target)){
                this.t=new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0};
            }
            else if( "me".equals(target)){
                this.t=new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 1.0};
            }
            else if( "mo".equals(target)){
               this.t=new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0};
            }
            else if( "ya".equals(target)){
                this.t=new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 0.0};
            }
            else if( "yu".equals(target)){
                this.t=new double[]{1.0, 0.0, 1.0, 1.0, 0.0, 1.0};
            }
            else if( "yo".equals(target)){
               this.t=new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0};
            }
            else if( "ra".equals(target)){
               this.t=new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0};
            }
            else if( "ri".equals(target)){
               this.t=new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0};
            }
            else if( "ru".equals(target)){
               this.t=new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0};
            }
            else if( "re".equals(target)){
               this.t=new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 0.0};
            }
            else if( "ro".equals(target)){
               this.t=new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0};
            }
            else if( "wa".equals(target)){
               this.t=new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 1.0};
            }
            else if( "wo".equals(target)){
               this.t=new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0};
            }
            else if( "n".equals(target)){
                this.t=new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0};
            }
    }
    
     //-----------Fungsi - Fungsi Khusus-----------
     
     double Aktivasi(double x)
     { 
        return 1.0/(1.0+(Math.exp(-x)));
     }

     double AktivasiAksen(double x)
     {
        return Aktivasi(x)*(1.0-(Aktivasi(x)));
     }
     
     public double random()
     {
        Random rand = new Random();

        double scaled = -5 + rand.nextDouble()*(10);
        return scaled;
     }
    
    public void initBobot()
    {
        for(int i=0; i<xi.length; i++){
            for(int j=0; j<zj.length; j++)
            {
                InisialisasiBobotIH(random(), i, j);
            }
        }

        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++)
            {
                InisialisasiBobotHO(random(), j, k);
            }
        } 
    }
    
    public void InisialisasiBobotIH(double Vij,int i,int j)
    {
        this.Vij[i][j]=Vij;
    }
    
    public void InisialisasiBobotHO(double Wjk,int j,int k)
    {
        this.Wjk[j][k]=Wjk;
    }
    
    //-----FeedForward (umpan Maju)
    public void HitungBobotIH(){
        for(int j=0; j<zj.length; j++){ 
            Zinj[j] = 0;
            
            for(int i=0; i<xi.length; i++){
                Zinj[j] = Zinj[j] + (xi[i] * Vij[i][j]);
            }
            
            zj[j] = Aktivasi(Zinj[j]); 
        }
     }
    
    public void HitungBobotHO(){
        double outputLayer = 0;
        for(int k=0; k<yk.length; k++){ 
            Yink[k] = 0;
            
            for(int j=0; j<zj.length; j++){
                Yink[k] = Yink[k] + (zj[j] * Wjk[j][k]);
            }

            yk[k] = Aktivasi(Yink[k]);
        }
    }
     
    public void HitungError(){
        double temp;

        for(int k=0; k<yk.length; k++){
            sum = sum +  pow((this.t[k]-yk[k]),2);
        }
    }

    //-----BackPropagation (propagasi Balik)
    
    public void KoreksiErrorHO(){
        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++){ 
                deltaK[k] = (t[k]-yk[k])*AktivasiAksen(Yink[k]);
                deltaWjk[j][k] = alpha * deltaK[k] * zj[j];
            }
        }
     }
    
    
    public void KoreksiErrorIH(){
        for(int j=0; j<zj.length; j++)
        {
            double delta_inJ = 0; 

            for(int k=0; k<yk.length; k++)
            {
                delta_inJ = delta_inJ + (deltaK[k] * Wjk[j][k]);
            }
            deltaJ[j] = AktivasiAksen(Zinj[j]) * (delta_inJ); 
        }
        
        for(int i=0; i<xi.length; i++){
            for(int j=0; j<zj.length; j++){
                deltaVij[i][j] = alpha * deltaJ[j] * xi[i];
            }
        }       
    }
     
    public void UpdateBobotHO(){
        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++)
            {
                Wjk[j][k] = Wjk[j][k] + deltaWjk[j][k];
            }
        }
    }
      
    public  void UpdateBobotIH(){
        double[][]Vij = new double[900][900];
        for(int i=0; i<xi.length; i++){
            for(int j=0; j<zj.length; j++)
            {
                Vij[i][j] = Vij[i][j] + deltaVij[i][j];
            }
        }
    }
    

    public void training(double[][] input, KatakanaImageCollection ki_collection){
        double error;
        int n;
        
        System.out.println("masuk BP");
        initBobot();
         
        n=1;
        do{
            sum = 0;
            for (int i = 0; i < input.length; i++)
            {
                for(int x=0; x<xi.length; x++){
                    xi[x]=input[i][x];
                }

                nilaitarget(ki_collection.getHandWriting(i).getKelas());
                HitungBobotIH();
                HitungBobotHO();
                HitungError();
                
                KoreksiErrorHO();
                KoreksiErrorIH();
                UpdateBobotHO();
                UpdateBobotIH();   
            }
            
            Erh = Math.sqrt(sum)/input.length; 
            
            ++n;
        }while(Erh>=E && n<=Nmaks);
        
        System.out.println("Nilai error : "+Erh);
         
        System.out.println("Simpan bobot input hidden bp");
        for(int i=0; i<xi.length; i++){
           for(int j=0; j<zj.length; j++)
           {
                saveWeight(i,j,"'input_hidden'", "-", Vij[i][j]);
           }
        }
        
        System.out.println("Simpan bobot hidden output bp");
        for(int j=0; j<zj.length; j++){
            for(int k=0; k<yk.length; k++)
            {
                saveWeight(j,k,"'hidden_output'", "-", Wjk[j][k]);
            }
        }
     }
     
    public void saveWeight(int indexI, int indexJ, String layer, String target, double bobot) 
    {
       String sql;
       try {
           conn = koneksi.getConnection();
           sql = "SELECT id_bobot FROM bobotbp WHERE indexI=" + indexI + " AND indexJ=" + indexJ + " AND layer=" + layer + " AND target='"+ target +"'";
           st = conn.createStatement();
           rs = st.executeQuery(sql);
           if (rs.first())
           {
               sql = "UPDATE bobotbp SET bobot=" + bobot + " WHERE id_bobot=" + rs.getInt("id_bobot");
               st = conn.createStatement();
               st.executeUpdate(sql);
           }
           else
           {
               sql = "INSERT INTO bobotbp(bobot, layer, target, indexI, indexJ) VALUES(" + bobot + ", " + layer + ",'" + target + "', " + indexI + ", " + indexJ + ")";
               st = conn.createStatement();
               st.executeUpdate(sql);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
     
     
    public void testing(double[] input) throws SQLException{
         String huruf;
         //46
         double[] output=new double[5];
         System.out.println("halo bp");
         
         xi=input;
         setWeights("-");
         
         for(int i=0; i<output.length;i++){
            System.out.println("target bp: "+getTarget(i));

            HitungBobotIH();
            HitungBobotHO();
            nilaitarget(getTarget(i));
            output[i]=calculateDistance();  

            System.out.println("output bp: "+output[i]);
            System.out.println();
        }
         
        double min;
        int index=0;
        
        min=output[0];
        for(int y=0;y<output.length;y++){
            if(min>output[y]){
                min=output[y];
                index=y;
            }
        }
         
        setLabelOutput(index);
    }

 
    private boolean setWeights(String target) throws SQLException
    {
        ArrayList<String[]> weights = koneksi.getWeightsBP(target);
        int indexI, indexJ;
        double w;
        boolean ada;
        
        ada = false;
        for (String[] weight: weights)
        {
            indexI = Integer.parseInt(weight[2]);
            indexJ = Integer.parseInt(weight[3]);
            
            w = Double.valueOf(weight[1]);
            
            
            if (weight[0].equals("input_hidden"))
            {   
                Vij[indexI][indexJ] = w;
            }
            else if (weight[0].equals("hidden_output"))
            {   
                Wjk[indexI][indexJ] = w;
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
    
    public double calculateDistance()
    {
        double sum = 0.0, d;
        double[] output;
        
        output = new double[yk.length];
        
        for(int i=0;i<yk.length;i++) {
            sum = sum + Math.pow((t[i]-yk[i]),2.0);
        }
        
        d = Math.sqrt(sum);
        
        return d;
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

        ft.outputfinalbp.add(outputs);
    }
}


