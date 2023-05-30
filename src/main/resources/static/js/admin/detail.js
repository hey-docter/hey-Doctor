
//=============================================================
// Modules
//=============================================================
function Replies(answerId, replies) {
    this.answerId = answerId;
    this.replies = replies ? replies : [];
    this.page = 0;

    this.addPage = () => ++page;
    this.clearPage = () => { page = 0; return page };
}

// answerId => the answer`s replies data
const repliesMap = {};

let appendTypes = {BEFORE: 'before', AFTER: 'after', INIT: 'init'};

let answerService = (() => {
    function writeAnswer(answerContent, callback) {
        $.ajax({
            url: `/answer/write`,
            type: `post`,
            data: JSON.stringify({userId: user.userId, questionId: question.questionId, answerContent: answerContent}),
            contentType: "application/json;charset=utf-8",
            success: function(answer) {
                if(callback) callback(answer);
            }
        });
    }

    function getAnswerList(callback) {
        $.ajax({
            url: `/answer/list/${question.questionId}/${page}`,
            success: function(answers) {
                if(callback) callback(answers);
            }
        });
    }

    return {writeAnswer: writeAnswer, getAnswerList: getAnswerList};
})();

let replyService = (() => {
    function writeReply(answerId, replyContent, callback) {
        $.ajax({
            url: `/reply/write`,
            type: `post`,
            data: JSON.stringify({userId: user.userId, answerId: answerId, replyContent: replyContent}),
            contentType: "application/json;charset=utf-8",
            success: function(reply) {
                if(callback) callback(reply);
            }
        });
    }

    function setReplySendEvent(answerId) {
        $(`.reply-send-${answerId}`).on('click', function () {
            let $replyContent = $(`.reply-write-${answerId}`);
            if($replyContent.val() === '') {
                showWarnModal("내용을 입력해 주세요.");
                return;
            }
            replyService.writeReply(answerId, $replyContent.val(), reply => {
                showReplies([reply], appendTypes.BEFORE);
                $replyContent.val("");
                $replyContent.blur();

            });
        });
    }

    function getReplyList(answerId, callback) {
        $.ajax({
            url: `/reply/list/${answerId}/${++repliesMap[answerId].page}`,
            success: function(replies) {
                if(callback) callback(replies);
            }
        });
    }

    return {writeReply: writeReply, setReplySendEvent: setReplySendEvent, getReplyList: getReplyList};
})();

//=============================================================
// Events
//=============================================================
const $answerArea = $("article.answer-write-box");
const $answerTextarea = $('textarea.answer-area');
const $answerContainer = $('div#answer-container-main');
const $answerSize = $('span.answer-size');
const $loading = $('.loading-items');
const $noneItems = $('.none-items');

let page = 0;
let isListRemains = false;

$answerArea.hide();

$(window).scroll(function(){
    if (Math.ceil(window.innerHeight + window.scrollY) >= document.body.scrollHeight && isListRemains) {
        page++;
        answerService.getAnswerList(answers => {
            showList(answers, appendTypes.AFTER);
        });
    }
});

$('div.answer-btn').on('click', function() {
    $('div.fake-submit-btn').each((_, e) => $(e).hide());
    $answerArea.show();
});

$answerTextarea.on('keyup', function() {
    let length = $(this).val().length;
    $('div.answer-char-size span').text(length);
    if(length >= 500) $('.answer-char-size').css('color', '#ee6767');
    else $('.answer-char-size').css('color', '#adb5bd');
});

// $('p.department-type').text(`${getDepartment(question.doctorDepartmentType).kor}`);

// $(document).ready(() => {
//     showList(answers, appendTypes.INIT);
//     showReplies(replies);
// });

