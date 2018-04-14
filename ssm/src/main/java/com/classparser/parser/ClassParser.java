package com.classparser.parser;

import com.classparser.bean.ClassType;

public class ClassParser {

	public static void classTypeParser(int access_flags) {
		int flag;
		// �Ƿ�Ϊpublic ����
		flag = access_flags & ClassType.ACC_PUBLIC.getValue();
		if (flag == ClassType.ACC_PUBLIC.getValue()) {
			System.out.println("public����");
		}
		// final
		flag = access_flags & ClassType.ACC_FINAL.getValue();
		if (flag == ClassType.ACC_FINAL.getValue()) {
			System.out.println("final����");
		}
		// interface
		flag = access_flags & ClassType.ACC_INTERFACE.getValue();
		if (flag == ClassType.ACC_INTERFACE.getValue()) {
			System.out.println("interface����");
		}
		// abstract
		flag = access_flags & ClassType.ACC_ABSTRACT.getValue();
		if (flag == ClassType.ACC_ABSTRACT.getValue()) {
			System.out.println("abstract����");
		}
		// synthetic
		flag = access_flags & ClassType.ACC_SYNTHETIC.getValue();
		if (flag == ClassType.ACC_SYNTHETIC.getValue()) {
			System.out.println("synthetic����");
		}
		// annotation
		flag = access_flags & ClassType.ACC_ANNOTATION.getValue();
		if (flag == ClassType.ACC_ANNOTATION.getValue()) {
			System.out.println("annotation����");
		}
		// enum
		flag = access_flags & ClassType.ACC_ENUM.getValue();
		if (flag == ClassType.ACC_ENUM.getValue()) {
			System.out.println("enum����");
		}
	}
}
