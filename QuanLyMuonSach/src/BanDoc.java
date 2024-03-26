
public class BanDoc {
	private int maBanDoc;
	private static int nextMaBanDoc = 10000;
	private String hoTen;
	private String diaChi;
	private String SDT;
	private String loaiBanDoc;
	public BanDoc(String hoTen, String diaChi, String SDT, String loaiBanDoc) {
		this.maBanDoc = nextMaBanDoc++;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.SDT = SDT;
		this.loaiBanDoc = loaiBanDoc;
	}
	public int getMaBanDoc() {
		return maBanDoc;
	}
	public void setMaBanDoc(int maBanDoc) {
		this.maBanDoc = maBanDoc;
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
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		this.SDT = sDT;
	}
	public String getLoaiBanDoc() {
		return loaiBanDoc;
	}
	public void setLoaiBanDoc(String loaiBanDoc) {
		this.loaiBanDoc = loaiBanDoc;
	}
	
	@Override
    public String toString() {
        return "Mã bạn đọc: " + maBanDoc + ", Họ tên: " + hoTen + ", Địa chỉ: " + diaChi + ", Số điện thoại: " + SDT + ", Loại bạn đọc: " + loaiBanDoc;
    }
	
}
