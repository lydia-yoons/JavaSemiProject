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
		
		ad.dataStructure();		// admin�� �ʿ��� �ڷᱸ��
		ad.makeUserList();		// �Ǹ� ��忡 �ʿ��� �ڷᱸ�� (Ƽ���ÿ� �ִ� �޼ҵ� ȣ����̾���, ��� �� ���̳� Ȯ���� �ּ�ó�� ����)

		do
		{
			System.out.println("=====================================");
			System.out.println("\t��ȭ ���� ���Ǳ�");
			System.out.println("=====================================\n");
			
			System.out.println("1. ����");
			System.out.println("2. ���� Ȯ��");
			System.out.println("3. ���� ���");
			System.out.println("4. ������ ����");
			System.out.println("5. ���α׷� ����");
			System.out.println();
			System.out.print("���ڸ� �������ּ��� : ");
			int a = sc.nextInt();
			System.out.println();
			switch (a)
			{
			case 1: ad.customerTk(); break;
			case 2: ad.checking(); break;
			case 3: ad.cancel(); break;
			case 4: ad.passwordComfirm(); break;
			case 5: System.exit(0); break;		// ���α׷� �������� ȣ��
			}
		}
		while (true);
		

	}
}




/*
class Theater		// ��ȭ�� �ڷᱸ�� �θ�Ŭ���� �� Admin Ŭ������ ���
{
	public Vector<Movie>movieList = new Vector<Movie>();
	public TreeMap<Integer, Object> theater1 = new TreeMap<Integer, Object>();
	public int[] arr1 = {9, 13, 17, 22};		// 1�� �󿵽ð�ǥ �迭 9�� / 13�� / 17�� / 22��
	public TreeMap<Integer, Object> theater2 = new TreeMap<Integer, Object>();
	public int[] arr2 = {8, 12, 16, 23};		// 2�� �󿵽ð�ǥ �迭 8�� / 12�� / 16�� / 23��
	public TreeMap<Integer, Object> theater3 = new TreeMap<Integer, Object>();
	public int[] arr3 = {7, 13, 18, 22};		// 3�� �󿵽ð�ǥ �迭 7�� / 13�� / 18�� / 22��


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