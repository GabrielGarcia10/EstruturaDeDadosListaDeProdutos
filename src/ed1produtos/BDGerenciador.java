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
        //se estiver vazio
      if(primeiro == null){
          primeiro = ultimo = produto; 
          //se n estiver vazio
      }else{
          ultimo.setProximo(produto);
          ultimo = produto;
      }
    }

    public void removerPosicao(int pos) {
        
        if(pos < 0 || pos >= length()){
            System.out.println("Posição invalida");
            return; 
        }
        if (pos ==0){
            //remover o primeiro
            primeiro = primeiro.getProximo();
            if(primeiro == null){
                //caso a lista fique vazia
                ultimo =  null;
            }
        }else{
            Produtos nohAnterior = primeiro;
            for(int i =0; i< pos -1 ; i++){
                nohAnterior = nohAnterior.getProximo();
            }
            //remover de uma posição especifica 
            Produtos nohRemover = nohAnterior.getProximo();
            nohAnterior.setProximo(nohRemover.getProximo());
            
            if(nohRemover == ultimo){
                ultimo = nohAnterior;
            }
        }
    }
    
    public Produtos buscarPosicao(int pos) {
        
        if(pos < 0 || pos >= length()){
              System.out.println("Posição invalida! ");
              return null;
        }
       
       Produtos nohAtual  = primeiro; 
       for (int i =0; i< pos ; i++){
           nohAtual = nohAtual.getProximo();
       }
       int posicaoDesej = 2;
       Produtos nohDesejado = buscarPosicao(posicaoDesej);
       
       if(nohDesejado != null){
           System.out.println("Produto encontrado: " +nohDesejado.getNome());
       }else{
           System.out.println("Produto não encontrado na posição desejada.");
       }
       
       return nohAtual; 
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
