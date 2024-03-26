
public class QuanLyKeKhaiGiangDay {
	private MonHoc[] danhSachMonHoc;
	private GiangVien[] danhSachGiangVien;
	private int soLuongMonHoc;
    private int soLuongGiangVien;
    
    
	public QuanLyKeKhaiGiangDay() {
		danhSachGiangVien = new GiangVien[100];
        danhSachMonHoc = new MonHoc[100];
        soLuongGiangVien = 0;
        soLuongMonHoc = 0;
	}
    
	public void nhapGiangVien(String hoTen, String diaChi, String soDT, String trinhDo) {
        GiangVien gv = new GiangVien(hoTen, diaChi, soDT, trinhDo);
        danhSachGiangVien[soLuongGiangVien++] = gv;
    }
	
	public void nhapMonHoc(String tenMon, int tongSoTiet, int soTietLyThuyet, double mucKinhPhi) {
        MonHoc monHoc = new MonHoc(tenMon, tongSoTiet, soTietLyThuyet, mucKinhPhi);
        danhSachMonHoc[soLuongMonHoc++] = monHoc;
    }
	
	public void hienThiDanhSachGiangVien() {
        for (int i = 0; i < soLuongGiangVien; i++) {
            GiangVien gv = danhSachGiangVien[i];
            System.out.println("Mã GV: " + gv.getMaGV() + ", Họ tên: " + gv.getHoTen() +
                    ", Địa chỉ: " + gv.getDiaChi() + ", Số điện thoại: " + gv.getSoDT() +
                    ", Trình độ: " + gv.getTrinhDo());
        }
    }
	
	public void hienThiDanhSachMonHoc() {
        for (int i = 0; i < soLuongMonHoc; i++) {
            MonHoc monHoc = danhSachMonHoc[i];
            System.out.println("Mã môn học: " + monHoc.getMaMonHoc() + ", Tên môn: " + monHoc.getTenMonHoc() +
                    ", Tổng số tiết: " + monHoc.getTongSoTiet() + ", Số tiết lý thuyết: " + monHoc.getSoTietLyThuyet() +
                    ", Mức kinh phí: " + monHoc.getMucKinhPhi());
        }
    }
	
	public void lapBangKhaiGiangDay() {
        for (int i = 0; i < soLuongGiangVien; i++) {
            GiangVien gv = danhSachGiangVien[i];
            System.out.println("Giảng viên: " + gv.getHoTen());
            for (int j = 0; j < soLuongMonHoc; j++) {
                MonHoc monHoc = danhSachMonHoc[j];
                System.out.println("- Môn học: " + monHoc.getTenMonHoc());
            }
        }
    }
	
	
	public void sapXepTheoHoTen() {
	    for (int i = 0; i < soLuongGiangVien - 1; i++) {
	        for (int j = 0; j < soLuongGiangVien - i - 1; j++) {
	            if (danhSachGiangVien[j].getHoTen().compareTo(danhSachGiangVien[j + 1].getHoTen()) > 0) {
	                GiangVien temp = danhSachGiangVien[j];
	                danhSachGiangVien[j] = danhSachGiangVien[j + 1];
	                danhSachGiangVien[j + 1] = temp;
	            }
	        }
	    }
	    System.out.println("Danh sách kê khai giảng dạy sau khi sắp xếp theo họ tên:");
	    for (int i = 0; i < soLuongGiangVien; i++) {
	        GiangVien gv = danhSachGiangVien[i];
	        System.out.println("Giảng viên: " + gv.getHoTen());
	    }
	}
	
	private int soTietGiangDayCuaGiangVien(GiangVien giangVien) {
	    int soTietGiangDay = 0;
	    for (int i = 0; i < soLuongMonHoc; i++) {
	        MonHoc monHoc = danhSachMonHoc[i];
	        soTietGiangDay += monHoc.getSoTietLyThuyet(); 
	    }
	    return soTietGiangDay;
	}


	
	public void sapXepTheoSoTietGiangDay() {
	    for (int i = 0; i < soLuongGiangVien; i++) {
	        for (int j = 0; j < soLuongGiangVien - i - 1; j++) {
	            int soTietGiangDayGV1 = soTietGiangDayCuaGiangVien(danhSachGiangVien[j]);
	            int soTietGiangDayGV2 = soTietGiangDayCuaGiangVien(danhSachGiangVien[j + 1]);
	            
	            if (soTietGiangDayGV1 < soTietGiangDayGV2 || 
	                (soTietGiangDayGV1 == soTietGiangDayGV2 && danhSachGiangVien[j].getHoTen().compareTo(danhSachGiangVien[j + 1].getHoTen()) > 0)) {
	                GiangVien temp = danhSachGiangVien[j];
	                danhSachGiangVien[j] = danhSachGiangVien[j + 1];
	                danhSachGiangVien[j + 1] = temp;
	            }
	        }
	    }

	    System.out.println("Danh sách kê khai giảng dạy sau khi sắp xếp theo số tiết giảng dạy mỗi môn giảm dần:");
	    for (int i = 0; i < soLuongGiangVien; i++) {
	        GiangVien gv = danhSachGiangVien[i];
	        System.out.println("Giảng viên: " + gv.getHoTen());
	    }
	}

	
}
