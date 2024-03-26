public class QuanLyMuonSach {
    private BanDoc banDoc;
    private Sach[] sachMuon;
    private int[] soLuongMuon;
    private int dem;

    public QuanLyMuonSach(BanDoc banDoc) {
        this.banDoc = banDoc;
        sachMuon = new Sach[5]; 
        soLuongMuon = new int[5];
        dem = 0;
    }

    public void muonSach(Sach sach, int soLuong) {
        if (dem < 5) {
            sachMuon[dem] = sach;
            soLuongMuon[dem] = soLuong;
            dem++;
            System.out.println("Mượn thành công.");
        } else {
            System.out.println("Không được mượn thêm.");
        }
    }

    public void inDanhSachMuon() {
        System.out.println("Danh sách sách đã mượn:");
        for (int i = 0; i < dem; i++) {
            System.out.println(sachMuon[i].getTenSach() + " Số lượng: " + soLuongMuon[i]);
        }
    }

    public int tongSachMuon() {
        int tong = 0;
        for (int i = 0; i < dem; i++) {
            tong += soLuongMuon[i];
        }
        return tong;
    }

    public BanDoc getBanDoc() {
        return banDoc;
    }

    public void setBanDoc(BanDoc banDoc) {
        this.banDoc = banDoc;
    }
}
