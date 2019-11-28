package QuanLiHoaDonKhachSan;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class SoHoaDon 
{
	private HoaDon SoHoaDon0[];
	private int STT;
	private	int SoHDGio;
	private int SoHDNgay;
	private float TongTienGio;
	private float TongTienNgay;
	private float TongTien;
	
	public SoHoaDon()
	{
		STT = 0;
		SoHoaDon0 = new HoaDon[STT];
		SoHDGio = 0;
		SoHDNgay = 0;
		TongTienGio = 0;
		TongTienNgay = 0;
		TongTien = 0;
	}
	
	public SoHoaDon(int STT)
	{
		this.STT = STT;
		SoHoaDon0 = new HoaDon[this.STT];
		SoHDGio = 0;
		SoHDNgay = 0;
		TongTienGio = 0;
		TongTienNgay = 0;
		TongTien = 0;
	}
	
	public void Nhap()
	{
		Scanner scan = new Scanner(System.in);
		
		// Nhap so moi, de nhap tu file can su dung ham khac de danh so tiep
		int SoHDNhap;
		System.out.print("So luong hoa don: ");
		SoHDNhap = scan.nextInt();
		this.STT = SoHDNhap;
		SoHoaDon0 = new HoaDon[this.STT];
		System.out.println("Nhap hoa don (1: theo gio, 2: theo ngay): ");
		for (int i=0; i<SoHDNhap; i++) {
			int type;
			int chk = 0;
			System.out.print("Loai: ");
			type = scan.nextInt();
			while (chk == 0) {
				if (type == 1) {
					SoHDGio++;
					chk = 1;
					HoaDonGio HDtemp = new HoaDonGio();
					HoaDonNgay convert;
					HDtemp.setID(i);
					HDtemp.Nhap();
					
//					ID,Ngay,Thang,Nam,TenKhachHang,IDPhong,DonGia,ThanhTien,SoNgayThue
					if (HDtemp.getSoGioThue() > 30) {			//convert sang ngay neu gio > 30
						convert = new HoaDonNgay(
								HDtemp.getID(), 
								HDtemp.getNgay(), 
								HDtemp.getThang(), 
								HDtemp.getNam(), 
								HDtemp.getTenKhachHang(), 
								HDtemp.getIDPhong(), 
								HDtemp.getDonGia()*24, 
								HDtemp.getThanhTien(), 
								(int)(HDtemp.getSoGioThue()/24));
						SoHoaDon0[i] = convert;
//						SoHoaDon0[i].Xuat();					//kiem tra output
					}
					else {
						SoHoaDon0[i] = HDtemp;
//						SoHoaDon0[i].Xuat();					//kiem tra output
					}
				}
				else if (type == 2) {
					SoHDNgay++;
					chk = 1;
					SoHoaDon0[i] = new HoaDonNgay();
					SoHoaDon0[i].setID(i);
					SoHoaDon0[i].Nhap();
				}
				else {
					System.out.print("Sai loai, nhap lai: ");
					type = scan.nextInt();
					chk = 0;
				}
			}
		}
	}
	
	public void Xuat() 
	{
		for (int i=0; i<STT; i++) {
			System.out.println(SoHoaDon0[i].toString());
		}
	}
	
	public void DemHoaDon()			//actually you don't need this because we count it when user input data
	{								//you can check at line 44 and line 72
		SoHDGio = 0;						//at this line, i set it equal 0
		SoHDNgay = 0;						//because we count once above
		for (int i=0; i<STT; i++) {			//so we need reset it to count again
			if (SoHoaDon0[i].getClass() == HoaDonGio.class) {
				SoHDGio++;
			}
			else if (SoHoaDon0[i].getClass() == HoaDonNgay.class) {
				SoHDNgay++;
			}
		}
	}
	public void getSoLuongLoai()
	{
		DemHoaDon();				
		System.out.println("So hoa don theo gio: "+ SoHDGio);
		System.out.println("So hoa don theo ngay: " + SoHDNgay);
	}
	
	public void DemTienThang(int ChonThang, int ChonNam)
	{
		float tempTienThang = 0;
		float tempTrungBinhThang = 0;
		for (int i=0; i<STT; i++) {
			if ((SoHoaDon0[i].getThang() == ChonThang) && (SoHoaDon0[i].getNam() == ChonNam)) {
				tempTienThang = tempTienThang + SoHoaDon0[i].getThanhTien();
			}
		}
		tempTrungBinhThang = tempTienThang/30;
	}
	public void DemTienTong() 			//the good part for manager (っ´ω`)ﾉ(╥ω╥)
	{
		TongTienGio = 0;			//Why equal 0? check line 107
		TongTienNgay = 0;
		TongTien = 0;
		for (int i=0; i<STT; i++) {
			if (SoHoaDon0[i].getClass() == HoaDonGio.class) {
				TongTienGio = TongTienGio + SoHoaDon0[i].getThanhTien();
			}
			else if (SoHoaDon0[i].getClass() == HoaDonNgay.class) {
				TongTienNgay = TongTienNgay + SoHoaDon0[i].getThanhTien();
			}
		}
		TongTien = TongTienNgay + TongTienGio;
	}
	public void getTien()
	{
		DemTienTong();
		System.out.println("Tong tien hoa don gio: " + TongTienGio);
		System.out.println("Tong tien hoa don ngay: " + TongTienNgay);
		System.out.println("Tong doanh thu: " + TongTien);
	}

	@Override
	public String toString() {
		return "SoHoaDon0=" + Arrays.toString(SoHoaDon0) + ", STT=" + STT + ", SoHDGio=" + SoHDGio
				+ ", SoHDNgay=" + SoHDNgay + ", TongTienGio=" + TongTienGio + ", TongTienNgay=" + TongTienNgay
				+ ", TongTien=" + TongTien;
	}
	public String toStringRaw() {
		String rawData = "";
		
		for (int i=0; i<STT; i++) {
			if (SoHoaDon0[i].getClass() == HoaDonGio.class) {
				rawData = rawData + "1 " + SoHoaDon0[i].toStringRaw() + "\n";
			}
			else if (SoHoaDon0[i].getClass() == HoaDonNgay.class) {
				rawData = rawData + "2 " + SoHoaDon0[i].toStringRaw() + "\n";
			}
		}
		return STT + "\n" + rawData;
	}
	
	// export to file data.dat
	public void ExportRawData()
	{
		File RawData = new File("data.dat");
		try {
			if (RawData.createNewFile()) {
				System.out.println("Exported to 'data.dat'");
			}
			else {
				System.out.println("File already exist!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WriteData();
	}
	public void WriteData()
	{
		FileWriter RawDataWriter;
		try {
			RawDataWriter = new FileWriter("data.dat");
			RawDataWriter.write(this.toStringRaw());
			RawDataWriter.close();
			System.out.print("Success write!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
