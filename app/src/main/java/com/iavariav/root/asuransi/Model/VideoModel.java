package com.iavariav.root.asuransi.Model;

import com.google.gson.annotations.SerializedName;

public class VideoModel{

	@SerializedName("VD_JN_ASURANSI")
	private String vDJNASURANSI;

	@SerializedName("VD_SIZE")
	private String vDSIZE;

	@SerializedName("VD_LINK")
	private String vDLINK;

	@SerializedName("VD_UPDATED_AT")
	private String vDUPDATEDAT;

	@SerializedName("VD_CREATED_AT")
	private String vDCREATEDAT;

	@SerializedName("VD_NAME")
	private String vDNAME;

	@SerializedName("ID_VIDEO")
	private String iDVIDEO;

	@SerializedName("VD_CREATED_BY")
	private String vDCREATEDBY;

	public void setVDJNASURANSI(String vDJNASURANSI){
		this.vDJNASURANSI = vDJNASURANSI;
	}

	public String getVDJNASURANSI(){
		return vDJNASURANSI;
	}

	public void setVDSIZE(String vDSIZE){
		this.vDSIZE = vDSIZE;
	}

	public String getVDSIZE(){
		return vDSIZE;
	}

	public void setVDLINK(String vDLINK){
		this.vDLINK = vDLINK;
	}

	public String getVDLINK(){
		return vDLINK;
	}

	public void setVDUPDATEDAT(String vDUPDATEDAT){
		this.vDUPDATEDAT = vDUPDATEDAT;
	}

	public String getVDUPDATEDAT(){
		return vDUPDATEDAT;
	}

	public void setVDCREATEDAT(String vDCREATEDAT){
		this.vDCREATEDAT = vDCREATEDAT;
	}

	public String getVDCREATEDAT(){
		return vDCREATEDAT;
	}

	public void setVDNAME(String vDNAME){
		this.vDNAME = vDNAME;
	}

	public String getVDNAME(){
		return vDNAME;
	}

	public void setIDVIDEO(String iDVIDEO){
		this.iDVIDEO = iDVIDEO;
	}

	public String getIDVIDEO(){
		return iDVIDEO;
	}

	public void setVDCREATEDBY(String vDCREATEDBY){
		this.vDCREATEDBY = vDCREATEDBY;
	}

	public String getVDCREATEDBY(){
		return vDCREATEDBY;
	}
}