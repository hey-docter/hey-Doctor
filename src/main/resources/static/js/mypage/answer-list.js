$(document).ready(function(){
    const $ul = $("#answer ul");

    let text = "";
    posts.forEach(post => {
        console.log("나와랏");
        text += `
                 <div tabindex="0" class="c-application c-list-item my-page-community-list-item my-page-community-card medium c-pointer">
                    <div class="c-application c-typography w-full c-body2" style="color: rgb(173, 179, 184);">
                        <div class="flex justify-content-between mb-8">
                            <div class="flex align-items-center">
                                <div class="c-application c-typography c-caption1 f-semi-bold"
                                    style="color: rgb(118, 125, 130);">
                                    질문
                                </div>
                            </div>
                        </div>
                        <div class="c-application c-typography my-page-community-list-item-title c-body1"
                            style="color: rgb(60, 65, 68);">${post.questionTitle}
                        </div>

                        <div class="flex flex-column">
                            <div class="c-application c-typography text-right"
                                style="color: rgb(173, 179, 184);">
                                <span class="date">${elapsedTime(post.questionRegisterDatetime)}</span> 
                            </div>
                        </div>
                    </div>
                 </div>
                <hr class="c-appli  cation c-divider line horizontal #F3F4F5 my-8"
                    style="border-color: rgba(243, 244, 245, .2);">                        
                `
    });

    $ul.html(text);
});