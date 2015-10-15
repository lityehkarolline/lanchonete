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
@Table(name="tb_compra")
public class Compra implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCompra;
	private Date dataCompra;
	
	@OneToMany(mappedBy="compra")
	private List<ItemDeCompra> itensDeCompra;
	
	@ManyToOne
	@JoinColumn(name="funcionario")
	private Funcionario funcionario;

	public Compra() {
		setItensDeCompra(new ArrayList<>());
	}

	public Compra(Integer codCompra, Date dataCompra, Funcionario funcionario) {
		super();
		this.codCompra = codCompra;
		this.dataCompra = dataCompra;
		this.funcionario = funcionario;
		setItensDeCompra(new ArrayList<>());
	}

	public Integer getCodCompra() {
		return codCompra;
	}

	public void setCodCompra(Integer codCompra) {
		this.codCompra = codCompra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItemDeCompra> getItensDeCompra() {
		return itensDeCompra;
	}

	public void setItensDeCompra(List<ItemDeCompra> itensDeCompra) {
		this.itensDeCompra = itensDeCompra;
	}

	public void addItemDeCompra(ItemDeCompra x) {
		itensDeCompra.add(x);
	}

	public void removeItemDeCompra(ItemDeCompra x) {
		itensDeCompra.remove(x);
	}
	
	@Override
	public String toString() {
		return "Compra [codCompra=" + codCompra + ", dataCompra=" + dataCompra + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCompra == null) ? 0 : codCompra.hashCode());
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
		Compra other = (Compra) obj;
		if (codCompra == null) {
			if (other.codCompra != null)
				return false;
		} else if (!codCompra.equals(other.codCompra))
			return false;
		return true;
	}

	// Metodo "+ totalDaCompra() : BigDecimal"

	public BigDecimal totalDaCompra() {
		  BigDecimal soma = new BigDecimal("0.00");
	        
	      for(int i = 0; i < itensDeCompra.size(); i++){
	           soma = soma.add(itensDeCompra.get(i).subTotalCompra());
	      }
	      
	      return soma; 
	}


}
