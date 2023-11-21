/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed1produtos;

import java.util.ArrayList;

/**
 *
 * @author humbertop
 */
public class BDGerenciador {

    Produtos primeiro;
    Produtos ultimo;

    public BDGerenciador() {
        primeiro = ultimo = null;
    }

    public void inserirFim(Produtos produto) {
      
    }

    public void removerPosicao(int pos) {

    }

    public Produtos buscarCodigo(int codigo) {
       return null;
    }

    public void alterarCodigo(Produtos produto) {
        
    }

    public Produtos[] listar() {
      
        return null;
    }
    public int length(){
        
         return 0;
    }

    public void ordenarporNome() {

    }

    private String linha(Produtos produto) {
        return produto.getCodigo() + "     " + produto.getNome() + "     " + produto.getQuantidade() + produto.getValor();
    }

    public boolean existeID(int id) {
       
        
        return false;

    }

}
