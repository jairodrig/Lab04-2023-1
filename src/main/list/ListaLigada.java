package list;

import list.EstruturaElementar;

public class ListaLigada implements EstruturaElementar{

    private No cabeca;

    public ListaLigada() {

    }

    @Override
    public boolean buscaElemento(int valor) {
        No atual = cabeca;
        while(atual!= null){
            if(atual.getValor()==valor){
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        No atual = cabeca;
    int i = 0;
        while(atual != null) {
            if(atual.getValor() == valor) {
                return i;
            } 
            else {
                atual = atual.getProximo();
                i++;
            }
        }
        return -1;
    }

    @Override
    public int minimo() {
        No atual= cabeca;
        int valorMin= atual.getValor();
        while(atual != null) {
            valorMin = Math.min(valorMin, atual.getValor());
            atual= atual.getProximo();
        }
        return valorMin;
    }

    @Override
    public int maximo() {
        No atual= cabeca;
        int valorMax= atual.getValor();
        while(atual != null) {
            valorMax= Math.max(valorMax, atual.getValor());
            atual= atual.getProximo();
        }
        return valorMax;
    }
    @Override
    public int predecessor(int valor) {
        if(cabeca==null||cabeca.getValor()==valor){
            return Integer.MIN_VALUE;
          }
          
          No atual= cabeca;
          
          while(atual.getProximo()!=null){
            if(atual.getProximo().getValor()==valor){
                return atual.getValor();
            }
            atual.getProximo();
          }
          return Integer.MIN_VALUE;
        }
        
    @Override
    public int sucessor(int valor) {
        No atual= cabeca;
        
        while(atual != null && atual.getValor() != valor){
            atual= atual.getProximo();
        }
        
        if(atual!= null && atual.getProximo()!= null){
            return atual.getProximo().getValor();
        }
        return Integer.MIN_VALUE;
    }

    @Override
    public void insereElemento(int valor) {
            No novoNo= new No(valor);
            if(cabeca== null){
                cabeca= novoNo;
            } 
            else{
                No atual= cabeca;
                while(atual.getProximo()!= null) {
                    atual= atual.getProximo();
                }
                atual.setProximo(novoNo);
            }
         }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
    No novoNo = new No(valor);
    if (buscaIndice == 0) {
        novoNo.setProximo(cabeca);
        cabeca = novoNo;
        return;
    }
    No atual = cabeca;
    for (int i= 0; i< buscaIndice-1 && atual!= null; i++) {
        atual= atual.getProximo();
    }
    if (atual!= null) {
        novoNo.setProximo(atual.getProximo());
        atual.setProximo(novoNo);
    }
}
        
    

    @Override
    public void insereInicio(int valor) {
        if (this.cabeca == null){
            this.cabeca = new No(valor);    
        }
        else{
            No n= new No(valor);
            n.setProximo(this.cabeca);
            this.cabeca = n;
        }
    }

    @Override
    public void insereFim(int valor) {
        No novoNo= new No(valor);
        if (cabeca== null) {
            cabeca= novoNo;
        } else{
            No atual= cabeca;
            while (atual.getProximo()!= null){
                atual= atual.getProximo();
            }
            atual.setProximo(novoNo);
        }    
    }

    @Override
    public void remove(int valor) {
        if(cabeca.getValor()== valor) {
            cabeca= cabeca.getProximo(); 
            return;
        }
        No atual = cabeca;
        No anterior= null;
        while(atual!= null && atual.getValor()!= valor){
            anterior= atual;
            atual= atual.getProximo();
        }
        if(atual != null) {
            anterior.setProximo(atual.getProximo());
        }
    }

    @Override
    public void removeIndice(int indice) {
        if (indice == 0) {
            cabeca = cabeca.getProximo();
            return;
        }
        No atual = cabeca;
        No anterior = null;
        int indiceAtual = 0;
        while (atual != null && indiceAtual < indice) {
            anterior = atual;
            atual = atual.getProximo();
            indiceAtual++;
        }
        if (atual != null) {
            anterior.setProximo(atual.getProximo());
        }
    }

    @Override
        public void removeInicio() {
            if (cabeca != null) {
                cabeca = cabeca.getProximo();
            }
        }

    @Override
    public void removeFim() {
            if(cabeca== null || cabeca.getProximo()== null){
                cabeca= null;
                return;
            }
            No atual= cabeca;
            No anterior= null;
            while (atual.getProximo() != null){
                anterior= atual;
                atual= atual.getProximo();
            }
            anterior.setProximo(null);
        }
    }