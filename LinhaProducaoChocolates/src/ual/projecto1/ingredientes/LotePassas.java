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
public class LotePassas extends LoteStock
{
    private static final Tipo tipo = Tipo.Passas;

    public LotePassas(int quantidade) 
    {
        super(quantidade);
    }
    
    

    @Override
    public String toString() 
    {
        return "Estao disponiveis: "+getQuantidade()+"gr de "+LotePassas.tipo+".";
    }
    
}
