<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>
<meta charset="UTF-8">
    <title>Chating</title>
    <style>
        *{
            margin:0;
            padding:0;
        }
        .container{
            width: 500px;
            margin: 0 auto;
            padding: 25px
        }
        .container h1{
            text-align: left;
            padding: 5px 5px 5px 15px;
            color: #FFBB00;
            border-left: 3px solid #FFBB00;
            margin-bottom: 20px;
        }
        .chating{
            background-color: #000;
            width: 500px;
            height: 500px;
            overflow: auto;
        }
        .chating p{
            color: #fff;
            text-align: left;
        }
        input{
            width: 330px;
            height: 25px;
        }
        #yourMsg{
            display: none;
        }
    </style>
</head>
<script type="text/javascript">
    var ws;

    function wsOpen(){
        ws = new WebSocket("ws://"+location.host+"/chating");
        wsEvt();
    }
    function wsEvt(){
        ws.onopen=function (data){
            //소켓이 열리면 초기화 세팅하기
        }
        ws.onmessage = function (data){
            var msg = data.data;
            if(msg!=null && msg.trim() != ""){ //메세지가 null이거나 빈공간만 보낸게 아니면
                $("#chating").append("<p>"+msg+"</p>"); //채팅창에 메시지 표시
            }
        }

        document.addEventListener("keypress", function (e){
            if(e.keyCode===13){ //enter를 누를시
                    send();
                 }
        });
    }

    function chatName(){
        var userName = $("#userName").val(); //username input 값 가져오기
        if(userName==null || userName.trim()===""){
            alert("사용자 이름을 입력해주세요.");
            $("#userName").focus(); //깜빡 거림
        }else {
            wsOpen(); //사용자가 있다면 소켓 열어줌..
            $("#yourName").hide();
            $("#yourMsg").show();
        }
    }

    function send(){
        var uN = $("#userName").val();
        var msg = $("#chatting").val();
        ws.send(uN+" : "+msg); //받아온 내용을 보여줌
        $('#chatting').val("");
    }
</script>
<body>
<div id="container" class="container">
    <h1>채팅</h1>
    <div id="chating" class="chating"></div>
    <div id="yourName">
        <table class="inputTable">
            <tr>
                <th>사용자명</th>
                <th><input type="text" name="userName" id="userName"></th>
                <th><button onclick="chatName()" id="startBtn">이름 등록</button> </th>
            </tr>
        </table>
    </div> <%--채팅명 입력 -> 추후에 사용자로 변경해야 할수도--%>

    <div id="yourMsg">
        <table class="inputTable">
            <tr>
                <th>메시지</th>
                <th><input id="chatting" placeholder="보내실 메시지를 입력하세요."></th>
                <th><button onclick="send()" id="sendBtn">보내기</button></th>
            </tr>
        </table>
    </div>

</div>
</body>
</html>