package com.classparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.classparser.bean.ConstantPool;
import com.classparser.util.ClassUtil;

public class ConstantPoolParser {
	// UTF-8 ������ַ�����1
	public static ConstantPool parserUtf8Info(InputStream in) throws IOException {
		int length = ClassUtil.readInteger(in, 2);
		String str = ClassUtil.readStr(in, length);
		System.out.println("\t���ƣ�" + str);
		ConstantPool pool = new ConstantPool();
		pool.setType(1);
		pool.setValue(str);
		return pool;
	}

	// ������������3
	public static ConstantPool readIntegerInfo(InputStream in) throws IOException {
		int i = ClassUtil.readInteger(in, 4);
		System.out.println(i);
		ConstantPool pool = new ConstantPool();
		pool.setType(3);
		pool.setValue(i);
		return pool;
		
	}

	// ��������������4
	public static ConstantPool readFloatInfo(InputStream in) throws IOException {
		float f = ClassUtil.readFloat(in);
		System.out.println(f);
		ConstantPool pool = new ConstantPool();
		pool.setType(4);
		pool.setValue(f);
		return pool;
	}

	// ��������������5
	public static ConstantPool readLongInfo(InputStream in) throws IOException {
		long l = ClassUtil.readLong(in);
		System.out.println(l);
		ConstantPool pool = new ConstantPool();
		pool.setType(5);
		pool.setValue(l);
		return pool;
	}

	// ˫���ȸ�������������6
	public static ConstantPool readDoubleInfo(InputStream in) throws IOException {
		double d = ClassUtil.readDouble(in);
		System.out.println(d);
		ConstantPool pool = new ConstantPool();
		pool.setType(6);
		pool.setValue(d);
		return pool;
	}

	// ���ӿڵķ������ã�7
	public static ConstantPool readClassInfo(InputStream in) throws IOException {
		// name_index
		int index = ClassUtil.readInteger(in, 2);
		System.out.println("\t����ֵ��" + index);
		ConstantPool pool = new ConstantPool();
		pool.setType(7);
		List<Integer> indexs = new ArrayList<>(1);
		indexs.add(index);
		pool.setIndexs(indexs);
		return pool;
	}

	// �ַ���������������8
	public static ConstantPool readStringInfo(InputStream in) throws IOException {
		// name_index
		int index = ClassUtil.readInteger(in, 2);
		System.out.println("\t����ֵ��" + index);
		ConstantPool pool = new ConstantPool();
		pool.setType(8);
		List<Integer> indexs = new ArrayList<>(1);
		indexs.add(index);
		pool.setIndexs(indexs);
		return pool;
	}

	// �ֶεķ������ã�9
	public static ConstantPool readFieldRefInfo(InputStream in) throws IOException {
		int index1 = ClassUtil.readInteger(in, 2);
		int index2 = ClassUtil.readInteger(in, 2);
		System.out.print("��" + index1);
		System.out.println("��" + index2);
		ConstantPool pool = new ConstantPool();
		pool.setType(9);
		List<Integer> indexs = new ArrayList<>(1);
		indexs.add(index1);
		indexs.add(index2);
		pool.setIndexs(indexs);
		return pool;
	}

	// ���з����ķ������ã�10
	public static ConstantPool readMethodRefInfo(InputStream in) throws IOException {
		int index1 = ClassUtil.readInteger(in, 2);
		int index2 = ClassUtil.readInteger(in, 2);
		System.out.print("��" + index1);
		System.out.println("��" + index2);
		ConstantPool pool = new ConstantPool();
		pool.setType(10);
		List<Integer> indexs = new ArrayList<>(1);
		indexs.add(index1);
		indexs.add(index2);
		pool.setIndexs(indexs);
		return pool;
	}

	// �ӿ��з����ķ������ã�11
	public static ConstantPool readInterfaceMethodRefInfo(InputStream in) throws IOException {
		int index1 = ClassUtil.readInteger(in, 2);
		int index2 = ClassUtil.readInteger(in, 2);
		System.out.print("��" + index1);
		System.out.println("��" + index2);
		ConstantPool pool = new ConstantPool();
		pool.setType(11);
		List<Integer> indexs = new ArrayList<>(1);
		indexs.add(index1);
		indexs.add(index2);
		pool.setIndexs(indexs);
		return pool;
	}

	// �ֶλ򷽷��ķ������ã�12
	public static ConstantPool readNameAndTypeInfo(InputStream in) throws IOException {
		int index1 = ClassUtil.readInteger(in, 2);
		int index2 = ClassUtil.readInteger(in, 2);
		System.out.print("��" + index1);
		System.out.println("��" + index2);
		ConstantPool pool = new ConstantPool();
		pool.setType(12);
		List<Integer> indexs = new ArrayList<>(1);
		indexs.add(index1);
		indexs.add(index2);
		pool.setIndexs(indexs);
		return pool;

	}
}
