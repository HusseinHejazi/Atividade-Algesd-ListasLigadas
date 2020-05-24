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
  
   public void ordenarBolha()
   {
      if(quantidade > 1) //de 2 elementos em diante
      {
         Nodo referencia;
         for(int i=0; i<quantidade-1; i++) //repetir N-1 vezes
         {
            referencia = inicio;
            while(referencia != fim) //enquanto a referencia tem um proximo
            {
               if(referencia.dado > referencia.link.dado)//fora de ordem
               {
                  int aux = referencia.dado;
                  referencia.dado = referencia.link.dado;
                  referencia.link.dado = aux;
               }
               referencia = referencia.link;
            }
         }
      }
   }
  
   public void ordenacaoSelecao()
   {
      Nodo referencia = inicio;
      while(referencia != fim)
      {
         Nodo menor = referencia;
         Nodo referencia2 = referencia.link;
         while(referencia2 != null)
         {
            if(referencia2.dado < menor.dado)
            {
               menor = referencia2;
            }
            referencia2 = referencia2.link;
         }
         //troca
         int aux = referencia.dado;
         referencia.dado = menor.dado;
         menor.dado = aux;
        
         referencia = referencia.link;
      }
   }
  
   public void ordenarBolhaOtimizado()
   {
      if(quantidade > 1) //de 2 elementos em diante
      {
         Nodo referencia;
         boolean trocas = true;
         while(trocas) //repetir enquanto as trocas ocorrem
         {
            trocas = false;
            referencia = inicio;
            while(referencia != fim) //enquanto a referencia tem um proximo
            {
               if(referencia.dado > referencia.link.dado)//fora de ordem
               {
                  int aux = referencia.dado;
                  referencia.dado = referencia.link.dado;
                  referencia.link.dado = aux;
                  trocas = true;
               }
               referencia = referencia.link;
            }
         }
      }
   }
  
   private void removerProximo(Nodo anterior)
   {
      if(anterior.link == fim) fim = anterior;
      anterior.link = anterior.link.link;
      quantidade--;
   }
  
   public void retirarRepetidos()
   {
      Nodo referencia = inicio;
      while(referencia != fim && referencia != null)
      {
         Nodo anterior = referencia;
         while(anterior != fim)
         {
            if(referencia.dado == anterior.link.dado) //há repetido
               removerProximo(anterior);
            else //não é repetido
               anterior = anterior.link; //avanço
         }       
         referencia = referencia.link;
      }
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
   public void inverter1()
   {   if(quantidade <= 1) return; 
       Nodo primeiro = inicio; //primeiro elemento
       for(int i=0; i<quantidade-1; i++)
       {    Nodo seguinte = primeiro.link; //segundo, terceiro, quarto ..... elemento
            primeiro.link = seguinte.link; //removendo o segundo
            quantidade--; //atualiza corretamente o atributo quantidade
            adicionarInicio(seguinte.dado);
       }
   }
   
   public void inverter2()
   {   if(quantidade <= 1) return; 
       Nodo primeiro = inicio; //primeiro elemento
       for(int i=0; i<quantidade-1; i++)
       {    Nodo seguinte = primeiro.link; //segundo, terceiro, quarto ..... elemento
            primeiro.link = seguinte.link; //removendo o segundo
            seguinte.link = inicio; //adicionando no inicio
            inicio = seguinte;
       }
   }
      
}

public class Exercicio8ListasLigadas

{
   public static void main(String args[])
   {
      ListaLigadaSimples lista = new ListaLigadaSimples();
      lista.adicionarInicio(7);
      lista.adicionarInicio(4);
      lista.adicionarInicio(2);
      lista.adicionarInicio(4);
      lista.adicionarInicio(5);
      lista.adicionarInicio(4);
      lista.adicionarInicio(7);
      lista.adicionarInicio(9);
      lista.adicionarFim(11);
      lista.adicionarFim(1);
      lista.adicionarFim(8);
      lista.adicionarFim(11);
      lista.adicionarFim(1);
      lista.adicionarFim(6);
      System.out.println("Lista no princípio: " + lista);
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
      //System.out.println("Tentando ordenar usando algoritmo da Bolha..");
      //lista.ordenarBolha();
      //System.out.println("Lista ordenada: " + lista);
      //System.out.println("Tentando ordenar usando algoritmo da Bolha Otimizado..");
      //lista.ordenarBolhaOtimizado();
      //System.out.println("Lista ordenada: " + lista);
      System.out.println("Tentando ordenar usando algoritmo de Seleção..");
      lista.ordenacaoSelecao();
      System.out.println("Lista ordenada: " + lista);
      System.out.println("Tentando retirar repetidos...");     
      lista.retirarRepetidos();
      System.out.println("Lista sem repetição: " + lista);
   }
}