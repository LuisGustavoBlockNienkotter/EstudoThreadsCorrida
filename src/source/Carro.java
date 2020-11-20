package source;

import java.util.Random;

public class Carro extends Thread{
	private String nome;
	private int distanciaPercorrida = 0;
	private Corrida corrida;

	public Carro(Corrida corrida, String nome) {
		super();
		this.nome = nome;
		this.corrida = corrida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}
	
	public Corrida getCorrida() {
		return corrida;
	}

	public void setCorrida(Corrida corrida) {
		this.corrida = corrida;
	}

	public void correr(int distancia) {
		this.distanciaPercorrida += distancia;
	}
	
	public void resetDistanciaPercorrida() {
		this.distanciaPercorrida = 0;
	}
	
	@Override
    public void run() {
        System.out.println(this.nome + " distancia inicial: " + this.distanciaPercorrida);
        
        Random random = new Random();
        boolean acidente = false;
        
        while ((this.distanciaPercorrida < this.corrida.getDistancia()) && !acidente) {
        	this.correr(1);
        	
        	if (random.nextInt(100) > 98) {
				acidente = true;
			}
        	
        	System.out.println(this.nome + " distancia atual: " + this.distanciaPercorrida);
        }
        
        if (!acidente) {
        	this.corrida.setCampeao(this);
		} else {
			System.out.println(this.nome + " sofreu um acidente, mas correu até: " + this.distanciaPercorrida);
		}
        
    }
	
}
