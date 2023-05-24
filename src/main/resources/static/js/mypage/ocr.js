console.log("나와랏");
$(".certify").on('click', function() {
    showOCRModal();
});

// 파일 첨부 시
$("#license").on("change", function(e){
    let reader = new FileReader();
    reader.readAsDataURL(e.target.files[0]);
    reader.onload = function (e) {
        // base64 String으로 이미지 가져오기
        let img = e.target.result;
        $.ajax({
            url: "https://api.ocr.space/parse/image",
            type: "post",
            //apikey 작성, base64Image에 base64 String작성, 나머지 노터치
            data: {apikey: "K84557068988957", base64Image: img, filetype: "jpg", language: "kor", isOverlayRequired: true},
            success: function(result){
                console.log(result);
                let datetime = result.ParsedResults[0].TextOverlay.Lines[6].LineText;
                //추출된 전체 문자열값에서 줄바꿈문자로 분리하여 12번째 인덱스에 있는 취득 년월일 추출
                $("#result").html(datetime);
            }
        });
    };
    console.log("인증이 되나?");
});
