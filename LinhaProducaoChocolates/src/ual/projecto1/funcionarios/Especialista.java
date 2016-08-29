/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.funcionarios;

/**
 *
 * @author Diogo
 */
public class Especialista extends Funcionario
{

    
    
    public Especialista(String nome) 
    {
        super(nome);
        setTipo(Tipo.Especialista);
    }
    
}
