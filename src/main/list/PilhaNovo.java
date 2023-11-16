package list;

public class PilhaNovo implements Pilha {
    private No topo;
    private int tamanho;

    private class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public PilhaNovo() {
        this.topo = null;
        this.tamanho = 0;
    }

    @Override
    public boolean isEmpty() {
        return topo == null;
    }

    @Override
    public void push(int item) {
        No novoNo = new No(item);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }

        int valor = topo.valor;
        topo = topo.proximo;
        tamanho--;

        return valor;
    }

    public int size() {
        return tamanho;
    }
}
