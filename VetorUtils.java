package exeIntegrados;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class VetorUtils {
	
	public static int[] vetor = new int[10];
	
	public VetorUtils(){
	}
	
	public void dimensiona(){
		int tam = Integer.parseInt(JOptionPane
				.showInputDialog("Digite o tamnho do valor"));
		vetor = new int[tam];
	}

	public void digita() {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o valor do vetor na posicao "
							+ i));
		}
	}

	public void apresenta() {
		String texto = "Vetor:";
		JOptionPane.showMessageDialog(null,
				texto + " " + Arrays.toString(vetor));
	}

}
