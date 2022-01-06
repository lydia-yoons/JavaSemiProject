import java.util.Scanner;
import java.util.Vector;
import java.util.Enumeration;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Calendar;

class Admin extends Theater
{
	private String password = "abc1234";	// �н����� private ���� ����
//
	int i=1000;			// �� ���Ź�ȣ �ʱⰪ
	public Vector<Customer> userList;

	public void makeUserList()	// ���α׷� ���۽� main �޼ҵ忡 userList�� ���� ������ ȣ���� �޼ҵ�
	{
		 userList = new Vector<Customer>();
	}


//
	public String getPass()		// �н����� ���� get()
	{
		return password;
	}

	public void passwordComfirm()		// �н����� Ȯ�� �޼ҵ�
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[������ ȭ�鿡 �����ϱ� ���ؼ��� ��й�ȣ�� �ʿ��մϴ�.]");
		System.out.print("\n>> ��й�ȣ�� �Է��ϼ��� : ");
		String pass = sc.next();
		System.out.println();

		if ((getPass()).equals(pass))
		{
			System.out.println("\n[�α��� ����]\n");
			adminMenu();
		}
		else
			System.out.println("\n[�߸� �Է��ϼ̽��ϴ�. ���� ȭ������ ���ư��ϴ�.]\n");
			return;
	}

	public void adminMenu()		// ������ �޴� ���
	{
		Scanner sc = new Scanner(System.in);

		do
		{
			System.out.println("\n=====================================");
			System.out.println("\t    ������ �޴�");
			System.out.println("=====================================\n");

			System.out.println("1. �� �ð�ǥ ����");
			System.out.println("2. �� ��ȭ ���");
			System.out.println("3. �� ��ȭ ����");
			System.out.println("4. ��ȭ �� �߰�");
			System.out.println("5. ��ȭ �� ����");
			System.out.println("6. �������� ���ư���");
			System.out.println();
			System.out.print(">> ���ڸ� �������ּ��� : ");

			int a = sc.nextInt();
			System.out.println();

			switch (a)
			{
			case 1: movieTimeTable(); break;
			case 2: movieAdd(); break;
			case 3: movieDel(); break;
			case 4: movieForm(); break;
			case 5: movieFormDel(); break;
			case 6: return;		// adminMenu() ���� �� main()���� ���ư�
			}
			
		}
		while (true);
	}//end adminMenu()
	
	public String todayIs()	// (����) "������ ���� ���� ������" ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	{
		Calendar cd = Calendar.getInstance();
		
		int w = cd.get(Calendar.DAY_OF_WEEK);
		String week = "";
		switch (w)
		{
			case Calendar.SUNDAY : week = "�Ͽ���"; break;
			case Calendar.MONDAY : week = "������"; break;
			case Calendar.TUESDAY : week = "ȭ����"; break;
			case Calendar.WEDNESDAY : week = "������"; break;
			case Calendar.THURSDAY : week = "�����"; break;
			case Calendar.FRIDAY : week = "�ݿ���"; break;
			case Calendar.SATURDAY : week = "�����"; break;		
		}

		String today = cd.get(Calendar.YEAR)+"�� "+(cd.get(Calendar.MONTH)+1)+"�� "+cd.get(Calendar.DATE)+"�� "+week;
		return today;
		
	}//end todayIs()

	public void movieTimeTable()	// �� �ð�ǥ ����
	{
		System.out.println("\n=====================================\n");
		System.out.printf("\t[ %s ]",todayIs());
		System.out.println("\n\t   [�󿵰��� � ��Ȳ]\n");			

		
		System.out.print("[1��]  ");
		for (int i=0; i<4; i++)	
		{
			if (theater1.get(arr1[i])!=null)
				System.out.print(" " + (i+1) +". " +arr1[i]+ "��("+(theater1.get(arr1[i])).movieName+")  ");
			else
				System.out.print(" " + (i+1) +". " +arr1[i]+ "��("+"����"+")  ");
		}	
		
		System.out.print("\n[2��]  ");
		for (int i=0; i<4; i++)	
		{
			if (theater2.get(arr2[i])!=null)
				System.out.print(" " + (i+1) +". " +arr2[i]+ "��("+(theater2.get(arr2[i])).movieName+")  ");
			else
				System.out.print(" " + (i+1) +". " +arr2[i]+ "��("+"����"+")  ");
		}	
		
		System.out.print("\n[3D��] ");
		for (int i=0; i<4; i++)	
		{
			if (theater3.get(arr3[i])!=null)
				System.out.print(" " + (i+1) +". " +arr3[i]+ "��("+(theater3.get(arr3[i])).movieName+")  ");
			else
				System.out.print(" " + (i+1) +". " +arr3[i]+ "��("+"����"+")  ");
		}	
		
		System.out.println();
		System.out.println("\n=====================================");

	}//end movieTimeTable()


	public void movieAdd()	// �� ��ȭ ���
	{
		Scanner sc = new Scanner(System.in);
		Movie mv = new Movie();

		System.out.println("\n=====================================");
		System.out.println("\t    ��ȭ �߰�");
		System.out.println("=====================================\n");

		System.out.println("[���� �󿵰��� ��ȭ ���]");

		for (int i=0; i<movieList.size(); i++)
		{
			if (true == (movieList.get(i).is3D))
			{
				System.out.printf("%d. %s (3D)\n", i+1, movieList.get(i).movieName);	
				// ���� is3D �� true�� (�� 3D��ȭ��) ��ȭ�̸� �ڿ� (3D) ��� ǥ��	
			}
			else
			{
				System.out.printf("%d. %s\n", i+1, movieList.get(i).movieName);		
			}
		}
		System.out.println();
		
		if (movieList.size()>=5)
		{
			System.out.println("\n[�� ������ ��ȭ ������ 5���� �ʰ��� �� �����ϴ�.]\n");
			return;
		}
		else
			System.out.print(">> ��ȭ ���� �Է� : ");
			mv.movieName = sc.nextLine();	// �� ������� ���� �Է¹������� next() ��� nextLine() ���
			/*
			System.out.print(">> ���� Ÿ�� �Է� : ");
			mv.runningTime = sc.nextInt();
			System.out.print(">> ���� ���� �Է�(��ü�������� 0) : ");
			mv.movieGrade = sc.nextInt();
			*/
			System.out.print("\n>> 3D ��ȭ ����(Y/N) : ");
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
				System.out.println("\n[�߸��Է��߽��ϴ�. ������ �޴��� ���ư��ϴ�.]");
				return;
			}

			

			movieList.addElement(mv);
			System.out.println();
			if (movieList.contains(mv))
			{
				System.out.println("[��ȭ�� ���������� ��ϵǾ����ϴ�.]\n");
			}
			else
				System.out.println("[��� �������� ������ �߻��߽��ϴ�.]\n");

		
	}//end movieAdd()

	public void movieDel()	// �� ��ȭ ����
	{
		Scanner sc = new Scanner(System.in);
		Movie mv = new Movie();
		String con;
		boolean b=true;

		do
		{
			System.out.println("\n=====================================");
			System.out.println("\t    ��ȭ ����");
			System.out.println("=====================================\n");
			System.out.println("[���� �� ��ȭ ���]");

			for (int i=0; i<movieList.size(); i++)
			{
				if (true == (movieList.get(i).is3D))
				{
					System.out.printf("%d. %s (3D)\n", i+1, movieList.get(i).movieName);	
					// ���� is3D �� true�� (�� 3D��ȭ��) ��ȭ�̸� �ڿ� (3D) ��� ǥ��	
				}
				else
				{
					System.out.printf("%d. %s\n", i+1, movieList.get(i).movieName);		
				}	
			}
			
			if (0>=movieList.size())
			{
				System.out.println("\n[�ػ��� ������ ��ȭ�� �����ϴ�. ������ �޴��� ���ư��ϴ�.]");
				return;
			}

			System.out.print("\n>> ������ ��ȭ�� ��ȣ�� �Է��ϼ���. : ");
			int num = sc.nextInt();

			if (num>movieList.size())
			{
				System.out.println("\n[����ȿ�� ���� �ƴմϴ�. �ٽ� �Է��ϼ���.]");
				movieDel();
			}
			else 
			{
				for (int i=0; i<4; i++)	// ��ǥ�� ��ϵǾ��ִ� ��ȭ�� ���� ���ϵ��� �ϴ� �ݺ���
				{
					if ((theater1.get(arr1[i]))!=null)	// �� ���� ����
					{
						if ((theater1.get(arr1[i])).movieName.equals(movieList.get(num-1).movieName))
						{
							System.out.println("\n[��ǥ�� ��ȭ�� ��ϵǾ� �ִ� �����Դϴ�. ���� ���� ������ �ּ���.]");
							System.out.println("[������ �޴��� ���ư��ϴ�.]");
							return;
						}
					}

					if ((theater2.get(arr2[i]))!=null)
					{
						if ((theater2.get(arr2[i])).movieName.equals(movieList.get(num-1).movieName))
						{
							System.out.println("\n[��ǥ�� ��ȭ�� ��ϵǾ� �ִ� �����Դϴ�. ���� ���� ������ �ּ���.]");
							System.out.println("[������ �޴��� ���ư��ϴ�.]");
							return;
						}
					}

					if ((theater3.get(arr3[i]))!=null)
					{
						if ((theater3.get(arr3[i])).movieName.equals(movieList.get(num-1).movieName))
						{
							System.out.println("\n[��ǥ�� ��ȭ�� ��ϵǾ� �ִ� �����Դϴ�. ���� ���� ������ �ּ���.]");
							System.out.println("[������ �޴��� ���ư��ϴ�.]");
							return;
						}
					}

				}
				
				movieList.remove(num-1);		// ����
				movieList.trimToSize();
				System.out.println();
				for (int i=0; i<movieList.size(); i++)			
					System.out.printf("%d. %s\n", i+1, movieList.get(i).movieName);				
			
				System.out.println();
				System.out.print("[���������� �����Ǿ����ϴ�.]\n�� ���� �Ͻðڽ��ϱ�? (Y/N) : ");
				con = sc.next().toUpperCase();
				

				if (con.equals("Y"))
					b = true;
				else
					b = false;

			}			
		}while (b);		
			
	} //end movieDel()


	public void movieForm()	// ��ȭ �� �߰�
	{	
		Scanner sc = new Scanner(System.in);
		
		int theaterMovie;	// ��ȭ�� �Է¹��� ����
		int theaterNum;		// ���� �Է� ���� ����
		int theaterTime;	// �ð��� �Է¹��� ����
		
		boolean b =  true;
		Movie mv = new Movie();

		while (b)
		{
			System.out.println("\n=====================================");
			System.out.println("\t    ��ȭ ��");
			System.out.println("=====================================\n");
			System.out.println("[�� ���� ��ȭ ���]");
			for (int i=0; i<movieList.size(); i++)
			{
				
				if (true == (movieList.get(i).is3D))
					System.out.printf("%d. %s (3D)\n", i+1, movieList.get(i).movieName);	
					// ���� is3D �� true�� (�� 3D��ȭ��) ��ȭ�̸� �ڿ� (3D) ��� ǥ��				

				else
				System.out.printf("%d. %s \n", i+1, movieList.get(i).movieName);	
				//System.out.printf("%d. %s (%s)\n", i+1, movieList.get(i).movieName, movieList.get(i).is3D);	
			}
			
			movieTimeTable();	// ���� �� �ð�ǥ ���
			
			if (movieList.size()<1)
			{
				System.out.println("\n[�� ������ ��ȭ�� �����ϴ�. ��ȭ�� ������ּ���.]");
				System.out.println("[������ �޴��� ���ư��ϴ�.]\n");
				return;
			}

			System.out.print("\n>> ���� ��ȭ�� �����ϼ��� : ");
			theaterMovie = sc.nextInt();
			mv = movieList.get(theaterMovie-1);

								
			if (movieList.get(theaterMovie-1).is3D)		// 3d��ȭ�� ���
			{			
				System.out.print("\n>> �󿵰��� �����ϼ���(1~3) : ");
				theaterNum = sc.nextInt();
				 

				if (theaterNum == 1 || theaterNum == 2)
				{
					System.out.println("\n[��3D������ ���� ������ ��ȭ�Դϴ�. �ٽ� �����ϼ���!]\n");
					//movieForm();
					//theaterTime=0;
					//break outerLoop;
					continue;
				}

				else
				{
					System.out.print("\n>> ���� ������ �ð��븦 ������ : ");
					theaterTime = sc.nextInt();
					mv.movieTime = arr3[theaterTime-1];
				}
			}

			else	// 3d��ȭ�� �ƴҰ��
			{
				System.out.print("\n>> �󿵰��� �����ϼ���(1~3) : ");
				theaterNum = sc.nextInt();

				if (theaterNum == 1)
				{
					System.out.print("\n>> ���� ������ �ð��븦 ������ : ");
					theaterTime = sc.nextInt();
					mv.movieTime = arr1[theaterTime-1];
				}

				else if (theaterNum == 2)
				{
					System.out.print("\n>> ���� ������ �ð��븦 ������ : ");
					theaterTime = sc.nextInt();
					mv.movieTime = arr2[theaterTime-1];
				}

				else
				{
					System.out.println("\n[��3D��ȭ�� ���� �� �ִ� �󿵰��Դϴ�. �ٽ� �����ϼ���!]\n");
					//movieForm();
					//theaterTime=0;
					//break outerLoop;
					continue;
				}
			}
			mv.gwan = theaterNum;
			fillArr();	// �¼���ġ�� �迭 ���ڸ�(��)�� ä��� �޼ҵ�

			switch (theaterNum)
			{
				case 1: theater1.put(arr1[(theaterTime)-1], mv); 
						mv.movieSeatArr = seatArr1; break;			// 1���� ���Ǵ� Movie ��ü�� �¼��迭 1�� �迭[3x8] �Ҵ�
				case 2: theater2.put(arr2[(theaterTime)-1], mv);
						mv.movieSeatArr = seatArr2; break;			// 2���� ���Ǵ� Movie ��ü�� �¼��迭 2�� �迭[4x8] �Ҵ�
				case 3: theater3.put(arr3[(theaterTime)-1], mv);
						mv.movieSeatArr = seatArr3; break;			// 3���� ���Ǵ� Movie ��ü�� �¼��迭 3�� �迭[4x4] �Ҵ�
			}
			b= false;
			
		}//end ��ȭ�� while��

			/* mv�� theater1�� �� ������ Ȯ�ο� ���
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

	public void movieFormDel()	// ��ȭ �� ����
	{
		Scanner sc = new Scanner(System.in);
		int theaterNum;		// ���� �Է� ���� ����
		int theaterTime;	// �ð��� �Է¹��� ����
		

		System.out.println("\n=====================================");
		System.out.print("\t    �� ����");
		movieTimeTable();	// ���� �� �ð�ǥ ���

		boolean isThereNothing=true;	// ������ ���� �ִٸ� false, ������ ���� ���ٸ� true���� ��ȯ�� boolean
		
		for (int i=0; i<4; i++)
		{
			if (theater1.get(arr1[i])!=null)	// 1���� value�� null�� �ƴ϶��
			{
				isThereNothing = false;
				break;
			}

			if (theater2.get(arr2[i])!=null)	// 2���� value�� null�� �ƴ϶��
			{
				isThereNothing = false;
				break;
			}

			if (theater3.get(arr3[i])!=null)	// 3���� value�� null�� �ƴ϶��
			{
				isThereNothing = false;
				break;
			}
		}

		if (isThereNothing)	// isThereNothing�� true�� ��(������ ���� ���� ��) �޼ҵ� ����
		{
			System.out.println("\n[������ ���� �������� �ʽ��ϴ�.]");
			System.out.println("[������ �޴��� ���ư��ϴ�.]\n");
			return;
		}

		System.out.print("\n>> �� ������ ���� �Է����ּ���(1~3) : ");
		theaterNum = sc.nextInt();

		System.out.print("\n>> �� ������ �ð��� �Է����ּ��� : ");
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


//////////////////////////////////////////////////////////////////////////////////////////////////// movieFormDel() ��ȭ ������

	public void customerTk() //�� Ƽ�� ���Ž�
	{
		Scanner sc = new Scanner(System.in);
		Customer cm = new Customer();
		int h;							// ����� �Է°��� �ӽ� ������ ����
		boolean b = true;

		// �ֹι�ȣ ��ȿ�� �˻縦 ���� �迭
		int[] chk = {2, 3, 4, 5, 6, 7, 0, 8, 9, 2, 3, 4, 5};

		// ���� ���� �� ������ �� ����
		int tot=0;

		System.out.print("\n>> �̸��� �Է����ּ��� : ");
		String erum = sc.next();


		System.out.print("\n>> �ֹι�ȣ�� �Է����ּ���(xxxxxx-xxxxxxx) : ");
		String jumin = sc.next();

		if (jumin.length() != 14)
		{
			System.out.println("\n[�Է¿����Դϴ�.]\n");
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


		// �ֹι�ȣ ��ȿ�� �˻� ��� ���
		// ��ȿ�� �˻縦 ����ؾ߸� userList ���Ϳ� ��� �� �߰�
		if (su == Integer.parseInt(jumin.substring(13)))
		{
			System.out.println("\n[�ֹι�ȣ�� Ȯ�εǾ����ϴ�.]\n");
			cm.setUserName(erum);
			cm.setUserID(jumin);

			// ������ ���
			System.out.print("\n������ : " + todayIs());
			cm.userDate = todayIs();
			System.out.println();
		}
		else
		{
			System.out.println("[�߸��� �ֹι�ȣ�Դϴ�.]\n");
			return;
		}

		while(b)
		{
			//���� �ο��� �Է�
			System.out.println("\n=========[���� �ο� �� �Է�]=========");
			System.out.println("�� ���Ű��� �ο� ���� �ִ� 2�� �Դϴ�");
			System.out.print("\n>> �� �ο� �� �Է� (1~2) : ");
			h = sc.nextInt();

			if (h <= 2 && h >= 1)
			{
				// �ο��� �Է� �� userList.get(i).userNum�� �߰�
				cm.userNum = h;
				b = false;
			}

			else
			{
				System.out.println("\n[�ο����� �߸��ƽ��ϴ�.]\n");
				continue;
			}
		}

		// ��ȭ �� �ð� ����
		movieTimeTable();	// ���� �� �ð�ǥ ���
		
		System.out.print("\n>> �󿵰� ���� (1~3) : ");
		h = sc.nextInt();
		int sn = h;			// �󿵰� �� �޾Ƶα�

		if (h <= 3 && h >= 1)
		{
			cm.userScreen = h;
		}
		else
		{
			System.out.println("\n[�󿵰��� �߸� �Է��ϼ̽��ϴ�.]\n");
			return;
		}

		System.out.print("\n>> �ð� ���� (1~4) : ");
		h = sc.nextInt();

		if (h <= 4 && h >= 1)
		{
			try
			{	if (sn==1)	//�󿵰��� 1�϶�
				{
					if (theater1.get(arr1[h-1])==null)
						throw new Exception();
				}
				if (sn==2)	//�󿵰��� 2�϶�
				{
					if (theater2.get(arr2[h-1])==null)
						throw new Exception();
				}
				if (sn==3)	//�󿵰��� 3�϶�
				{
					if (theater3.get(arr3[h-1])==null)
						throw new Exception();
				}
				
			}
			catch (Exception e)
			{
				System.out.println("[�ش�ð��� ���ϴ� ��ȭ�� �����ϴ�.]\n");
				return;
			}

			cm.userTime = h;
		}
		else
		{
			System.out.println("[�ð��� �߸� �Է��ϼ̽��ϴ�.]\n");
			return;
		}
		
		   /////������� �ڸ����� ������~~ �ڡ�
	  System.out.println();
	  System.out.println("[ �ڸ� ���� ]");
      System.out.println("[ ���� ������ �¼� : �� // ���� �Ұ����� �¼� : �� ]\n");
	  System.out.println("----��ũ��----");
      showSeats(sn, h);
      System.out.println();
	  System.out.println("�� : �� / �� : ��\n");
      
      int count = 1;

      do
      {
         System.out.printf("[%d�� �¼� ����]\n", count);

         System.out.print(">> �� ����(���� �Է�) : ");
         int hang = sc.nextInt();
         System.out.print(">> �� ����(���� �Է�) : ");
         int yeol = sc.nextInt();
         
		 switch (count)	// �ڡڡ� ����ġ�� �߰�
		 {
			case 1: cm.userSeatHang1=hang;
					cm.userSeatYeol1=yeol; break;
			case 2: cm.userSeatHang2=hang;
					cm.userSeatYeol2=yeol; break;
		 }
         
         if (!bookSeat(sn, h, hang, yeol)) // bookSeat ���� true�� ���� �� : ������ �ƴٴ� ����
         {
            System.out.println("�̹� ����� �¼��Դϴ�. �ٸ� �ڸ��� �������ּ���.\n");
            count--;
         }
         
         if (count==cm.userNum)
         {
            System.out.println("[�ڸ� ���� �Ϸ�]");
            break;
         }
         count++;
         
      }
      while (true);
      //////�������~~~ �ڡ�

		// ���Ź�ȣ �ο� (1000���� ++)
		cm.ticketNumber = i;			// ���Ź�ȣ
		i++;							// ���Ź�ȣ 1�� ����


		//userList�� �� �־��ֱ�
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
////////////////////////////////////////////////////////////////////////////////////////////////////// Ticketing ����


	public void showSeats(int sn, int h)	// �ڡ� ������ ��ȭ�� �¼���ġ�� ���
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
			System.out.println("�ش�ð��� ���ϴ� ��ȭ�� �����ϴ�.\n");
			return;
		}
		
	}//end shoeSeats()



	public boolean bookSeat(int sn, int h, int hang, int yeol)
	// �ڡ� ��ǥ�� ����� �¼���ġ�� �迭�� ���Ű���(��)�濹�źҰ���(��) �ٲ��ִ� �޼ҵ�
	{
		boolean result = false;
		try
		{
			switch (sn)
			{
			case 1:		// �ڡڡ� 
				if (theater1.get(arr1[h-1]).movieSeatArr[hang-1][yeol-1].equals("��"))
				{
					theater1.get(arr1[h-1]).movieSeatArr[hang-1][yeol-1] = "��";
					result = true;
					
				};
				break;
				
			case 2:
				if (theater2.get(arr2[h-1]).movieSeatArr[hang-1][yeol-1].equals("��"))
				{
					theater2.get(arr2[h-1]).movieSeatArr[hang-1][yeol-1] = "��";
					result = true;
				};
				break;

			case 3:
				if (theater3.get(arr3[h-1]).movieSeatArr[hang-1][yeol-1].equals("��"))
				{
					theater3.get(arr3[h-1]).movieSeatArr[hang-1][yeol-1] = "��";
					result = true;
				};
				break;
			}

			return result;
		}
		catch (Exception e)
		{
			System.out.println("�ش�ð��� ���ϴ� ��ȭ�� �����ϴ�.\n");
			return result;
		}
	}//end bookSeat()

///////////////////////////////////////////////////////////////////////////////////////////// showSeats() bookSeat() �¼� ����

	
	public void pay()
	{
		Scanner sc = new Scanner(System.in);
		

		System.out.println("\n=====================================");
		System.out.println("\t    [���� �ݾ� Ȯ��]");
		System.out.println("=====================================\n");
		System.out.printf("[���� �ο� �� %d������, ���� �ݾ��� %,d�� �Դϴ�.]\n", userList.get(userList.size()-1).userNum, (userList.get(userList.size()-1).userNum)*15000);
		System.out.print(">> ���� �Ͻðڽ��ϱ�? (Y/N) : ");
		String con = sc.next();

		
		if (con.toUpperCase().equals("Y"))
		{
			System.out.println("\n=====================================");
			System.out.println("     [������ �Ϸ� �Ǿ����ϴ�.]");
			System.out.println("=====================================\n");		
			

			int h = (userList.get(userList.size()-1).ticketNumber);
				
			for (int j = 0; j<userList.size(); j++)
			{
				if ((userList.get(j).ticketNumber) == h)
				{

					if (userList.get(j).userScreen == 1)
					{
						System.out.println("������ �� : " + userList.get(j).getUserName());
						System.out.println("��ȭ ���� : " + theater1.get(arr1[userList.get(j).userTime-1]).movieName + "(" + userList.get(userList.size()-1).userScreen + "��)");
						System.out.println("�� ��¥ : " + userList.get(j).userDate);
						System.out.println("���� �ð� : " + theater1.get(arr1[userList.get(j).userTime-1]).movieTime + "��");
						System.out.print("���� �¼� : "); //////////////�ڡڡ�
						if (userList.get(j).userNum == 1)
						{
							System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						}
						else if (userList.get(j).userNum == 2)
						{
							System.out.printf("%d��, %d�� / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
							System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
						}////////////////////
						System.out.print("���� ��ȣ : "+ userList.get(userList.size()-1).ticketNumber);
						System.out.printf("\n��     �� : %,d��\n",(userList.get(userList.size()-1).userNum)*15000);
					}
					if (userList.get(j).userScreen == 2)
					{
						System.out.println("������ �� : " + userList.get(j).getUserName());
						System.out.println("��ȭ ���� : " + theater2.get(arr2[userList.get(j).userTime-1]).movieName + "(" + userList.get(userList.size()-1).userScreen + "��)");
						System.out.println("�� ��¥ : " + userList.get(j).userDate);
						System.out.println("���� �ð� : " + theater2.get(arr2[userList.get(j).userTime-1]).movieTime + "��");
						System.out.print("���� �¼� : "); //////////////�ڡڡ�
						if (userList.get(j).userNum == 1)
						{
							System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						}
						else if (userList.get(j).userNum == 2)
						{
							System.out.printf("%d��, %d�� / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
							System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
						}////////////////////
						System.out.print("���� ��ȣ : "+ userList.get(userList.size()-1).ticketNumber);
						System.out.printf("\n��     �� : %,d��\n",(userList.get(userList.size()-1).userNum)*15000);
					}
					if (userList.get(j).userScreen == 3)
					{ 
						System.out.println("������ �� : " + userList.get(j).getUserName());
						System.out.println("��ȭ ���� : " + theater3.get(arr3[userList.get(j).userTime-1]).movieName + "(" + userList.get(userList.size()-1).userScreen + "��)");
						System.out.println("�� ��¥ : " + userList.get(j).userDate);
						System.out.println("���� �ð� : " + theater3.get(arr3[userList.get(j).userTime-1]).movieTime + "��");
						System.out.print("���� �¼� : "); //////////////�ڡڡ�
						if (userList.get(j).userNum == 1)
						{
							System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						}
						else if (userList.get(j).userNum == 2)
						{
							System.out.printf("%d��, %d�� / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
							System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
						}////////////////////
						System.out.print("���� ��ȣ : "+ userList.get(userList.size()-1).ticketNumber);
						System.out.printf("\n��     �� : %,d��\n",(userList.get(userList.size()-1).userNum)*15000);
					}					

					System.out.println();
				}
			}
								
		}
		
		
		else
		{
			System.out.println("\n[������ ��ҵǾ� ���� ȭ������ ���ư��ϴ�.]");
			///////////////////�ڡڡ�
			int temp = userList.get(userList.size()-1).userTime;

			switch (userList.get(userList.size()-1).userScreen)
			{
				case 1:
					if (userList.get(userList.size()-1).userNum==1)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
					}
					else if (userList.get(userList.size()-1).userNum==2)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
						x = userList.get(userList.size()-1).userSeatHang2;
						y = userList.get(userList.size()-1).userSeatYeol2;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
					}
					break;
				case 2:
					if (userList.get(userList.size()-1).userNum==1)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
					}
					else if (userList.get(userList.size()-1).userNum==2)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "��";
						x = userList.get(userList.size()-1).userSeatHang2;
						y = userList.get(userList.size()-1).userSeatYeol2;
						theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "��";
					}
					break;
				case 3:
					if (userList.get(userList.size()-1).userNum==1)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "��";
					}
					else if (userList.get(userList.size()-1).userNum==2)
					{
						int x = userList.get(userList.size()-1).userSeatHang1;
						int y = userList.get(userList.size()-1).userSeatYeol1;
						theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "��";
						x = userList.get(userList.size()-1).userSeatHang2;
						y = userList.get(userList.size()-1).userSeatYeol2;
						theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "��";
					}
					break;
			}
			////////////////////////////
			userList.remove(userList.size()-1);		// ����
			userList.trimToSize();
			i--;
			// System.out.println(" ���� : userList.size() : "+userList.size()); //���� �׽�Ʈ
			return;
		}		
		
	}//end pay()

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////pay ���� 


	public void checking()	//�� ���� Ȯ��
	{
		boolean b = true;

		Scanner sc = new Scanner(System.in);
		
		if (userList.size() == 0)
		{
			System.out.println("[������ ����� �����ϴ�.]\n");
			return;
		}

		// ����� �Է°��� ���� ���尪 ���� ���� Ȯ��
		outerLoop : 
		while (b)
		{
			System.out.print("\n>> �̸��� �Է��ϼ��� : ");
			String k = sc.next();

			System.out.print("\n>> ���Ź�ȣ�� �Է��ϼ��� : ");
			int h = sc.nextInt();
		  
			for (int j = 0; j<userList.size(); j++)
			{
				if (((userList.get(j).getUserName()).equals(k)) && (userList.get(j).ticketNumber) == h)
				{
				  System.out.println("\n===========[���� ����]=============");
				  System.out.println("������ �� : " + userList.get(j).getUserName());
				   
				   if (userList.get(j).userScreen == 1)
				   {
					 System.out.print("��ȭ ���� : ");
					 System.out.print(theater1.get(arr1[userList.get(j).userTime-1]).movieName);
					 System.out.println(" (" + theater1.get(arr1[userList.get(j).userTime-1]).gwan + "��)");
					  
				   }
				   else if (userList.get(j).userScreen == 2)
				   {
					 System.out.print("��ȭ ���� : ");
					 System.out.print(theater2.get(arr2[userList.get(j).userTime-1]).movieName);
					 System.out.println(" (" + theater2.get(arr2[userList.get(j).userTime-1]).gwan + "��)");
				   }
				   else if (userList.get(j).userScreen == 3)
				   {
					 System.out.print("��ȭ ���� : ");
					 System.out.print(theater3.get(arr3[userList.get(j).userTime-1]).movieName);
					 System.out.println(" (" + theater3.get(arr3[userList.get(j).userTime-1]).gwan + "��)");
				   }
				   
				   System.out.println("�� ��¥ : " + userList.get(j).userDate);

				   if (userList.get(j).userScreen == 1)
				   {
					 System.out.println("���� �ð� : " + theater1.get(arr1[userList.get(j).userTime-1]).movieTime+"��");
				   }
				   else if (userList.get(j).userScreen == 2)
				   {
					 System.out.println("���� �ð� : " + theater2.get(arr2[userList.get(j).userTime-1]).movieTime+"��");
				   }
				   else if (userList.get(j).userScreen == 3)
				   {
					 System.out.println("���� �ð� : " + theater3.get(arr3[userList.get(j).userTime-1]).movieTime+"��");
				   }
				   
				   // ������ �¼� �����ֱ�~!
				   System.out.print("���� �¼� : "); //////////////�ڡڡ�
					if (userList.get(j).userNum == 1)
					{
						System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
					}
					else if (userList.get(j).userNum == 2)
					{
						System.out.printf("%d��, %d�� / ", userList.get(j).userSeatHang1, userList.get(j).userSeatYeol1);
						System.out.printf("%d��, %d��\n", userList.get(j).userSeatHang2, userList.get(j).userSeatYeol2);
					}////////////////////
				   System.out.println("���� ��ȣ : " + userList.get(j).ticketNumber);
				   System.out.printf("��     �� : %,d��\n", 15000 * userList.get(j).userNum);
				   System.out.println();

				   b = false;
				   break outerLoop; //�ݺ��� ����������
				}            
				

			 }//end for��

			  System.out.println("[���� ��ȸ�� �����߽��ϴ�. �ٽ� �Է����ּ���.]\n");
			  continue;

		}//end while��
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Check  ���� üũ

	public void cancel()	//���� ���
	{
		String k;						//����� �Է°��� �ӽ� ������ ���ڿ� Ÿ�� ����
		int	h;							//����� �Է°��� �ӽ� ������ ���� Ÿ�� ����
		boolean b = true;

		Scanner sc = new Scanner(System.in);

		if (userList.size() == 0)
		{
			System.out.println("[������ ����� �����ϴ�.]\n");
			return;
		}


		// ����� �Է°��� ���� ���尪 ���� ���� Ȯ��
		outerLoop : 
		while (b)
		{
			System.out.print(">> �̸��� �Է��ϼ��� : ");
			k = sc.next();

			System.out.print(">> ���Ź�ȣ�� �Է��ϼ��� : ");
			h = sc.nextInt();
		
			for (int j = 0; j<userList.size(); j++)
			{
				if (((userList.get(j).getUserName()).equals(k)) && (userList.get(j).ticketNumber) == h)
				{
					///////////////////�ڡڡ�
					int temp = userList.get(j).userTime;

					switch (userList.get(j).userScreen)
					{
						case 1:
							if (userList.get(j).userNum==1)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
							}
							else if (userList.get(j).userNum==2)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
								x = userList.get(j).userSeatHang2;
								y = userList.get(j).userSeatYeol2;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
							}
							break;
						case 2:
							if (userList.get(j).userNum==1)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater1.get(arr1[temp-1]).movieSeatArr[x-1][y-1] = "��";
							}
							else if (userList.get(j).userNum==2)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "��";
								x = userList.get(j).userSeatHang2;
								y = userList.get(j).userSeatYeol2;
								theater2.get(arr2[temp-1]).movieSeatArr[x-1][y-1] = "��";
							}
							break;
						case 3:
							if (userList.get(j).userNum==1)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "��";
							}
							else if (userList.get(j).userNum==2)
							{
								int x = userList.get(j).userSeatHang1;
								int y = userList.get(j).userSeatYeol1;
								theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "��";
								x = userList.get(j).userSeatHang2;
								y = userList.get(j).userSeatYeol2;
								theater3.get(arr3[temp-1]).movieSeatArr[x-1][y-1] = "��";
							}
							break;
					}
			////////////////////////////
					userList.remove(j);
					System.out.println("[��� �Ϸ�Ǿ����ϴ�.]");
					b = false;
					break outerLoop;
				}

			}
			System.out.println("\n[���� ��ȸ�� �����߽��ϴ�. �ٽ� �Է����ּ���.]");
			break;

		}

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////  Cancel() ���� ���

}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  end Admin Class ���� Ŭ���� ��!!!!!!

