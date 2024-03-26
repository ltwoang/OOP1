import java.util.Scanner;

public class QuanLyMuonSachThuVien {
	private static BanDoc[] danhSachBanDoc = new BanDoc[100];
	private static Sach[] danhSachSach = new Sach[100];
	private static QuanLyMuonSach[] danhSachQuanLyMuonSach = new QuanLyMuonSach[100];
	private static int soLuongBanDoc = 0;
	private static int soLuongSach = 0;
	private static int soLuongMuonSach = 0;
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int luaChon;
        do {
            System.out.println("\n MENU ");
            System.out.println("1. Nhập đầu sách mới");
            System.out.println("2. Nhập bạn đọc mới");
            System.out.println("3. Lập bảng QL mượn sách cho từng bạn đọc");
            System.out.println("4. Sắp xếp danh sách Quản lý mượn sách");
            System.out.println("5. Tìm kiếm và hiển thị danh sách mượn sách theo tên bạn đọc");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1:
                    nhapDanhSachSachVaIn();
                    break;
                case 2:
                    nhapDanhSachBanDocVaIn();
                    break;
                case 3:
                    lapBangMuonSach();
                    break;
                case 4:
                    sapXepBangMuonSach();
                    break;
                case 5:
                    timKiemVaHienThiBangMuonSach();
                    break;
                case 0:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, chọn lại.");
            }
        } while (luaChon != 0);
	}
	
	private static void nhapDanhSachSachVaIn() {
	    System.out.print("Nhập số lượng sách muốn nhập: ");
	    int n = scanner.nextInt();
	    scanner.nextLine();
	    for (int i = 0; i < n; i++) {
	        System.out.print("Tên sách: ");
	        String tenSach = scanner.nextLine();
	        System.out.print("Tác giả: ");
	        String tacGia = scanner.nextLine();
	        System.out.print("Chuyên ngành: ");
	        String chuyenNganh = scanner.nextLine();
	        System.out.print("Năm xuất bản: ");
	        int namXuatBan;
	        if(scanner.hasNextInt()) {
	            namXuatBan = scanner.nextInt();
	            scanner.nextLine();
	        } else {
	            System.out.println("Năm xuất bản không hợp lệ.");
	            scanner.nextLine();
	            continue;
	        }
	        danhSachSach[soLuongSach++] = new Sach(tenSach, tacGia, chuyenNganh, namXuatBan);
	    }

	    System.out.println("Danh sách các đầu sách:");
	    for (int i = 0; i < soLuongSach; i++) {
	        Sach sach = danhSachSach[i];
	        System.out.println(sach.toString());
	    }
	}

	
	private static void nhapDanhSachBanDocVaIn() {
        System.out.print("Nhập số lượng bạn đọc cần nhập: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            System.out.print("SDT: ");
            String soDienThoai = scanner.nextLine();
            System.out.print("Loại bạn đọc: ");
            String loaiBanDoc = scanner.nextLine();
            danhSachBanDoc[soLuongBanDoc++] = new BanDoc(hoTen, diaChi, soDienThoai, loaiBanDoc);
        }

        System.out.println("Danh sách bạn đọc:");
        for (int i = 0; i < soLuongBanDoc; i++) {
            BanDoc banDoc = danhSachBanDoc[i];
            System.out.println(banDoc.toString());
        }
    }
	
	private static void lapBangMuonSach() {
        System.out.print("Nhập mã bạn đọc: ");
        int maBanDoc = scanner.nextInt();
        scanner.nextLine();
        BanDoc banDoc = timBanDocTheoMa(maBanDoc);
        if (banDoc != null) {
            QuanLyMuonSach quanLyMuonSach = new QuanLyMuonSach(banDoc);
            System.out.print("Nhập số lượng sách muốn mượn: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập mã sách: ");
                int maSach = scanner.nextInt();
                scanner.nextLine(); 
                Sach sach = timSachTheoMa(maSach);
                if (sach != null) {
                    System.out.print("Nhập số lượng muốn mượn: ");
                    int soLuong = scanner.nextInt();
                    scanner.nextLine();
                    quanLyMuonSach.muonSach(sach, soLuong);
                } else {
                    System.out.println("Không tìm thấy sách có mã " + maSach);
                }
            }
            danhSachQuanLyMuonSach[soLuongMuonSach++] = quanLyMuonSach;
            quanLyMuonSach.inDanhSachMuon();
        } else {
            System.out.println("Không tìm thấy bạn đọc có mã " + maBanDoc);
        }
    }

    private static void sapXepBangMuonSach() {
        int luaChon;
        do {
            System.out.println("\n CHỌN CÁCH SẮP XẾP ");
            System.out.println("1. Theo tên bạn đọc");
            System.out.println("2. Theo Số lượng cuốn sách được mượn (giảm dần)");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn của bạn: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    sapXepTheoTenBanDoc();
                    break;
                case 2:
                    sapXepTheoSoLuongMuon();
                    break;
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, chọn lại.");
            }
        } while (luaChon != 0);
    }

    private static void sapXepTheoTenBanDoc() {
        for (int i = 0; i < soLuongMuonSach - 1; i++) {
            for (int j = 0; j < soLuongMuonSach - i - 1; j++) {
                if (danhSachQuanLyMuonSach[j].getBanDoc().getHoTen().compareTo(danhSachQuanLyMuonSach[j + 1].getBanDoc().getHoTen()) > 0) {
                    QuanLyMuonSach temp = danhSachQuanLyMuonSach[j];
                    danhSachQuanLyMuonSach[j] = danhSachQuanLyMuonSach[j + 1];
                    danhSachQuanLyMuonSach[j + 1] = temp;
                }
            }
        }
        
        System.out.println("Danh sách Quản lý mượn sách sau khi sắp xếp theo tên:");
        hienThiDanhSachMuonSach();
    }

    private static void sapXepTheoSoLuongMuon() {
        for (int i = 0; i < soLuongMuonSach - 1; i++) {
            for (int j = 0; j < soLuongMuonSach - i - 1; j++) {
                if (danhSachQuanLyMuonSach[j].tongSachMuon() < danhSachQuanLyMuonSach[j + 1].tongSachMuon()) {
                    QuanLyMuonSach temp = danhSachQuanLyMuonSach[j];
                    danhSachQuanLyMuonSach[j] = danhSachQuanLyMuonSach[j + 1];
                    danhSachQuanLyMuonSach[j + 1] = temp;
                }
            }
        }

        System.out.println("Danh sách Quản lý mượn sách sau khi sắp xếp theo số lượng sách mượn giảm dần:");
        hienThiDanhSachMuonSach();
    }

    private static void timKiemVaHienThiBangMuonSach() {
        System.out.print("Nhập tên bạn đọc cần tìm kiếm: ");
        String tenBanDoc = scanner.nextLine();
        int found = 0;
        System.out.println("Danh sách mượn sách của bạn đọc có tên '" + tenBanDoc + "':");
        for (int i = 0; i < soLuongMuonSach; i++) {
            BanDoc banDoc = danhSachQuanLyMuonSach[i].getBanDoc();
            if (banDoc.getHoTen().equalsIgnoreCase(tenBanDoc)) {
                found = 1;
                System.out.println("Mã bạn đọc: " + banDoc.getMaBanDoc());
                danhSachQuanLyMuonSach[i].inDanhSachMuon();
                break;
            }
        }
        if (found == 0) {
            System.out.println("Không tìm thấy bạn đọc có tên '" + tenBanDoc + "'.");
        }
    }

    private static Sach timSachTheoMa(int maSach) {
        for (int i = 0; i < soLuongSach; i++) {
            if (danhSachSach[i].getMaSach() == maSach) {
                return danhSachSach[i];
            }
        }
        return null;
    }
    
    private static BanDoc timBanDocTheoMa(int maBanDoc) {
        for (int i = 0; i < soLuongBanDoc; i++) {
            if (danhSachBanDoc[i].getMaBanDoc() == maBanDoc) {
                return danhSachBanDoc[i];
            }
        }
        return null;
    }

    

    private static void hienThiDanhSachMuonSach() {
        for (int i = 0; i < soLuongMuonSach; i++) {
            BanDoc banDoc = danhSachQuanLyMuonSach[i].getBanDoc();
            System.out.println("Tên bạn đọc: " + banDoc.getHoTen());
            System.out.println("Số lượng sách đã mượn: " + danhSachQuanLyMuonSach[i].tongSachMuon());
            danhSachQuanLyMuonSach[i].inDanhSachMuon();
            System.out.println();
        }
    }
	
}
