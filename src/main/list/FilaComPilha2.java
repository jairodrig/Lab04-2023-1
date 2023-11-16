package list;

public class FilaComPilha2 implements FilaComPilha {
    private PilhaNovo pilha1;
    private PilhaNovo pilha2;

    public FilaComPilha2() {
        this.pilha1= new PilhaNovo();
        this.pilha2= new PilhaNovo();
}

    @Override
    public void enqueue(int item) {
        pilha1.push(item);
}

    @Override
    public int dequeue(){
        if (isEmpty()) {
            throw new IllegalStateException("A fila está SECA");
        }

        if (pilha2.isEmpty()){
            transferirPilha1ParaPilha2();
    }

        return pilha2.pop();
    }

    @Override
    public boolean isEmpty(){
        return pilha1.isEmpty() && pilha2.isEmpty();
 }

    @Override
    public int size(){
        return pilha1.size()+pilha2.size();
    }

    private void transferirPilha1ParaPilha2() {
        while (!pilha1.isEmpty()){
            pilha2.push(pilha1.pop());
        }
}
}
