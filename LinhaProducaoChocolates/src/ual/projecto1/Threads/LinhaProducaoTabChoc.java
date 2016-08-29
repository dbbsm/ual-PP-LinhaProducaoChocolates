/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.Threads;

import java.util.ArrayList;
import java.util.HashMap;
import ual.projecto1.GUI.Main;
import ual.projecto1.funcionarios.EspecialistaTabChoc;
import ual.projecto1.produtos.TabChoc;

/**
 *
 * @author Diogo
 */
public class LinhaProducaoTabChoc extends Thread
{
    private boolean disponivel=true;
    private Main janela;
    
    public ArrayList<EspecialistaTabChoc> EspecialistasParaTrabalhar = new ArrayList<EspecialistaTabChoc>(); 
    
    public LinhaProducaoTabChoc(Main Janela) 
    { 
        this.janela= Janela;
        this.start();
    }

    @Override
    public synchronized void run() 
    {
        try
        {
            while(true)
            {
                if(isDisponivel()==true && !getEspecialistasParaTrabalhar().isEmpty())
                {
                    this.setDisponivel(false);
                    janela.sendMessage("Comecou a producao de TabChoc.");
                    //System.out.println("comecou uma tablete. LinhaProducaoTabChoc");
                    getEspecialistasParaTrabalhar().get(0).getTableteAproduzir().produzir();
                    janela.sendMessage("Terminou uma TabChoc.");
                    getEspecialistasParaTrabalhar().remove(0);
                    this.setDisponivel(true);
                        
                }
               
                else
                {
                    System.out.println("A thread  (TabChoc) esta parada!");
                    wait(5000);
                }

            }
        }
        catch(InterruptedException e)
        {
            
        }
    }

    /**
     * @return the disponivel
     */
    public synchronized boolean isDisponivel() {
        notifyAll();
        return disponivel;
    }

    /**
     * @param aDisponivel the disponivel to set
     */
    public synchronized void setDisponivel(boolean aDisponivel) {
        disponivel = aDisponivel;
        notifyAll();
    }

    /**
     * @return the EspecialistasParaTrabalhar
     */
    public ArrayList<EspecialistaTabChoc> getEspecialistasParaTrabalhar() {
        return EspecialistasParaTrabalhar;
    }

    /**
     * @param aEspecialistasParaTrabalhar the EspecialistasParaTrabalhar to set
     */
    public synchronized void setEspecialistasParaTrabalhar(ArrayList<EspecialistaTabChoc> aEspecialistasParaTrabalhar) {
        EspecialistasParaTrabalhar = aEspecialistasParaTrabalhar;
        notifyAll();
    }

    /**
     * @return the janela
     */
    public Main getJanela() {
        return janela;
    }

    /**
     * @param janela the janela to set
     */
    public void setJanela(Main janela) {
        this.janela = janela;
    }

    /**
     * @return the thread_available
     */

    
    
    
    
}
