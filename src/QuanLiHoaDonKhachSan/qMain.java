package QuanLiHoaDonKhachSan;

import java.io.IOException;

public class qMain 
{
	public static void main(String [] args)
	{
//		System.out.print("heelo");
		SoHoaDon SoMoi = new SoHoaDon();
		SoMoi.Nhap();
//		SoMoi.Xuat();
		System.out.print(SoMoi.toStringRaw());
		SoMoi.ExportRawData();
//		nha.Nhap();
//		nha.Xuat();
//		System.out.println(nha.toString());
//		System.out.println(nha.toStringRaw());
//		String rawData = "44";
//		rawData = rawData + "6";
//		System.out.print(rawData);
	}
}
