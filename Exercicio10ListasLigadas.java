
    class Fila {
      private int vet[];
      private int inicio, fim, quantidade;
   
       public Fila(int tamanho)
      {
         vet = new int[tamanho];
         inicio = fim = quantidade = 0;
      }
   
       public void enfileirar(int x)
      {
         vet[fim] = x;
         fim++;
         quantidade++;
         if (fim == vet.length)
            fim = 0;
      }
   
       public int desenfileirar()
      {
         int resp = vet[inicio];
         inicio++;
         quantidade--;
         if (inicio == vet.length)
            inicio = 0;
         return resp;
      }
   
       public boolean vazia()
      {
         if (quantidade == 0) 
            return true;
         else 
            return false;
      }
   
       public boolean cheia()
      {
         if (quantidade == vet.length) 
            return true;
         else 
            return false;
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
   
   public class Exercicio10ListasLigadas
   {
   public static void main(String[] args)
      {
         Fila f = new Fila(10);
      
         System.out.println("Colocando 8 números na fila.");
         for(int i = 1; i <= 8; i++)
            f.enfileirar(i);
      
         System.out.println("Retirando todos os elementos da fila:");
         while(! f.vazia())
         {
            System.out.println( f.desenfileirar() );
         }
      
         System.out.println("Colocando mais 10 números na fila.");
      
         for(int i = 9; i <= 18; i++)
            f.enfileirar(i);
      
         System.out.println("Retirando todos os elementos da fila:");
      
         while(! f.vazia())
         {
            System.out.println( f.desenfileirar() );
         }
      }
   } 