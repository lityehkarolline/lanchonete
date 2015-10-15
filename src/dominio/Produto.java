package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codProduto;
	private String nome;
	private BigDecimal preco;
	private String descricao;
	
	@OneToMany(mappedBy="produto") //leva o nome da variavel da classe *
	private List<ItemDePedido> itensDePedido;
	
	public Produto() {
		this.itensDePedido = new ArrayList<ItemDePedido>();
	}

	public Produto(Integer codProduto, String nome, BigDecimal preco, String descricao) {
		super();
		this.codProduto = codProduto;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.itensDePedido = new ArrayList<ItemDePedido>();
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ItemDePedido> getItensDePedido() {
		return itensDePedido;
	}

	public void setItensDePedido(List<ItemDePedido> itensDePedido) {
		this.itensDePedido = itensDePedido;
	}
	
	
	
	public void addItemDePedido(ItemDePedido x){
		this.itensDePedido.add(x);
	}
	
	public void removeItemDePedido(ItemDePedido x){
		this.itensDePedido.remove(x);
	}

	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProduto == null) ? 0 : codProduto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codProduto == null) {
			if (other.codProduto != null)
				return false;
		} else if (!codProduto.equals(other.codProduto))
			return false;
		return true;
	}
	
	
	

}
