package QuanLiHoaDonKhachSan;

import java.util.Scanner;

public class HoaDonGio extends HoaDon
{
	private float SoGioThue;
	
	public HoaDonGio()
	{
		super();
		SoGioThue = 0;
		this.setThanhTien();
	}
	
	public HoaDonGio(int ID, int Ngay, int Thang, int Nam, String TenKhachHang, int IDPhong, float DonGia, float ThanhTien, float SoGioThue)
	{
		super(ID, Ngay, Thang, Nam, TenKhachHang, IDPhong, DonGia, ThanhTien);
		this.SoGioThue = SoGioThue;
		this.setThanhTien();
	}
	
	@Override
	public void Nhap()
	{
		Scanner scan = new Scanner(System.in);
		
		super.Nhap();
		try {
			System.out.print("So gio thue: ");
			SoGioThue = scan.nextFloat();
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
		System.out.println("So gio thue: " + SoGioThue);
	}

	public float getSoGioThue() {
		return SoGioThue;
	}
	public void setSoGioThue(float soGioThue) {
		SoGioThue = soGioThue;
	}
	
	@Override
	public float getThanhTien() {
		this.setThanhTien();
		return super.getThanhTien();
	}
	@Override
	public void setThanhTien() {
		if ((SoGioThue > 24) && (SoGioThue < 30)) {
			SoGioThue = 24;
		}
		super.setThanhTien(SoGioThue * getDonGia());
	}

	@Override
	public String toString() {
		return super.toString() + ", SoGioThue=" + SoGioThue;
	}
	@Override
	public String toStringRaw() {
		return super.toStringRaw() + " " + SoGioThue;
	}
	
}
