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
public class EspecialistaOvosEamendoas extends Funcionario
{
    
    private static final TipoEspecialista especialidade = TipoEspecialista.AmendoasEovos;
    
    private OvoPascoa ovoAProduzir;
    private AmendChoc amendAProduzir;
    private static ArrayList<EspecialistaOvosEamendoas> EspecialistasAmendoasEovos= new ArrayList<EspecialistaOvosEamendoas>();

    public EspecialistaOvosEamendoas(String nome) 
    {
        super(nome);
        setTipo(Tipo.Especialista);
        
        EspecialistasAmendoasEovos.add(this);
    }
    

    /**
     * @return the especialidade
     */
    public static TipoEspecialista getEspecialidade() {
        return especialidade;
    }

    /**
     * @return the EspecialistasAmendoasEovos
     */
    public static ArrayList<EspecialistaOvosEamendoas> getEspecialistasAmendoasEovos() {
        return EspecialistasAmendoasEovos;
    }

    /**
     * @param aEspecialistasAmendoasEovos the EspecialistasAmendoasEovos to set
     */
    public static void setEspecialistasAmendoasEovos(ArrayList<EspecialistaOvosEamendoas> aEspecialistasAmendoasEovos) {
        EspecialistasAmendoasEovos = aEspecialistasAmendoasEovos;
    }

    /**
     * @return the ovoAProduzir
     */
    public OvoPascoa getOvoAProduzir() {
        return ovoAProduzir;
    }

    /**
     * @param ovoAProduzir the ovoAProduzir to set
     */
    public void setOvoAProduzir(OvoPascoa ovoAProduzir) {
        this.ovoAProduzir = ovoAProduzir;
    }

    /**
     * @return the amendAProduzir
     */
    public AmendChoc getAmendAProduzir() {
        return amendAProduzir;
    }

    /**
     * @param amendAProduzir the amendAProduzir to set
     */
    public void setAmendAProduzir(AmendChoc amendAProduzir) {
        this.amendAProduzir = amendAProduzir;
    }
    
    
    
}
