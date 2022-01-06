import java.util.Scanner;
import java.util.Vector;
import java.util.Enumeration;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Calendar;

class Admin extends Theater
{
	private String password = "abc1234";	// 패스워드 private 변수 설정
//
	int i=1000;			// 고객 예매번호 초기값
	public Vector<Customer> userList;

	public void makeUserList()	// 프로그램 시작시 main 메소드에 userList에 벡터 생성자 호출할 메소드
	{
		 userList = new Vector<Customer>();
	}


//
	public String getPass()		// 패스워드 변수 get()
	{
		return password;
	}

	public void passwordComfirm()		// 패스워드 확인 메소드
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[관리자 화면에 접근하기 위해서는 비밀번호가 필요합니다.]");
		System.out.print("\n>> 비밀번호를 입력하세요 : ");
		String pass = sc.next();
		System.out.println();

		if ((getPass()).equals(pass))
		{
			System.out.println("\n[로그인 성공]\n");
			adminMenu();
		}
		else
			System.out.println("\n[잘못 입력하셨습니다. 메인 화면으로 돌아갑니다.]\n");
			return;
	}

	public void adminMenu()		// 관리자 메뉴 출력
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println("\n=====================================");
			System.out.println("\t    관리자 메뉴");
			System.out.println("=====================================\n");

			System.out.println("1. 편성 시간표 보기");
			System.out.println("2. 상영 영화 등록");
			System.out.println("3. 상영 영화 삭제");
			System.out.println("4. 영화 편성 추가");
			System.out.println("5. 영화 편성 삭제");
			System.out.println("6. 메인으로 돌아가기");
			System.out.println();
			System.out.print(">> 숫자를 선택해주세요 : ");

			int a = sc.nextInt();
			System.out.println();

			switch (a)
			{
			case 1: movieTimeTable(); break;
			case 2: movieAdd(); break;
			case 3: movieDel(); break;
			case 4: movieForm(); break;
			case 5: movieFormDel(); break;
			case 6: return;		// adminMenu() 종료 → main()으로 돌아감
			}
			
		}
		while (true);
	}//end adminMenu()
	
	public String todayIs()	// (오늘) "ㅇㅇ년 ㅇ월 ㅇ일 ㅇ요일" 문자열로 반환하는 메소드
	{
		Calendar cd = Calendar.getInstance();
		
		int w = cd.get(Calendar.DAY_OF_WEEK);
		String week = "";
		switch (w)
		{
			case Calendar.SUNDAY : week = "일요일"; break;
			case Calendar.MONDAY : week = "월요일"; break;
			case Calendar.TUESDAY : week = "화요일"; break;
			case Calendar.WEDNESDAY : week = "수요일"; break;
			case Calendar.THURSDAY : week = "목요일"; break;
			case Calendar.FRIDAY : week = "금요일"; break;
			case Calendar.SATURDAY : week = "토요일"; break;		
		}

		String today = cd.get(Calendar.YEAR)+"년 "+(cd.get(Calendar.MONTH)+1)+"월 "+cd.get(Calendar.DATE)+"일 "+week;
		return today;
		
	}//end todayIs()

	public void movieTimeTable()	// 편성 시간표 보기
	{
		System.out.println("\n=====================================\n");
		System.out.printf("\t[ %s ]",todayIs());
		System.out.println("\n\t   [상영관별 운영 현황]\n");			

		
		System.out.print("[1관]  ");
		for (int i=0; i<4; i++)	
		{
			if (theater1.get(arr1[i])!=null)
				System.out.print(" " + (i+1) +". " +arr1[i]+ "시("+(theater1.get(arr1[i])).movieName+")  ");
			else
				System.out.print(" " + (i+1) +". " +arr1[i]+ "시("+"없음"+")  ");
		}	
		
		System.out.print("\n[2관]  ");
		for (int i=0; i<4; i++)	
		{
			if (theater2.get(arr2[i])!=null)
				System.out.print(" " + (i+1) +". " +arr2[i]+ "시("+(theater2.get(arr2[i])).movieName+")  ");
			else
				System.out.print(" " + (i+1) +". " +arr2[i]+ "시("+"없음"+")  ");
		}	
		
		System.out.print("\n[3D관] ");
		for (int i=0; i<4; i++)	
		{
			if (theater3.get(arr3[i])!=null)
				System.out.print(" " + (i+1) +". " +arr3[i]+ "시("+(theater3.get(arr3[i])).movieName+")  ");
			else
				System.out.print(" " + (i+1) +". " +arr3[i]+ "시("+"없음"+")  ");
		}	
		
		System.out.println();
		System.out.println("\n=====================================");

	}//end movieTimeTable()


	public void movieAdd()	// 상영 영화 등록
	{
		Scanner sc = new Scanner(System.in);
		Movie mv = new Movie();

		System.out.println("\n=====================================");
		System.out.println("\t    영화 추가");
		System.out.println("=====================================\n");

		System.out.println("[현재 상영가능 영화 목록]");

		for (int i=0; i<movieList.size(); i++)
		{
			if (true == (movieList.get(i).is3D))
			{
				System.out.printf("%d. %s (3D)\n", i+1, movieList.get(i).movieName);	
				// 만약 is3D 가 true면 (즉 3D영화면) 영화이름 뒤에 (3D) 라고 표기	
			}
			else
			{
				System.out.printf("%d. %s\n", i+1, movieList.get(i).movieName);		
			}
		}
		System.out.println();
		
		if (movieList.size()>=5)
		{
			System.out.println("\n[상영 가능한 영화 갯수가 5개를 초과할 수 없습니다.]\n");
			return;
		}
		else
			System.out.print(">> 영화 제목 입력 : ");
			mv.movieName = sc.nextLine();	// ★ 띄어쓰기까지 전부 입력받을려면 next() 대신 nextLine() 사용
			/*
			System.out.print(">> 러닝 타임 입력 : ");
			mv.runningTime = sc.nextInt();
			System.out.print(">> 제한 연령 입력(전체관람가는 0) : ");
			mv.movieGrade = sc.nextInt();
			*/
			System.out.print("\n>> 3D 영화 여부(Y/N) : ");
			String con = sc.next();
			if (con.toUpperCase().equals("Y"))
			{
				mv.is3D = true;
			}
			else if(con.toUpperCase().equals("N"))
			{
				mv.is3D = false;
			}
			else 
			{
				System.out.println("\n[잘못입력했습니다. 관리자 메뉴로 돌아갑니다.]");
				return;
			}

			

			movieList.addElement(mv);
			System.out.println();
			if (movieList.contains(mv))
			{
				System.out.println("[영화가 정상적으로 등록되었습니다.]\n");
			}
			else
				System.out.println("[등록 과정에서 문제가 발생했습니다.]\n");

		
	}//end movieAdd()

	public void movieDel()	// 상영 영화 삭제
	{
		Scanner sc = new Scanner(System.in);
		Movie mv = new Movie();
		String con;
		boolean b=true;

		do
		{
			System.out.println("\n=====================================");
			System.out.println("\t    영화 삭제");
			System.out.println("=====================================\n");
			System.out.println("[현재 상영 영화 목록]");

			for (int i=0; i<movieList.size(); i++)
			{
				if (true == (movieList.get(i).is3D))
				{
					System.out.printf("%d. %s (3D)\n", i+1, movieList.get(i).movieName);	
					// 만약 is3D 가 true면 (즉 3D영화면) 영화이름 뒤에 (3D) 라고 표기	
				}
				else
				{
					System.out.printf("%d. %s\n", i+1, movieList.get(i).movieName);		
				}	
			}
			
			if (0>=movieList.size())
			{
				System.out.println("\n[※삭제 가능한 영화가 없습니다. 관리자 메뉴로 돌아갑니다.]");
				return;
			}

			System.out.print("\n>> 삭제할 영화의 번호를 입력하세요. : ");
			int num = sc.nextInt();

			if (num>movieList.size())
			{
				System.out.println("\n[※유효한 값이 아닙니다. 다시 입력하세요.]");
				movieDel();
			}
			else 
			{
				for (int i=0; i<4; i++)	// 편성표에 등록되어있는 영화는 삭제 못하도록 하는 반복문
				{
					if ((theater1.get(arr1[i]))!=null)	// ★ 오류 잡음
					{
						if ((theater1.get(arr1[i])).movieName.equals(movieList.get(num-1).movieName))
						{
							System.out.println("\n[편성표에 영화가 등록되어 있는 상태입니다. 편성을 먼저 삭제해 주세요.]");
							System.out.println("[관리자 메뉴로 돌아갑니다.]");
							return;
						}
					}

					if ((theater2.get(arr2[i]))!=null)
					{
						if ((theater2.get(arr2[i])).movieName.equals(movieList.get(num-1).movieName))
						{
							System.out.println("\n[편성표에 영화가 등록되어 있는 상태입니다. 편성을 먼저 삭제해 주세요.]");
							System.out.println("[관리자 메뉴로 돌아갑니다.]");
							return;
						}
					}

					if ((theater3.get(arr3[i]))!=null)
					{
						if ((theater3.get(arr3[i])).movieName.equals(movieList.get(num-1).movieName))
						{
							System.out.println("\n[편성표에 영화가 등록되어 있는 상태입니다. 편성을 먼저 삭제해 주세요.]");
							System.out.println("[관리자 메뉴로 돌아갑니다.]");
							return;
						}
					}

				}
				
				movieList.remove(num-1);		// 삭제
				movieList.trimToSize();
				System.out.println();
				for (int i=0; i<movieList.size(); i++)			
					System.out.printf("%d. %s\n", i+1, movieList.get(i).movieName);				
			
				System.out.println();
				System.out.print("[정상적으로 삭제되었습니다.]\n더 삭제 하시겠습니까? (Y/N) : ");
				con = sc.next().toUpperCase();
				

				if (con.equals("Y"))
					b = true;
				else
					b = false;

			}			
		}while (b);		
			
	} //end movieDel()


	public void movieForm()	// 영화 편성 추가
	{	
		Scanner sc = new Scanner(System.in);
		
		int theaterMovie;	// 영화를 입력받을 변수
		int theaterNum;		// 관을 입력 받을 변수
		int theaterTime;	// 시간대 입력받을 변수
		
		boolean b =  true;
		Movie mv = new Movie();

		while (b)
		{
			System.out.println("\n=====================================");
			System.out.println("\t    영화 편성");
			System.out.println("=====================================\n");
			System.out.println("[편성 가능 영화 목록]");
			for (int i=0; i<movieList.size(); i++)
			{
				
				if (true == (movieList.get(i).is3D))
					System.out.printf("%d. %s (3D)\n", i+1, movieList.get(i).movieName);	
					// 만약 is3D 가 true면 (즉 3D영화면) 영화이름 뒤에 (3D) 라고 표기				

				else
				System.out.printf("%d. %s \n", i+1, movieList.get(i).movieName);	
				//System.out.printf("%d. %s (%s)\n", i+1, movieList.get(i).movieName, movieList.get(i).is3D);	
			}
			
			movieTimeTable();	// 현재 편성 시간표 출력
			
			if (movieList.size()<1)
			{
				System.out.println("\n[편성 가능한 영화가 없습니다. 영화를 등록해주세요.]");
				System.out.println("[관리자 메뉴로 돌아갑니다.]\n");
				return;
			}

			System.out.print("\n>> 편성할 영화를 선택하세요 : ");
			theaterMovie = sc.nextInt();
			mv = movieList.get(theaterMovie-1);

								
			if (movieList.get(theaterMovie-1).is3D)		// 3d영화일 경우
			{			
				System.out.print("\n>> 상영관을 선택하세요(1~3) : ");
				theaterNum = sc.nextInt();
				 

				if (theaterNum == 1 || theaterNum == 2)
				{
					System.out.println("\n[※3D관에만 편성이 가능한 영화입니다. 다시 선택하세요!]\n");
					//movieForm();
					//theaterTime=0;
					//break outerLoop;
					continue;
				}

				else
				{
					System.out.print("\n>> 상영이 가능한 시간대를 고르세요 : ");
					theaterTime = sc.nextInt();
					mv.movieTime = arr3[theaterTime-1];
				}
			}

			else	// 3d영화가 아닐경우
			{
				System.out.print("\n>> 상영관을 선택하세요(1~3) : ");
				theaterNum = sc.nextInt();

				if (theaterNum == 1)
				{
					System.out.print("\n>> 상영이 가능한 시간대를 고르세요 : ");
					theaterTime = sc.nextInt();
					mv.movieTime = arr1[theaterTime-1];
				}

				else if (theaterNum == 2)
				{
					System.out.print("\n>> 상영이 가능한 시간대를 고르세요 : ");
					theaterTime = sc.nextInt();
					mv.movieTime = arr2[theaterTime-1];
				}

				else
				{
					System.out.println("\n[※3D영화만 편성할 수 있는 상영관입니다. 다시 선택하세요!]\n");
					//movieForm();
					//theaterTime=0;
					//break outerLoop;
					continue;
				}
			}
			mv.gwan = theaterNum;
			fillArr();	// 좌석배치도 배열 빈자리(□)로 채우기 메소드

			switch (theaterNum)
			{
				case 1: theater1.put(arr1[(theaterTime)-1], mv); 
						mv.movieSeatArr = seatArr1; break;			// 1관에 편성되는 Movie 객체에 좌석배열 1관 배열[3x8] 할당
				case 2: theater2.put(arr2[(theaterTime)-1], mv);
						mv.movieSeatArr = seatArr2; break;			// 2관에 편성되는 Movie 객체에 좌석배열 2관 배열[4x8] 할당
				case 3: theater3.put(arr3[(theaterTime)-1], mv);
						mv.movieSeatArr = seatArr3; break;			// 3관에 편성되는 Movie 객체에 좌석배열 3관 배열[4x4] 할당
			}
			b= false;
			
		}//end 영화편성 while문

			/* mv가 theater1에 잘 들어갔는지 확인용 출력
			if (theater1.get(9)!=null)
			{
				for (int i=0; i<3; i++)	
				{
					for (int j=0; j<8; j++)
						System.out.print((theater1.get(9)).movieSeatArr[i][j]);

					System.out.println();
				}

				System.out.println((theater1.get(9)).movieName);
				System.out.println((theater1.get(9)).is3D);
			}
			*/

	}//end movieForm()

	public void movieFormDel()	// 영화 편성 삭제
	{
		Scanner sc = new Scanner(System.in);
		int theaterNum;		// 관을 입력 받을 변수
		int theaterTime;	// 시간대 입력받을 변수
		

		System.out.println("\n=====================================");
		System.out.print("\t    편성 삭제");
		movieTimeTable();	// 현재 편성 시간표 출력

		boolean isThereNothing=true;	// 삭제할 편성이 있다면 false, 삭제할 편성이 없다면 true값을 반환할 boolean
		
		for (int i=0; i<4; i++)
		{
			if (theater1.get(arr1[i])!=null)	// 1관의 value가 null이 아니라면
			{
				isThereNothing = false;
				break;
			}

			if (theater2.get(arr2[i])!=null)	// 2관의 value가 null이 아니라면
			{
				isThereNothing = false;
				break;
			}

			if (theater3.get(arr3[i])!=null)	// 3관의 value가 null이 아니라면
			{
				isThereNothing = false;
				break;
			}
		}

		if (isThereNothing)	// isThereNothing이 true일 때(삭제할 편성이 없을 때) 메소드 종료
		{
			System.out.println("\n[삭제할 편성이 존재하지 않습니다.]");
			System.out.println("[관리자 메뉴로 돌아갑니다.]\n");
			return;
		}

		System.out.print("\n>> 편성 삭제할 관을 입력해주세요(1~3) : ");
		theaterNum = sc.nextInt();

		System.out.print("\n>> 편성 삭제할 시간대 입력해주세요 : ");
		theaterTime = sc.nextInt();

		if (theaterNum == 1)
		{
			theater1.remove(arr1[(theaterTime)-1]);
		}
		else if (theaterNum == 2)
		{
			theater2.remove(arr2[(theaterTime)-1]);
		}

		else if (theaterNum == 3)
		{
			theater3.remove(arr3[(theaterTime)-1]);
		}
	
	}// end movieFormDel()


