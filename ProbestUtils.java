package exeIntegrados;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class ProbestUtils {
	private int somaVet = 0;

	public ProbestUtils() {
		for (int i = 0; i < VetorUtils.vetor.length; i++) {
			somaVet += VetorUtils.vetor[i];
		}
	}

	public void media() {
		JOptionPane.showMessageDialog(null, "Media: " + getMedia());
	}
	
	public double getMedia() {
		return somaVet / VetorUtils.vetor.length;
	}

	public void desvioPadrao() {
		JOptionPane.showMessageDialog(null,
				"Desvio Padrao: " + getDesvioPadrao());
	}
	
	public double getDesvioPadrao() {
		 return Math.sqrt(getVariancia());
	}

	public void variancia() {
		JOptionPane.showMessageDialog(null, "Variancia: " + getVariancia());
	}

	public double getVariancia() {
		int variancia = 0; 
		
		for(int i = 0; i < VetorUtils.vetor.length; i++){
			double temp = VetorUtils.vetor[i] - getMedia();
			variancia += Math.pow(temp, 2);
		}
		return variancia / VetorUtils.vetor.length;
	}

	public void ordenar() {
		Arrays.sort(VetorUtils.vetor);

	}

	public void mediana() {
		this.ordenar();
		int tipo = VetorUtils.vetor.length % 2;
		double saida;
		
		if (tipo == 1) {
			saida = VetorUtils.vetor[((VetorUtils.vetor.length + 1) / 2) - 1];
		} else {
			int m = VetorUtils.vetor.length / 2;
			saida = (VetorUtils.vetor[m - 1] + VetorUtils.vetor[m]) / 2;
		}
		
		JOptionPane.showMessageDialog(null, "Mediana: " + saida);
	}
	
	public void coefAssimetria(){
		JOptionPane.showMessageDialog(null, "Coef. de Assimetria: " + getCoefAssimetria());
	}

	public double getCoefAssimetria() {
		double coef = 0;
		for(int i = 0; i < VetorUtils.vetor.length; i++){
			double temp = VetorUtils.vetor[i] - getMedia();
			coef += Math.pow(temp, 3);
		}
		return coef / (VetorUtils.vetor.length * getDesvioPadrao());
	}
	
	public void coefVariancia(){
		JOptionPane.showMessageDialog(null, "Coef. de Variancia: " + getCoefVariancia());
	}

	public double getCoefVariancia() {
		return 100 * (getDesvioPadrao() / getMedia());
	}
}