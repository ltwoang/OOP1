import java.util.Scanner;

public class QuanLyTraLuong {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean danhSachMonHocDaNhap = false;
    private static boolean danhSachGiangVienDaNhap = false;
    public static void main(String[] args) {
        QuanLyKeKhaiGiangDay quanLyKeKhaiGiangDay = new QuanLyKeKhaiGiangDay();
        while (true) {
            System.out.println("\n MENU ");
            System.out.println("1. Nhập danh sách môn học");
            System.out.println("2. Nhập danh sách giảng viên");
            System.out.println("3. Lập bảng kê khai giảng dạy cho mỗi giảng viên");
            System.out.println("4. Sắp xếp danh sách kê khai giảng dạy");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng môn học: ");
                    int soLuongMonHoc = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < soLuongMonHoc; i++) {
                        System.out.print("Tên môn: ");
                        String tenMon = scanner.nextLine();
                        System.out.print("Tổng số tiết: ");
                        int tongSoTiet = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Số tiết lý thuyết: ");
                        int soTietLyThuyet = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Mức kinh phí: ");
                        float mucKinhPhi = scanner.nextFloat();
                        scanner.nextLine();
                        quanLyKeKhaiGiangDay.nhapMonHoc(tenMon, tongSoTiet, soTietLyThuyet, mucKinhPhi);
                    }
                    quanLyKeKhaiGiangDay.hienThiDanhSachMonHoc();
                    danhSachMonHocDaNhap = true;
                    break;
                case 2:
                    System.out.print("Nhập số lượng giảng viên: ");
                    int soLuongGiangVien = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < soLuongGiangVien; i++) {
                        System.out.print("Họ tên: ");
                        String hoTen = scanner.nextLine();
                        System.out.print("Địa chỉ: ");
                        String diaChi = scanner.nextLine();
                        System.out.print("Số điện thoại: ");
                        String soDT = scanner.nextLine();
                        System.out.print("Trình độ: ");
                        String trinhDo = scanner.nextLine();
                        quanLyKeKhaiGiangDay.nhapGiangVien(hoTen, diaChi, soDT, trinhDo);
                    }
                    quanLyKeKhaiGiangDay.hienThiDanhSachGiangVien();
                    danhSachGiangVienDaNhap = true;
                    break;
                case 3:
                	 if (!danhSachMonHocDaNhap || !danhSachGiangVienDaNhap) {
                         System.out.println("Yêu cầu nhập danh sách môn học và danh sách giảng viên trước.");
                         break;
                     }
                    quanLyKeKhaiGiangDay.lapBangKhaiGiangDay();
                    break;
                case 4:
                	if (!danhSachMonHocDaNhap || !danhSachGiangVienDaNhap) {
                        System.out.println("Yêu cầu nhập danh sách môn học và danh sách giảng viên trước.");
                        break;
                    }
                    System.out.println("1. Sắp xếp theo họ tên giảng viên");
                    System.out.println("2. Sắp xếp theo số tiết giảng dạy mỗi môn (giảm dần)");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    int sapXepChoice = scanner.nextInt();
                    if (sapXepChoice == 1) {
                        quanLyKeKhaiGiangDay.sapXepTheoHoTen();
                    } else if (sapXepChoice == 2) {
                        quanLyKeKhaiGiangDay.sapXepTheoSoTietGiangDay();
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
