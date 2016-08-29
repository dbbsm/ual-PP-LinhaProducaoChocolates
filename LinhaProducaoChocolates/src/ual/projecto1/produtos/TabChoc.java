/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.produtos;

import ual.projecto1.ingredientes.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ual.projecto1.Threads.LinhaProducaoTabChoc;
import ual.projecto1.funcionarios.EspecialistaTabChoc;

/**
 *
 * @author Diogo
 */
public class TabChoc
{
    
    private int id;
    private LoteCacau chocolate;
    private static final int quantidadeChoc = 100;
    private EspecialistaTabChoc EspecialistaQueProduziu;
    
    private static int count_tabchoc=0;
    
    private static ArrayList<TabChoc> tabChocsParaFazer = new ArrayList<TabChoc>();
    
    public TabChoc(LoteCacau chocolate) 
    {
        this.chocolate = chocolate;
        count_tabchoc++;
        this.id=count_tabchoc;
        this.chocolate.removerQuantidade(-quantidadeChoc);
        setEspecialistaQueProduziu(null);
        
    }
    
    public void escreveNoFicheiro(int count)
    {
        //codigo para escrever no ficheiro ao ser produzida uma tablete
        try
        {
            BufferedWriter fOut = new BufferedWriter(new FileWriter("./TabChoc/Tablet-Chocolate-Simples-numero-"+count));
            fOut.write("Chocolate-"+TabChoc.quantidadeChoc+"\n");
            fOut.write("Produzida pelo especialista - nº: "+getEspecialistaQueProduziu().getId()+", "+getEspecialistaQueProduziu().getNome());
            fOut.flush();
            fOut.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Erro na escrita do ficheiro TabChoc numero: "+count);
        }
    }
   

    
    public synchronized void produzir() 
    {
        
        try 
        {
            System.out.println("Comecou a producao de um chocolate. produzir");
            //tempo de produçao de uma tablete sleep
            Thread.sleep(30000);
            escreveNoFicheiro(this.getId());
            this.EspecialistaQueProduziu.setTableteAproduzir(null);
            System.out.println("Acabou a producao de um chocolate. produzir");
            notifyAll();
            
            
        } 
        catch (InterruptedException ex) 
        {
        }
        
        
    }


    /**
     * @return the count_tabchoc
     */
    public static int getCount_tabchoc() {
        return count_tabchoc;
    }

    /**
     * @param aCount_tabchoc the count_tabchoc to set
     */
    public static void setCount_tabchoc(int aCount_tabchoc) {
        count_tabchoc = aCount_tabchoc;
    }

    /**
     * @return the EspecialistaQueProduziu
     */
    public synchronized EspecialistaTabChoc getEspecialistaQueProduziu() {
        notifyAll();
        return EspecialistaQueProduziu;
    }

    /**
     * @param EspecialistaQueProduziu the EspecialistaQueProduziu to set
     */
    public synchronized void setEspecialistaQueProduziu(EspecialistaTabChoc EspecialistaQueProduziu) {
        this.EspecialistaQueProduziu = EspecialistaQueProduziu;
        notifyAll();
    }

    /**
     * @return the tabChocsParaFazer
     */
    public synchronized static ArrayList<TabChoc> getTabChocsParaFazer() {
        return tabChocsParaFazer;
    }

    /**
     * @param aTabChocsParaFazer the tabChocsParaFazer to set
     */
    public static void setTabChocsParaFazer(ArrayList<TabChoc> aTabChocsParaFazer) {
        tabChocsParaFazer = aTabChocsParaFazer;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

   

    
    
    
    
    
    
}
