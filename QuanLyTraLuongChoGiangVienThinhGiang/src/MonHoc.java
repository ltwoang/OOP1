
public class MonHoc {
	private static int nextMaMonHoc = 100;
	private int maMonHoc;
	private String tenMonHoc;
	private int tongSoTiet;
	private int soTietLyThuyet;
	private double mucKinhPhi;
	public MonHoc(String tenMonHoc, int tongSoTiet, int soTietLyThuyet, double mucKinhPhi) {
		this.maMonHoc = nextMaMonHoc++;
		this.tenMonHoc = tenMonHoc;
		this.tongSoTiet = tongSoTiet;
		this.soTietLyThuyet = soTietLyThuyet;
		this.mucKinhPhi = mucKinhPhi;
	}
	public int getMaMonHoc() {
		return maMonHoc;
	}
	public void setMaMonHoc(int maMonHoc) {
		this.maMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return tenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		this.tenMonHoc = tenMonHoc;
	}
	public int getTongSoTiet() {
		return tongSoTiet;
	}
	public void setTongSoTiet(int tongSoTiet) {
		this.tongSoTiet = tongSoTiet;
	}
	public int getSoTietLyThuyet() {
		return soTietLyThuyet;
	}
	public void setSoTietLyThuyet(int soTietLyThuyet) {
		this.soTietLyThuyet = soTietLyThuyet;
	}
	public double getMucKinhPhi() {
		return mucKinhPhi;
	}
	public void setMucKinhPhi(double mucKinhPhi) {
		this.mucKinhPhi = mucKinhPhi;
	}
	
	
}
