package packsuper;

public class Article {
	
	static final Integer[] tabTVA = new Integer[] {550, 2000};
	
	private long codeBarre;
	private String reference;
	private String libelle;
	private int prixHT;
	private int tauxTVA;
	
			
	public Article(long codeBarre, String reference, String libelle, int prixHT, int tauxTVA) {
		super();
		this.codeBarre = codeBarre;
		this.reference = reference;
		this.libelle = libelle;
		this.prixHT = prixHT;
		this.tauxTVA = tauxTVA;
	}


	public long getCodeBarre() {
		return codeBarre;
	}


	public String getReference() {
		return reference;
	}


	public String getLibelle() {
		return libelle;
	}


	public int getPrixHT() {
		return prixHT;
	}


	public int getTauxTVA() {
		return tauxTVA;
	}


	public int getTVA() {
		return tabTVA[this.tauxTVA];
	}
	
	
	// Méthodes pour faciliter mise en forme
	
	// Prix HT en Euros
	public float getPrixHTf() {
		float pht = this.getPrixHT(); 
		return pht/100; 
	}
	
	// TVA au format 0,###
	public float getTVAf() {
		float tva = this.getTVA(); 
		return tva/10000; 
	}
	
	// Prix TTC en Euros
	public float getPrixTTC() {
		float pht = this.getPrixHT(); 
		float tvaf = this.getTVAf();
		return pht*(1+tvaf)/100; 
	}
	
	// Montant HT en Euros (Prix HT * quantité)
	public float getMontantHT(int qte) {
		float pht = this.getPrixHTf(); 
		return pht*qte; 
	}
	
	// Montant TTC en Euros (Prix TTC * quantité)
	public float getMontantTTC(int qte) {
		float pttc = this.getPrixTTC(); 
		return pttc*qte; 
	}
	
		
}