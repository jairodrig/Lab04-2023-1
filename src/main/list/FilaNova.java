package list;

public class FilaNova implements Fila {
    private No inicio;
    private No fim;
    private int tamanho;

    private class No {
        int valor;
        No proximo;

        No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public FilaNova() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void enqueue(int item) {
        No novoNo = new No(item);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }

    @Override
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("A fila está vazia");
        }

        int valorRemovido = inicio.valor;
        inicio = inicio.proximo;
        tamanho--;

        if (isEmpty()) {
            fim = null;
        }

        return valorRemovido;
    }

    @Override
    public boolean isEmpty() {
        return inicio == null;
    }

    @Override
    public int size() {
        return tamanho;
    }
}