$('button.write-answer').on('click', function (e) {
    e.preventDefault();
    if($answerTextarea.val() === '') {
        showWarnModal("내용을 작성해주세요.");
        return;
    }
    answerService.writeAnswer($answerTextarea.val(), (answer) => {
        showList([answer], appendTypes.BEFORE);
        $('div.fake-submit-btn').each((_, e) => $(e).show());
        $answerArea.hide();

        $answerSize.text(parseInt($answerSize.text())+1);
    });
});
//
// function showList(answers, appendType) {
//     let text = "";
//
//     if(answers.length < 1) {
//         $answerContainer.html('');
//         $noneItems.show();
//         $loading.hide();
//         return;
//     }
//     $noneItems.hide();
//     $loading.hide();
//
//     answers.forEach((answer, i) => {
//         if(i > 9) {
//             isListRemains = true;
//             $loading.show();
//         }
//         else {
//             isListRemains = false;
//             $loading.hide();
//             text += `
//                  <article class="c-application c-box c-box--has-border mb-24 answer-wrap" style="border-color: rgb(234, 236, 238); padding: 0;">
//                      <div class="c-application c-box p-relative" style="background-color: rgb(255, 255, 255); padding: 20px;">
//                          <div class="flex justify-between align-items-center">
//                              <div class="c-application c-user-information mb-14 full">
//
//                                  <div class="avatar-wrapper">
//                                      <div>
//                                          <div class="c-application c-avatar--container medium">
//                                              <i class="c-avatar nickname medium" style="background: rgb(145, 207, 211);"></i>
//                                              <div class="c-avatar--item">
//
//                                                  <div class="c-application c-typography c-body1 f-semi-bold" style="color: rgb(255, 255, 255);">
//                                                      ${answer.doctorName.substring(0, 1)}
//                                                  </div>
//                                              </div>
//                                          </div>
//                                      </div>
//                                  </div>
//
//                                  <div class="information-wrapper">
//                                      <div class="name-company-wrapper">
//                                          <div class="name-icon-wrapper">
//                                              <div class="name-wrapper">
//                                                  <div class="c-application c-typography user-information-name ellipsis c-body1 ellipsis" style="color: inherit; font-weight: 600;">
//                                                     ${answer.doctorName}
//                                                  </div>
//                                              </div>
//                                              <div class="user-info-wrapper">
//                                                  <div class="user-information-company">
//                                                      <div class="c-application c-typography ellipsis c-body2" style="color: rgb(148, 155, 160);">
//                                                          ${answer.hospitalName}
//                                                      </div>
//                                                      <svg width="12" height="12"
//                                                           viewBox="0 0 12 12"
//                                                           fill="black"
//                                                           xmlns="http://www.w3.org/2000/svg"
//                                                           class="ml-2 c-application c-icon"
//                                                           style="fill: rgb(42, 125, 225);">
//                                                          <path
//                                                                fill-rule="evenodd"
//                                                                clip-rule="evenodd"
//                                                                d="M6 11C8.76142 11 11 8.76142 11 6C11 3.23858 8.76142 1 6 1C3.23858 1 1 3.23858 1 6C1 8.76142 3.23858 11 6 11ZM8.35355 5.35355C8.54882 5.15829 8.54882 4.84171 8.35355 4.64645C8.15829 4.45118 7.84171 4.45118 7.64645 4.64645L5.5 6.79289L4.35355 5.64645C4.15829 5.45118 3.84171 5.45118 3.64645 5.64645C3.45118 5.84171 3.45118 6.15829 3.64645 6.35355L5.14645 7.85355C5.34171 8.04882 5.65829 8.04882 5.85355 7.85355L8.35355 5.35355Z">
//                                                          </path>
//                                                      </svg>
//                                                  </div>
//                                              </div>
//                                         </div>
//                                      </div>
//                                      <div class="other-wrapper" style="margin-top: 4px;">
//                                          <div class="c-application c-typography c-caption1" type="full" style="color: rgb(173, 179, 184);">
//                                              ${getDepartment(answer.doctorDepartmentType).kor}
//                                               ∙ 채택률 ${answer.adoptedAnswerPercent}%
//                                          </div>
//                                      </div>
//                                  </div>
//                              </div>
//                              <div>
//                                 <div class="c-application c-dropdown">
//                                     <div class="c-dropdown--item-group" style="max-width: 200px;">
//                                         <div>
//                                             <button type="button" class="c-application c-icon-button medium">
//                                                 <svg width="24"
//                                                         height="24" viewBox="0 0 24 24"
//                                                         fill="black"
//                                                         xmlns="http://www.w3.org/2000/svg"
//                                                         class="c-application c-icon"
//                                                         style="fill: rgb(148, 155, 160);">
//                                                     <circle cx="12" cy="5.5" r="1.5">
//                                                     </circle>
//                                                     <circle cx="12" cy="12" r="1.5">
//                                                     </circle>
//                                                     <circle cx="12" cy="18.5" r="1.5">
//                                                     </circle>
//                                                 </svg>
//                                             </button>
//                                         </div>
//                                     </div>
//                                 </div>
//                             </div>
//                         </div>
//                         <p class="c-application c-typography c-application c-content c-body1 c-content--body" style="color: rgb(32, 35, 37);">
//                                 <span>${answer.answerContent}</span>
//                         </p>
//                         <div class="answer-footer-container">
//                             <div class="answer-footer-action-container">
//                                 <div class="answer-footer-action-wrapper">
//                                     <button class="c-application c-rating-button case-detail-like-button info" icon-name="IconLikeSmallLine" color="info">
//                                         <svg width="16"
//                                              height="16" viewBox="0 0 16 16"
//                                              fill="black"
//                                              xmlns="http://www.w3.org/2000/svg"
//                                              class="mr-4 c-application c-icon"
//                                              style="fill: rgb(148, 155, 160);">
//                                             <path
//                                                   fill-rule="evenodd"
//                                                   clip-rule="evenodd"
//                                                   d="M8 5.79179L7.16516 4.5257C6.75467 3.90318 6.05854 3.5 5.27273 3.5C4.02534 3.5 3 4.5219 3 5.8C3 6.46253 3.27323 7.21871 3.78425 8.03207C4.28965 8.8365 4.98019 9.62153 5.6981 10.3215C6.41239 11.0179 7.13067 11.6079 7.67232 12.0246C7.79109 12.116 7.90097 12.1988 8 12.2722C8.09904 12.1988 8.20892 12.116 8.32768 12.0246C8.86934 11.6079 9.58761 11.0179 10.3019 10.3215C11.0198 9.62153 11.7103 8.8365 12.2157 8.03207C12.7268 7.21871 13 6.46253 13 5.8C13 4.5219 11.9747 3.5 10.7273 3.5C9.94146 3.5 9.24533 3.90318 8.83485 4.5257L8 5.79179ZM8 13.5C8 13.5 2 9.5 2 5.8C2 3.97746 3.46525 2.5 5.27273 2.5C6.0432 2.5 6.75149 2.76846 7.31061 3.21768C7.57757 3.43217 7.81052 3.68786 8 3.97522C8.18948 3.68786 8.42244 3.43217 8.6894 3.21768C9.24851 2.76846 9.9568 2.5 10.7273 2.5C12.5348 2.5 14 3.97746 14 5.8C14 9.5 8 13.5 8 13.5Z">
//                                             </path>
//                                         </svg>
//                                         <div class="c-application c-typography c-body2"
//                                              style="color: rgb(148, 155, 160);"><!--${answer.answerLikeCount}--> 0
//                                         </div>
//                                     </button>
//                                 </div>
//                                 <hr class="c-application c-divider mx-12 line vertical #EAECEE" style="border-color: rgb(234, 236, 238); height: 12px;">
//                                 <div class="answer-footer-action-wrapper">
//                                     <button class="c-application c-rating-button case-detail-bookmark-button info"
//                                             icon-name="IconBookmarkSmallLine"
//                                             color="info">
//                                         <svg width="16" height="16"
//                                                 viewBox="0 0 16 16" fill="black"
//                                                 xmlns="http://www.w3.org/2000/svg"
//                                                 class="mr-4 c-application c-icon"
//                                                 style="fill: rgb(148, 155, 160);">
//                                             <path
//                                                   fill-rule="evenodd"
//                                                   clip-rule="evenodd"
//                                                   d="M12 3H4V12.5504L6.88646 10.6157C7.56015 10.1642 8.43985 10.1642 9.11354 10.6157L12 12.5504V3ZM4 2C3.44772 2 3 2.44772 3 3V13.4875C3 13.8874 3.44619 14.1255 3.77839 13.9028L7.44323 11.4464C7.78008 11.2206 8.21992 11.2206 8.55677 11.4464L12.2216 13.9028C12.5538 14.1255 13 13.8874 13 13.4875V3C13 2.44772 12.5523 2 12 2H4Z">
//                                             </path>
//                                         </svg>
//                                         <div class="c-application c-typography c-body2"
//                                              style="color: rgb(148, 155, 160);">
//                                              ${answer.bookmarkCount}
//                                         </div>
//                                     </button>
//                                 </div>
//
//                             </div>
//                             <p class="c-application c-typography c-application c-content c-body2 c-content--caption"
//                                style="color: rgb(207, 212, 215);">
//                                 ${elapsedTime(answer.answerRegisterDateTime)}
//                             </p>
//                         </div>
//                     </div>
//                      <hr class="slight-divider">
//                      <div class="c-application c-box reply-textarea-container"
//                          style="background-color: rgb(255, 255, 255); padding: 16px 20px;">
//                         <div class="c-application c-box additional-comment-container additional-comment-content-wrapper" style="background-color: rgb(255, 255, 255); padding: 0px;">
//                             <div class="c-application c-textarea additional-comment-textarea reply">
//                                 <div class="flex">
//                                     <label class="text-wrap">
//                                         <textarea class="reply-write-${answer.answerId}" placeholder="답변에 대한 의견이 있으신가요?" style="max-height: 256px; min-height: 38px; overflow-y: auto;"></textarea>
//                                     </label>
//                                     <button type="button"
//                                             class="c-application c-icon-button c-textarea--reply-icon medium reply-btn reply-send-${answer.answerId}">
//                                         <svg width="24" height="24"
//                                                 viewBox="0 0 24 24" fill="black"
//                                                 xmlns="http://www.w3.org/2000/svg"
//                                                 class="c-application c-icon"
//                                                 style="fill: rgb(234, 236, 238);">
//                                             <path
//                                                   fill-rule="evenodd"
//                                                   clip-rule="evenodd"
//                                                   d="M20.4582 12.9062C21.2277 12.5471 21.2277 11.4529 20.4582 11.0938L5.42255 4.07716C4.57275 3.68059 3.69362 4.5666 4.09681 5.41328L6.75715 11H11C11.5523 11 12 11.4477 12 12C12 12.5523 11.5523 13 11 13H6.75712L4.09681 18.5867C3.69362 19.4333 4.57275 20.3193 5.42255 19.9228L20.4582 12.9062Z">
//                                             </path>
//                                         </svg>
//                                     </button>
//                                 </div>
//                             </div>
//                         </div>
//                     </div>
//                      <div class="reply-container-${answer.answerId}">
//                          <!---->
//                          <!---->
//                          <!---->
//                      </div>
//                  </article>
//                  <hr class="f-divider">
//             `;
//         }
//     });

    switch (appendType) {
        case appendTypes.BEFORE:
            $answerContainer.prepend(text);
            console.log($answerContainer.length);
            console.log($answerContainer);
            $answerContainer.filter(i => i >= 9).each((i, answer) => $(answer).remove());
            break;
        case appendTypes.AFTER:
            $answerContainer.append(text);
            break;
        case appendTypes.INIT:
            $answerContainer.html(text);
            break;
    }

    answers.map(answer => answer.answerId).forEach(answerId => {
        $(`.reply-write-${answerId}`).on('keyup', function () {
            let $buttonIcon = $(`.reply-send-${answerId} svg`);
            if($(this).val() !== "") $buttonIcon.css('fill', '#2a7de1');
            else $buttonIcon.css('fill', "white");
        });

        replyService.setReplySendEvent(answerId);
    });


