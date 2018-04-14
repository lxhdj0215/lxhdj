package com.classparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.util.List;
import java.util.Map;

import com.classparser.bean.ConstantPool;
import com.classparser.bean.FieldType;
import com.classparser.util.ClassUtil;

public class FieldParser {
	public static String getFildType(String descriptor) {
		String type = "";
		switch (descriptor) {
		case "B":
			type = "byte";
			break;
		case "C":
			type = "char";
			break;
		case "D":
			type = "double";
			break;
		case "F":
			type = "float";
			break;
		case "I":
			type = "int";
			break;
		case "J":
			type = "long";
			break;
		case "S":
			type = "short";
			break;
		case "Z":
			type = "boolean";
			break;
		case "V":
			type = "void";
			break;
		case "L":
			type = "object";
			break;
		default:
			break;
		}
		return type;
	}

	public static void readFields(InputStream in, Map<Integer, ConstantPool> map) throws IOException {
		int access_flags = ClassUtil.readInteger(in, 2);
		System.out.println("\taccess_flags��" + access_flags);
		FieldParser.readAccessFlags(access_flags);
		int name_index = ClassUtil.readInteger(in, 2);
		System.out.print("\tname_index��" + name_index);
		List<String> name = ClassUtil.getValue(map, name_index);
		System.out.println("��" + name);
		int descriptor_index = ClassUtil.readInteger(in, 2);
		System.out.print("\tdescriptor��" + descriptor_index);
		List<String> descriptor = ClassUtil.getValue(map, descriptor_index);
		System.out.print("��" + descriptor);
		System.out.println("��" + getFildType(descriptor.get(0)));
		int attributes_count = ClassUtil.readInteger(in, 2);
		System.out.println("\tattributes_count��" + attributes_count);
		for (int i = 0; i < attributes_count; i++) {
			AttributeParser.parserAttribute(in, map);
		}
	}

	public static void readAccessFlags(int access_flags) {
		int flag;
		// �Ƿ�Ϊpublic ����
		flag = access_flags & FieldType.ACC_PUBLIC.getValue();
		if (flag == FieldType.ACC_PUBLIC.getValue()) {
			System.out.println("public����");
		}
		// �Ƿ�Ϊprivate ����
		flag = access_flags & FieldType.ACC_PRIVATE.getValue();
		if (flag == FieldType.ACC_PRIVATE.getValue()) {
			System.out.println("private����");
		}
		// �Ƿ�Ϊprotected ����
		flag = access_flags & FieldType.ACC_PROTECTED.getValue();
		if (flag == FieldType.ACC_PROTECTED.getValue()) {
			System.out.println("protected����");
		}
		// �Ƿ�Ϊstatic ����
		flag = access_flags & FieldType.ACC_STATIC.getValue();
		if (flag == FieldType.ACC_STATIC.getValue()) {
			System.out.println("static����");
		}
		// final
		flag = access_flags & FieldType.ACC_FINAL.getValue();
		if (flag == FieldType.ACC_FINAL.getValue()) {
			System.out.println("final����");
		}
		// volatile
		flag = access_flags & FieldType.ACC_VOLATILE.getValue();
		if (flag == FieldType.ACC_VOLATILE.getValue()) {
			System.out.println("volatile����");
		}
		// transient
		flag = access_flags & FieldType.ACC_TRANSIENT.getValue();
		if (flag == FieldType.ACC_TRANSIENT.getValue()) {
			System.out.println("transient����");
		}
		// synthetic
		flag = access_flags & FieldType.ACC_SYNTHETIC.getValue();
		if (flag == FieldType.ACC_SYNTHETIC.getValue()) {
			System.out.println("synthetic����");
		}
		// enum
		flag = access_flags & FieldType.ACC_ENUM.getValue();
		if (flag == FieldType.ACC_ENUM.getValue()) {
			System.out.println("enum����");
		}
	}
}
