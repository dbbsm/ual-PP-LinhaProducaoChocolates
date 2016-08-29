/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.Threads;

import java.util.ArrayList;
import ual.projecto1.GUI.Main;
import ual.projecto1.funcionarios.EspecialistaOvosEamendoas;
import ual.projecto1.produtos.AmendChoc;
import ual.projecto1.produtos.OvoPascoa;

/**
 *
 * @author Diogo
 */
public class LinhaProducaoAmendoasEovos extends Thread
{
    
    private static boolean disponivel=true;
    private ArrayList<EspecialistaOvosEamendoas> EspecialistasParaTrabalhar = new ArrayList<EspecialistaOvosEamendoas>();
    private Main janela;
    
    
    public LinhaProducaoAmendoasEovos(Main j) 
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
                    this.setDisponivel(false);
                    
                    if(getEspecialistasParaTrabalhar().get(0).getAmendAProduzir()!=null)
                    {
                        janela.sendMessage("Comecou a producao de AmendChoc.");
                        getEspecialistasParaTrabalhar().get(0).getAmendAProduzir().produzir();
                        janela.sendMessage("Terminou uma AmendChoc.");
                    }
                    else
                    {
                        janela.sendMessage("Comecou a producao de OvoPascoa.");
                        getEspecialistasParaTrabalhar().get(0).getOvoAProduzir().produzir();
                        janela.sendMessage("Terminou um OvoPascoa.");
                    }
                    
                    
                    getEspecialistasParaTrabalhar().remove(0);
                    this.setDisponivel(true);
                        
                }
               
                else
                {
                    System.out.println("A thread (Amend e Ovos) esta parada!");
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
    public static boolean isDisponivel() {
        return disponivel;
    }

    /**
     * @param aThread_available the disponivel to set
     */
    public static void setDisponivel(boolean aThread_available) {
        disponivel = aThread_available;
    }

    /**
     * @return the EspecialistasParaTrabalhar
     */
    public ArrayList<EspecialistaOvosEamendoas> getEspecialistasParaTrabalhar() {
        return EspecialistasParaTrabalhar;
    }

    /**
     * @param EspecialistasParaTrabalhar the EspecialistasParaTrabalhar to set
     */
    public void setEspecialistasParaTrabalhar(ArrayList<EspecialistaOvosEamendoas> EspecialistasParaTrabalhar) {
        this.EspecialistasParaTrabalhar = EspecialistasParaTrabalhar;
    }
    
    
    
    
}
