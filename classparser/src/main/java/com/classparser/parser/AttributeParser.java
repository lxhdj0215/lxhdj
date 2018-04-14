package com.classparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.classparser.bean.ConstantPool;
import com.classparser.util.ClassUtil;

public class AttributeParser {
	public static void parserAttribute(InputStream in, Map<Integer, ConstantPool> map) throws IOException {
		int attribute_name_index = ClassUtil.readInteger(in, 2);
		System.out.print("\tattribute_name_index£º" + attribute_name_index);
		List<String> name = ClassUtil.getValue(map, attribute_name_index);
		System.out.println("£º" + name);
		int attribute_length = ClassUtil.readInteger(in, 4);
		System.out.println("\tattribute_length£º" + attribute_length);
		if ("Code".equals(name.get(0))) {
			readCode(in, map);
		} else if ("LineNumberTable".equals(name.get(0))) {
			readLineNumberTable(in);
		} else if ("LocalVariableTable".equals(name.get(0))) {
			readLocalVariableTable(in);
		} else if ("SourceFile".equals(name.get(0))) {
			readSourceFile(in,map);
		}
	}

	public static void readLocalVariableTable(InputStream in) throws IOException {
		int local_variable_table_length = ClassUtil.readInteger(in, 2);
		System.out.println("\tlocal_variable_table_length£º" + local_variable_table_length);
		for (int i = 0; i < local_variable_table_length; i++) {
			int start_pc = ClassUtil.readInteger(in, 2);
			System.out.println("\tstart_pc£º" + start_pc);
			int length = ClassUtil.readInteger(in, 2);
			System.out.println("\tlength£º" + length);
			int name_index = ClassUtil.readInteger(in, 2);
			System.out.println("\tname_index£º" + name_index);
			int descriptor_index = ClassUtil.readInteger(in, 2);
			System.out.println("\tdescriptor_index£º" + descriptor_index);
			int index = ClassUtil.readInteger(in, 2);
			System.out.println("\tindex£º" + index);
		}
	}

	public static void readLineNumberTable(InputStream in) throws IOException {
		int line_number_table_length = ClassUtil.readInteger(in, 2);
		System.out.println("\tline_number_table_length£º" + line_number_table_length);
		for (int i = 0; i < line_number_table_length; i++) {
			int start_pc = ClassUtil.readInteger(in, 2);
			System.out.println("\tstart_pc£º" + start_pc);
			int line_number = ClassUtil.readInteger(in, 2);
			System.out.println("\tline_number£º" + line_number);
		}
	}
	
	public static void readSourceFile(InputStream in, Map<Integer, ConstantPool> map) throws IOException {
		int sourcefile_index = ClassUtil.readInteger(in, 2);
		System.out.print("\tsourcefile_index£º" + sourcefile_index);
		List<String> name = ClassUtil.getValue(map, sourcefile_index);
		System.out.println("£º" + name);
	}

	public static void readCode(InputStream in, Map<Integer, ConstantPool> map) throws IOException {
		int max_stack = ClassUtil.readInteger(in, 2);
		System.out.println("\tmax_stack£º" + max_stack);
		int max_locals = ClassUtil.readInteger(in, 2);
		System.out.println("\tmax_locals£º" + max_locals);
		int code_length = ClassUtil.readInteger(in, 4);
		System.out.println("\tcode_length£º" + code_length);
		for (int i = 0; i < code_length; i++) {
			int code = ClassUtil.readInteger(in, 1);
			System.out.println("\t" + i + ":" + Integer.toHexString(code));
		}
		int exception_table_lenth = ClassUtil.readInteger(in, 2);
		System.out.println("\texception_table_lenth£º" + exception_table_lenth);
		for (int i = 0; i < exception_table_lenth; i++) {

		}
		int attributes_count = ClassUtil.readInteger(in, 2);
		System.out.println("\tattributes_count£º" + attributes_count);
		for (int i = 0; i < attributes_count; i++) {
			parserAttribute(in, map);
		}
	}
}
