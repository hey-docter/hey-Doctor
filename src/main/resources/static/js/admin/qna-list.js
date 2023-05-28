
$(document).ready(function(){
    const $ul = $("#content-wrap tbody");
    // $("#content-wrap tbody").html("hello");
    let text = "";
    qnas.forEach(qna => {
        console.log(qna);
        text += `
                    <a href="javascript:void(0)">
                        <tr>
                            <td class="checkbox-line"><input type="checkbox" name="qnaId"></td>
                            <td class="noticeId">${qna.qnaId}</td>
                            <td>
                                <a href="">${qna.qnaTitle}</a>
                            </td>
                            <td>${qna.userName}</td>
                            <td>${qna.qnaRegisterDateTime}</td>
                            <td class="answerCheck"></td>
                         </tr>
        `
        if(qna.answerCount != null && qna.answerCount>=1){
            $(td.answerCheck).html("답변 완료");
        }else{
            $(td.answerCheck).html("답변");

        }
        // questions.files.forEach(file => {
        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })var $prev = $($(".page-button")[0]);
        //
        // $(".page-button").each((i, e) => {
        // 	var $pageNumber = $(e);
        //
        // 	$pageNumber.on("click", function (e) {
        // 		e.preventDefault();
        // 		if ($prev == $pageNumber) {
        // 			return;
        // 		}
        //
        // 		$prev.removeClass("page-button-active");
        // 		$pageNumber.addClass("page-button-active");
        //
        // 		$prev = $pageNumber;
        // 	});
        // })

        text += `
                    </a>
        `
    });
    // console.log(text);
    $ul.html(text);
});



