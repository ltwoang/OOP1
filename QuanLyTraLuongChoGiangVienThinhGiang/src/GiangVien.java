
public class GiangVien {
	private static int nextMaGV = 100;
	private int maGV;
	private String hoTen;
	private String diaChi;
	private String soDT;
	private String trinhDo;
	public GiangVien(String hoTen, String diaChi, String soDT, String trinhDo) {
		this.maGV = nextMaGV++;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDT = soDT;
		this.trinhDo = trinhDo;
	}
	public int getMaGV() {
		return maGV;
	}
	public void setMaGV(int maGV) {
		this.maGV = maGV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public String getSoDT() {
		return soDT;
	}
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	
	
}
