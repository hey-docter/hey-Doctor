
$(document).ready(function(){
    const $ul = $("#content-wrap tbody");
    // $("#content-wrap tbody").html("hello");
    let text = "";
    questions.forEach(question => {
        console.log(question.userName);
        text += `
                    <a href="/question-board/detail?questionId=${question.questionId}">
                        <tr>
                            <td class="checkbox-line"><input type="checkbox" name="check" class="box"></td>
                            <td class="noticeId">${question.questionId}</td>
                            <td><a href="/question-board/detail?questionId=${question.questionId}">${question.questionTitle}</a></td>
                            <td>${question.userName}</td>
                            <td>${question.questionRegisterDatetime}</td>
                         </tr>
                    </a>
        `

        // questions.files.forEach(file => {
        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })


        text += `
                    
            
        `
    });
    console.log(text);
    $ul.html(text);
});

// <tr th:each="qna:${qnas}">
//     <td th:text="안녕하세요?"></td>
//     <td th:text="${qna.qnaTitle}"></td>
//     <td th:text="${qna.qnaRegisterDateTime}"></td>
//     <td th:text="${qna.userName}"></td>
//
//     </tr>

//
// function view(){
//     $('#content-wrap tr').click(function() {
//         window.location = 'http://location/here';
//     });
// }