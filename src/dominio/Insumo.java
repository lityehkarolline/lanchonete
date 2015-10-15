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
@Table(name="tb_insumo")
public class Insumo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codItemDeCompra;
	private String nome;
	private String unidadeDeMedida;
	private BigDecimal preco;
	
	@OneToMany(mappedBy="insumo")
	private List<ItemDeCompra> itensDeCompra;
	
	public Insumo() {
		setItensDeCompra(new ArrayList<>());
	}

	public Insumo(Integer codItemDeCompra, String nome, String unidadeDeMedida, BigDecimal preco) {
		super();
		this.codItemDeCompra = codItemDeCompra;
		this.nome = nome;
		this.unidadeDeMedida = unidadeDeMedida;
		this.preco = preco;
		setItensDeCompra(new ArrayList<>());
	}

	public Integer getCodItemDeCompra() {
		return codItemDeCompra;
	}

	public void setCodItemDeCompra(Integer codItemDeCompra) {
		this.codItemDeCompra = codItemDeCompra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public List<ItemDeCompra> getItensDeCompra() {
		return itensDeCompra;
	}

	public void setItensDeCompra(List<ItemDeCompra> itensDeCompra) {
		this.itensDeCompra = itensDeCompra;
	}

	public void addItemDeCompra(ItemDeCompra x){
		this.itensDeCompra.add(x);
	}
	
	public void removeItemDeCompra(ItemDeCompra x){
		this.itensDeCompra.remove(x);
	}

	@Override
	public String toString() {
		return "ItemDeCompra [codItemDeCompra=" + codItemDeCompra + ", nome=" + nome + ", unidadeDeMedida="
				+ unidadeDeMedida + ", preco=" + preco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemDeCompra == null) ? 0 : codItemDeCompra.hashCode());
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
		Insumo other = (Insumo) obj;
		if (codItemDeCompra == null) {
			if (other.codItemDeCompra != null)
				return false;
		} else if (!codItemDeCompra.equals(other.codItemDeCompra))
			return false;
		return true;
	}

	
	
	

}
