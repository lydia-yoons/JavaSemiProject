import java.util.Vector;
import java.util.TreeMap;

class Theater		// 영화관 자료구조 부모클래스 → Admin 클래스에 상속
{
	public Vector<Movie>movieList;
	public TreeMap<Integer, Movie> theater1;
	public int[] arr1 = {9, 13, 17, 22};		// 1관 상영시간표 배열 9시 / 13시 / 17시 / 22시
	public TreeMap<Integer, Movie> theater2;
	public int[] arr2 = {8, 12, 16, 23};		// 2관 상영시간표 배열 8시 / 12시 / 16시 / 23시
	public TreeMap<Integer, Movie> theater3;
	public int[] arr3 = {7, 13, 18, 22};		// 3관 상영시간표 배열 7시 / 13시 / 18시 / 22시

	// 1관		 3x8	좌석배열
	public String seatArr1[][] = new String[3][8];
	// 2관		 4x8	좌석배열
	public String seatArr2[][] = new String[4][8];
	// 3d관		 4x4	좌석배열
	public String seatArr3[][] = new String[4][4];

	public void dataStructure()
	// 선언된 자료구조(등록된 영화, 각 상영관별 편성)에 생성자 호출
	// 메인메소드가 실행될 때(=프로그램이 실행될 때) 자료구조들은 초기화됨
	{
		movieList = new Vector<Movie>();
		theater1 = new TreeMap<Integer, Movie>();
		theater2 = new TreeMap<Integer, Movie>();
		theater3 = new TreeMap<Integer, Movie>();
	}
	

	protected void timeTable()	// 상영관마다 키값으로 상영시간표 분배해줌
	{
		for (int i=0; i<arr1.length; i++)
		{
			theater1.put(arr1[i], null);
			theater2.put(arr2[i], null);
			theater3.put(arr3[i], null);
		}
	}

	protected void fillArr()	// 각 상영관의 좌석배치도 배열에 기본적으로 ㅁ(예매가능좌석) 부여
	{
		for (int i=0; i<3; i++)
		{
			for (int j=0; j<8; j++)
				seatArr1[i][j] = "□";
		}

		for (int i=0; i<4; i++)
		{
			for (int j=0; j<8; j++)
				seatArr2[i][j] = "□";
		}

		for (int i=0; i<4; i++)
		{
			for (int j=0; j<4; j++)
				seatArr3[i][j] = "□";
		}
	}
	
}