package banheiro;
public class Banheiro {

  private boolean estaSujo = true;


    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

      System.out.println(nome + " Batendo na porta");

      synchronized(this) {
        System.out.println(nome + " Entrando no banheiro");

        if(estaSujo) esperarFora(nome);

        System.out.println(nome + " Fazendo coisa rapida");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nome + " Dando descarga");
        System.out.println(nome + " Lavando Mao");
        System.out.println(nome + " Saindo do banheiro");
        this.estaSujo = true;

      }
    }

    public void fazNumero2() {
      String nome = Thread.currentThread().getName();

      System.out.println(nome + " Batendo na porta");

      synchronized(this) {
        System.out.println(nome + " Entrando no banheiro");

        if(estaSujo) esperarFora(nome);

        System.out.println(nome + " Fazendo coisa demorada");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nome + " Dando descarga");
        System.out.println(nome + " Lavando Mao");
        System.out.println(nome + " Saindo do banheiro");
        this.estaSujo = true;
      }

    }
    


    private void esperarFora(String nome) {
        System.out.println(nome + " saiu do banheiro que está sujo");
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }


      public void limpa() {
      String nome = Thread.currentThread().getName();

      System.out.println(nome + " Batendo na porta");

      synchronized(this) {
        System.out.println(nome + " entrando no banheiro");


        if(!estaSujo) {
          System.out.println("Banheiro não está sujo! Saindo.");
          return;
        }

        System.out.println(nome + " limpando banheiro");
        this.estaSujo = false;

        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.notifyAll();

        System.out.println(nome + " saindo do banheiro");
      }
      }
}
