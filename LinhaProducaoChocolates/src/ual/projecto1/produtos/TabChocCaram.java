/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.produtos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import ual.projecto1.ingredientes.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ual.projecto1.funcionarios.EspecialistaTabChocCaram;
/**
 *
 * @author Diogo
 */
public class TabChocCaram
{
    private int id;
    private LoteCacau chocolate;
    private LoteCaramelo caramelo;
    private static int quantidadeChoc = 100;
    private static int quantidadeCaram = 25;
    
    private EspecialistaTabChocCaram especialistaQueProduziu;
    
    private static int count_tabs=0;
    
    private static ArrayList<TabChocCaram> tabsAfazer = new ArrayList<TabChocCaram>();


    public TabChocCaram(LoteCacau chocolate, LoteCaramelo caramelo) 
    {
        this.chocolate = chocolate;
        this.caramelo = caramelo;
        this.caramelo.removerQuantidade(-quantidadeCaram);
        this.chocolate.removerQuantidade(-quantidadeCaram);
        count_tabs++;
        this.id=count_tabs;
        setEspecialistaQueProduziu(null);
        
    }
    
    public void escreveNoFicheiro(int count)
    {
        //codigo para escrever no ficheiro ao ser produzida uma tablete
        try
        {
            BufferedWriter fOut = new BufferedWriter(new FileWriter("./TabChocCaram/TabChocCaram-numero-"+count));
            fOut.write("Chocolate-"+TabChocCaram.quantidadeChoc+"\n");
            fOut.write("Caramelo-"+TabChocCaram.quantidadeCaram+"\n");
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
            System.out.println("Comecou a producao de um chocolate.");
            //tempo de produçao de uma tablete sleep
            Thread.sleep(37500);
            escreveNoFicheiro(this.id);
            this.getEspecialistaQueProduziu().setTabAfazer(null);
            System.out.println("Acabou a producao de um chocolate.");
            notifyAll();
            
            
        } 
        catch (InterruptedException ex) 
        {
        }
        
        
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

    /**
     * @return the chocolate
     */
    public LoteCacau getChocolate() {
        return chocolate;
    }

    /**
     * @param chocolate the chocolate to set
     */
    public void setChocolate(LoteCacau chocolate) {
        this.chocolate = chocolate;
    }

    /**
     * @return the caramelo
     */
    public LoteCaramelo getCaramelo() {
        return caramelo;
    }

    /**
     * @param caramelo the caramelo to set
     */
    public void setCaramelo(LoteCaramelo caramelo) {
        this.caramelo = caramelo;
    }

    /**
     * @return the quantidadeChoc
     */
    public static int getQuantidadeChoc() {
        return quantidadeChoc;
    }

    /**
     * @param aQuantidadeChoc the quantidadeChoc to set
     */
    public static void setQuantidadeChoc(int aQuantidadeChoc) {
        quantidadeChoc = aQuantidadeChoc;
    }

    /**
     * @return the quantidadeCaram
     */
    public static int getQuantidadeCaram() {
        return quantidadeCaram;
    }

    /**
     * @param aQuantidadeCaram the quantidadeCaram to set
     */
    public static void setQuantidadeCaram(int aQuantidadeCaram) {
        quantidadeCaram = aQuantidadeCaram;
    }

    /**
     * @return the especialistaQueProduziu
     */
    public EspecialistaTabChocCaram getEspecialistaQueProduziu() {
        return especialistaQueProduziu;
    }

    /**
     * @param especialistaQueProduziu the especialistaQueProduziu to set
     */
    public void setEspecialistaQueProduziu(EspecialistaTabChocCaram especialistaQueProduziu) {
        this.especialistaQueProduziu = especialistaQueProduziu;
    }

    /**
     * @return the count_tabs
     */
    public static int getCount_tabs() {
        return count_tabs;
    }

    /**
     * @param aCount_tabs the count_tabs to set
     */
    public static void setCount_tabs(int aCount_tabs) {
        count_tabs = aCount_tabs;
    }

    /**
     * @return the tabsAfazer
     */
    public static ArrayList<TabChocCaram> getTabsAfazer() {
        return tabsAfazer;
    }

    /**
     * @param aTabsAfazer the tabsAfazer to set
     */
    public static void setTabsAfazer(ArrayList<TabChocCaram> aTabsAfazer) {
        tabsAfazer = aTabsAfazer;
    }
    
    

    
    
    
    
}
