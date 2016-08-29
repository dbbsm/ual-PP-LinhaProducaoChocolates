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
public abstract class LoteStock 
{
    private int quantidade;
    private static Tipo tipo;
    
    public abstract String toString();

    public LoteStock(int quantidade) 
    {
        this.quantidade = quantidade;
    }
    
    public synchronized void removerQuantidade(int q)
    {
        int aux= this.quantidade+q;
        setQuantidade(aux);
    }
    
    public synchronized void reporQuantidade(int q)
    {
        int aux = this.quantidade+q;
        setQuantidade(aux);
    }
    
    /*-------------------------------------------------------------------------------------*/

    /**
     * @return the quantidade
     */
    public synchronized int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public synchronized void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
