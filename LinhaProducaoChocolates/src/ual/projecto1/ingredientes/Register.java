/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.ingredientes;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import ual.projecto1.ContentManager.*;
import ual.projecto1.Threads.LinhaProducaoTabChoc;
import ual.projecto1.funcionarios.EspecialistaTabChoc;
import ual.projecto1.produtos.*;

/**
 *
 * @author Diogo
 */
public class Register 
{
    public LoteAmendoas AmendoasEmStock;
    public LoteCacau CacauEmStock;
    public LoteCaramelo CarameloEmStock;
    public LotePassas PassasEmStock;

    public Register(LoteAmendoas AmendoasEmStock, LoteCacau CacauEmStock, LoteCaramelo CarameloEmStock, LotePassas PassasEmStock) 
    {
        this.AmendoasEmStock = AmendoasEmStock;
        this.CacauEmStock = CacauEmStock;
        this.CarameloEmStock = CarameloEmStock;
        this.PassasEmStock = PassasEmStock;
    }
    
    public String toString()
    {
        return "\n\nCapacidade total do Stock:\n\tAmendoas: "+this.AmendoasEmStock.getQuantidade()+"gr\n\tPassas: "+this.PassasEmStock.getQuantidade()
                +"gr\n\tCaramelo: "+this.CarameloEmStock.getQuantidade()+"gr\n\tCacau: "+this.CacauEmStock.getQuantidade();
    }

    
    
    public String Load()
    {
        String s="";
        String linha;
        
        try
        {
            BufferedReader fInAmendoas=new BufferedReader(new FileReader("Amendoas.txt"));
            
            while((linha=fInAmendoas.readLine())!=null)
            {
                
                String arr[] = linha.split("-");
                
                AmendoasEmStock.reporQuantidade(+Integer.parseInt(arr[1]));
                s+="\nForam adicionadas "+arr[1]+"gr de Amendoas.";
                
            }
            fInAmendoas.close();
            //apagar o ficheiro depois de o ler
            //File f = new File("Amendoas.txt");
            //f.delete();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "IOException na leitura do ficheiro das Amendoas");

        }
        try
        {
            BufferedReader fInCacau=new BufferedReader(new FileReader("Cacau.txt"));
            
            //leitura do ficheiro do cacau
            while((linha=fInCacau.readLine())!=null)
            {
                
                String arr[] = linha.split("-");
                
                CacauEmStock.reporQuantidade(+Integer.parseInt(arr[1]));
                s+="\nForam adicionadas "+arr[1]+"gr de Cacau.";
                
            }
            fInCacau.close();
            //apagar o ficheiro depois de o ler
            //File f = new File("Cacau.txt");
            //f.delete();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "IOException na leitura do ficheiro do Cacau");
        }
            
        try
        {
            BufferedReader fInCaramelo=new BufferedReader(new FileReader("Caramelo.txt"));
            
            //leitura do ficheiro do Caramelo
            while((linha=fInCaramelo.readLine())!=null)
            {
                
                String arr[] = linha.split("-");
                
                CarameloEmStock.reporQuantidade(+Integer.parseInt(arr[1]));
                s+="\nForam adicionadas "+arr[1]+"gr de Caramelo.";
                
            }
            fInCaramelo.close();
            //apagar o ficheiro depois de o ler
            //File f = new File("Caramelo.txt");
            //f.delete();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "IOException na leitura do ficheiro do Caramelo");
        }
            
        try
        {
            BufferedReader fInPassas=new BufferedReader(new FileReader("Passas.txt"));
            
            //leitura do ficheiro das passas
            while((linha=fInPassas.readLine())!=null)
            {
                
                String arr[] = linha.split("-");
                
                PassasEmStock.reporQuantidade(+Integer.parseInt(arr[1]));
                s+="\nForam adicionadas "+arr[1]+"gr de Passas.";
                
            }
            fInPassas.close();
            //apagar o ficheiro depois de o ler
            //File f = new File("Passas.txt");
            //f.delete();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "IOException na leitura do ficheiro das Passas");
        }
            
       return s;
        
    }
    


    /*--------------------------------------------------------------------------------------------*/

    
    
}
