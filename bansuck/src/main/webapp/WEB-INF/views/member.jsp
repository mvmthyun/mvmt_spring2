<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
</head>

<style>

    * {
        list-style: none;
        color: black;
        padding: 0px;
        margin: 0px;
        text-decoration: none;
        border-collapse: collapse;
    }

    .signupForm {
        background: lightgray;
        border: 3px solid red;
        width: 300px;
        height: 100%;

        margin-top: 50px;

        text-align: center;
    }

    .signupForm > h2 {
        margin-top: 15px;
    }

    .signupForm > div {
        margin: 15px 0 5px 0;
        
    }

    .signupForm > button {
        width: 200px;
        margin: 15px 0 15px 0;
    }

    .searchForm {
        background: lightgray;
        border: 3px solid red;
        width: 300px;
        height: 100%;

        margin-top: 50px;

        text-align: center;
    }

    .searchForm > hr:first-of-type {
        background: blue;
        height: 3px;
        margin-top: 15px;
    }

    .searchForm > hr:last-of-type {
        background: blue;
        height: 3px;
        margin-bottom: 15px;
    }

    .searchForm > h2 {
        margin-top: 15px;
    }

    .searchForm > div {
        margin: 10px 0 10px 0;
        
    }

    .searchForm > button {
        width: 200px;
        margin: 15px 0 15px 0;
    }

</style>

<body>

    <form class="signupForm" id="signupForm">
        <h2>회원가입</h2>
        <div>
            <label for="">아이디</label>
            <input id="signupInputId" name="signupInputId" type="text" />
        </div>
        <div>
            <label for="">패스워드</label>
            <input id="signupInputPwd" type="password" />
        </div>
        <div>
            <label for="">이메일</label>
            <input id="signupInputEmail" type="email" />
        </div>
        <div>
            <label for="">이름</label>
            <input id="signupInputName" type="text" />
        </div>
        <div>
            <label for="">번호</label>
            <input id="signupInputPhone" type="text" />
        </div>
        <div>
            <label for="">주소</label>
            <input id="signupInputAddr" type="text" />
        </div>
        <button id="signupBtn" type="button" > 가입 </button>
    </form>

    <form class="searchForm" id="searchForm">
        <h2>사용자 정보 조회</h2>
        <hr>
        <div>
            <label for="">**이메일**</label>
            <input id="searchInputEmail" type="email" />
        </div>
        <hr>
        <div>
            <label for="">아이디</label>
            <input id="searchInputId" name="searchInputId" type="text" readonly="readonly"/>
        </div>
        <div>
            <label for="">패스워드</label>
            <input id="searchInputPwd" type="password" readonly="readonly"/>
        </div>
        <div>
            <label for="">이름</label>
            <input id="searchInputName" type="text" readonly="readonly" />
        </div>
        <div>
            <label for="">번호</label>
            <input id="searchInputPhone" type="text" readonly="readonly" />
        </div>
        <div>
            <label for="">주소</label>
            <input id="searchInputAddr" type="text" readonly="readonly" />
        </div>
        <button id="searchBtn" type="button" > 조회 </button>
    </form>


    <script>

        // 회원가입
        var signupInputId = $('#signupInputId');
        var signupInputPwd = $('#signupInputPwd');
        var signupInputEmail = $('#signupInputEmail');
        var signupInputName = $('#signupInputName');
        var signupInputPhone = $('#signupInputPhone');
        var signupInputAddr = $('#signupInputAddr');

        // 사용자 정보 조회
        var searchInputId = $('#searchInputId');
        var searchInputPwd = $('#searchInputPwd');
        var searchInputEmail = $('#searchInputEmail');
        var searchInputName = $('#searchInputName');
        var searchInputPhone = $('#searchInputPhone');
        var searchInputAddr = $('#searchInputAddr');

        // 가입 스크립트
        $(document).ready(function () {
            $('#signupBtn').on("click", function () {
                
                    const form = $('#signupForm'); // 가입 서식

                    let data = {
                        'memberId': signupInputId.val()
                        , 'memberPassword': signupInputPwd.val()
                        , 'memberEmail': signupInputEmail.val()
                        , 'memberName': signupInputName.val()
                        , 'memberNumber': signupInputPhone.val()
                        , 'memberAddr': signupInputAddr.val()
                    }

                    console.log(JSON.stringify(data));

                    $.ajax({
                        url: "/api/member/signup",
                        type: 'POST',
                        data: JSON.stringify(data),
                        // dataType: 'json',
                        contentType: 'application/json; charset=utf-8',
                        cache: false,
                        // contentType: false, // 해당 타입을 true 로 하면 일반 text로 구분되어 진다.
                        processData: false, // 데이터 객체를 문자열로 바꿀지에 대한 값이다.
                        success: function (res) {
                            console.log(res);
                        },
                        error: function (xhr) {
                            console.log(xhr);
                        }
                    });

                })
            }
        )

        // 조회 스크립트
        $(document).ready(function () {
            $('#searchBtn').on("click", function () {
                
                if (searchInputEmail.val() == null || searchInputEmail.val() == "") {
                    alert("이메일에 입력된 정보가 없습니다.");
                }

                const form = $('#searchForm'); // 가입 서식
                const formData = new FormData(); // 데이터폼

                console.log(searchInputEmail.val());

                let data = {
                    'memberId': signupInputId.val()
                    , 'memberPassword': searchInputPwd.val()
                    , 'memberEmail': searchInputEmail.val()
                    , 'memberName': searchInputName.val()
                    , 'memberNumber': searchInputPhone.val()
                    , 'memberAddr': searchInputAddr.val()
                }

                // console.log(JSON.stringify(data));

                $.ajax({
                    url: "/api/member/search",
                    type: 'POST',
                    data: JSON.stringify(data),
                    // dataType: 'json',
                    contentType: 'application/json; charset=utf-8',
                    cache: false,
                    // contentType: false, // 해당 타입을 true 로 하면 일반 text로 구분되어 진다.
                    processData: false, // 데이터 객체를 문자열로 바꿀지에 대한 값이다.
                    success: function (res) {
                        console.log(res);
  
                        searchInputId.val(res.memberId);
                        searchInputPwd.val(res.memberPassword);
                        searchInputName.val(res.memberName);
                        searchInputPhone.val(res.memberNumber);
                        searchInputAddr.val(res.memberAddr);
                    },
                    error: function (xhr) {
                        console.log(xhr);
                    }
                });

                })
            }
        )

    </script>

</body>

</html>