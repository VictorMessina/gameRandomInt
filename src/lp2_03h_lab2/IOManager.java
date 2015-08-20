package lp2_03h_lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cacique
 */
public class IOManager {
    
    /**
     * Método de leitura via teclado
     * @param instruction frase a ser apresentada antes da leitura
     * @return string lida
     */
    public static String readKey(String instruction)
    {
        String result = "";
        System.out.println(instruction);
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        
        try {
            result = br.readLine();
        } catch (IOException ex) {
            result = "Deu ruim na leitura!";
            Logger.getLogger(IOManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    /**
     * Escreve um objeto Gamer serializado em um arquivo txt
     * @param gamer objeto a ser serializado
     * @param file arquivo destino
     */
    public static void writeGamer(Gamer gamer, File file){
        
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gamer);
            oos.close();
            fos.close();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    
    /**
     * Método de leitura de um objeto Gamer serializado em um arquivo txt
     * @param file
     * @return 
     */
    public static Gamer readGamer(File file){
        Gamer gamer = null;
        
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            gamer = (Gamer) ois.readObject();
            ois.close();
            fis.close();
        } catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        
        return gamer;
    }
    
}
