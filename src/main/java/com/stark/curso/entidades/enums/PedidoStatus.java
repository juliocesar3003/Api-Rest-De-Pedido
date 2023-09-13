package com.stark.curso.entidades.enums;

public enum PedidoStatus {

	Aguardando_Pagamento (1),
	Pago (2),
	Enviado(3),
	Entrege(4),
	Cancelado(5);
	
	private int code;
	
	
	private PedidoStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}	
	
	public static PedidoStatus valueOf(int code) {
		for (PedidoStatus valor : PedidoStatus.values()) {
			if(valor.getCode() == code) {
				return valor;
			}
		}
		throw new IllegalArgumentException("code invalido PedidoStatus");
	}
}
