/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

/**
 *
 * @author USUARIO
 */
public interface Transacao {
    public void executar(Lampada l, int qtde);
    
}
