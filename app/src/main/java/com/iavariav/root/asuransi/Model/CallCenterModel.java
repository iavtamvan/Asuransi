package com.iavariav.root.asuransi.Model;

import com.google.gson.annotations.SerializedName;

public class CallCenterModel{

	@SerializedName("ID_CC")
	private String iDCC;

	@SerializedName("CC_EMAIL")
	private String cCEMAIL;

	@SerializedName("CC_ALAMAT")
	private String cCALAMAT;

	@SerializedName("CC_TELP")
	private String cCTELP;

	@SerializedName("CC_INFO")
	private String cCINFO;

	@SerializedName("CC_NAME")
	private String cCNAME;

	public void setIDCC(String iDCC){
		this.iDCC = iDCC;
	}

	public String getIDCC(){
		return iDCC;
	}

	public void setCCEMAIL(String cCEMAIL){
		this.cCEMAIL = cCEMAIL;
	}

	public String getCCEMAIL(){
		return cCEMAIL;
	}

	public void setCCALAMAT(String cCALAMAT){
		this.cCALAMAT = cCALAMAT;
	}

	public String getCCALAMAT(){
		return cCALAMAT;
	}

	public void setCCTELP(String cCTELP){
		this.cCTELP = cCTELP;
	}

	public String getCCTELP(){
		return cCTELP;
	}

	public void setCCINFO(String cCINFO){
		this.cCINFO = cCINFO;
	}

	public String getCCINFO(){
		return cCINFO;
	}

	public void setCCNAME(String cCNAME){
		this.cCNAME = cCNAME;
	}

	public String getCCNAME(){
		return cCNAME;
	}
}