package dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codFuncionario;
	private String nome;
	private Date dataNascimento;
	private String endereco;
	private String telefone;
	private String login;
	private String senha;
	
	@OneToMany(mappedBy="funcionario")
	private List<Compra> compras;
	
	@OneToMany(mappedBy="funcionario")
	private List<Pedido> pedidos;
	
	public Funcionario() {
		this.compras = new ArrayList<Compra>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public Funcionario(Integer codFuncionario, String nome, Date dataNascimento, String endereco, String telefone,
			String login, String senha) {
		super();
		this.codFuncionario = codFuncionario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		this.compras = new ArrayList<Compra>();
		this.pedidos = new ArrayList<Pedido>();
	}
	
	
	public Integer getCodFuncionario() {
		return codFuncionario;
	}

	public void setCodFuncionario(Integer codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	
	

	public void addPedido(Pedido x){
		this.pedidos.add(x);
	}
	
	public void removePedido(Pedido x){
		this.pedidos.remove(x);
	}
	
	
	
	public void addCompra(Compra x){
		this.compras.add(x);
	}
	
	public void removeCompra(Compra x){
		this.compras.remove(x);
	}

	@Override
	public String toString() {
		return "Funcionario [codFuncionario=" + codFuncionario + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", endereco=" + endereco + ", telefone=" + telefone + ", login=" + login + ", senha=" + senha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codFuncionario == null) ? 0 : codFuncionario.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (codFuncionario == null) {
			if (other.codFuncionario != null)
				return false;
		} else if (!codFuncionario.equals(other.codFuncionario))
			return false;
		return true;
	}
	
	
}
