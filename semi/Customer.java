class Customer
{
	private String userName;	// ���̸�
	private String userID;		// �ֹι�ȣ
	public int userNum;			// �����ο� ��
	//public String userMovie;	// ������ ��ȭ �̸�
	public int userSeatHang1, userSeatYeol1;		// �¼� �� 1 �ڡ�
	public int userSeatHang2, userSeatYeol2;		// �¼� �� 2 �ڡ�
	public String userDate;		// ������ ��ȭ �� ��¥
	public int userTime;		// ��ȭ ���� �ð�
	public int userPay;			// �� ���� ����
	public int userScreen;		// ��ȭ �� ����

	
	public int ticketNumber;	// ���Ź�ȣ(1000���� ++ 4�ڸ�)

	public String getUserID()
	{
		return userID;
	}

	public void setUserID(String userID)
	{
		this.userID = userID;
	}

	
	
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	

/*
	public int getUserNum()
	{
		return userNum;
	}

	public void setUserNum(int userNum)
	{
		this.userNum = userNum;
	}
*/
}