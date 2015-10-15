package aplicacao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Compra;
import dominio.Funcionario;
import dominio.Insumo;
import dominio.ItemDeCompra;
import dominio.ItemDePedido;
import dominio.Pedido;
import dominio.Produto;

public class InstanciacaoDoBanco {
	
	public static void main(String args[]) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Funcionario f1 = new Funcionario(null, "Lia", sdf.parse("20/01/1994"), "Rua do Enfermeiro nº 55 Planalto", "(034)9944-3377", "lialanches", "123456");
		Funcionario f2 = new Funcionario(null, "Tito", sdf.parse("22/05/1992"), "Rua Anbros nº 44 Tibery", "(034)3377-8822", "titolanches", "123456");	
		
		Produto pro1 = new Produto(null, "X Tudo", new BigDecimal("15.00"), "Pão, Hambúrguer, Ovo, Bacon, Presunto, Mozarela, Salsicha, Queijo, Alface, Tomate, Maionese temperada");
		Produto pro2 = new Produto(null, "Cachorro Quente", new BigDecimal("7.00"), "Pão, salsicha, Molho,  Milho, Batata Palha");
		Produto pro3 = new Produto(null, "Suco Laranja", new BigDecimal("2.00"), "Del Valle caixinha 200ml");

		Pedido pe1 = new Pedido(null, sdf.parse("08/09/2015"), f1);
		Pedido pe2 = new Pedido(null, sdf.parse("27/08/2015"), f2);

		f1.addPedido(pe1);
		f2.addPedido(pe2);

		ItemDePedido ip1 = new ItemDePedido(null, 2, pe1, pro1);
		ItemDePedido ip2 = new ItemDePedido(null, 1, pe1, pro2);
		ItemDePedido ip3 = new ItemDePedido(null, 2, pe2, pro2);
		ItemDePedido ip4 = new ItemDePedido(null, 2, pe2, pro3);
		
		pe1.addItemDePedido(ip1);
		pe1.addItemDePedido(ip2);
		
		pe2.addItemDePedido(ip3);
		pe2.addItemDePedido(ip4);
		
		
		Insumo i1 = new Insumo(null, "Presunto", "Quilograma", new BigDecimal("25.00"));
		Insumo i2 = new Insumo(null, "Mozarela", "Quilograma", new BigDecimal("20.00"));
		Insumo i3 = new Insumo(null, "Suco de Caixinh", "Unidade", new BigDecimal("2.00"));
		
		Compra c1 = new Compra(null, sdf.parse("04/08/2015"), f2);
		Compra c2 = new Compra(null, sdf.parse("10/09/2015"), f1);
		Compra c3 = new Compra(null, sdf.parse("10/10/2015"), f1);
		
		f2.addCompra(c1);
		f1.addCompra(c2);
		f1.addCompra(c3);
	
		ItemDeCompra ic1 = new ItemDeCompra(null, 0.5, c1, i1);
		ItemDeCompra ic2 = new ItemDeCompra(null, 0.5, c1, i2);
		ItemDeCompra ic3 = new ItemDeCompra(null, 10.0, c2, i3);
		ItemDeCompra ic4 = new ItemDeCompra(null, 30.0, c3, i3);
		
		c1.addItemDeCompra(ic1);
		c1.addItemDeCompra(ic2);
		c2.addItemDeCompra(ic3);
		c3.addItemDeCompra(ic4);
		
		i1.addItemDeCompra(ic1);
		i2.addItemDeCompra(ic2);
		i3.addItemDeCompra(ic3);
		i3.addItemDeCompra(ic4);
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(f1);
		em.persist(f2);

		em.persist(pro1);
		em.persist(pro2);
		em.persist(pro3);
		
		em.persist(pe1);
		em.persist(pe2);
		
		em.persist(ip1);
		em.persist(ip2);
		em.persist(ip3);
		em.persist(ip4);
		
		em.persist(i1);
		em.persist(i2);
		em.persist(i3);
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		
		em.persist(ic1);
		em.persist(ic2);
		em.persist(ic3);
		em.persist(ic4);
		
		em.getTransaction().commit();

		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
