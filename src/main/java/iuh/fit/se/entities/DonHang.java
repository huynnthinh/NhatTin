package iuh.fit.se.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Table(name = "donhang")
@Data
public class DonHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Ma don hang khong duoc de trong")
	private String maDonHang;
	@NotEmpty(message = "Ten khach hang khong duoc de trong")
	@Size(min = 5, max = 50, message = "Ten khach hang phai lon hon 5 ky tu va nho hon 50 ky tu")
	private String tenKH;
	@NotEmpty(message = "Email khong duoc de trong")
	@Email(message = "Vui long nhap dung dinh dang email")
	private String email;
	@NotNull(message = "Ngay dat hang khong duoc de trong")
	private LocalDate ngayDatHang;
	@NotEmpty(message = "Ten san pham khong duoc de trong")
	private String tenSP;
	private boolean trangThai;
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name ="maDH")
	private CuaHang cuaHang;
	
	@PrePersist
	public void generateMaDonHang() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		this.maDonHang = LocalDateTime.now().format(formatter);
	}
}
