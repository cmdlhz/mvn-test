package com.mvn.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.mvn.test.vo.PhotoBoardVO;

public class ReflectionTest2 {
	public static void main(String[] args) {
		List<FileItem> fis = new ArrayList<>();
		FileItem fi = new FileItem();
		fi.setKey("pbNum");
		fi.setValue(1);
		fis.add(fi);
		
		PhotoBoardVO pb = new PhotoBoardVO();	// 
		pb.setPbNum(1);
//		System.out.println(pb);	// 문자로 메모리 생성 ==> reflection
		
		String className = "com.mvn.test.vo.PhotoBoardVO";
		try {
			Class clazz = Class.forName(className);
			Object obj = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for(FileItem fil : fis) {
				for(Method meth : methods) {
					String methodName = "set" + fil.getKey().substring(0,1).toUpperCase() + fil.getKey().substring(1);
					if(meth.getName().equals(methodName)) {
						meth.invoke(obj, fil.getValue()); 
					}
				}
			}
			System.out.println(obj); // 위와 같은 결과 출력 (This is "reflection".)
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
