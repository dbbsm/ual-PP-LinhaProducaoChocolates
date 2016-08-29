/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.projecto1.ContentManager;

import java.util.ArrayList;
import ual.projecto1.ingredientes.*;
import java.util.TimerTask;
import ual.projecto1.GUI.Main;
import ual.projecto1.Threads.*;
import ual.projecto1.funcionarios.*;
import ual.projecto1.produtos.*;

/**
 *
 * @author Diogo
 */
public class JobScheduler extends TimerTask {

    private Register register;
    
    private Main j;

    private LinhaProducaoTabChoc LPTC;
    private LinhaProducaoTabChocCaram LPTCC;
    private LinhaProducaoTabChocAmendPassas LPTCAP;
    private LinhaProducaoAmendoasEovos LPAO;

    public JobScheduler(Main j, Register r,LinhaProducaoAmendoasEovos lao, LinhaProducaoTabChoc ltc, LinhaProducaoTabChocCaram ltcar, LinhaProducaoTabChocAmendPassas lap)
    {
        this.register=r;
        this.LPTC=ltc;
        this.LPAO=lao;
        this.LPTCC=ltcar;
        this.LPTCAP=lap;
        this.j=j;
    }

    @Override
    public void run() 
    {
        /*-----------------------------TABCHOCSAMENDOAePASSAS-----------------------------------------*/
        //agendar a producao de tabchocamendoaspassas
        
        while(register.AmendoasEmStock.getQuantidade()>= 25 )
        {
            if(register.PassasEmStock.getQuantidade()>=25)
            {
                if(register.CacauEmStock.getQuantidade() >= 100)
                {
                    TabChocAmendPassas.getTabsAfazer().add(new TabChocAmendPassas(register.CacauEmStock, register.AmendoasEmStock, register.PassasEmStock));
                    
                }
                else
                    break;
            }
            else
                break;
        }
        
        //lista com tabs a retirar da lista de tabs a fazer
        ArrayList<TabChocAmendPassas> tabsAmendEpassasARetirar=new ArrayList<TabChocAmendPassas>();
        
        if(!TabChocAmendPassas.getTabsAfazer().isEmpty())
        {
            for(TabChocAmendPassas tap : TabChocAmendPassas.getTabsAfazer())
            {
                if(tap.getEspecialistaQueProduziu()==null)
                {
                    if(!EspecialistaTabChocAmendPassas.getEspecialistasTabChocAmendPassas().isEmpty())
                    {
                        for(EspecialistaTabChocAmendPassas etc : EspecialistaTabChocAmendPassas.getEspecialistasTabChocAmendPassas())
                        {
                            if(etc.getTableteAproduzir()==null)
                            {
                                etc.setTableteAproduzir(tap);
                                tap.setEspecialistaQueProduziu(etc);
                                tabsAmendEpassasARetirar.add(tap);
                                LPTCAP.getEspecialistasParaTrabalhar().add(etc);
                                System.out.println("Um especialista foi atribuido a um chocolate.");
                                j.sendFilaDeEspera("Um TabChocAmendPassas esta em fila de espera com especialista atribuido.");
                                break;
                            }

                        }

                    }
                    else if(EspecialistaTabChocAmendPassas.getEspecialistasTabChocAmendPassas().isEmpty())
                    {
                        System.out.println("O array de especialistas esta vazio.");
                    }
                }
            }
            
            if(!tabsAmendEpassasARetirar.isEmpty())
            {
                TabChocAmendPassas.getTabsAfazer().removeAll(tabsAmendEpassasARetirar);
            
            }
        }
        
        /*-----------------------------TABCHOCSCaramelo-----------------------------------------*/
        
        while(register.CarameloEmStock.getQuantidade()>= 25 )
        {
                if(register.CacauEmStock.getQuantidade() >= 100)
                {
                    TabChocCaram.getTabsAfazer().add(new TabChocCaram(register.CacauEmStock, register.CarameloEmStock));
                }
                else
                    break;
        }
        
        //lista com tabs a retirar da lista de tabs a fazer
        ArrayList<TabChocCaram> tabsCarameloAretirar=new ArrayList<TabChocCaram>();
        
        if(!TabChocCaram.getTabsAfazer().isEmpty())
        {
            for(TabChocCaram tc : TabChocCaram.getTabsAfazer())
            {
                if(tc.getEspecialistaQueProduziu()==null)
                {
                    if(!EspecialistaTabChocCaram.getEspecialistasTabChocCaram().isEmpty())
                    {
                        for(EspecialistaTabChocCaram etc : EspecialistaTabChocCaram.getEspecialistasTabChocCaram())
                        {
                            if(etc.getTabAfazer()==null)
                            {
                                etc.setTabAfazer(tc);
                                tc.setEspecialistaQueProduziu(etc);
                                tabsCarameloAretirar.add(tc);
                                LPTCC.getEspecialistasParaTrabalhar().add(etc);
                                System.out.println("Um especialista foi atribuido a um chocolate.");
                                j.sendFilaDeEspera("Um TabChocCaram esta em fila de espera com especialista atribuido.");
                                break;
                            }

                        }

                    }
                    else if(EspecialistaTabChocCaram.getEspecialistasTabChocCaram().isEmpty())
                    {
                        System.out.println("O array de especialistas esta vazio.");
                    }
                }
                
            }
            
            if(!tabsCarameloAretirar.isEmpty())
            {
                TabChoc.getTabChocsParaFazer().removeAll(tabsCarameloAretirar);
            
            }
        }

        
        
        /*-----------------------------TABCHOCS-----------------------------------------*/
        //agendar a producao de tabchoc
        
        while (register.CacauEmStock.getQuantidade() >= 100)
        {
            TabChoc.getTabChocsParaFazer().add(new TabChoc(register.CacauEmStock));
            System.out.println("Um chocolate foi adicionado a lista para fazer.");
            
        }
        
        //lista com tabs a retirar da lista de tabs a fazer
        ArrayList<TabChoc> tabsRetirar=new ArrayList<TabChoc>();
        
        if(!TabChoc.getTabChocsParaFazer().isEmpty())
        {
            for(TabChoc tc : TabChoc.getTabChocsParaFazer())
            {
                if(tc.getEspecialistaQueProduziu()==null)
                {
                    if(!EspecialistaTabChoc.getEspecialistasTabChoc().isEmpty())
                    {
                        for(EspecialistaTabChoc etc : EspecialistaTabChoc.getEspecialistasTabChoc())
                        {
                            if(etc.getTableteAproduzir()==null)
                            {
                                etc.setTableteAproduzir(tc);
                                tc.setEspecialistaQueProduziu(etc);
                                tabsRetirar.add(tc);
                                LPTC.EspecialistasParaTrabalhar.add(etc);
                                System.out.println("Um especialista foi atribuido a um chocolate.");
                                j.sendFilaDeEspera("Um TabChoc esta em fila de espera com especialista atribuido.");
                                break;
                            }

                        }

                    }
                    else if(EspecialistaTabChoc.getEspecialistasTabChoc().isEmpty())
                    {
                        System.out.println("O array de especialistas esta vazio.");
                    }
                }
                
            }
            
            if(!tabsRetirar.isEmpty())
            {
                TabChoc.getTabChocsParaFazer().removeAll(tabsRetirar);
            
            }
        }
        
        /*-----------------------------FIM_TABCHOCS-----------------------------------------*/
        
        /*-----------------------------Amendoas e Ovos-----------------------------------------*/

        while (register.AmendoasEmStock.getQuantidade() >= 2)
        {
            if(register.CacauEmStock.getQuantidade()>=3)
            {
                //System.out.println("Criei amendoa");
                //uma amendoa foi adicionada para fazer...
                AmendChoc.getTabsAfazer().add(new AmendChoc(register.AmendoasEmStock,register.CacauEmStock));
                
            }
            else
                break;
                   
        }
        
        while(register.CacauEmStock.getQuantidade()>=15)
        {
            //System.out.println("criei ovo");
            //enquanto houver quantidade suficiente de Cacau ele produz ovos de chocolate
            OvoPascoa.getTabsAfazer().add(new OvoPascoa(register.CacauEmStock));
        
        }
        
        ArrayList<AmendChoc> AmendoasAretirar = new ArrayList<AmendChoc>();
        
        ArrayList<OvoPascoa> OvosAretirar = new ArrayList<OvoPascoa>();
        
        if(!AmendChoc.getTabsAfazer().isEmpty())
        {
            for(AmendChoc ac : AmendChoc.getTabsAfazer())
            {
                if(ac.getEspecialistaQueProduziu()==null)
                {
                    if(!EspecialistaOvosEamendoas.getEspecialistasAmendoasEovos().isEmpty())
                    {
                        for(EspecialistaOvosEamendoas eoa : EspecialistaOvosEamendoas.getEspecialistasAmendoasEovos())
                        {
                            if(eoa.getAmendAProduzir()==null && eoa.getOvoAProduzir()==null)
                            {
                                eoa.setAmendAProduzir(ac);
                                ac.setEspecialistaQueProduziu(eoa);
                                AmendoasAretirar.add(ac);
                                LPAO.getEspecialistasParaTrabalhar().add(eoa);
                                j.sendFilaDeEspera("Uma AmendChoc esta em fila de espera com especialista atribuido.");
                                break;
                            }
                        }
                        
                    }
                    else if(EspecialistaOvosEamendoas.getEspecialistasAmendoasEovos().isEmpty())
                    {
                        
                        System.out.println("O array de Especialistas Ovos e Amendoas esta Vazio.");
                    }
                    
                    
                }
            }
            
            if(!AmendoasAretirar.isEmpty())
            {
                AmendChoc.getTabsAfazer().removeAll(AmendoasAretirar);
            
            }
        }
        
        if(!OvoPascoa.getTabsAfazer().isEmpty())
        {
            
            for(OvoPascoa op : OvoPascoa.getTabsAfazer())
            {
                if(op.getEspecialistaQueProduziu()==null)
                {
                    if(!EspecialistaOvosEamendoas.getEspecialistasAmendoasEovos().isEmpty())
                    {
                        for(EspecialistaOvosEamendoas eoa : EspecialistaOvosEamendoas.getEspecialistasAmendoasEovos())
                        {
                            if(eoa.getAmendAProduzir()==null && eoa.getOvoAProduzir()==null)
                            {
                                eoa.setOvoAProduzir(op);
                                op.setEspecialistaQueProduziu(eoa);
                                OvosAretirar.add(op);
                                LPAO.getEspecialistasParaTrabalhar().add(eoa);
                                j.sendFilaDeEspera("Um OvoPascoa esta em fila de espera com especialista atribuido.");
                                break;
                            }
                        }
                    
                    }
                    else if(EspecialistaOvosEamendoas.getEspecialistasAmendoasEovos().isEmpty())
                    {
                        System.out.println("O array de especialistas amendoas e ovos esta vazio.");
                    }
                
                }
            }
            
            if(!OvosAretirar.isEmpty())
            {
                OvoPascoa.getTabsAfazer().removeAll(OvosAretirar);
            
            }
        
        }


    }

}
