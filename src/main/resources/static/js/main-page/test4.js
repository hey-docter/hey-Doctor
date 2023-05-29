replies.forEach(reply=> {

    let count = 0;

    text += `
                    <hr class="c-application c-divider dash horizontal #EAECEE" style="border-color: rgb(234, 236, 238);">
                    <div class="c-card--replies-wrapper">
                        <div class="name-text-container">
                                                            <div class="name-wrapper">
                                                                <div class="c-application c-typography text-truncate c-body2 f-semi-bold"
                                                                     style="color: rgb(32, 35, 37);">
                                                                    <div class="case-profile-name">
                                                                        <span>${reply.answerTitle}</span>
                                                                        <div class="c-application c-typography ml-4 c-caption1"
                                                                             style="color: rgb(148, 155, 160);">
                                                                             <span>${reply.userName}</span>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div>
                                                                <p data-v-45a3e27e=""
                                                                   class="c-application c-typography case-comment c-body2"
                                                                   style="color: rgb(60, 65, 68);">
                                                                    ${reply.answerContent}
                                                                </p>
                                                            </div>
                                                        </div>
                        <button type="button" class="c-application c-narrow-button medium" style="color: rgb(110, 167, 235);">
                            <div class="c-narrow-button--icon"></div>
                            답변 더보기
                            <div class="c-narrow-button--icon"></div>
                        </button>
                    </div>
                </div>
            </article>
            </a>
</div>
        `
    count++

    if(count>=2) {
        return;
    }

    $('#test-second').html(text);
});