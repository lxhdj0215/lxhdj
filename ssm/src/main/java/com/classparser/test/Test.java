package com.classparser.test;

import com.classparser.util.CommonUtil;

public class Test {
	public static void main(String[] args) {
		System.out.println(0x0010);
		
		byte[] arr = new byte[] {(byte)0xFF};
		System.out.println(CommonUtil.byteArrayToInt(arr));


		// ClassType PUBLIC = ClassType.ACC_PUBLIC;
		// System.out.println(PUBLIC.getValue());
		// System.out.println(PUBLIC.getType());
	}
}
