class Nodo
{
   public int dado;
   public Nodo link; //referência
}

class ListaLigadaSimples
{
   public Nodo inicio, fim;
   public int quantidade;
  
   public ListaLigadaSimples()
   {
      inicio = null;
      fim = null;
      quantidade = 0;
   }

   public void adicionarInicio(int x)
   {
      if(quantidade == 0)
      {
         Nodo novo = new Nodo();
         novo.dado = x;
         novo.link = null;
         inicio = novo;
         fim = novo;
         quantidade = 1;
      }
      else //já existem elementos na lista
      {
         Nodo novo = new Nodo();
         novo.dado = x;
         novo.link = inicio;
         inicio = novo;
         quantidade++;
      }
   }
  
   public void adicionarFim(int x)
   {
      if(quantidade == 0)
      {
         Nodo novo = new Nodo();
         novo.dado = x;
         novo.link = null;
         inicio = novo;
         fim = novo;
         quantidade = 1;
      }
      else //já existem elementos na lista
      {
         Nodo novo = new Nodo();
         novo.dado = x;
         novo.link = null;
         fim.link = novo;
         fim = novo;
         quantidade++;
      }
   }
  
   public int removerInicio()
   {
      if(quantidade==0) throw new RuntimeException(); //lance exceção
      else if(quantidade==1)
      {
         int aux = inicio.dado;
         inicio = null;
         fim = null;
         quantidade=0;
         return aux;
      }
      else
      {
         int aux = inicio.dado;
         inicio = inicio.link;
         quantidade--;
         return aux;
      }
   }
  
   public int removerFim()
   {
      if(quantidade==0) throw new RuntimeException(); //lance exceção
      else if(quantidade==1)
      {
         int aux = inicio.dado;
         inicio = null;
         fim = null;
         quantidade=0;
         return aux;
      }
      else
      {
         int aux = fim.dado;
         Nodo penultimo=inicio;
         while(penultimo.link != fim)
         {
            penultimo = penultimo.link;
         }
         fim = penultimo;
         penultimo.link = null;
         quantidade--;
         return aux;
      }
   }
  
   public boolean removerElemento(int elemento)
   {
      if(quantidade==0)
         return false;
      else if(quantidade==1)
      {
         if(inicio.dado == elemento)
         {
            inicio = null;
            fim = null;
            quantidade=0;
            return true;
         }
         else
            return false;
      }
      else
      {
         if(inicio.dado == elemento) removerInicio(); //eh o primeiro
         else if (fim.dado == elemento) removerFim(); //eh o ultimo
         else
         {
            Nodo referencia = inicio;
            while(referencia.link != null && referencia.link.dado != elemento)
            {
               referencia = referencia.link;
            }
            if(referencia.link == null)
               return false; //nao existe!!
            else //existe o elemento a remover
            {
               referencia.link = referencia.link.link;
               quantidade--;
            }
         }
         return true;
      }
   }
  
   public boolean existe(int elemento)
   {
      Nodo aux=inicio;
      while(aux != null)
      {
         if(aux.dado == elemento)
            return true;
         else aux = aux.link;
      }
      return false;
   }
  
   public String toString()
   {
      Nodo nodo = inicio;
      String saida = "INICIO -> ";
      for(int i=0; i<quantidade;i++)
      {
         saida = saida + nodo.dado + " -> ";
         nodo = nodo.link;
      }
      saida = saida + "FIM";
      return saida;
   }
   
   public boolean compara(ListaLigadaSimples lista2)
   {    if(quantidade != lista2.quantidade) return false;
        Nodo aux = inicio, aux2 = lista2.inicio;
        for(int i=0; i<quantidade; i++)
        {   if(aux.dado != aux2.dado) return false;
            else
            {   aux = aux.link;
                aux2 = aux2.link;
            }
        }
        return true;
   }
   
}

public class Exercicio5ListasLigadas
{
   public static void main(String args[])
   {
      ListaLigadaSimples lista = new ListaLigadaSimples();
      ListaLigadaSimples lista2 = new ListaLigadaSimples();
      lista.adicionarInicio(7);
      lista.adicionarInicio(4);
      lista.adicionarInicio(2);
      lista.adicionarFim(8);
      lista.adicionarFim(11);
      
      lista2.adicionarInicio(7);
      lista2.adicionarInicio(4);
      lista2.adicionarInicio(2);
      lista2.adicionarFim(8);
      lista2.adicionarFim(11);
      
      System.out.println("Listas 1 e 2 são iguais? " + lista.compara(lista2));
      
      
      System.out.println("Lista no princípio: " + lista);
      lista.adicionarFim(5);
      System.out.println("Lista com a adição do 5: " + lista);                       
      System.out.println("Removi o primeiro: " + lista.removerInicio());
      System.out.println("Lista após remoção: " + lista);
      System.out.println("Removi o último: " + lista.removerFim());
      System.out.println("Lista após remoção: " + lista);
      System.out.println("O elemento 7 existe na lista? Resposta: " + lista.existe(7));
      System.out.println("O elemento 15 existe na lista? Resposta: " + lista.existe(15));
      System.out.println("Tentando remover o 7. Consegui? " + lista.removerElemento(7));
      System.out.println("Lista: " + lista);
      System.out.println("Tentando remover o 15. Consegui? " + lista.removerElemento(15));
      System.out.println("Lista: " + lista);
   }
}