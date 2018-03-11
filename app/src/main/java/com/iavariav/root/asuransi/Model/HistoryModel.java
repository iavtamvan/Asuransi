package com.iavariav.root.asuransi.Model;

import com.google.gson.annotations.SerializedName;

public class HistoryModel{

	@SerializedName("NSB_PEKERJAAN")
	private Object nSBPEKERJAAN;

	@SerializedName("NSB_AGAMA")
	private Object nSBAGAMA;

	@SerializedName("NSB_ALAMAT")
	private String nSBALAMAT;

	@SerializedName("ID_NASABAH")
	private String iDNASABAH;

	@SerializedName("NSB_KEWARGANEGARA")
	private Object nSBKEWARGANEGARA;

	@SerializedName("ID_JNS_ASURANSI")
	private String iDJNSASURANSI;

	@SerializedName("NSB_NAME")
	private String nSBNAME;

	@SerializedName("NSB_JENIS_KELAMIN")
	private String nSBJENISKELAMIN;

	@SerializedName("NSB_TGL_LAHIR")
	private String nSBTGLLAHIR;

	@SerializedName("NSB_TMP_LAHIR")
	private Object nSBTMPLAHIR;

	@SerializedName("NSB_TELP")
	private String nSBTELP;

	@SerializedName("NSB_STASUS_KAWIN")
	private Object nSBSTASUSKAWIN;

	@SerializedName("ID_USER")
	private String iDUSER;

	@SerializedName("NO_VERIF_NASABAH")
	private String nOVERIFNASABAH;

	public void setNSBPEKERJAAN(Object nSBPEKERJAAN){
		this.nSBPEKERJAAN = nSBPEKERJAAN;
	}

	public Object getNSBPEKERJAAN(){
		return nSBPEKERJAAN;
	}

	public void setNSBAGAMA(Object nSBAGAMA){
		this.nSBAGAMA = nSBAGAMA;
	}

	public Object getNSBAGAMA(){
		return nSBAGAMA;
	}

	public void setNSBALAMAT(String nSBALAMAT){
		this.nSBALAMAT = nSBALAMAT;
	}

	public String getNSBALAMAT(){
		return nSBALAMAT;
	}

	public void setIDNASABAH(String iDNASABAH){
		this.iDNASABAH = iDNASABAH;
	}

	public String getIDNASABAH(){
		return iDNASABAH;
	}

	public void setNSBKEWARGANEGARA(Object nSBKEWARGANEGARA){
		this.nSBKEWARGANEGARA = nSBKEWARGANEGARA;
	}

	public Object getNSBKEWARGANEGARA(){
		return nSBKEWARGANEGARA;
	}

	public void setIDJNSASURANSI(String iDJNSASURANSI){
		this.iDJNSASURANSI = iDJNSASURANSI;
	}

	public String getIDJNSASURANSI(){
		return iDJNSASURANSI;
	}

	public void setNSBNAME(String nSBNAME){
		this.nSBNAME = nSBNAME;
	}

	public String getNSBNAME(){
		return nSBNAME;
	}

	public void setNSBJENISKELAMIN(String nSBJENISKELAMIN){
		this.nSBJENISKELAMIN = nSBJENISKELAMIN;
	}

	public String getNSBJENISKELAMIN(){
		return nSBJENISKELAMIN;
	}

	public void setNSBTGLLAHIR(String nSBTGLLAHIR){
		this.nSBTGLLAHIR = nSBTGLLAHIR;
	}

	public String getNSBTGLLAHIR(){
		return nSBTGLLAHIR;
	}

	public void setNSBTMPLAHIR(Object nSBTMPLAHIR){
		this.nSBTMPLAHIR = nSBTMPLAHIR;
	}

	public Object getNSBTMPLAHIR(){
		return nSBTMPLAHIR;
	}

	public void setNSBTELP(String nSBTELP){
		this.nSBTELP = nSBTELP;
	}

	public String getNSBTELP(){
		return nSBTELP;
	}

	public void setNSBSTASUSKAWIN(Object nSBSTASUSKAWIN){
		this.nSBSTASUSKAWIN = nSBSTASUSKAWIN;
	}

	public Object getNSBSTASUSKAWIN(){
		return nSBSTASUSKAWIN;
	}

	public void setIDUSER(String iDUSER){
		this.iDUSER = iDUSER;
	}

	public String getIDUSER(){
		return iDUSER;
	}

	public void setNOVERIFNASABAH(String nOVERIFNASABAH){
		this.nOVERIFNASABAH = nOVERIFNASABAH;
	}

	public String getNOVERIFNASABAH(){
		return nOVERIFNASABAH;
	}
}