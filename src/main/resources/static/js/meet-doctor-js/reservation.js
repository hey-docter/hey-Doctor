$(document).ready(function() {
  $('input[type="text"]').blur(function() {
    var id = $(this).attr("id");
    // address_kakao랑 address_detail은 유효성 검사 제외
    if (id === "address_kakao" || id === "address_detail") {
      return;
    }
    
    var $inputs = $(this).parent().find("span");
    if (!$(this).val()) {
      $(this).css("border-color", "red");
      // 빈칸일시 유효성검사
      if ($inputs.length == 0) {
        $(this).parent().append("<span style='color:red;'>빈칸을 채워주세요.</span>");
      }
    } 
    // 빈칸이 아니면 유효성 제거
    else {
      $(this).css("border-color", "#ced4da");
      $inputs.remove();
    }
  });
});
