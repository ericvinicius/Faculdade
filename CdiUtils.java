package exeIntegrados;

import javax.swing.JOptionPane;

public class CdiUtils {

	public String getFuncao() {
		String texto = "";
		for (int i = 0; i < VetorUtils.vetor.length; i++) {
			int elevado = VetorUtils.vetor.length - i;

			if (VetorUtils.vetor[i] > 0 && i != 0) {
				texto += " + ";
			}

			if (elevado == 1) {
				texto += VetorUtils.vetor[i] + "x";
			} else {
				texto += VetorUtils.vetor[i] + "x^" + elevado;
			}

		}

		return texto;
	}

	public String getDerivada() {
		String texto = "";
		int[] derivadaVet = new int[VetorUtils.vetor.length];
		for (int i = 0; i < VetorUtils.vetor.length; i++) {
			int elevado = (VetorUtils.vetor.length - i) - 1;
			derivadaVet[i] = VetorUtils.vetor[i] * elevado;

			if (elevado != 0) {
				if (VetorUtils.vetor[i] > 0 && i != 0) {
					texto += " + ";
				}

				if (elevado == 1) {
					texto += derivadaVet[i] + "x";
				} else {
					texto += derivadaVet[i] + "x^" + elevado + " ";
				}
			}
		}
		return texto;
	}

	public void funcao() {
		JOptionPane.showMessageDialog(null, "Funcao: " + getFuncao());
	}

	public void derivada() {
		JOptionPane.showMessageDialog(null, "Derivada: " + getDerivada());
	}
}
