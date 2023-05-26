$(document).ready(function () {
    let text = "";
    questions.forEach(question => {

        const questionId=question.questionId;

        console.log(questionId);

        text += `
                
                    <div class="swiper-slide swiper-slide-active" style="width: 542px; margin-right: 24px;">
                        <a href="/qeustion-board/detail?id=${question.questionId}">
                        <article class="c-application c-core-card" style="width: auto;">
                            <div class="c-application c-box c-box--has-border" style="border-color: rgb(234, 236, 238); padding: 18px 20px 16px;">
                            <div data-v-1d8d6f66="" class="c-core-card--content-wrapper">
                        <div class="c-application c-chip-group case-chip-group medium">
                            <span class="c-application c-chip chip-views-top fill  info small">
                             조회수 TOP
                            </span>
                            <span class="c-application c-chip chip-case-category fill  info small">${question.doctorDepartmentType}</span>
                        </div>
                        <p class="c-application c-typography c-application c-content c-caption1 c-content--overline" data-v-1d8d6f66="" style="color: rgb(173, 179, 184);">
                            <span class="c-application c-typography" style="color: inherit;"></span> · 
                            <span class="c-application c-typography" style="color: inherit;"></span>
                        </p>
                        <h2 class="c-application c-typography c-application c-content c-headline7 c-content--title" style="color: rgb(4, 5, 5);">
                            ${question.questionTitle}
                        </h2>
                        <p class="c-application c-typography c-application c-content c-body1 c-content--body" style="color: rgb(32, 35, 37);">
                        ${question.questionContent}
                        </p>
                        <div class="c-application c-rating-group">
                            <div class="c-application c-icon-rating">
                                <!--<svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(42, 125, 225);">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M3.69638 13.5299C4.05199 13.1404 4.04399 12.5417 3.67811 12.1619C2.63802 11.0821 2 9.6166 2 8C2 4.68629 4.68629 2 8 2C11.3137 2 14 4.68629 14 8C14 11.3137 11.3137 14 8 14H3.26717L3.69638 13.5299ZM1 8C1 9.88557 1.74553 11.597 2.95789 12.8556L1.76434 14.1629C1.47131 14.4838 1.699 15 2.13358 15H8C11.866 15 15 11.866 15 8C15 4.13401 11.866 1 8 1C4.13401 1 1 4.13401 1 8Z">
                                    </path>
                                    <path d="M6 8C6 8.41421 5.66421 8.75 5.25 8.75C4.83579 8.75 4.5 8.41421 4.5 8C4.5 7.58579 4.83579 7.25 5.25 7.25C5.66421 7.25 6 7.58579 6 8Z">
                                    </path>
                                    <path d="M8.75 8C8.75 8.41421 8.41421 8.75 8 8.75C7.58579 8.75 7.25 8.41421 7.25 8C7.25 7.58579 7.58579 7.25 8 7.25C8.41421 7.25 8.75 7.58579 8.75 8Z">
                                    </path>
                                    <path d="M11.5 8C11.5 8.41421 11.1642 8.75 10.75 8.75C10.3358 8.75 10 8.41421 10 8C10 7.58579 10.3358 7.25 10.75 7.25C11.1642 7.25 11.5 7.58579 11.5 8Z">
                                    </path>
                                </svg>-->
                                <div class="c-application c-typography c-body2" style="color: rgb(42, 125, 225);">
                                 <!-- 댓글 갯수 -->
                                </div>
                            </div>
                            <div class="c-application c-icon-rating">
                                <svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(233, 37, 37);">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M8 5.79179L7.16516 4.5257C6.75467 3.90318 6.05854 3.5 5.27273 3.5C4.02534 3.5 3 4.5219 3 5.8C3 6.46253 3.27323 7.21871 3.78425 8.03207C4.28965 8.8365 4.98019 9.62153 5.6981 10.3215C6.41239 11.0179 7.13067 11.6079 7.67232 12.0246C7.79109 12.116 7.90097 12.1988 8 12.2722C8.09904 12.1988 8.20892 12.116 8.32768 12.0246C8.86934 11.6079 9.58761 11.0179 10.3019 10.3215C11.0198 9.62153 11.7103 8.8365 12.2157 8.03207C12.7268 7.21871 13 6.46253 13 5.8C13 4.5219 11.9747 3.5 10.7273 3.5C9.94146 3.5 9.24533 3.90318 8.83485 4.5257L8 5.79179ZM8 13.5C8 13.5 2 9.5 2 5.8C2 3.97746 3.46525 2.5 5.27273 2.5C6.0432 2.5 6.75149 2.76846 7.31061 3.21768C7.57757 3.43217 7.81052 3.68786 8 3.97522C8.18948 3.68786 8.42244 3.43217 8.6894 3.21768C9.24851 2.76846 9.9568 2.5 10.7273 2.5C12.5348 2.5 14 3.97746 14 5.8C14 9.5 8 13.5 8 13.5Z">
                                    </path>
                                </svg>
                                <div class="c-application c-typography c-body2" style="color: rgb(233, 37, 37);">
                                 ${question.questionLikeCount}
                                 <!-- 좋아요 갯수 나와야함 -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr class="c-application c-divider dash horizontal #EAECEE" style="border-color: rgb(234, 236, 238);">
                    <div data-v-47a6dbf4="" class="avatar-wrapper">
                        <div user-belong="삼성전자">
                            <div class="c-application c-avatar--container small">
                                <i class="c-avatar nickname small" style="background: rgb(176, 171, 164);"></i>
                                <div data-v-16c10fa5="" class="c-avatar--item">
                                    <div class="c-application c-typography c-body2 f-semi-bold" style="color: rgb(255, 255, 255);">
                                     삼
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <div method="answerCount(questionId){}"></div>
                    
                </div>
            </article>
        </a>
</div>
        `
        $('#check-test').html(text);

    });


});



$(document).ready(function answerCount(questionId) {
    console.log(questionId);
    replies.forEach(reply => {
        if (questionId === reply.questionId) {
            let count=0;
            if(count<2){
                text += `
                        <div class="name-text-container">
                            <div class="name-wrapper">
                                <div class="c-application c-typography text-truncate c-body2 f-semi-bold" style="color: rgb(32, 35, 37);">
                                    <div class="case-profile-name">
                                    <span>${reply.answerTitle}</span>
                                        <div class="c-application c-typography ml-4 c-caption1" style="color: rgb(148, 155, 160);">
                                            <span>${reply.userName}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div>
                            <p data-v-45a3e27e="" class="c-application c-typography case-comment c-body2" style="color: rgb(60, 65, 68);">${reply.answerContent}</p>
                            </div>
                        </div>
                        
                        <div></div>
                        
                   `
                $('#heyJin').html(text);
            }
        }
    });

});