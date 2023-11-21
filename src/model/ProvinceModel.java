package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class ProvinceModel implements Serializable {
	private int idProvince;
	private String nameProvince;

	public ProvinceModel(int idProvince, String nameProvince) {
		this.idProvince = idProvince;
		this.nameProvince = nameProvince;
	}

	public int getIdProvince() {
		return idProvince;
	}

	public void setIdProvince(int idProvince) {
		this.idProvince = idProvince;
	}

	public String getNameProvince() {
		return nameProvince;
	}

	public void setNameProvince(String nameProvince) {
		this.nameProvince = nameProvince;
	}

	@Override
	public String toString() {
		return nameProvince;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProvince, nameProvince);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProvinceModel other = (ProvinceModel) obj;
		return idProvince == other.idProvince && Objects.equals(nameProvince, other.nameProvince);
	}
	
	public static ArrayList<ProvinceModel> getListProvince(){
		String [] arr_province = {"An Giang",
				"Bà Rịa – Vũng Tàu",
				"Bắc Giang",
				"Bắc Kạn",
				"Bạc Liêu",
				"Bắc Ninh",
				"Bến Tre",
				"Bình Định",
				"Bình Dương",
				"Bình Phước",
				"Bình Thuận",
				"Cà Mau",
				"Cần Thơ",
				"Cao Bằng",
				"Đà Nẵng",
				"Đắk Lắk",
				"Đắk Nông",
				"Điện Biên",
				"Đồng Nai",
				"Đồng Tháp",
				"Gia Lai",
				"Hà Giang",
				"Hà Nam",
				"Hà Nội",
				"Hà Tĩnh",
				"Hải Dương",
				"Hải Phòng",
				"Hậu Giang",
				"Hòa Bình",
				"Hưng Yên",
				"Khánh Hòa",
				"Kiên Giang",
				"Kon Tum",
				"Lai Châu",
				"Lâm Đồng",
				"Lạng Sơn",
				"Lào Cai",
				"Long An",
				"Nam Định",
				"Nghệ An",
				"Ninh Bình",
				"Ninh Thuận",
				"Phú Thọ",
				"Phú Yên",
				"Quảng Bình",
				"Quảng Nam",
				"Quảng Ngãi",
				"Quảng Ninh",
				"Quảng Trị",
				"Sóc Trăng",
				"Sơn La",
				"Tây Ninh",
				"Thái Bình",
				"Thái Nguyên",
				"Thanh Hóa",
				"Thừa Thiên Huế",
				"Tiền Giang",
				"TP Hồ Chí Minh",
				"Trà Vinh",
				"Tuyên Quang",
				"Vĩnh Long",
				"Vĩnh Phúc",
				"Yên Bái",};
		int i = 0;
		ArrayList<ProvinceModel> listIdProvince = new ArrayList<ProvinceModel>();
		for (String string : arr_province) {
			ProvinceModel t = new ProvinceModel(i, string);
			listIdProvince.add(t);
			i++;
		}
		return listIdProvince;
	}

	public static ProvinceModel getProvinceById(int place) {
		return ProvinceModel.getListProvince().get(place-1);
	}

	public static ProvinceModel getProvinceByName(String province) {
		ArrayList<ProvinceModel> list = ProvinceModel.getListProvince();
		for (ProvinceModel provinceModel : list) {
			if(provinceModel.nameProvince.equals(province)) {
				return provinceModel;
			}
		}
		return null;
	}
}
