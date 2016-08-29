/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.Threads;
import java.util.ArrayList;
import ual.projecto1.GUI.Main;
import ual.projecto1.funcionarios.EspecialistaTabChocCaram;
import ual.projecto1.produtos.TabChocCaram;
/**
 *
 * @author Diogo
 */
public class LinhaProducaoTabChocCaram extends Thread
{
    
    private static boolean disponivel=true;
    private static ArrayList<EspecialistaTabChocCaram> EspecialistasParaTrabalhar = new ArrayList<EspecialistaTabChocCaram>();
    private Main janela;
    
    
    public LinhaProducaoTabChocCaram(Main j) 
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
                    janela.sendMessage("Comecou a producao de TabChocCaram.");
                    this.setDisponivel(false);
                    getEspecialistasParaTrabalhar().get(0).getTabAfazer().produzir();
                    janela.sendMessage("Terminou uma TabChocCaram.");
                    getEspecialistasParaTrabalhar().remove(0);
                    this.setDisponivel(true);
                        
                }
               
                else
                {
                    System.out.println("A thread (TabChocCaram) esta parada!");
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
    public static ArrayList<EspecialistaTabChocCaram> getEspecialistasParaTrabalhar() {
        return EspecialistasParaTrabalhar;
    }

    /**
     * @param aEspecialistasParaTrabalhar the EspecialistasParaTrabalhar to set
     */
    public static void setEspecialistasParaTrabalhar(ArrayList<EspecialistaTabChocCaram> aEspecialistasParaTrabalhar) {
        EspecialistasParaTrabalhar = aEspecialistasParaTrabalhar;
    }
    
    
    
}
