$(document).ready(function() {
    $('input[type="text"]').blur(function() {
      var $errorSpan = $(this).parent().find("span");
      if (!$(this).val()) {
        $(this).css("border-color", "red");
        if ($errorSpan.length == 0) {
          $(this).parent().append("<span style='color:red;'>빈칸을 채워주세요.</span>");
        }
      } else {
        $(this).css("border-color", "#ced4da");
        $errorSpan.remove();
      }
    });
  });
  