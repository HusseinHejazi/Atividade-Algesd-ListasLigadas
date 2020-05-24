public class Exercicio9ListasLigadas {
     
    public Object[] pilha;
    public int posicaoPilha;
 
    public Exercicio9ListasLigadas() {
        this.posicaoPilha = -1;

        this.pilha = new Object[10];

    }
 
    public boolean pilhaVazia() {
       
        if (this.posicaoPilha == -1) {
            return true;
        }
        return false;
    }
 
    public int tamanho() {
    
        if (this.pilhaVazia()) {
            return 0;
        }
        return this.posicaoPilha + 1;
    }
 
    public Object exibeUltimoValor() {
     
        if (this.pilhaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha];
    }
 
    public Object desempilhar() {
   
        if (pilhaVazia()) {
            return null;
        }
        return this.pilha[this.posicaoPilha--];
    }
 
    public void empilhar(Object valor) {
  
        if (this.posicaoPilha < this.pilha.length - 1) {
            this.pilha[++posicaoPilha] = valor;
        }
        class No{
         private int elem;
         private No prox;
         public No(int n){
            elem=n;
            prox=null;
            }
         public No inicia(int n){
            No aux = new No(n);
         return aux;
            }
        public void insereProx(No n){
	      prox=n;
	      }	   	
      public No passaProximo(){
	      return prox;
	      }
         public void inserenoProx(No n) {
             prox = n;
                }
      public int mostra(){
	      return elem;
              }	

         }
    }
 
    public static void main(String args[]) {
        Exercicio9ListasLigadas p = new Exercicio9ListasLigadas();
        p.empilhar("one ");
        p.empilhar("two ");
        p.empilhar("three ");
        p.empilhar("four ");
        p.empilhar(10);
                while (p.pilhaVazia() == false) {
            System.out.println(p.desempilhar());
        }
    }
}