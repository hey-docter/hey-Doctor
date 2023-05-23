$(document).ready(function(){
    const $ul = $("#c-application #c-typography #w-full #c-body2 div");

    let text = "";
    questions.forEach(question => {
        text += `
           <div class="flex justify-content-between mb-8">&ndash;&gt;
                                                    <div class="flex align-items-center">
                                                        <div class="c-application c-typography c-caption1 f-semi-bold"
                                                            style="color: rgb(118, 125, 130);">
                                                            ${question.doctorDepartmentType}
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="c-application c-typography my-page-community-list-item-title c-body1"
                                                    style="color: rgb(60, 65, 68);">
                                                    ${question.questionTitle}
                                                </div>

                                                <div class="flex flex-column">
                                                    <div class="c-application c-typography text-right"
                                                        style="color: rgb(173, 179, 184);">
                                                         ${question.questionRegisterDatetime}
                                                    </div>
                                                </div>
                                            </div>
        `
        // question.files.forEach(file => {
        //     if(file.fileType == "REPRESENTATIVE"){
        //         text += `<img src="/files/display?fileName=${file.filePath}/t_${file.fileUuid}_${file.fileName}" class="preview">`;
        //     }
        // })

        text += `
                    </a>
                </div>
            </li>
        `
    });

    $ul.html(text);
});