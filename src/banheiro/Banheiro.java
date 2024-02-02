package banheiro;
public class Banheiro {

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();


      synchronized(this) {
        System.out.println(nome + " Entrando no banheiro");
        System.out.println(nome + " Fazendo coisa rapida");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(nome + " Dando descarga");
        System.out.println(nome + " Lavando Mao");
        System.out.println(nome + " Saindo do banheiro");
      }
    }

    public void fazNumero2() {

        String nome = Thread.currentThread().getName();


      synchronized(this) {
        System.out.println(nome + " Entrando no banheiro");
        System.out.println(nome + " Fazendo coisa demorada");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nome + " Dando descarga");
        System.out.println(nome + " Lavando Mao");
        System.out.println(nome + " Saindo do banheiro");
      }

    }
    
}
