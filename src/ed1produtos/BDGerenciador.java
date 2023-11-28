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
       for (int i = 0; i < pos ; i++){
           nohAtual = nohAtual.getProximo();
       }
       
       return nohAtual; 
    }
    
    public Produtos buscarCodigo(int codigo) {
       
       for (Produtos noh = this.primeiro; noh != null ; noh = noh.getProximo()){
           if(noh.getCodigo() == codigo){
               return noh;
           }
       }
        
        return null;
    }

    public void alterarCodigo(Produtos produto, int codigo) {
        while (buscarCodigo(codigo) != null) {
            codigo++;           
        }
        produto.setCodigo(codigo);
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

    private int sort(Produtos obj1, Produtos obj2){
        int r = 0;
        try{
            String s1 = obj1.getNome();
            String s2 = obj2.getNome();
            r = s1.compareTo (s2);
        }catch(Exception e){}
       return r;
    }
    
    private int sort(int obj1, int obj2){
        int r = 0;
        try{
            Integer i1 = obj1;
            Integer i2 = obj2;
            r = i1.compareTo (i2);
        }catch(Exception e){}
       return r;
    }
    
    public void ordenarporNome() {
        if(this.length() == 0) return;
        
        Produtos temp;
        Produtos noh;
        Produtos NohAtual;
        int i;
        int s = 1;
        int length =  this.length();
        while(s == 1){
            s = 0;
            //Vez do primeiro
            if(sort(this.primeiro, this.primeiro.getProximo()) >= 1){
                s = 1;
                temp = this.primeiro;
                this.primeiro = this.primeiro.getProximo();
                temp.setProximo(this.primeiro.getProximo());
                this.primeiro.setProximo(temp);
            }
            for(i = 0, noh = this.primeiro; i < length-2; i++, noh = noh.getProximo()){
                NohAtual = noh.getProximo();
                 if( sort(NohAtual, NohAtual.getProximo()) >= 1){
                    s = 1;
                    temp = NohAtual.getProximo();
                    NohAtual.setProximo(temp.getProximo());
                    temp.setProximo(NohAtual);
                    noh.setProximo(temp);
                }
            }
        }
    }

    public void ordenarporCodigo() {
        if(this.length() == 0) return;
        
        Produtos temp;
        Produtos noh;
        Produtos NohAtual;
        int i;
        int s = 1;
        int length =  this.length();
        while(s == 1){
            s = 0;
            //Vez do primeiro
            if(sort(this.primeiro.getCodigo(), this.primeiro.getProximo().getCodigo()) >= 1){
                s = 1;
                temp = this.primeiro;
                this.primeiro = this.primeiro.getProximo();
                temp.setProximo(this.primeiro.getProximo());
                this.primeiro.setProximo(temp);
            }
            for(i = 0, noh = this.primeiro; i < length-2; i++, noh = noh.getProximo()){
                NohAtual = noh.getProximo();
                 if(sort(NohAtual.getCodigo(), NohAtual.getProximo().getCodigo()) >= 1){
                    s = 1;
                    temp = NohAtual.getProximo();
                    NohAtual.setProximo(temp.getProximo());
                    temp.setProximo(NohAtual);
                    noh.setProximo(temp);   
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
