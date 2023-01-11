// import javax.swing.*;
// import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.Color;
import javax.swing.JFrame;

import java.util.Random;
import java.util.Scanner;

public class fo extends JFrame{
    String palavraChave = "bicicleta";
    String letrasUsada = "";
    String num1 = "pou";
    String num4 = "oi";
    String lUtilizadas = ""; 
    int num3 = 0;
    String dica = "";
    Scanner input= new Scanner(System.in);
    // Integer soma;
    String num2, palavraAdivinhada = "";
    int MaxTentativas = 20;
    // int tentativas = 0;
    int sair,soma = 0;
    Scanner digite = new Scanner(System.in);
    Random random = new Random();

    public fo(){
       
         palpite();
  
    }
// class que ira comparar a letra digitada com apalavra
    public void palpite(){
    //  se ja tiver um rendom nao serar sorteado um novo
        if(num4 == num1){
            num1 = num4;
          //se ñ tiver um random ira sortear um valor aleatorio
          }else{
            num3 = random.nextInt(90);
            num1 = num4;
          // medio
        }
        // :array contendo as palavras
        String[] palavras = { 
            //tecnologia = 31
            "java", "internet", "computador", "algoritimo", "constante", "recorde", "processador", "atividade", "rede","sistema", "arquivo", "classe", "unidade",  "data","html","css",
                  "tecnologia", "arquitetura", "engenharia", "software", "energia", "massa", "velocidade", "vazio","pesquisa","paradoxo",  "tela", "teclado", "celular","nuvem", "python", 
                  //geografia = 30
                "país",	"capital",	"continente","belgica",	"bruxelas"	, "belize",  "afeganistão"	,"cabul","grecia",  "africa"	,"pretória"	,"africa", "albânia","airana","auropa", "asia",
                "alemanha"	,"aerlim",	  "andorra"	,"andorra-a-velha	", "angola","america",  "teresina",	"iade","japao", "argélia","Argel","argentina"	,"piaui", "arménia","arevã",
                    // times = 30
                  "altos",    "athletico-pr",  "atlético-mn", "bahia", "boavista", "botafogo", "bragantino", "chapecoense", "corinthians","cruzeiro", "flamengo", "fluminense", "fortaleza","gremio"
                   ,"internacional", "ituano" ,  "juventude",  "londrina", "luverdense" ,   "operário" , "palmeira", "psg","portuguesa",   "remo","river",   "santos","barcelona" , "sport","vasco","vitoria"
                  };
                //   junto com random sortea um numero aleatorio que ira indicar a posicao da palavra
                String palavra = palavras[num3];
                // se for menor que 30 vai esta nas tecnologias
                if(num3<30){
                    dica = "tecnologia";
                    //se for menor que 60 vai esta nas geografia
                }else if(num3 <60){
                    dica = "geografia";
                    //se for menor que 90 vai esta nas times
             }else if(num3 <90){
                dica = "times";
         }


        for (int i = 0; i < palavra.length();){
            palavraAdivinhada +="_";
            ++soma;
            for(int tentativas = 0; ; tentativas++){
                erros();
                // depois do boneco apresentar todas as partes o jogador perde
                if(sair == MaxTentativas){
                    System.out.printf(" A palavra era '%s", palavra);
                    System.out.printf("A sua burrice fez com que um inocente morrece.");
                    System.out.printf("\n1 - para continuar: ");
                    System.out.printf("2 - para sair:\n ");
                    int op1 = input.nextInt();
                    int op2 =1;
                    // se o jogador clicar 1 ira serar
                    if(op1 == op2){
                        soma=0;
                        palavraChave="";
                        palavraAdivinhada="";
                        letrasUsada = "";
                        tentativas = 0;
                        num1 = "10002";
                        num4 = "12";
                        sair = 1;
                        lUtilizadas="";
                        palpite();
                    }else{
                    System.exit(0);}
                }erros();
                if(num3<29){
                  dica = "tecnologia";}
                System.out.printf("\n %s   \n", palavraAdivinhada);
                System.out.printf(" %s   \n" + "Letras usadas %s\n", dica,lUtilizadas);
                System.out.printf("\nRodada %d.Qual a sua próxima letra? ", tentativas);
                // String letraTentada = num2;
                // pega o codigo fonte da letra e compara com as letras da palavra sorteada
                char letraTentada ;
                // String letraTentada = letraTentada1.toUpperCase();
                letraTentada = input.next().charAt(0);
                lUtilizadas += " " + letraTentada; 
                // verifica se a letra digitada ja foi inserida antes
                if(letrasUsada.indexOf(letraTentada)>= 0){
                    System.out.printf(" Você ja tentou a letra %c.%n", letraTentada);
                    // se a letra inserida for nova ela vai procurar essa letra na palavra de uma-a-uma
                }else{
                    letrasUsada += letraTentada;
                    if(palavra.indexOf(letraTentada)>= 0){
                        palavraAdivinhada = "";
                        // nas espacos q a letra for igual ao elemento digitado ela substitui pala propria letra
                        // o que nao for igual ela substitui por um "_"
                        for(int j = 0; j < palavra.length(); j++){
                            palavraAdivinhada+= letrasUsada.indexOf(palavra.charAt(j)) >= 0 ? palavra.charAt(j): "_";
                        }
                        if(palavraAdivinhada.contains("_")){
                            System.out.printf("Muito bom! %s  existe na palavra. Ainda tem letras escondidas", letraTentada);
                            // se o jogador acerta o palpite
                        }else{
                            System.out.printf("Parabens! A palavra adivinhada era '%s'", palavra);
                            // System.exit(0);
                            System.out.printf("\n1 - para continuar: ");
                            System.out.printf("2 - para sair:\n ");
                            int op1 = input.nextInt();
                            int op2 =1;
                            // opcoes para continuar ou encerrar o jogo
                            if(op1 == op2){
                                soma=0;
                                palavraChave="";
                                letrasUsada = "";
                                letraTentada=0;
                                palavraAdivinhada="";
                                tentativas = 0;
                                num1 = "10002";
                                num4 = "12";
                                sair = 1;
                                lUtilizadas="";
                                palpite();
                            }else{
                            System.exit(0);}
                                }
                            }else{
                        // erros();
                        System.out.printf("Infelizmente a letra %c não existe na palavra.", letraTentada);
                        ++soma;
                    }
                }
            }
        }
    }
    public void erros(){
        // inicia a forca
        
        if(soma == 1){
            System.out.println("\n      ________" + 
                               "\n     |        |" + 
                               "\n     |"+ 
                               "\n     | "+ 
                               "\n     | "+ 
                               "\n    _|_ \n");
            // caso erre uma letra
        }else if(soma ==2){
            System.out.println("\n      ________" + 
                               "\n     |        |" + 
                               "\n     |        O"+ 
                               "\n     | "+ 
                               "\n     | "+ 
                               "\n    _|_ \n");
                            //    caso erre 2 letras
        }else if(soma ==3){
            System.out.println("\n      ________" + 
                               "\n     |        |" + 
                               "\n     |        O"+ 
                               "\n     |        |"+ 
                               "\n     | "+ 
                               "\n    _|_  \n");
                            //    caso erre 3 letras
        }else if(soma ==4){
            System.out.println("\n      ________" + 
                               "\n     |        |" + 
                               "\n     |        O"+ 
                               "\n     |       /|"+ 
                               "\n     | "+ 
                               "\n    _|_  \n ");
                            //    caso erre 4 letras
        }else if(soma ==5){
            System.out.printf("\n       ________" + 
                               "\n     |        |" + 
                               "\n     |        O"+ 
                               "\n     |       /|\\"+ 
                               "\n     | "+ 
                               "\n    _|_  \n");
                               //    caso erre 5 letras
        }else if(soma ==6){
            System.out.printf("\n       ________" + 
                               "\n     |        |" + 
                               "\n     |        O"+ 
                               "\n     |       /|\\"+ 
                               "\n     |       / "+ 
                               "\n    _|_  \n");
                               //    caso erre 6 letras
        }else if(soma ==7) {
            // sair vai se igual ao maximo de tentativas
            sair =20;
            System.out.printf("\n       ________" + 
                               "\n     |        |" + 
                               "\n     |        O"+ 
                               "\n     |       /|\\"+ 
                               "\n     |       / \\"+ 
                               "\n    _|_  \n");
                               
       
            
        }
    }
    

    public static void main(String[] args) throws Exception {
        // digitar numero
        new fo();
        
        // for  (int i=0; i < 9; i++){
        //     if (click[i] == true){
        //         cont++;
        // }
        
       


    }
    
}