//////////////////////////////////////////////////////////////////////////////////////////////////// movieFormDel() 영화 편성삭제

	public void customerTk() //고객 티켓 예매시
	{
		Scanner sc = new Scanner(System.in);
		Customer cm = new Customer();
		int h;							// 사용자 입력값을 임시 저장할 변수
		boolean b = true;

		// 주민번호 유효성 검사를 위한 배열
		int[] chk = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};

		// 곱셈 연산 후 누적합 할 변수
		int tot=0;

		System.out.print("\n>> 이름을 입력해주세요 : ");
		String erum = sc.next();


		System.out.print("\n>> 주민번호를 입력해주세요(xxxxxx-xxxxxxx) : ");
		String jumin = sc.next();

		if (jumin.length() != 14)
		{
			System.out.println("\n[입력오류입니다.]\n");
			return;
		}

		for (int i=0; i<13; i++)
		{
			if (i==6)
				continue;

			tot += chk[i] * Integer.parseInt(jumin.substring(i, (i+1)));
		}

		int su = 11 - tot%11;
		su = su % 10;


		// 주민번호 유효성 검사 결과 출력
		// 유효성 검사를 통과해야만 userList 벡터에 모든 값 추가
		if (su == Integer.parseInt(jumin.substring(13)))
		{
			System.out.println("\n[주민번호가 확인되었습니다.]\n");
			cm.setUserName(erum);
			cm.setUserID(jumin);

			// 관람일 출력
			System.out.print("\n관람일 : " + todayIs());
			cm.userDate = todayIs();
			System.out.println();
		}
		else
		{
			System.out.println("[잘못된 주민번호입니다.]\n");
			return;
		}

		while(b)
		{
			//관람 인원수 입력
			System.out.println("\n=========[관람 인원 수 입력]=========");
			System.out.println("※ 예매가능 인원 수는 최대 2명 입니다");
			System.out.print("\n>> 총 인원 수 입력 (1~2) : ");
			h = sc.nextInt();

			if (h <= 2 && h >= 1)
			{
				// 인원수 입력 후 userList.get(i).userNum에 추가
				cm.userNum = h;
				b = false;
			}

			else
			{
				System.out.println("\n[인원수가 잘못됐습니다.]\n");
				continue;
			}
		}

		// 영화 및 시간 선택
		movieTimeTable();	// 현재 편성 시간표 출력
		
		System.out.print("\n>> 상영관 선택 (1~3) : ");
		h = sc.nextInt();
		int sn = h;			// 상영관 값 받아두기

		if (h <= 3 && h >= 1)
		{
			cm.userScreen = h;
		}
		else
		{
			System.out.println("\n[상영관을 잘못 입력하셨습니다.]\n");
			return;
		}

		System.out.print("\n>> 시간 선택 (1~4) : ");
		h = sc.nextInt();

		if (h <= 4 && h >= 1)
		{
			try
			{	if (sn==1)	//상영관이 1일때
				{
					if (theater1.get(arr1[h-1])==null)
						throw new Exception();
				}
				if (sn==2)	//상영관이 2일때
				{
					if (theater2.get(arr2[h-1])==null)
						throw new Exception();
				}
				if (sn==3)	//상영관이 3일때
				{
					if (theater3.get(arr3[h-1])==null)
						throw new Exception();
				}
				
			}
			catch (Exception e)
			{
				System.out.println("[해당시간에 상영하는 영화가 없습니다.]\n");
				return;
			}

			cm.userTime = h;
		}
		else
		{
			System.out.println("[시간을 잘못 입력하셨습니다.]\n");
			return;
		}
		
		   /////여기부터 자리선택 편집중~~ ★★
	  System.out.println();
	  System.out.println("[ 자리 선택 ]");
      System.out.println("[ 예매 가능한 좌석 : □ // 예매 불가능한 좌석 : ■ ]\n");
	  System.out.println("----스크린----");
      showSeats(sn, h);
      System.out.println();
	  System.out.println("행 : → / 열 : ↓\n");
      
      int count = 1;

      do
      {
         System.out.printf("[%d번 좌석 선택]\n", count);

         System.out.print(">> 행 선택(숫자 입력) : ");
         int hang = sc.nextInt();
         System.out.print(">> 열 선택(숫자 입력) : ");
         int yeol = sc.nextInt();
         
		 switch (count)	// ★★★ 스위치문 추가
		 {
			case 1: cm.userSeatHang1=hang;
					cm.userSeatYeol1=yeol; break;
			case 2: cm.userSeatHang2=hang;
					cm.userSeatYeol2=yeol; break;
		 }
         
         if (!bookSeat(sn, h, hang, yeol)) // bookSeat 값이 true면 □→■ 됨 : 예약이 됐다는 뜻임
         {
            System.out.println("이미 예약된 좌석입니다. 다른 자리를 선택해주세요.\n");
            count--;
         }
         
         if (count==cm.userNum)
         {
            System.out.println("[자리 예약 완료]");
            break;
         }
         count++;
         
      }
      while (true);
      //////여기까지~~~ ★★

		// 예매번호 부여 (1000부터 ++)
		cm.ticketNumber = i;			// 예매번호
		i++;							// 예매번호 1씩 증가


		//userList에 값 넣어주기
		userList.add(cm);


		pay();

