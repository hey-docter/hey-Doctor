var naver_id_login = new naver_id_login("0QEJy5lMTxel75jSVhqm", "http://localhost:10000/login/naver");
var state = naver_id_login.getUniqState();
naver_id_login.setButton("white", 3,48);
naver_id_login.setDomain("http://localhost:10000/");
naver_id_login.setState(state);
naver_id_login.init_naver_id_login();

$(document).ready(function() {
    $('.show2').hide(); //페이지를 로드할 때 숨길 요소
});