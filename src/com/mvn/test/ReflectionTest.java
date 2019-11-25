package com.mvn.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mvn.test.vo.PhotoBoardVO;

public class ReflectionTest {
	public static void main(String[] args) {
		PhotoBoardVO pb = new PhotoBoardVO();	// 
		pb.setPbNum(1);
//		System.out.println(pb);	// 문자로 메모리 생성 ==> reflection
		
		String className = "com.mvn.test.vo.PhotoBoardVO";
		try {
			Class clazz = Class.forName(className);
			Object obj = clazz.newInstance();
			Method[] methods = clazz.getMethods();
			for(Method meth : methods) {
//				System.out.print(meth.getName()); // 상속받은 모든 methods 출력
				if(meth.getName().equals("setPbNum")) {
					meth.invoke(obj, 1); 
				}
			}
			System.out.println(obj); // 위와 같은 결과 출력 (This is "reflection".)
			/*
			 * PhotoBoardVO(pbNum=1, pbTitle=null, pbContent=null, pbImg1=, pbImg2=, pbImgFile1=null, pbImgFile2=null, credat=null, cretim=null, creusr=null, moddat=null, modtim=null, modusr=null, pbCnt=null)
			 */
			// map을 사용하지 않고도 주고 받을 수 있다.
			// 아직 만들어지 않은 class 공통 작업은 어떻게 할 것인가.
			// 이름 규칙 만 지어놓으면 내가 미리 규칙을 만들어 놓을께.
			// 선생님 회사 아무도 파일 upload 신경 안 씀
			// 요즘엔 reading이라고 해서 aop를 사용 (reflection 대신)
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
