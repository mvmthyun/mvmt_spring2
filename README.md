# mvmt_spring2
mvmt_spring2

## 프로젝트 시작 세팅

## member service
- 회원가입 ok
  - 가입 내용
    - 아이디
    - 패스워드
    - 이메일
    - 이름
    - 번호
    - 주소
    - (가입일자) = now()
    - (수정일자) = null
    - (계정 활성화) Y/N => Y
- 로그인
  - 로그인 정보
    - 아이디
    - 패스워드
- 조회 ok
  - 조회 정보
    - 이메일 => 아이디
    - 아이디, 이메일 => 패스워드
- 변경
  - 변경 정보
    - 패스워드
    - 이메일
    - 이름
    - 번호
    - 주소
    - (수정일자) = now()
- 삭제
  - 삭제 정보
    - (계정 활성화) Y/N => N


private String memberId; // 아이디
private String memberPassword; // 패스워드
private String memberEmail; // 이메일
private String memberName; // 이름
private String memberNumber; // 연락처
private String memberAddr; // 주소
private Date memberCreateAt; // 생성일자
private Date memberModifiedAt; // 수정일자
private String memberActivation; // 활성화/비활성화

MEMBER_ID VARCHAR(255) NOT NULL DEFAULT nextval('members_seq'::regclass),
MEMBER_PASSWORD VARCHAR(255) NOT NULL,
MEMBER_EMAIL VARCHAR(255) NOT NULL,
MEMBER_NAME VARCHAR(50) NOT NULL,
MEMBER_NUMBER VARCHAR(50) NOT NULL,
MEMBER_ADDR VARCHAR(300) NOT NULL,
MEMBER_CREATE_AT TIMESTAMP DEFAULT NOW(),
MEMBER_MODIFIED_AT TIMESTAMP NULL
MEMBER_ACTIVATION VARCHAR(10) NOT NULL DEFAULT "Y"

<result property="memberId" column="MEMBER_ID" />
<result property="memberPassword" column="MEMBER_PASSWORD" />
<result property="memberEmail" column="MEMBER_EMAIL" />
<result property="memberName" column="MEMBER_NAME" />
<result property="memberNumber" column="MEMBER_NUMBER" />
<result property="memberAddr" column="MEMBER_ADDR" />
<result property="memberCreateAt" column="MEMBER_CREATE_AT" />
<result property="memberModifiedAt" column="MEMBER_MODIFIED_AT" />
<result property="memberActivation" column="MEMBER_ACTIVATION" />