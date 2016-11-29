package auxiliares;

public class MostraProduto {
	private Long id;
	private int quantidade;
	private double preco;
	private double precoBase;
	private String nome;
	
	
	
	public MostraProduto(Long id, int quantidade, double precoBase, String nome) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.preco = precoBase * quantidade;
		this.precoBase = precoBase;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPrecoBase() {
		return precoBase;
	}

	public void setPrecoBase(double precoBase) {
		this.precoBase = precoBase;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
