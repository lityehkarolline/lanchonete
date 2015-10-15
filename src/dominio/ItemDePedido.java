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
@Table(name="tb_itemdepedido")
public class ItemDePedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer codItemDoPedido;
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name="pedidos")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="produto") // incherga o vinculo com a clase produto
	private Produto produto;
	
	public ItemDePedido() {
		
	}

	public ItemDePedido(Integer codItemDoPedido, Integer quantidade, Pedido pedido, Produto produto) {
		super();
		this.codItemDoPedido = codItemDoPedido;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Integer getCodItemDoPedido() {
		return codItemDoPedido;
	}

	public void setCodItemDoPedido(Integer codItemDoPedido) {
		this.codItemDoPedido = codItemDoPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Override
	public String toString() {
		return "ItemDePedido [codItemDoPedido=" + codItemDoPedido + ", quantidade=" + quantidade + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codItemDoPedido == null) ? 0 : codItemDoPedido.hashCode());
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
		ItemDePedido other = (ItemDePedido) obj;
		if (codItemDoPedido == null) {
			if (other.codItemDoPedido != null)
				return false;
		} else if (!codItemDoPedido.equals(other.codItemDoPedido))
			return false;
		return true;
	}


	// Metodo "+ subTotal() : BigDecimal"

	public BigDecimal subTotal() {
		
		return produto.getPreco().multiply( new BigDecimal(quantidade));
		
	}
	

}
