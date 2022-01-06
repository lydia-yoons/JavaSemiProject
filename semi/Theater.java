import java.util.Vector;
import java.util.TreeMap;

class Theater		// ��ȭ�� �ڷᱸ�� �θ�Ŭ���� �� Admin Ŭ������ ���
{
	public Vector<Movie>movieList;
	public TreeMap<Integer, Movie> theater1;
	public int[] arr1 = {9, 13, 17, 22};		// 1�� �󿵽ð�ǥ �迭 9�� / 13�� / 17�� / 22��
	public TreeMap<Integer, Movie> theater2;
	public int[] arr2 = {8, 12, 16, 23};		// 2�� �󿵽ð�ǥ �迭 8�� / 12�� / 16�� / 23��
	public TreeMap<Integer, Movie> theater3;
	public int[] arr3 = {7, 13, 18, 22};		// 3�� �󿵽ð�ǥ �迭 7�� / 13�� / 18�� / 22��

	// 1��		 3x8	�¼��迭
	public String seatArr1[][] = new String[3][8];
	// 2��		 4x8	�¼��迭
	public String seatArr2[][] = new String[4][8];
	// 3d��		 4x4	�¼��迭
	public String seatArr3[][] = new String[4][4];

	public void dataStructure()
	// ����� �ڷᱸ��(��ϵ� ��ȭ, �� �󿵰��� ��)�� ������ ȣ��
	// ���θ޼ҵ尡 ����� ��(=���α׷��� ����� ��) �ڷᱸ������ �ʱ�ȭ��
	{
		movieList = new Vector<Movie>();
		theater1 = new TreeMap<Integer, Movie>();
		theater2 = new TreeMap<Integer, Movie>();
		theater3 = new TreeMap<Integer, Movie>();
	}
	

	protected void timeTable()	// �󿵰����� Ű������ �󿵽ð�ǥ �й�����
	{
		for (int i=0; i<arr1.length; i++)
		{
			theater1.put(arr1[i], null);
			theater2.put(arr2[i], null);
			theater3.put(arr3[i], null);
		}
	}

	protected void fillArr()	// �� �󿵰��� �¼���ġ�� �迭�� �⺻������ ��(���Ű����¼�) �ο�
	{
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<8; j++)
				seatArr1[i][j] = "��";
		}

		for (int i=0; i<4; i++)
		{
			for (int j=0; j<8; j++)
				seatArr2[i][j] = "��";
		}

		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
				seatArr3[i][j] = "��";
		}
	}
	
}