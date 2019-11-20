package test;

public class Test {
	public static void main(String[] args) {
		try{
			String str = "123";
			if(!"456".equals(str)){
				throw new Exception("I’m not 123!");
			}
		System.out.println("=== Commit ===");
		} catch(Exception e){
			System.out.println("=== Rollback ===");
			e.printStackTrace();
		} finally {
			System.out.println("=== END ===");
		}
	}
}
