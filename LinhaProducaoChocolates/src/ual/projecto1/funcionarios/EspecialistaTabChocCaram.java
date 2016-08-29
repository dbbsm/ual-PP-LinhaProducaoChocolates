/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.funcionarios;

import java.util.ArrayList;
import ual.projecto1.produtos.*;

/**
 *
 * @author Diogo
 */
public class EspecialistaTabChocCaram extends Funcionario
{
    
    private static final TipoEspecialista especialidade = TipoEspecialista.TabChocCaram;
    
    private TabChocCaram tabAfazer;
    
    private static ArrayList<EspecialistaTabChocCaram> EspecialistasTabChocCaram= new ArrayList<EspecialistaTabChocCaram>();

    public EspecialistaTabChocCaram(String nome) 
    {
        super(nome);
        setTipo(Tipo.Especialista);
        
        
        EspecialistasTabChocCaram.add(this);
    }

    

    /**
     * @return the EspecialistasTabChocCaram
     */
    public static ArrayList<EspecialistaTabChocCaram> getEspecialistasTabChocCaram() {
        return EspecialistasTabChocCaram;
    }

    /**
     * @param aEspecialistasTabChocCaram the EspecialistasTabChocCaram to set
     */
    public static void setEspecialistasTabChocCaram(ArrayList<EspecialistaTabChocCaram> aEspecialistasTabChocCaram) {
        EspecialistasTabChocCaram = aEspecialistasTabChocCaram;
    }

    /**
     * @return the tabAfazer
     */
    public TabChocCaram getTabAfazer() {
        return tabAfazer;
    }

    /**
     * @param tabAfazer the tabAfazer to set
     */
    public void setTabAfazer(TabChocCaram tabAfazer) {
        this.tabAfazer = tabAfazer;
    }
    
    
    
}
