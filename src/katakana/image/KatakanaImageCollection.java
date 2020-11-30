/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package katakana.image;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nana
 */
public class KatakanaImageCollection {
    

    List<KatakanaImage> lsthw; //list itu vector
    List<String> listnamafiles;
  

    public KatakanaImageCollection() 
    {
        lsthw = new ArrayList<KatakanaImage>();      
        listnamafiles = new ArrayList<String>();
    }
    
    public void addHandWriting(KatakanaImage ki,String nmfile)
    {
        lsthw.add(ki); // ini untuk handwritingimage berupa gambar
        listnamafiles.add(nmfile);
    }
    
    public KatakanaImage getHandWriting(int idx)
    {
        return lsthw.get(idx);
    }
    
    public String getFileNames(int idx) {
         return listnamafiles.get(idx);
    }
    
    public int getTotalHandWriting()
    {
        return lsthw.size(); //untuk membaca panjang data
    }
    
    public void clearlist(){
        listnamafiles.clear();
        lsthw.clear();
    }
}
