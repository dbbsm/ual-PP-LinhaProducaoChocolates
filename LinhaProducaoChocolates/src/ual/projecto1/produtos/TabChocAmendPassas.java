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
import javax.swing.JOptionPane;
import ual.projecto1.funcionarios.EspecialistaTabChocAmendPassas;
import ual.projecto1.ingredientes.*;
/**
 *
 * @author Diogo
 */
public class TabChocAmendPassas
{
    private int id;
    private LoteCacau chocolate;
    private LoteAmendoas amendoas;
    private LotePassas passas;
    private static final int quantidadeChoc = 100;
    private static final int quantidadeAmendoas = 25;
    private static final int quantidadePassas = 25;
    
    private EspecialistaTabChocAmendPassas especialistaQueProduziu;
    
    private static int count_tabs=0;
    
    private static ArrayList<TabChocAmendPassas> tabsAfazer = new ArrayList<TabChocAmendPassas>();

    public TabChocAmendPassas(LoteCacau chocolate, LoteAmendoas amendoas, LotePassas passas) 
    {
        this.chocolate = chocolate;
        this.amendoas = amendoas;
        this.passas = passas;
        this.amendoas.removerQuantidade(-quantidadeAmendoas);
        this.passas.removerQuantidade(-quantidadePassas);
        this.chocolate.removerQuantidade(-quantidadeChoc);
        count_tabs++;
        this.id=count_tabs;
        setEspecialistaQueProduziu(null);
        
    }
    
    public void escreveNoFicheiro(int count)
    {
        //codigo para escrever no ficheiro ao ser produzida uma tablete
        try
        {
            BufferedWriter fOut = new BufferedWriter(new FileWriter("./TabChocAmendPassas/TabChocAmendPassas-numero-"+count));
            fOut.write("Chocolate-"+TabChocAmendPassas.quantidadeChoc+"\n");
            fOut.write("Passas-"+TabChocAmendPassas.quantidadePassas+"\n");
            fOut.write("Amendoas-"+TabChocAmendPassas.quantidadeAmendoas+"\n");
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
            System.out.println("Comecou a producao de um chocolate. amend passas");
            //tempo de produçao de uma tablete sleep
            Thread.sleep(45000);
            escreveNoFicheiro(this.id);
            this.getEspecialistaQueProduziu().setTableteAproduzir(null);
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
     * @return the amendoas
     */
    public LoteAmendoas getAmendoas() {
        return amendoas;
    }

    /**
     * @param amendoas the amendoas to set
     */
    public void setAmendoas(LoteAmendoas amendoas) {
        this.amendoas = amendoas;
    }

    /**
     * @return the passas
     */
    public LotePassas getPassas() {
        return passas;
    }

    /**
     * @param passas the passas to set
     */
    public void setPassas(LotePassas passas) {
        this.passas = passas;
    }

    /**
     * @return the quantidadeChoc
     */
    public static int getQuantidadeChoc() {
        return quantidadeChoc;
    }

    /**
     * @return the quantidadeAmendoas
     */
    public static int getQuantidadeAmendoas() {
        return quantidadeAmendoas;
    }

    /**
     * @return the quantidadePassas
     */
    public static int getQuantidadePassas() {
        return quantidadePassas;
    }

    /**
     * @return the especialistaQueProduziu
     */
    public EspecialistaTabChocAmendPassas getEspecialistaQueProduziu() {
        return especialistaQueProduziu;
    }

    /**
     * @param especialistaQueProduziu the especialistaQueProduziu to set
     */
    public void setEspecialistaQueProduziu(EspecialistaTabChocAmendPassas especialistaQueProduziu) {
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
    public static ArrayList<TabChocAmendPassas> getTabsAfazer() {
        return tabsAfazer;
    }


    
    

    
    
    
    
    
}
