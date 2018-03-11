package com.iavariav.root.asuransi.Model;

import com.google.gson.annotations.SerializedName;

public class CompanyModel{

	@SerializedName("COM_TELP")
	private String cOMTELP;

	@SerializedName("COM_ALAMAT")
	private String cOMALAMAT;

	@SerializedName("COM_STATUS")
	private String cOMSTATUS;

	@SerializedName("NO_VERIF_COMPANY")
	private String nOVERIFCOMPANY;

	@SerializedName("COM_NAME")
	private String cOMNAME;

	@SerializedName("ID_COMPANY")
	private String iDCOMPANY;

	@SerializedName("COM_JOIN_US")
	private String cOMJOINUS;

	@SerializedName("COM_EMAIL")
	private String cOMEMAIL;

	@SerializedName("COM_CREATED_AT")
	private String cOMCREATEDAT;

	public void setCOMTELP(String cOMTELP){
		this.cOMTELP = cOMTELP;
	}

	public String getCOMTELP(){
		return cOMTELP;
	}

	public void setCOMALAMAT(String cOMALAMAT){
		this.cOMALAMAT = cOMALAMAT;
	}

	public String getCOMALAMAT(){
		return cOMALAMAT;
	}

	public void setCOMSTATUS(String cOMSTATUS){
		this.cOMSTATUS = cOMSTATUS;
	}

	public String getCOMSTATUS(){
		return cOMSTATUS;
	}

	public void setNOVERIFCOMPANY(String nOVERIFCOMPANY){
		this.nOVERIFCOMPANY = nOVERIFCOMPANY;
	}

	public String getNOVERIFCOMPANY(){
		return nOVERIFCOMPANY;
	}

	public void setCOMNAME(String cOMNAME){
		this.cOMNAME = cOMNAME;
	}

	public String getCOMNAME(){
		return cOMNAME;
	}

	public void setIDCOMPANY(String iDCOMPANY){
		this.iDCOMPANY = iDCOMPANY;
	}

	public String getIDCOMPANY(){
		return iDCOMPANY;
	}

	public void setCOMJOINUS(String cOMJOINUS){
		this.cOMJOINUS = cOMJOINUS;
	}

	public String getCOMJOINUS(){
		return cOMJOINUS;
	}

	public void setCOMEMAIL(String cOMEMAIL){
		this.cOMEMAIL = cOMEMAIL;
	}

	public String getCOMEMAIL(){
		return cOMEMAIL;
	}

	public void setCOMCREATEDAT(String cOMCREATEDAT){
		this.cOMCREATEDAT = cOMCREATEDAT;
	}

	public String getCOMCREATEDAT(){
		return cOMCREATEDAT;
	}
}