function showReplies(replies, type) {
    let texts = [];
    console.log(repliesMap);

    replies.forEach(reply => {
        //check if init reply group
        //console.log(repliesMap[reply.answerId]);

        if(!repliesMap[reply.answerId]) {
            texts[reply.answerId] = `
                <hr class="slight-divider">
                <div class="c-application c-box reply-title-${reply.answerId}"
                    style="background-color: rgb(255, 255, 255); padding: 20px 16px 0px;">
                    <div class="c-application c-typography c-body2" style="color: rgb(89, 95, 99);">
                        댓글
                        <span class="c-application c-typography reply-size-${reply.answerId}"
                            style="color: inherit; font-weight: 500;">
                            ${replies.filter(r => r.answerId === reply.answerId).length}
                        </span>
                    </div>
                </div>
            `;

            repliesMap[reply.answerId] = {
                replies: [],
                page: 0
            };
        }

        if(!texts[reply.answerId]) texts[reply.answerId] = "";

        texts[reply.answerId] +=
            `<div class="answer-comment">
                <div class="c-application c-box" style="background-color: rgb(255, 255, 255); padding: 16px 20px;">
                    <div class="flex justify-between">
                        <div class="c-application c-user-information normal">
                            <div class="avatar-wrapper reply">
                                <div>
                                    <div class="c-application c-avatar--container small">
                                        <i class="c-avatar nickname small"
                                            style="background: rgb(176, 171, 164);"></i>
                                        <div class="c-avatar--item">
                                            <!---->
                                            <!---->
                                            <div class="c-application c-typography c-body2 f-semi-bold"
                                                style="color: rgb(255, 255, 255);">
                                                ${reply.userName.substring(0, 1)}
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="information-wrapper">
                                <div class="name-company-wrapper">
                                    <div class="name-icon-wrapper">
                                        <div class="name-wrapper">
                                            <div class="c-application c-typography user-information-name ellipsis c-body2"
                                                style="color: inherit; font-weight: 600;">
                                                ${reply.userName}
                                            </div>
                                        </div>
                                        <div class="user-info-wrapper">
                                            <!---->
                                            <!---->
                                        </div>
                                    </div>
                                </div>
                                <div class="other-wrapper">
                                    <div class="c-application c-typography c-caption1"
                                        type="normal" style="color: rgb(173, 179, 184);">
                                        ${elapsedTime(reply.replyRegisterDateTime)}
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!---->
                    </div>
                    <div class="c-application c-typography c-body1" style="color: rgb(60, 65, 68);">
                        <span>${reply.replyContent}</span>
                    </div>
                </div>
            </div>
            <hr class="slight-divider">
        `;

        repliesMap[reply.answerId].replies.push(reply);
    });

    let distinctList = [];
    Object.keys(repliesMap).forEach(id => {
        console.log(texts[id]);
        let $count = $(`span.reply-size-${id}`);
        $count.text(parseInt($count.text())+1);

        let $container = $(`.reply-container-${id}`);
        if(type === appendTypes.BEFORE) $(`.reply-title-${id}`).after(texts[id]);
        else $container.append(texts[id]);
    });
}


