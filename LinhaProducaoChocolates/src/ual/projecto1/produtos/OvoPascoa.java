/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.produtos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ual.projecto1.ingredientes.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ual.projecto1.funcionarios.EspecialistaOvosEamendoas;

/**
 *
 * @author Diogo
 */
public class OvoPascoa
{
    private int id;
    private LoteCacau chocolate;
    private static final int quantidadeChoc = 15;
    
    private static int count=0;
    
    private EspecialistaOvosEamendoas especialistaQueProduziu;
    
    private static ArrayList<OvoPascoa> tabsAfazer = new ArrayList<OvoPascoa>();


    public OvoPascoa(LoteCacau chocolate) 
    {
        this.chocolate = chocolate;
        this.chocolate.removerQuantidade(-quantidadeChoc);
        count++;
        this.id=count;
        setEspecialistaQueProduziu(null);
        
    }

    public void escreveNoFicheiro(int count)
    {
        //codigo para escrever no ficheiro ao ser produzida uma tablete
        try
        {
            BufferedWriter fOut = new BufferedWriter(new FileWriter("./AmendEovos/Ovo-Pascoa-numero-"+count));
            fOut.write("Chocolate-"+OvoPascoa.quantidadeChoc+"\n");
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
            System.out.println("Comecou a producao de um chocolate. ovopascoa");
            //tempo de produçao de uma tablete sleep
            Thread.sleep(4500);
            escreveNoFicheiro(this.id);
            this.getEspecialistaQueProduziu().setOvoAProduzir(null);
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
     * @return the quantidadeChoc
     */
    public static int getQuantidadeChoc() {
        return quantidadeChoc;
    }

    /**
     * @return the count
     */
    public static int getCount() {
        return count;
    }

    /**
     * @param aCount the count to set
     */
    public static void setCount(int aCount) {
        count = aCount;
    }

    /**
     * @return the especialistaQueProduziu
     */
    public EspecialistaOvosEamendoas getEspecialistaQueProduziu() {
        return especialistaQueProduziu;
    }

    /**
     * @param especialistaQueProduziu the especialistaQueProduziu to set
     */
    public void setEspecialistaQueProduziu(EspecialistaOvosEamendoas especialistaQueProduziu) {
        this.especialistaQueProduziu = especialistaQueProduziu;
    }

    /**
     * @return the tabsAfazer
     */
    public static ArrayList<OvoPascoa> getTabsAfazer() {
        return tabsAfazer;
    }

    /**
     * @param aTabsAfazer the tabsAfazer to set
     */
    public static void setTabsAfazer(ArrayList<OvoPascoa> aTabsAfazer) {
        tabsAfazer = aTabsAfazer;
    }

    
    
    
    
}
