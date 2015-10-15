package dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codPedido;
	private Date dataPedido;
	
	@ManyToOne
	@JoinColumn(name="funcionario")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy="pedido")
	private List<ItemDePedido> itensDePedido;
	
	public Pedido() {
		this.itensDePedido = new ArrayList<ItemDePedido>();
	}

	public Pedido(Integer codPedido, Date dataPedido, Funcionario funcionario) {
		super();
		this.codPedido = codPedido;
		this.dataPedido = dataPedido;
		this.funcionario = funcionario;
		this.itensDePedido = new ArrayList<ItemDePedido>();
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		return "Pedido [codPedido=" + codPedido + ", dataPedido=" + dataPedido + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPedido == null) ? 0 : codPedido.hashCode());
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
		Pedido other = (Pedido) obj;
		if (codPedido == null) {
			if (other.codPedido != null)
				return false;
		} else if (!codPedido.equals(other.codPedido))
			return false;
		return true;
	}
	
	// Metodo "+ totalDoPedido() : BigDecimal"
	
	public BigDecimal totalDoPedido() {
		
		  BigDecimal soma = new BigDecimal("0.00");
	        
	      for(int i = 0; i < itensDePedido.size(); i++){
	           soma = soma.add(itensDePedido.get(i).subTotal());
	      }
	      
	      return soma; 
	       
	}
	
	
	
	
	

}
