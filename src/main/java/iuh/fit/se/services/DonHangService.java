package iuh.fit.se.services;

import java.util.List;

import iuh.fit.se.entities.DonHang;

public interface DonHangService {
	List<DonHang> findAll();
	DonHang findByid(int id);
	DonHang save(DonHang donHang);
	DonHang update(int id,DonHang donHang);
	void delete(int id);
	List<DonHang> findByMaDHorTenCH( String maDonHang, String ten);
}
