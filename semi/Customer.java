class Customer
{
	private String userName;	// 고객이름
	private String userID;		// 주민번호
	public int userNum;			// 예매인원 수
	//public String userMovie;	// 예매한 영화 이름
	public int userSeatHang1, userSeatYeol1;		// 좌석 행 1 ★★
	public int userSeatHang2, userSeatYeol2;		// 좌석 행 2 ★★
	public String userDate;		// 예약한 영화 상영 날짜
	public int userTime;		// 영화 시작 시간
	public int userPay;			// 총 결제 가격
	public int userScreen;		// 영화 관 선택

	
	public int ticketNumber;	// 예매번호(1000부터 ++ 4자리)

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