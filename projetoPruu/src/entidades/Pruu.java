package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pruu {

	private static int id;
	private int idPruu;
	private String texto;
	private Date dataCriacao;
	private String dataFormatada;
	private int qtdLikes;
	private boolean bloqueado;
	private Usuario usuario;
	private boolean textoValido = true;
	
	
	public Pruu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Pruu(String texto, Usuario usuario) {
		super();
		validarTexto(texto);
		if (textoValido == true) {
			this.texto = texto;
			this.usuario = usuario;
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
			Pruu.id++;
			idPruu = Pruu.id;
		} else if (textoValido == false) {
			this.texto = "Pruu digitado fora dos parametros \nrequisitados pelo sistema, pruu descartado.";
			this.usuario = usuario;
			this.dataCriacao = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
			String dataFormatada = formatador.format(dataCriacao);
			this.dataFormatada = dataFormatada;
		}
				
	}
	//metodos
	
	public boolean validarTexto(String texto) {
		if ((texto.length() > 300) || (texto.trim().length() < 1)) {
			textoValido = false;
		} else {
			textoValido = true;
		}
		return textoValido;
	}
	
	public void adicionarLike() {
		this.qtdLikes++;
	}
	
		
	public int getId() {
		return id;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public int getQtdLikes() {
		return qtdLikes;
	}
	public void setQtdLikes(int qtdLikes) {
		this.qtdLikes = qtdLikes;
	}
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}


	public boolean isTextoValido() {
		return textoValido;
	}

	public void setTextoValido(boolean textoValido) {
		this.textoValido = textoValido;
	}

	@Override
	public String toString() {
		if (bloqueado) {
			return "\nID:" + idPruu + "\nEsse pruu foi bloqueado por descumprir \nas normas do portal!!!" + "\nPostado em " + dataFormatada
					 + "\nPostado por: " + usuario + "\n";
		} else {
			
		return "\nID:" + idPruu + "\nPruuuuuu: " + texto + "\nPostado em " + dataFormatada + "\n" + qtdLikes
				+ " curtidas" + "\nPostado por: " + usuario + "\n";
		}
	}


	
	
}
