import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;
import java.util.TreeMap;

public class Cinema
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Admin ad = new Admin();
		
		ad.dataStructure();		// admin에 필요한 자료구조
		ad.makeUserList();		// 판매 모드에 필요한 자료구조 (티켓팅에 있던 메소드 호출용이었음, 없어도 돼 보이나 확인차 주석처리 상태)

		do
		{
			System.out.println("=====================================");
			System.out.println("\t영화 예매 자판기");
			System.out.println("=====================================\n");
			
			System.out.println("1. 예매");
			System.out.println("2. 예매 확인");
			System.out.println("3. 예매 취소");
			System.out.println("4. 관리자 설정");
			System.out.println("5. 프로그램 종료");
			System.out.println();
			System.out.print("숫자를 선택해주세요 : ");
			int a = sc.nextInt();
			System.out.println();
			switch (a)
			{
			case 1: ad.customerTk(); break;
			case 2: ad.checking(); break;
			case 3: ad.cancel(); break;
			case 4: ad.passwordComfirm(); break;
			case 5: System.exit(0); break;		// 프로그램 정상종료 호출
			}
		}
		while (true);
		

	}
}




/*
class Theater		// 영화관 자료구조 부모클래스 → Admin 클래스에 상속
{
	public Vector<Movie>movieList = new Vector<Movie>();
	public TreeMap<Integer, Object> theater1 = new TreeMap<Integer, Object>();
	public int[] arr1 = {9, 13, 17, 22};		// 1관 상영시간표 배열 9시 / 13시 / 17시 / 22시
	public TreeMap<Integer, Object> theater2 = new TreeMap<Integer, Object>();
	public int[] arr2 = {8, 12, 16, 23};		// 2관 상영시간표 배열 8시 / 12시 / 16시 / 23시
	public TreeMap<Integer, Object> theater3 = new TreeMap<Integer, Object>();
	public int[] arr3 = {7, 13, 18, 22};		// 3관 상영시간표 배열 7시 / 13시 / 18시 / 22시


	protected void timeTable()
	{
		for (int i=0; i<arr1.length; i++)
		{
			theater1.put(arr1[i], null);
			theater2.put(arr2[i], null);
			theater3.put(arr3[i], null);
		}
	}
	
}
*/