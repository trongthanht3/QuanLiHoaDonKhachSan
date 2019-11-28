package QuanLiHoaDonKhachSan;

import java.util.Scanner;

public class HoaDonNgay extends HoaDon
{
	private int SoNgayThue;
	
	public HoaDonNgay()
	{
		super();
		SoNgayThue = 0;
		this.setThanhTien();
	}
	
	public HoaDonNgay(int ID, int Ngay, int Thang, int Nam, String TenKhachHang, int IDPhong, float DonGia, float ThanhTien, int SoNgayThue)
	{
		super(ID, Ngay, Thang, Nam, TenKhachHang, IDPhong, DonGia, ThanhTien);
		this.SoNgayThue = SoNgayThue;
	}

	@Override
	public void Nhap()
	{
		Scanner scan = new Scanner(System.in);
		
		super.Nhap();
		try {
			System.out.print("So ngay thue: ");
			SoNgayThue = scan.nextInt();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		this.setThanhTien();
	}
	
	@Override
	public void Xuat()
	{
		this.setThanhTien();
		super.Xuat();
		System.out.println("So ngay thue: " + SoNgayThue);
	}
	
	public int getSoNgayThue() {
		return SoNgayThue;
	}
	public void setSoNgayThue(int soNgayThue) {
		SoNgayThue = soNgayThue;
	}
	
	@Override
	public float getThanhTien() {
		this.setThanhTien();
		return super.getThanhTien();
	}
	@Override
	public void setThanhTien() {
		float tempTien = 0;
		if (SoNgayThue > 7) {
			tempTien = (float) (7*getDonGia() + (SoNgayThue-7)*(0.8)*getDonGia()); 
			super.setThanhTien(tempTien);
		}
		else {
			super.setThanhTien(getDonGia() * SoNgayThue);
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + ", SoNgayThue=" + SoNgayThue;
	}
	@Override
	public String toStringRaw() {
		return super.toStringRaw() + " " + SoNgayThue;
	}
}
