/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooperativos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author vicnb
 */
public class Archive <E>{
    
    private String filename;
    
    public Archive() {
       
    }

    public Archive(String filename) {
        this.filename = filename;
    }
    
       
    public ArrayList<E> readFile(){
        ArrayList lista=new ArrayList<E>();
        File f = new File( filename );
        BufferedReader entrada = null;
        try {
            entrada = new BufferedReader( new FileReader( f ) );
            String linea;
            while(entrada.ready())
            {
                linea = entrada.readLine();
                lista.add(linea);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
        try{
            entrada.close();
        }catch(IOException e1){}
        }
        return lista;
    }
    
    public void writeFile(ArrayList<E> x){
        
        
        
    }
}
