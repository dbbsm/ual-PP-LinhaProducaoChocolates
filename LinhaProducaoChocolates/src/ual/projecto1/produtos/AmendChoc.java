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
import ual.projecto1.ingredientes.*;
import ual.projecto1.funcionarios.EspecialistaOvosEamendoas;

/**
 *
 * @author Diogo
 */
public class AmendChoc
{
    private int id;
    private LoteAmendoas amendoas;
    private LoteCacau chocolate;
    private static final int quantidadeChoc = 3;
    private static final int quantidadeAmendoa = 2;
    private static int count_AmendChoc=0;
    
    private EspecialistaOvosEamendoas especialistaQueProduziu;
    
    private static ArrayList<AmendChoc> tabsAfazer = new ArrayList<AmendChoc>();


    public AmendChoc(LoteAmendoas amendoas, LoteCacau chocolate) 
    {
        this.amendoas = amendoas;
        this.chocolate = chocolate;
        getChocolate().removerQuantidade(-quantidadeChoc);
        getAmendoas().removerQuantidade(-quantidadeAmendoa);
        count_AmendChoc++;
        this.id=count_AmendChoc;
        setEspecialistaQueProduziu(null);
        
    }

        public void escreveNoFicheiro(int count)
    {
        //codigo para escrever no ficheiro ao ser produzida uma tablete
        try
        {
            BufferedWriter fOut = new BufferedWriter(new FileWriter("./AmendEovos/Amend-Choc-numero-"+count));
            fOut.write("Chocolate-"+AmendChoc.quantidadeChoc+"\n");
            fOut.write("Amendoas-"+AmendChoc.quantidadeAmendoa+"\n");
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
            System.out.println("Comecou a producao de um chocolate.  amend choc");
            //tempo de produçao de uma tablete sleep
            Thread.sleep(1500);
            escreveNoFicheiro(this.id);
            this.getEspecialistaQueProduziu().setAmendAProduzir(null);
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
     * @return the quantidadeAmendoa
     */
    public static int getQuantidadeAmendoa() {
        return quantidadeAmendoa;
    }

    /**
     * @return the count_AmendChoc
     */
    public static int getCount_AmendChoc() {
        return count_AmendChoc;
    }

    /**
     * @param aCount_AmendChoc the count_AmendChoc to set
     */
    public static void setCount_AmendChoc(int aCount_AmendChoc) {
        count_AmendChoc = aCount_AmendChoc;
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
    public synchronized static ArrayList<AmendChoc> getTabsAfazer() {
        return tabsAfazer;
    }

    /**
     * @param aTabsAfazer the tabsAfazer to set
     */
    public static void setTabsAfazer(ArrayList<AmendChoc> aTabsAfazer) {
        tabsAfazer = aTabsAfazer;
    }
    
    

    
    
    
    
}
