package dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_itemdecompra")
public class ItemDeCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codItemDeCompra;
	private Double quantidade;
	
	@ManyToOne
	@JoinColumn(name="compra")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="insumo")
	private Insumo insumo;
	
	public ItemDeCompra() {
	}

	public ItemDeCompra(Integer codItemDeCompra, Double quantidade, Compra compra, Insumo insumo) {
		super();
		this.codItemDeCompra = codItemDeCompra;
		this.quantidade = quantidade;
		this.compra = compra;
		this.insumo = insumo;
	}

	public Integer getCodItemDeCompra() {
		return codItemDeCompra;
	}

	public void setCodItemDeCompra(Integer codItemDeCompra) {
		this.codItemDeCompra = codItemDeCompra;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	@Override
	public String toString() {
		return "ItemDeCompra [codItemDeCompra=" + codItemDeCompra + ", quantidade=" + quantidade + "]";
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
		ItemDeCompra other = (ItemDeCompra) obj;
		if (codItemDeCompra == null) {
			if (other.codItemDeCompra != null)
				return false;
		} else if (!codItemDeCompra.equals(other.codItemDeCompra))
			return false;
		return true;
	}
	
	public BigDecimal subTotalCompra() {

		/*BigDecimal x = new BigDecimal("5");
		BigDecimal y = new BigDecimal("3");
		int n = 3;
		
		BigDecimal z = x.multiply( new BigDecimal(n) );*/
		
		
		BigDecimal multiplicacao = insumo.getPreco().multiply(new BigDecimal(quantidade));
		
		BigDecimal arredondado = multiplicacao.setScale(2, BigDecimal.ROUND_HALF_UP);

		return arredondado;
	}
	
	
}
