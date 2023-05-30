// $(document).ready(function(){
//     // const $div = $("#community-lists div");
//     let text = "";
//     lists.forEach(list => {
//         text += `
//             <div class="c-application c-typography timeline-title mb-12 c-headline7" style="color: rgb(4, 5, 5); font-weight: 500;">
//                     ${list.questionTitle}
//                 </div>
//                 <div class="c-application c-typography timeline-content c-body2" style="color: rgb(89, 95, 99); font-weight: 400;">
//                     ${list.questionContent}
//                     <span class="more-text">더보기</span>
//                 </div>
//             </div>
//         </div>
//         <div class="timeline-bottom-content-wrapper flex flex-row align-items-center justify-between mt-24">
//             <div class="c-application c-rating-group">
//                 <div class="c-application c-icon-rating">
//                     <svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(148, 155, 160);">
//                         <path fill-rule="evenodd" clip-rule="evenodd" d="M13.8766 8C11.3452 12.6334 4.65478 12.6334 2.12331 8C4.65478 3.36658 11.3452 3.36658 13.8766 8ZM14.8923 7.78461C12.0525 2.10504 3.94746 2.10504 1.10767 7.78461C1.03988 7.9202 1.03988 8.07979 1.10767 8.21538C3.94746 13.895 12.0525 13.895 14.8923 8.21538C14.9601 8.07979 14.9601 7.9202 14.8923 7.78461Z"></path>
//                         <path fill-rule="evenodd" clip-rule="evenodd" d="M8 9.5C8.82843 9.5 9.5 8.82843 9.5 8C9.5 7.17157 8.82843 6.5 8 6.5C7.17157 6.5 6.5 7.17157 6.5 8C6.5 8.82843 7.17157 9.5 8 9.5ZM8 10.5C9.38071 10.5 10.5 9.38071 10.5 8C10.5 6.61929 9.38071 5.5 8 5.5C6.61929 5.5 5.5 6.61929 5.5 8C5.5 9.38071 6.61929 10.5 8 10.5Z"></path>
//                     </svg>
//                     <div class="c-application c-typography c-body2" style="color: rgb(148, 155, 160);">
//                         ${list.readCount}
//                     </div>
//                 </div>
//                 <div class="c-application c-icon-rating">
//                     <svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(148, 155, 160);">
//                         <path fill-rule="evenodd" clip-rule="evenodd" d="M3.69638 13.5299C4.05199 13.1404 4.04399 12.5417 3.67811 12.1619C2.63802 11.0821 2 9.6166 2 8C2 4.68629 4.68629 2 8 2C11.3137 2 14 4.68629 14 8C14 11.3137 11.3137 14 8 14H3.26717L3.69638 13.5299ZM1 8C1 9.88557 1.74553 11.597 2.95789 12.8556L1.76434 14.1629C1.47131 14.4838 1.699 15 2.13358 15H8C11.866 15 15 11.866 15 8C15 4.13401 11.866 1 8 1C4.13401 1 1 4.13401 1 8Z"></path>
//                         <path d="M6 8C6 8.41421 5.66421 8.75 5.25 8.75C4.83579 8.75 4.5 8.41421 4.5 8C4.5 7.58579 4.83579 7.25 5.25 7.25C5.66421 7.25 6 7.58579 6 8Z"></path>
//                         <path d="M8.75 8C8.75 8.41421 8.41421 8.75 8 8.75C7.58579 8.75 7.25 8.41421 7.25 8C7.25 7.58579 7.58579 7.25 8 7.25C8.41421 7.25 8.75 7.58579 8.75 8Z"></path>
//                         <path d="M11.5 8C11.5 8.41421 11.1642 8.75 10.75 8.75C10.3358 8.75 10 8.41421 10 8C10 7.58579 10.3358 7.25 10.75 7.25C11.1642 7.25 11.5 7.58579 11.5 8Z"></path>
//                     </svg>
//                     <div class="c-application c-typography c-body2" style="color: rgb(148, 155, 160);"> ${list.questionLikeCount} </div>
//                 </div>
//                 <div class="c-application c-icon-rating community-timeline-card-bookmark">
//                     <svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(148, 155, 160);">
//                         <path fill-rule="evenodd" clip-rule="evenodd" d="M12 3H4V12.5504L6.88646 10.6157C7.56015 10.1642 8.43985 10.1642 9.11354 10.6157L12 12.5504V3ZM4 2C3.44772 2 3 2.44772 3 3V13.4875C3 13.8874 3.44619 14.1255 3.77839 13.9028L7.44323 11.4464C7.78008 11.2206 8.21992 11.2206 8.55677 11.4464L12.2216 13.9028C12.5538 14.1255 13 13.8874 13 13.4875V3C13 2.44772 12.5523 2 12 2H4Z"></path>
//                     </svg>
//                     <div class="c-application c-typography c-body2" style="color: rgb(148, 155, 160);">
//                         ${list.bookmarkedCount}
//                     </div>
//                 </div>
//         `
//
//     });
//     $('#community-lists div').html(text);
//     // $div.html(text);
//     // const $div = $("#community-lists div");
// });

