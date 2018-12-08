package Chapter14_1;

@FunctionalInterface
interface MyFunction {
	void myMethod();	// public abstract void myMethod();
}

public class LambdaEx2 {
	
	public static void main(String[] args) {
		MyFunction f = () -> {};	// MyFunction f = (MyFunction)(() -> {});
		Object obj = (MyFunction)(() -> {});	// Object타입으로 형변환이 생략됨.
		String str = ((Object)(MyFunction)(() -> {})).toString();
		
		System.out.println(f);
		System.out.println(obj);
		System.out.println(str);
		
		System.out.println((MyFunction)(() -> {}));		
	}

}
