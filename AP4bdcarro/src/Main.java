package src;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static String escolheDir(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int option = fileChooser.showOpenDialog(null); // Abre a janela de seleção
        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String directoryPath = selectedDirectory.getAbsolutePath();
            return directoryPath;
        } else {
            System.out.println("Nenhum diretório selecionado.");
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        //ArrayList<Carro> bdcarros = new ArrayList<Carro>();
        Carro carro1 = addCarro();
        File dir = new File(escolheDir());
        serCarro(carro1, dir);
        desserCarro(dir);
    }

    public static void serCarro(Carro carro, File dir){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(dir, true);
            if (dir.length() == 0) {
                oos = new ObjectOutputStream(fos);
            } else {
                oos = new AppendableObjectOutputStream(fos);
            }
            oos.writeObject(carro);

        } catch (FileNotFoundException e){
            System.out.println("ERRO: Arquivo não encontrado!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERRO: Erro na criação do arquivo!");
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    fos.close();
                    oos.close();
                } catch (IOException e) {
                    System.out.println("ERRO: Erro para fechar o arquivo!");
                }
            }
        }
    }

    public static void desserCarro(File dir){
        Carro carro = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(dir);
            ois = new ObjectInputStream(fis);
            while (true) {
                try {
                    carro = (Carro) ois.readObject(); // Lê um objeto por vez
                    carro.mostraCarro();
                } catch (EOFException e) {
                    break; // Fim do arquivo
                }
            }
        } catch (ClassNotFoundException e){
            System.out.println("ERRO: Classe não encontrado!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERRO: Erro na leitura do arquivo!");
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    fis.close();
                    ois.close();
                } catch (IOException e) {
                    System.out.println("ERRO: Erro para fechar o arquivo!");
                }
            }
        }
    }

    public static Carro addCarro(){
        String marcaCarro = JOptionPane.showInputDialog(null, "Marca do carro:");
        String modeloCarro = JOptionPane.showInputDialog(null, "Modelo do carro:");
        String corCarro = JOptionPane.showInputDialog(null, "Cor do carro:");
        Carro carro = new Carro(marcaCarro, modeloCarro, corCarro);
        return carro;
    }
}