/*
		//test
		for (int j = 0; j<userList.size(); j++)
		{
			System.out.println(j + " : " + userList.get(j).getUserName() + ", " + userList.get(j).ticketNumber + 
			", " + userList.get(j).getUserID() + ", " + userList.get(j).userDate +
			", " + userList.get(j).userNum + ", " + userList.get(j).userScreen + ", " + userList.get(j).userTime);
		}
		System.out.println(userList.size());
*/

	}//end customerTk()
////////////////////////////////////////////////////////////////////////////////////////////////////// Ticketing 예매


	public void showSeats(int sn, int h)	// ★★ 예약한 영화의 좌석배치도 출력
	{
		try
		{
			if (sn==1) // 3x8
			{
				for (int i=0; i<3; i++)
				{
					for (int j=0; j<8; j++)
						System.out.print(theater1.get(arr1[h-1]).movieSeatArr[i][j]);
					System.out.println();
				}
			}
			else if (sn==2)	// 4x8
			{
				for (int i=0; i<4; i++)
				{
					for (int j=0; j<8; j++)
						System.out.print(theater2.get(arr2[h-1]).movieSeatArr[i][j]);
					System.out.println();
				}
			}
			else // 4x4
			{
				for (int i=0; i<4; i++)
				{
					for (int j=0; j<4; j++)
						System.out.print(theater3.get(arr3[h-1]).movieSeatArr[i][j]);
					System.out.println();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("해당시간에 상영하는 영화가 없습니다.\n");
			return;
		}
		
	}//end shoeSeats()



	public boolean bookSeat(int sn, int h, int hang, int yeol)
	// ★★ 편성표에 저장된 좌석배치도 배열에 예매가능(□)→예매불가능(■) 바꿔주는 메소드
	{
		boolean result = false;
		try
		{
			switch (sn)
			{
			case 1:		// ★★★ 
				if (theater1.get(arr1[h-1]).movieSeatArr[hang-1][yeol-1].equals("□"))
				{
					theater1.get(arr1[h-1]).movieSeatArr[hang-1][yeol-1] = "■";
					result = true;
					
				};
				break;
				
			case 2:
				if (theater2.get(arr2[h-1]).movieSeatArr[hang-1][yeol-1].equals("□"))
				{
					theater2.get(arr2[h-1]).movieSeatArr[hang-1][yeol-1] = "■";
					result = true;
				};
				break;

			case 3:
				if (theater3.get(arr3[h-1]).movieSeatArr[hang-1][yeol-1].equals("□"))
				{
					theater3.get(arr3[h-1]).movieSeatArr[hang-1][yeol-1] = "■";
					result = true;
				};
				break;
			}

			return result;
		}
		catch (Exception e)
		{
			System.out.println("해당시간에 상영하는 영화가 없습니다.\n");
			return result;
		}
	}//end bookSeat()

///////////////////////////////////////////////////////////////////////////////////////////// showSeats() bookSeat() 좌석 선택

	
	public void pay()
	{
		Scanner sc = new Scanner(System.in);
		

		System.out.println("\n=====================================");
		System.out.println("\t    [결제 금액 확인]");
		System.out.println("=====================================\n");
		System.out.printf("[관람 인원 총 %d명으로, 결제 금액은 %,d원 입니다.]\n", userList.get(userList.size()-1).userNum, (userList.get(userList.size()-1).userNum)*15000);
		System.out.print(">> 결제 하시겠습니까? (Y/N) : ");
		String con = sc.next();

		
		if (con.toUpperCase().equals("Y"))
		{
			System.out.println("\n=====================================");
			System.out.println("     [결제가 완료 되었습니다.]");
			System.out.println("=====================================\n");		
			

			int h = (userList.get(userList.size()-1).ticketNumber);
				
			for (int j = 0; j<userList.size(); j++)
			{
				if ((userList.get(j).ticketNumber) == h)
				{

					if (userList.get(j).userScreen == 1)
					{
						System.out.println("예매자 명 : " + userList.get(j).getUserName());
						System.out.println("영화 제목 : " + theater1.get(arr1[userList.get(j).userTime-1]).movieName + "(" + userList.get(userList.size()-1).userScreen + "관)");
						System.out.println("상영 날짜 : " + userList.get(j).userDate);
						System.out.println("시작 시간 : " + theater1.get(arr1[userList.get(j).userTime-1]).movieTime + "시");
						System.out.print("예약 좌석 : "); //////////////★★★
						if (userList.get(j).userNum == 1)
						{
							System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						}
						else if (userList.get(j).userNum == 2)
						{
							System.out.printf("%d행, %d열 / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
							System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
						}////////////////////
						System.out.print("예매 번호 : "+ userList.get(userList.size()-1).ticketNumber);
						System.out.printf("\n금     액 : %,d원\n",(userList.get(userList.size()-1).userNum)*15000);
					}
					if (userList.get(j).userScreen == 2)
					{
						System.out.println("예매자 명 : " + userList.get(j).getUserName());
						System.out.println("영화 제목 : " + theater2.get(arr2[userList.get(j).userTime-1]).movieName + "(" + userList.get(userList.size()-1).userScreen + "관)");
						System.out.println("상영 날짜 : " + userList.get(j).userDate);
						System.out.println("시작 시간 : " + theater2.get(arr2[userList.get(j).userTime-1]).movieTime + "시");
						System.out.print("예약 좌석 : "); //////////////★★★
						if (userList.get(j).userNum == 1)
						{
							System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						}
						else if (userList.get(j).userNum == 2)
						{
							System.out.printf("%d행, %d열 / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
							System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
						}////////////////////
						System.out.print("예매 번호 : "+ userList.get(userList.size()-1).ticketNumber);
						System.out.printf("\n금     액 : %,d원\n",(userList.get(userList.size()-1).userNum)*15000);
					}
					if (userList.get(j).userScreen == 3)
					{ 
						System.out.println("예매자 명 : " + userList.get(j).getUserName());
						System.out.println("영화 제목 : " + theater3.get(arr3[userList.get(j).userTime-1]).movieName + "(" + userList.get(userList.size()-1).userScreen + "관)");
						System.out.println("상영 날짜 : " + userList.get(j).userDate);
						System.out.println("시작 시간 : " + theater3.get(arr3[userList.get(j).userTime-1]).movieTime + "시");
						System.out.print("예약 좌석 : "); //////////////★★★
						if (userList.get(j).userNum == 1)
						{
							System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						}
						else if (userList.get(j).userNum == 2)
						{
							System.out.printf("%d행, %d열 / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
							System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
						}////////////////////
						System.out.print("예매 번호 : "+ userList.get(userList.size()-1).ticketNumber);
						System.out.printf("\n금     액 : %,d원\n",(userList.get(userList.size()-1).userNum)*15000);
					}					

					System.out.println();
				}
			}
								
		}
		
		
		else
		{
			System.out.println("\n[결제가 취소되어 메인 화면으로 돌아갑니다.]");
			///////////////////★★★
			int temp = userList.get(userList.size()-1).userTime;

			switch (userList.get(userList.size()-1).userScreen)
			{
				case 1:
					if (userList.get(userList.size()-1).userNum==1)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
					}
					else if (userList.get(userList.size()-1).userNum==2)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
						x = userList.get(userList.size()-1).userSeatHang2;
						y = userList.get(userList.size()-1).userSeatYeol2;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
					}
					break;
				case 2:
					if (userList.get(userList.size()-1).userNum==1)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
					}
					else if (userList.get(userList.size()-1).userNum==2)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "□";
						x = userList.get(userList.size()-1).userSeatHang2;
						y = userList.get(userList.size()-1).userSeatYeol2;
						theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "□";
					}
					break;
				case 3:
					if (userList.get(userList.size()-1).userNum==1)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "□";
					}
					else if (userList.get(userList.size()-1).userNum==2)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "□";
						x = userList.get(userList.size()-1).userSeatHang2;
						y = userList.get(userList.size()-1).userSeatYeol2;
						theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "□";
					}
					break;
			}
			////////////////////////////
			userList.remove(userList.size()-1);		// 삭제
			userList.trimToSize();
			i--;
			// System.out.println(" 현재 : userList.size() : "+userList.size()); //혜진 테스트
			return;
		}		
		
	}//end pay()

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////pay 결제 


	public void checking()	//고객 예매 확인
	{
		boolean b = true;

		Scanner sc = new Scanner(System.in);
		
		if (userList.size() == 0)
		{
			System.out.println("[예매한 사람이 없습니다.]\n");
			return;
		}

		// 사용자 입력값과 벡터 저장값 동일 유무 확인
		outerLoop : 
		while (b)
		{
			System.out.print("\n>> 이름을 입력하세요 : ");
			String k = sc.next();

			System.out.print("\n>> 예매번호를 입력하세요 : ");
			int h = sc.nextInt();
		  
			for (int j = 0; j<userList.size(); j++)
			{
				if (((userList.get(j).getUserName()).equals(k)) && (userList.get(j).ticketNumber) == h)
				{
				  System.out.println("\n===========[예매 정보]=============");
				  System.out.println("예매자 명 : " + userList.get(j).getUserName());
				   
				   if (userList.get(j).userScreen == 1)
				   {
					 System.out.print("영화 제목 : ");
					 System.out.print(theater1.get(arr1[userList.get(j).userTime-1]).movieName);
					 System.out.println(" (" + theater1.get(arr1[userList.get(j).userTime-1]).gwan + "관)");
					  
				   }
				   else if (userList.get(j).userScreen == 2)
				   {
					 System.out.print("영화 제목 : ");
					 System.out.print(theater2.get(arr2[userList.get(j).userTime-1]).movieName);
					 System.out.println(" (" + theater2.get(arr2[userList.get(j).userTime-1]).gwan + "관)");
				   }
				   else if (userList.get(j).userScreen == 3)
				   {
					 System.out.print("영화 제목 : ");
					 System.out.print(theater3.get(arr3[userList.get(j).userTime-1]).movieName);
					 System.out.println(" (" + theater3.get(arr3[userList.get(j).userTime-1]).gwan + "관)");
				   }
				   
				   System.out.println("상영 날짜 : " + userList.get(j).userDate);

				   if (userList.get(j).userScreen == 1)
				   {
					 System.out.println("시작 시간 : " + theater1.get(arr1[userList.get(j).userTime-1]).movieTime+"시");
				   }
				   else if (userList.get(j).userScreen == 2)
				   {
					 System.out.println("시작 시간 : " + theater2.get(arr2[userList.get(j).userTime-1]).movieTime+"시");
				   }
				   else if (userList.get(j).userScreen == 3)
				   {
					 System.out.println("시작 시간 : " + theater3.get(arr3[userList.get(j).userTime-1]).movieTime+"시");
				   }
				   
				   // 예매한 좌석 보여주기~!
				   System.out.print("예약 좌석 : "); //////////////★★★
					if (userList.get(j).userNum == 1)
					{
						System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
					}
					else if (userList.get(j).userNum == 2)
					{
						System.out.printf("%d행, %d열 / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						System.out.printf("%d행, %d열\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
					}////////////////////
				   System.out.println("예매 번호 : " + userList.get(j).ticketNumber);
				   System.out.printf("금     액 : %,d원\n", 15000 * userList.get(j).userNum);
				   System.out.println();

				   b = false;
				   break outerLoop; //반복문 빠져나오기
				}            
				

			 }//end for문

			  System.out.println("[예매 조회에 실패했습니다. 다시 입력해주세요.]\n");
			  continue;

		}//end while문
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Check  예매 체크

	public void cancel()	//예매 취소
	{
		String k;						//사용자 입력값을 임시 저장할 문자열 타입 변수
		int	h;							//사용자 입력값을 임시 저장할 정수 타입 변수
		boolean b = true;

		Scanner sc = new Scanner(System.in);

		if (userList.size() == 0)
		{
			System.out.println("[예매한 사람이 없습니다.]\n");
			return;
		}


		// 사용자 입력값과 벡터 저장값 동일 유무 확인
		outerLoop : 
		while (b)
		{
			System.out.print(">> 이름을 입력하세요 : ");
			k = sc.next();

			System.out.print(">> 예매번호를 입력하세요 : ");
			h = sc.nextInt();
		
			for (int j = 0; j<userList.size(); j++)
			{
				if (((userList.get(j).getUserName()).equals(k)) && (userList.get(j).ticketNumber) == h)
				{
					///////////////////★★★
					int temp = userList.get(j).userTime;

					switch (userList.get(j).userScreen)
					{
						case 1:
							if (userList.get(j).userNum==1)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
							}
							else if (userList.get(j).userNum==2)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
								x = userList.get(j).userSeatHang2;
								y = userList.get(j).userSeatYeol2;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
							}
							break;
						case 2:
							if (userList.get(j).userNum==1)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "□";
							}
							else if (userList.get(j).userNum==2)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "□";
								x = userList.get(j).userSeatHang2;
								y = userList.get(j).userSeatYeol2;
								theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "□";
							}
							break;
						case 3:
							if (userList.get(j).userNum==1)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "□";
							}
							else if (userList.get(j).userNum==2)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "□";
								x = userList.get(j).userSeatHang2;
								y = userList.get(j).userSeatYeol2;
								theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "□";
							}
							break;
					}
			////////////////////////////
					userList.remove(j);
					System.out.println("[취소 완료되었습니다.]");
					b = false;
					break outerLoop;
				}

			}
			System.out.println("\n[예매 조회에 실패했습니다. 다시 입력해주세요.]");
			break;

		}

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////  Cancel() 예매 취소

}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  end Admin Class 어드민 클래스 끝!!!!!!