function showQuestion() {
    let search = $("input#c-search-input-2").val();

    if(!search) {
        search = '';
    }

    $.ajax({
        url: `/search/question-list?keyword=${search}`,
        success : function (questions) {

            let text = "";
            questions.forEach(question => {
                text +=`
<!--                    <div class="community-results community-listss">-->
                        <a href="">
                            <article class="community-timeline-card community-results-card">
                                <div class="c-application c-box p-relative">
    
                                    <!-- 커뮤니티 내용 시작-->
                                    <div class="main-content-container">
                                        <div class="main-content-wrapper">
                                            <div class="c-application c-typography timeline-title mb-12 c-headline7" style="color: rgb(4, 5, 5); font-weight: 500;">
                                                ${question.questionTitle}
                                            </div>
                                            <div class="c-application c-typography timeline-content c-body2" style="color: rgb(89, 95, 99); font-weight: 400;">
                                                ${question.questionContent}
                
                                            </div>
                                            <div class="c-application c-typography timeline-content c-body2" style="color: rgb(89, 95, 99); font-weight: 400;">
                                                ${question.userName}
                                            </div>
                                            <div class="c-application c-typography timeline-content c-body2" style="color: rgb(89, 95, 99); font-weight: 400;">
                                                ${question.doctorDepartmentType}
                                            </div>
                                        </div>
                                    </div>
                                    <div class="timeline-bottom-content-wrapper flex flex-row align-items-center justify-between mt-24">
                                        <div class="c-application c-rating-group">
                                            <div class="c-application c-icon-rating">
                                                <svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(148, 155, 160);">
                                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M13.8766 8C11.3452 12.6334 4.65478 12.6334 2.12331 8C4.65478 3.36658 11.3452 3.36658 13.8766 8ZM14.8923 7.78461C12.0525 2.10504 3.94746 2.10504 1.10767 7.78461C1.03988 7.9202 1.03988 8.07979 1.10767 8.21538C3.94746 13.895 12.0525 13.895 14.8923 8.21538C14.9601 8.07979 14.9601 7.9202 14.8923 7.78461Z"></path>
                                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M8 9.5C8.82843 9.5 9.5 8.82843 9.5 8C9.5 7.17157 8.82843 6.5 8 6.5C7.17157 6.5 6.5 7.17157 6.5 8C6.5 8.82843 7.17157 9.5 8 9.5ZM8 10.5C9.38071 10.5 10.5 9.38071 10.5 8C10.5 6.61929 9.38071 5.5 8 5.5C6.61929 5.5 5.5 6.61929 5.5 8C5.5 9.38071 6.61929 10.5 8 10.5Z"></path>
                                                </svg>
                                                <div class="c-application c-typography c-body2" style="color: rgb(148, 155, 160);"> 
                                                    ${question.readCount} 
                                                </div>
                                            </div>
                                            <span class="c-application c-typography c-body2">${elapsedTime(question.questionRegisterDatetime)}</span>
                                            <!--<div class="c-application c-icon-rating">
                                                <svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(148, 155, 160);">
                                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M3.69638 13.5299C4.05199 13.1404 4.04399 12.5417 3.67811 12.1619C2.63802 11.0821 2 9.6166 2 8C2 4.68629 4.68629 2 8 2C11.3137 2 14 4.68629 14 8C14 11.3137 11.3137 14 8 14H3.26717L3.69638 13.5299ZM1 8C1 9.88557 1.74553 11.597 2.95789 12.8556L1.76434 14.1629C1.47131 14.4838 1.699 15 2.13358 15H8C11.866 15 15 11.866 15 8C15 4.13401 11.866 1 8 1C4.13401 1 1 4.13401 1 8Z"></path>
                                                    <path d="M6 8C6 8.41421 5.66421 8.75 5.25 8.75C4.83579 8.75 4.5 8.41421 4.5 8C4.5 7.58579 4.83579 7.25 5.25 7.25C5.66421 7.25 6 7.58579 6 8Z"></path>
                                                    <path d="M8.75 8C8.75 8.41421 8.41421 8.75 8 8.75C7.58579 8.75 7.25 8.41421 7.25 8C7.25 7.58579 7.58579 7.25 8 7.25C8.41421 7.25 8.75 7.58579 8.75 8Z"></path>
                                                    <path d="M11.5 8C11.5 8.41421 11.1642 8.75 10.75 8.75C10.3358 8.75 10 8.41421 10 8C10 7.58579 10.3358 7.25 10.75 7.25C11.1642 7.25 11.5 7.58579 11.5 8Z"></path>
                                                </svg>
                                                <div class="c-application c-typography c-body2" style="color: rgb(148, 155, 160);"> ${question.questionLikeCount} </div>
                                            </div>
                                            <div class="c-application c-icon-rating community-timeline-card-bookmark">
                                                <svg width="16" height="16" viewBox="0 0 16 16" fill="black" xmlns="http://www.w3.org/2000/svg" class="mr-4 c-application c-icon" style="fill: rgb(148, 155, 160);">
                                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M12 3H4V12.5504L6.88646 10.6157C7.56015 10.1642 8.43985 10.1642 9.11354 10.6157L12 12.5504V3ZM4 2C3.44772 2 3 2.44772 3 3V13.4875C3 13.8874 3.44619 14.1255 3.77839 13.9028L7.44323 11.4464C7.78008 11.2206 8.21992 11.2206 8.55677 11.4464L12.2216 13.9028C12.5538 14.1255 13 13.8874 13 13.4875V3C13 2.44772 12.5523 2 12 2H4Z"></path>
                                                </svg>
                                                <div class="c-application c-typography c-body2" style="color: rgb(148, 155, 160);">
                                                    ${question.bookmarkCount}
                                                </div>
                                            </div>
                                        </div>
                                    </div>-->
                                </div>
                            </article>
                        </a>
<!--                   </div>-->
                
                `


            })
            //검색 결과가 없습니다.(만들어야됨)
            if(questions.length == 0){
                text += `
                        <div>
                            현재 게시글이 없습니다. 게시글 작성을 해보세요!
                        </div>
                    
                `
            }
            // const $div = $("#community-listss div");
            // $div.html(text);
            const wrapper = document.querySelector('.community-listss')
            wrapper.innerHTML = text
        }
    })
}

function elapsedTime(date) {
    const start = new Date(date);
    const end = new Date();

    const diff = (end - start) / 1000;

    const times = [
        { name: '년', milliSeconds: 60 * 60 * 24 * 365 },
        { name: '개월', milliSeconds: 60 * 60 * 24 * 30 },
        { name: '일', milliSeconds: 60 * 60 * 24 },
        { name: '시간', milliSeconds: 60 * 60 },
        { name: '분', milliSeconds: 60 },
    ];

    for (const value of times) {
        const betweenTime = Math.floor(diff / value.milliSeconds);

        if (betweenTime > 0) {
            return `${betweenTime}${value.name} 전`;
        }
    }
    return '방금 전';
}


