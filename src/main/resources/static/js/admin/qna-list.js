
$(document).ready(function(){
    const $ul = $("#content-wrap tbody");
    // $("#content-wrap tbody").html("hello");
    let text = "";
    let answerPresent = "답변 완료";
    let answerAbsent = "미답변";
    qnas.forEach(qna => {
        console.log(qna);
        text += `
                    <a href="/qna/qna-detail?qnaId=${qna.qnaId}">
                        <tr class="row">
                            <td class="checkbox-line"><input type="checkbox" name="qnaId"></td>
                            <td class="noticeId">${qna.qnaId}</td>
                            <td>
                                <a href="/qna/qna-detail?qnaId=${qna.qnaId}">${qna.qnaTitle}</a>
                            </td>
                            <td>${qna.userName}</td>
                            <td>${qna.qnaRegisterDateTime}</td>
                            <td class="answerCheck">미답변</td>
                         </tr>
        `
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
    // checkReply();
});
//
// function checkReply(){
//     let index = 0;
//     $("tr .answerCheck").each(function(index, tr) {
//         console.log(index);
//         console.log("ㅑ");
//         console.log(tr);
//     });
//
//     qnas.forEach(qna => {
//         let index = 0;
//         let $reply;
//         $("tr .answercheck").each(function(i, tr) {
//             if(i==index){
//                 $reply = tr;
//             }
//         });
//         if(qna.answerCount != null && qna.answerCount >= 1){
//             $reply.html("답변 완료");
//             index++;
//             console.log("already");
//             console.log($reply);
//         }else{
//             $reply.html("미답변");
//             index++;
//             console.log("not yet");
//             console.log($reply);
//         }
// });
// }
//
