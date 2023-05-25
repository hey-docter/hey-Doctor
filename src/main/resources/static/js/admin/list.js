//
// $(document).ready(function(){
//     const $ul = $("#content-wrap ul");
//
//     let text = "";
//     questions.forEach(question => {
//         text += `
//             <li>
//                 <div>
//                     <a href="javascript:void(0)">
//                         <section class="content-container">
//                             <div class="profile">
//                                 <div><img src="/images/profile.png" width="15px"></div>
//                                 <h6 class="writer">${question.userName}</h6>
//                             </div>
//                             <h4 class="title">${question.questionTitle}</h4>
//                             <h6 clss="post-info">
//                                 <span class="read-count">조회 ${question.readCount}</span>
//                                 <span>·</span>
//                                 <span class="date">6일 전</span>
//                             </h6>
//                         </section>
//         `
//         question.files.forEach(file => {
//             if(file.fileType == "REPRESENTATIVE"){
//                 text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
//             }
//         })
//
//         text += `
//                     </a>
//                 </div>
//             </li>
//         `
//     });
//
//     $ul.html(text);
// });
//
// // <tr th:each="qna:${qnas}">
// //     <td th:text="안녕하세요?"></td>
// //     <td th:text="${qna.qnaTitle}"></td>
// //     <td th:text="${qna.qnaRegisterDateTime}"></td>
// //     <td th:text="${qna.userName}"></td>
// //
// //     </tr>