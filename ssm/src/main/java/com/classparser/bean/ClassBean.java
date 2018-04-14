package com.classparser.bean;

import java.util.Map;

public class ClassBean {
	// ħ��
	private String magic;
	// �ΰ汾��
	private int minor_version;
	// ���汾��
	private int major_version;
	// ����������
	private int constant_pool_count;
	// ������
	private Map<Integer, ConstantPool> map;

	public String getMagic() {
		return magic;
	}

	public void setMagic(String magic) {
		this.magic = magic;
	}

	public int getMinor_version() {
		return minor_version;
	}

	public void setMinor_version(int minor_version) {
		this.minor_version = minor_version;
	}

	public int getMajor_version() {
		return major_version;
	}

	public void setMajor_version(int major_version) {
		this.major_version = major_version;
	}

	public int getConstant_pool_count() {
		return constant_pool_count;
	}

	public void setConstant_pool_count(int constant_pool_count) {
		this.constant_pool_count = constant_pool_count;
	}

	public Map<Integer, ConstantPool> getMap() {
		return map;
	}

	public void setMap(Map<Integer, ConstantPool> map) {
		this.map = map;
	}

}
