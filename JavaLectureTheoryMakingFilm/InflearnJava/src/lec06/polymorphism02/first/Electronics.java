package lec06.polymorphism02.first;

public class Electronics extends Company {
	
	public int electricalPartsCount;
	public int electronicsPartsCount;
	
	public void makeMobileDevice() {
		System.out.println("����� ������ǰ�� ����ϴ�.");
	}
	
	public void homeDevice() {
		System.out.println("������ǰ�� ����ϴ�.");
	}
	
	public void systemDevice() {
		System.out.println("�ý��� ������ǰ�� ����ϴ�.");
	}
	
	public void coreDevice() {
		System.out.println("�ٽ� ������ǰ�� ����ϴ�.");
	}

}