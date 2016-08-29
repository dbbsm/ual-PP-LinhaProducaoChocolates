/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.Threads;

import java.util.ArrayList;
import ual.projecto1.GUI.Main;
import ual.projecto1.funcionarios.EspecialistaTabChocAmendPassas;

/**
 *
 * @author Diogo
 */
public class LinhaProducaoTabChocAmendPassas extends Thread
{
    private static boolean disponivel=true;
    private static ArrayList<EspecialistaTabChocAmendPassas> EspecialistasParaTrabalhar = new ArrayList<EspecialistaTabChocAmendPassas>();
    private Main janela;
    
    
    public LinhaProducaoTabChocAmendPassas(Main j) 
    {
        this.janela=j;
        this.start();
    }

    @Override
    public synchronized void run() 
    {
        try
        {
            
            while(true)
            {
                if(isDisponivel()==true && !EspecialistasParaTrabalhar.isEmpty())
                {
                   janela.sendMessage("Comecou a producao de TabChocAmendPassas.");
                   this.setDisponivel(false);
                   getEspecialistasParaTrabalhar().get(0).getTableteAproduzir().produzir();
                   janela.sendMessage("Terminou uma TabChocAmendPassas.");
                   getEspecialistasParaTrabalhar().remove(0);
                   this.setDisponivel(true);
                
                }
                else
                {
                    System.out.println("A Thread (TabChocAmendPassas) esta parada.");
                    this.wait(5000);
                }
            
            }
        
        }
        catch(InterruptedException e)
        {
        
        }
    }

    /**
     * @return the thread_available
     */
    public static boolean isDisponivel() {
        return disponivel;
    }

    /**
     * @param aThread_available the thread_available to set
     */
    public static void setDisponivel(boolean aThread_available) {
        disponivel = aThread_available;
    }

    /**
     * @return the EspecialistasParaTrabalhar
     */
    public static ArrayList<EspecialistaTabChocAmendPassas> getEspecialistasParaTrabalhar() {
        return EspecialistasParaTrabalhar;
    }

    /**
     * @param aEspecialistasParaTrabalhar the EspecialistasParaTrabalhar to set
     */
    public static void setEspecialistasParaTrabalhar(ArrayList<EspecialistaTabChocAmendPassas> aEspecialistasParaTrabalhar) {
        EspecialistasParaTrabalhar = aEspecialistasParaTrabalhar;
    }

  
    
    
    
}
