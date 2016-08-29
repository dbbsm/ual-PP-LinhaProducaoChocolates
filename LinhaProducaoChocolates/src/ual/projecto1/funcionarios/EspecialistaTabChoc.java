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
public class EspecialistaTabChoc extends Funcionario
{
    
    private static final TipoEspecialista especialidade = TipoEspecialista.TabChoc;
    private TabChoc tableteAproduzir;
    
    //Array de Especialistas
    private static ArrayList<EspecialistaTabChoc> EspecialistasTabChoc= new ArrayList<EspecialistaTabChoc>();
    

    public EspecialistaTabChoc(String nome) 
    {
        super(nome);
        setTipo(Tipo.Especialista);
        tableteAproduzir=null;
        
        EspecialistasTabChoc.add(this);
    }


    /**
     * @return the especialidade
     */
    public TipoEspecialista getEspecialidade() {
        return especialidade;
    }

    /**
     * @return the tableteAproduzir
     */
    public synchronized TabChoc getTableteAproduzir() {
        notifyAll();
        return tableteAproduzir;
    }

    /**
     * @param tableteAproduzir the tableteAproduzir to set
     */
    public synchronized void setTableteAproduzir(TabChoc tableteAproduzir) {
        this.tableteAproduzir = tableteAproduzir;
        notifyAll();
    }

    /**
     * @return the EspecialistasTabChoc
     */
    public static ArrayList<EspecialistaTabChoc> getEspecialistasTabChoc() {
        return EspecialistasTabChoc;
    }

    /**
     * @param aEspecialistasTabChoc the EspecialistasTabChoc to set
     */
    public static void setEspecialistasTabChoc(ArrayList<EspecialistaTabChoc> aEspecialistasTabChoc) {
        EspecialistasTabChoc = aEspecialistasTabChoc;
    }


    
    
    
}
