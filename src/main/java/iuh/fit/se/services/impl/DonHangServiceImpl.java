package iuh.fit.se.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.entities.DonHang;
import iuh.fit.se.repositories.DonHangRepository;
import iuh.fit.se.services.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService {
	@Autowired
	private DonHangRepository donHangRepository;
	
	@Override
	public List<DonHang> findAll() {
		// TODO Auto-generated method stub
		return donHangRepository.findAll();
	}

	@Override
	public DonHang findByid(int id) {
		// TODO Auto-generated method stub
		return donHangRepository.findById(id).get();
	}

	@Override
	public DonHang save(DonHang donHang) {
		// TODO Auto-generated method stub
		return donHangRepository.save(donHang);
	}

	@Override
	public DonHang update(int id, DonHang donHang) {
		// TODO Auto-generated method stub
		if(findByid(id)!=null) return donHangRepository.save(donHang);
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		donHangRepository.deleteById(id);
	}

	@Override
	public List<DonHang> findByMaDHorTenCH( String maDonHang, String ten) {
		// TODO Auto-generated method stub
		return donHangRepository.findByMaDHorTenCH(maDonHang, ten);
	}

}
