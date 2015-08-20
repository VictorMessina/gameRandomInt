package lp2_03h_lab2;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cacique
 */
public class MainGame {
    
    private Gamer gamer;
    private int randomInt;
    private File file;
    
    public MainGame(){
        //Leitura do nome do jogador
        String name = IOManager.readKey("Qual seu nome?");
        
        //Cria um arquivo para leitura.
        //Caso não exista, cria um novo.
        file = new File("scoreData_"+name+".txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
                gamer = new Gamer(name,0,0);
            } catch (IOException ex) {
                Logger.getLogger(MainGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Lê o objeto Gamer serializado
            gamer = IOManager.readGamer(file);
        }
        gamer.setCurrent_score(0);
        
        //Apresenta os dados do jogador
        System.out.println("---------------");
        System.out.println("Gamer: "+gamer.getName());
        System.out.println("Max: "+gamer.getMax_score());
        System.out.println("Last: "+gamer.getLast_score());
        System.out.println("---------------");
        
        //Loop do jogo - enquanto o jogador responder S ou s
        //Não tratamos o N ou n, assim, qualquer coisa diferente de S ou s será a negativa
        //TODO: validar N ou n
        boolean cont = true;
        do{
            String resp = IOManager.readKey("Quer jogar? (S/N)");
            if(resp.equalsIgnoreCase("S")){
                gameLoop();
            } else {
                cont = false;
            }
        } while(cont);
        
        //Caso o jogador decida terminar o jogo, perguntar se ele quer salvar
        String resp2 = IOManager.readKey("Quer salvar o seu jogo? (S/N)");
        if(resp2.equalsIgnoreCase("s")){
            //Troca a última pontuação pela atual
            gamer.setLast_score( gamer.getCurrent_score() );
            //Verifica se é maior que a máxima
            if(gamer.getCurrent_score() > gamer.getMax_score()) gamer.setMax_score(  gamer.getCurrent_score());
            
            //Salva o jogo
            IOManager.writeGamer(gamer, file);
            System.out.println("Seu jogo foi salvo com sucesso!");
        }
        System.out.println("TCHAU!");
        
    }
    
    public void gameLoop()
    {
        //Gera um número aleatório
        randomInt = randomize(0,10);
        
        //System.out.println("número gerado: "+randomInt);
        
        //Pergunta ao usuário um número para comparação
        //TODO: tratar excessão de valo não inteiro
        int gamerInt = Integer.parseInt(IOManager.readKey("Adivinha meu número (0-10)!"));
        
        //Compara os dois números
        if(gamerInt == randomInt) {
            gamer.incrementScore();
            System.out.println("Ok!");
        } else {
            System.out.println("Você perdeu!");
        }
        System.out.println("Você tem: "+gamer.getCurrent_score()+" pontos!");
    }
    
    /**
     * Gera um número aleatório no intervalo [min,max)
     * @param min menor valor do intervalo
     * @param max maior valor do intervalo
     * @return inteiro aleatório no intervalo
     */
    public int randomize(int min, int max){
        return (int)(min + Math.random() * (max - min +1));
    }
    
}
