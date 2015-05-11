package exeIntegrados;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Tela extends JFrame implements ActionListener, MenuListener {
	

	private JMenu menuOrdenacao;
	private JMenu menuBusca;
	private JMenuItem itemDimensiona;
	private JMenuItem itemDigita;
	private JMenuItem itemApresenta;
	private JMenuItem itemMedia;
	private JMenuItem itemDesvioPadrao;
	private JMenuItem itemVariancia;
	private JMenuItem itemMediana;
	private JMenuItem itemCoefAssimetria;
	private JMenuItem itemCoefVariancia;
	private JMenuItem itemFuncao;
	private JMenuItem itemDerivada;
	private JMenuItem itemTrocas;
	private JMenuItem itemSelecao;
	private JMenuItem itemInsercao;
	private JMenuItem itemQuick;
	private JMenuItem itemMerge;
	private JMenuItem itemLinearIterativa;
	private JMenuItem itemLinearRecursiva;
	private JMenuItem itemBinariaIterativa;
	private JMenuItem itemBinariaRecursiva;

	private JMenu itemSair;

	public Tela() {
		configuraJanela();
		JMenuBar menuBarra = new JMenuBar();
		setJMenuBar(menuBarra);

		// Menu Vetor
		JMenu menuVet = new JMenu("Vetor");

		itemDimensiona = new JMenuItem("Dimensiona");
		itemDimensiona.addActionListener(this);
		menuVet.add(itemDimensiona);

		itemDigita = new JMenuItem("Digita");
		itemDigita.addActionListener(this);
		menuVet.add(itemDigita);

		itemApresenta = new JMenuItem("Apresenta");
		itemApresenta.addActionListener(this);
		menuVet.add(itemApresenta);

		menuBarra.add(menuVet);

		// Menu PROBEST
		JMenu menuPro = new JMenu("PROBEST");

		itemMedia = new JMenuItem("Media");
		itemMedia.addActionListener(this);
		menuPro.add(itemMedia);

		itemDesvioPadrao = new JMenuItem("Desvio Padrao");
		itemDesvioPadrao.addActionListener(this);
		menuPro.add(itemDesvioPadrao);

		itemVariancia = new JMenuItem("Variancia");
		itemVariancia.addActionListener(this);
		menuPro.add(itemVariancia);

		itemMediana = new JMenuItem("Mediana");
		itemMediana.addActionListener(this);
		menuPro.add(itemMediana);

		itemCoefAssimetria = new JMenuItem("Coef. Assimetria");
		itemCoefAssimetria.addActionListener(this);
		menuPro.add(itemCoefAssimetria);

		itemCoefVariancia = new JMenuItem("Coef. Variancia");
		itemCoefVariancia.addActionListener(this);
		menuPro.add(itemCoefVariancia);

		menuBarra.add(menuPro);

		// Menu CDI
		JMenu menuCdi = new JMenu("CDI");

		itemFuncao = new JMenuItem("Funcao");
		itemFuncao.addActionListener(this);
		menuCdi.add(itemFuncao);

		itemDerivada = new JMenuItem("Derivada");
		itemDerivada.addActionListener(this);
		menuCdi.add(itemDerivada);

		menuBarra.add(menuCdi);

		// Menu ALGED
		JMenu menuAlged = new JMenu("ALGED");

		// Menu Ordenacao
		menuOrdenacao = new JMenu("Ordenacao");

		itemTrocas = new JMenuItem("Trocas");
		itemTrocas.addActionListener(this);
		menuOrdenacao.add(itemTrocas);

		itemSelecao = new JMenuItem("Selecao");
		itemSelecao.addActionListener(this);
		menuOrdenacao.add(itemSelecao);

		itemInsercao = new JMenuItem("Insercao");
		itemInsercao.addActionListener(this);
		menuOrdenacao.add(itemInsercao);

		itemQuick = new JMenuItem("Quick");
		itemQuick.addActionListener(this);
		menuOrdenacao.add(itemQuick);

		itemMerge = new JMenuItem("Merge");
		itemMerge.addActionListener(this);
		menuOrdenacao.add(itemMerge);

		menuAlged.add(menuOrdenacao);

		// Menu Busca
		menuBusca = new JMenu("Busca");

		itemLinearIterativa = new JMenuItem("Linear Iterativa");
		itemLinearIterativa.addActionListener(this);
		menuBusca.add(itemLinearIterativa);

		itemLinearRecursiva = new JMenuItem("Linear Recursiva");
		itemLinearRecursiva.addActionListener(this);
		menuBusca.add(itemLinearRecursiva);

		itemBinariaIterativa = new JMenuItem("Binaria Iterativa");
		itemBinariaIterativa.addActionListener(this);
		menuBusca.add(itemBinariaIterativa);

		itemBinariaRecursiva = new JMenuItem("Binaria Recursiva");
		itemBinariaRecursiva.addActionListener(this);
		menuBusca.add(itemBinariaRecursiva);

		menuAlged.add(menuBusca);
		
		menuBarra.add(menuAlged);
		
		itemSair = new JMenu("Sair");
		itemSair.addMenuListener(this);
		menuBarra.add(itemSair);

	}

	private void configuraJanela() {
		setLayout(null);
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		
		VetorUtils vetorUtils = new VetorUtils();
		ProbestUtils probestUtils = new ProbestUtils();
		CdiUtils cdiUtils = new CdiUtils();
		AlgedUtils algedUtils = new AlgedUtils();

		if (item == itemDimensiona) {
			vetorUtils.dimensiona();

		} else if (item == itemDigita) {
			vetorUtils.digita();

		} else if (item == itemApresenta) {
			vetorUtils.apresenta();

		} else if (item == itemMedia) {
			probestUtils.media();

		} else if (item == itemDesvioPadrao) {
			probestUtils.desvioPadrao();
			
		} else if (item == itemVariancia) {
			probestUtils.variancia();

		} else if (item == itemMediana) {
			probestUtils.mediana();

		} else if (item == itemCoefAssimetria) {
			probestUtils.coefAssimetria();

		} else if (item == itemCoefVariancia) {
			probestUtils.coefVariancia();

		} else if (item == itemFuncao) {
			cdiUtils.funcao();

		} else if (item == itemDerivada) {
			cdiUtils.derivada();

		} else if (item == itemTrocas) {
			algedUtils.bubbleSort();
			
		} else if (item == itemSelecao) {
			algedUtils.selectionSort();
			
		} else if (item == itemInsercao) {
			algedUtils.insertionSort();
			
		} else if (item == itemQuick) {
			algedUtils.quickSort();
			
		} else if (item == itemMerge) {
			algedUtils.mergeSort();
			
		} else if (item == itemLinearIterativa) {
			algedUtils.buscaLinearIterativa();
			
		} else if (item == itemLinearRecursiva) {
			algedUtils.buscaLinearRecursiva();
			
		} else if (item == itemBinariaIterativa) {
			algedUtils.buscaBinariaIterativa();
			
		} else if (item == itemBinariaRecursiva) {
			algedUtils.buscaBinariaRecursiva();
			
		} 
	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource() == itemSair){
			System.exit(0);
		}
		
	}

	@Override
	public void menuDeselected(MenuEvent e) {
	}

	@Override
	public void menuCanceled(MenuEvent e) {
	}
}
