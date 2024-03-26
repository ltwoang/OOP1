
public class Sach {
	private int maSach;
	private static int nextMaSach = 10000;
	private String tenSach;
	private String tacGia;
	private String chuyenNganh;
	private int namXuatBan;
	
	public Sach(String tenSach, String tacGia, String chuyenNganh, int namXuatBan) {
		this.maSach = nextMaSach++;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.chuyenNganh = chuyenNganh;
		this.namXuatBan = namXuatBan;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	
	@Override
    public String toString() {
        return "Mã sách: " + maSach + ", Tên sách: " + tenSach + ", Tác giả: " + tacGia + ", Chuyên ngành: " + chuyenNganh + ", Năm xuất bản: " + namXuatBan;
    }
	
}
