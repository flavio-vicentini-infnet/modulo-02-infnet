package br.com.flaviovicentini.AppFinance.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Investimento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idAtivoFinanceiro")
	private AtivoFinanceiro ativo;
	private float quantidade;
	private float preco;
	private LocalDateTime data;
	
	public Investimento() {
		this.data = LocalDateTime.now();
	}

	public Investimento(Integer id) {
		this.data = LocalDateTime.now();
		this.id = id;
	}

	public Investimento(Cliente cliente, AtivoFinanceiro ativoFinanceiro, float quantidade, float precoCompra) {
		this.data = LocalDateTime.now();
		this.cliente = cliente;
		this.ativo = ativoFinanceiro;
		this.quantidade = quantidade;
		this.preco = precoCompra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public AtivoFinanceiro getAtivo() {
		return ativo;
	}

	public void setAtivo(AtivoFinanceiro ativo) {
		this.ativo = ativo;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public float getTotal() {
		return preco * quantidade;
	}
	
	public String dataFormatada() {
        return this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
}
