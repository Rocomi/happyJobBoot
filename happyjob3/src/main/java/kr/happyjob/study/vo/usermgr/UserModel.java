package kr.happyjob.study.vo.usermgr;

public class UserModel {
	
	private String loginID;     // 로그인 ID
	private String user_type;   // 사용자 종류 A : 관리자  B : User   공통코드 관리
	private String name;        // 이름
	private String password;    // 비밀번호 
	private String sex;        // 성별 -- 남자 : M   여성 : W   
	private String hp;          // 핸드폰 번호 -- XXX-XXXX-XXXX  
	private String email;       // 이메일
	private String regdate;     // 등록일자 
	private String loc;         // 지역코드 -- 공통코드   02 : 서울
	private String locname;     // 지역명
	private String birthday;    // 생년월일  
	private String zipcd;       // 우편번호    	
	private String addr;        // 주소
	private String dtladdr;     // 상세주소 
	
	
	
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getLocname() {
		return locname;
	}
	public void setLocname(String locname) {
		this.locname = locname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getZipcd() {
		return zipcd;
	}
	public void setZipcd(String zipcd) {
		this.zipcd = zipcd;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDtladdr() {
		return dtladdr;
	}
	public void setDtladdr(String dtladdr) {
		this.dtladdr = dtladdr;
	}
	
	
}
