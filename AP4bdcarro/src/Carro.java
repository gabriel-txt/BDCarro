package src;

import java.io.Serializable;

public class Carro implements Serializable {
    private static int contadorCarros = 0;
    private int id;
    private String marca;
    private String modelo;
    private String cor;

    public Carro(String marca, String modelo, String cor) {
        this.id = contadorCarros++;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void mostraCarro(){
        System.out.printf("Carro %d: [Marca: %s] [Modelo: %s] [Cor: %s]\n", this.getId(), this.getMarca(), this.getModelo(), this.getCor());
    }
}
