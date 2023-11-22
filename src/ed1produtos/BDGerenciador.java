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
    
    public Produtos buscarPosicao(int pos) {
       return null;
    }
    
    public Produtos buscarCodigo(int codigo) {
       return null;
    }

    public void alterarCodigo(Produtos produto) {
        
    }

    public Produtos[] listar() {
        Produtos[] p = new Produtos[this.length()];
        int i;
        Produtos noh;
        for(i = 0, noh = this.primeiro; noh != null; i++, noh = noh.getProximo()){
            p[i] = noh;
        }
        return p;
    }
    public int length(){
        int i;
        Produtos noh;
        for(i = 0, noh = this.primeiro; noh != null; i++, noh = noh.getProximo()){}
         return i;
    }

    private int sort(Produtos s1, Produtos s2){
       return s1.getNome().compareTo (s2.getNome());
    }
    
    public void ordenarporNome() {
        Produtos temp;
        Produtos noh;
        int i;
        int s = 1;
        while(s != 1){
            s = 0;
            for(i = 0, noh = this.primeiro; noh.getProximo() != this.ultimo; i++, noh = noh.getProximo()){
                if(i == 0){
                    //Vez do primeiro
                    s = 1;
                    if(sort(noh, noh.getProximo()) == 1){
                        temp = noh;
                        this.primeiro = noh.getProximo();
                        temp.setProximo(this.primeiro.getProximo());
                        this.primeiro.setProximo(temp);
                    }
                }
                if( sort(noh.getProximo(), noh.getProximo().getProximo()) == 1){
                    s = 1;
                    temp = noh.getProximo();
                    noh.setProximo( temp.getProximo());
                    temp.setProximo(noh.getProximo().getProximo());
                    noh.getProximo().setProximo(temp);
                }
            }
        }
    }

    private String linha(Produtos produto) {
        return produto.getCodigo() + "     " + produto.getNome() + "     " + produto.getQuantidade() + produto.getValor();
    }

    public boolean existeID(int id) {
        
        return ((id <= this.length()) ? true : false);
    }

}
