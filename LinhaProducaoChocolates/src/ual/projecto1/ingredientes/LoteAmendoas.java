/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.ingredientes;

/**
 *
 * @author Diogo
 */
public class LoteAmendoas extends LoteStock
{
    private static final Tipo tipo = Tipo.Amendoas;

    public LoteAmendoas(int quantidade) 
    {
        super(quantidade);
        
    }
    
    @Override
    public String toString() 
    {
        return "Estao disponiveis: "+getQuantidade()+"gr de "+LoteAmendoas.tipo+".";
    }
    
}
