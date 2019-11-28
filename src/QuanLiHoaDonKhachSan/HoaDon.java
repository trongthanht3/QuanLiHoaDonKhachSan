package QuanLiHoaDonKhachSan;

import java.util.Scanner;

public class HoaDon 
{
	private int ID;
	private int Ngay, Thang, Nam;
	private String TenKhachHang;
	private int IDPhong;
	private float DonGia;
	private float ThanhTien;
	
	public HoaDon()
	{
		ID = -1;
		Ngay = 1; Thang = 1; Nam = 1900;
		TenKhachHang = "";
		IDPhong = -1;
		DonGia = 0;
		ThanhTien = 0;
	}
	
	public HoaDon(int ID, int Ngay, int Thang, int Nam, String TenKhachHang, int IDPhong, float DonGia, float ThanhTien)
	{
		this.ID = ID;
		this.Ngay = Ngay; this.Thang = Thang; this.Nam = Nam;
		this.TenKhachHang = TenKhachHang;
		this.IDPhong = IDPhong;
		this.DonGia = DonGia;
		this.ThanhTien = ThanhTien;
	}
	
	public void Nhap()
	{
		Scanner scan = new Scanner(System.in);
		try {
//			System.out.print("Ma hoa don: ");		//let ID = array index
//			ID = scan.nextInt();
			System.out.print("Ngay/Thang/Nam: ");
			Ngay = scan.nextInt();
			Thang = scan.nextInt();
			Nam = scan.nextInt();
			System.out.print("Ten khach Hang: ");
			scan.nextLine();
			TenKhachHang = scan.nextLine();
			System.out.print("Ma phong: ");
			IDPhong = scan.nextInt();
			System.out.print("Don gia: ");
			DonGia = scan.nextFloat();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public void Xuat()
	{
		System.out.println("Ma hoa don: " + ID);
		System.out.println("Ngay/Thang/Nam: " + Ngay + "/" + Thang + "/" + Nam);
		System.out.println("Ten khach Hang: " + TenKhachHang);
		System.out.println("Ma phong: " + IDPhong);
		System.out.println("Don gia: " + DonGia);
		System.out.println("Thanh tien: " + getThanhTien());
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getNgay() {
		return Ngay;
	}
	public void setNgay(int ngay) {
		Ngay = ngay;
	}

	public int getThang() {
		return Thang;
	}
	public void setThang(int thang) {
		Thang = thang;
	}

	public int getNam() {
		return Nam;
	}
	public void setNam(int nam) {
		Nam = nam;
	}
	
	public void setNgayThangNam(int Ngay, int Thang, int Nam) {
		this.Ngay = Ngay;
		this.Thang = Thang;
		this.Nam = Nam;
	}
	public String getNgayThangNamString() {
		return Ngay + "/" + Thang + "/" + Nam;
	}

	public String getTenKhachHang() {
		return TenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		TenKhachHang = tenKhachHang;
	}

	public int getIDPhong() {
		return IDPhong;
	}
	public void setIDPhong(int iDPhong) {
		IDPhong = iDPhong;
	}

	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {	
		DonGia = donGia;
	}

	public float getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien() {
	}
	public void setThanhTien(float thanhTien) {	//user don't need this
		ThanhTien = thanhTien;
	}
	
	@Override
	public String toString() {
		return "ID=" + ID + ", Ngay=" + Ngay + ", Thang=" + Thang + ", Nam=" + Nam + ", TenKhachHang="
				+ TenKhachHang + ", IDPhong=" + IDPhong + ", DonGia=" + DonGia + ", ThanhTien=" + getThanhTien();
	}
	
	public String toStringRaw() {
		return ID + " " + Ngay + " " + Thang + " " + Nam + " " + TenKhachHang + " " 
				+ IDPhong + " " + DonGia + " " + getThanhTien();
	}
	
}
