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
public class EspecialistaTabChocAmendPassas extends Funcionario
{
    
    private static final TipoEspecialista especialidade = TipoEspecialista.TabChocAmendPassas;
    
    private TabChocAmendPassas tableteAproduzir;
    
    
    private static ArrayList<EspecialistaTabChocAmendPassas> EspecialistasTabChocAmendPassas= new ArrayList<EspecialistaTabChocAmendPassas>();

    public EspecialistaTabChocAmendPassas(String nome) {
        super(nome);
        setTipo(Tipo.Especialista);
        
        
        EspecialistasTabChocAmendPassas.add(this);
    }
    

    /**
     * @return the especialidade
     */
    public static TipoEspecialista getEspecialidade() {
        return especialidade;
    }

    /**
     * @return the EspecialistasTabChocAmendPassases
     */
    public static ArrayList<EspecialistaTabChocAmendPassas> getEspecialistasTabChocAmendPassas() {
        return EspecialistasTabChocAmendPassas;
    }

    /**
     * @param aEspecialistasTabChocAmendPassases the EspecialistasTabChocAmendPassases to set
     */
    public static void setEspecialistasTabChocAmendPassases(ArrayList<EspecialistaTabChocAmendPassas> aEspecialistasTabChocAmendPassases) {
        EspecialistasTabChocAmendPassas = aEspecialistasTabChocAmendPassases;
    }

    /**
     * @return the tableteAproduzir
     */
    public TabChocAmendPassas getTableteAproduzir() {
        return tableteAproduzir;
    }

    /**
     * @param tableteAproduzir the tableteAproduzir to set
     */
    public void setTableteAproduzir(TabChocAmendPassas tableteAproduzir) {
        this.tableteAproduzir = tableteAproduzir;
    }
    
    
}
