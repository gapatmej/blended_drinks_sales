package ec.com.andres.entities;

import java.math.BigDecimal;

import ec.com.andres.enums.SizeEnum;

public class Size extends EntityCrud<Size>{
	
	private SizeEnum sizeEnum;
	private String name;
	private BigDecimal amount;

	public Size() {
		super.setEntity(this);
	}
	
	public SizeEnum getSizeEnum() {
		return sizeEnum;
	}
	public void setSizeEnum(SizeEnum sizeEnum) {
		this.sizeEnum = sizeEnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
