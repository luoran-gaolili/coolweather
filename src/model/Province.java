package model;

public class Province {
	// ������id
	private int id;
	// ʡ������
	private String provinceName;
	// ʡ�ݴ���
	private String provinceCode;

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceName=" + provinceName
				+ ", provinceCode=" + provinceCode + "]";
	}

}
