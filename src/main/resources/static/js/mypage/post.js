

const $search = $("div.search-container input");
const $upload = $("input.upload");
const $thumbnail = $("label.attach img.thumbnail");
const $checkAgree = $("input[name='agree']");

$("img.preview").each(function(i){
    if(!$(this).attr("src")){
        $(this).hide();
    }
});

$search.on("focus", function(){
    $("div.search-container").css("outline", "#eb7c78 solid 2px");
});

$search.on("blur", function(){
    $("div.search-container").css("outline", "none");
});

let sizes = new Array();
$upload.on("change", function(e){
    let i = $upload.index($(this));
    let files = $(this)[0].files;
    let name = files[0].name;
    let formData = new FormData();

    sizes.push(files[0].size);

    $(files).each((i, file) => {
        formData.append("uploadFile", file);
    });

    $.ajax({
        url: "/files/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(uuids){
            $("label.attach").eq(i).find("h6").hide();
            $("div.x").eq(i).show();
            $("img.thumbnail").eq(i).show();

            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();

            month = month < 10 ? "0" + month : month;
            date = date < 10 ? "0" + date : date;

            let fileName = year + "/" + month + "/" + date + "/t_" + uuids[0] + "_" + name;
            $("img.thumbnail").eq(i).attr("src", `/files/display?fileName=${fileName}`);
        }
    });

    // console.log($(this).files[0]);

    // var reader = new FileReader();
    // reader.readAsDataURL(e.target.files[0]);
    // reader.onload = function(e){
    //     let url = e.target.result;
    //     if(url.includes('image')){
    //         $("label.attach").eq(i).find("h6").hide();
    //         $("div.x").eq(i).show();
    //         $thumbnail.eq(i).show();
    //         $thumbnail.eq(i).attr('src', url);
    //     }else{
    //         showWarnModal("이미지 파일만 등록 가능합니다.");
    //     }
    // }
});

$("div.x").on("click", function(e){
    e.preventDefault();
    let i = $("div.x").index($(this));
    sizes = sizes.splice(i, 1);
    $upload.eq(i).val("");
    $("label.attach").eq(i).find("h6").show();
    $("div.x").eq(i).hide();
    $thumbnail.eq(i).attr('src', "");
    $thumbnail.eq(i).hide();
});

$("button.ok-button").on("click", function(){
    const imgs = $("img.thumbnail").filter((i, img) => $(img).attr("src"));
    let text = ``;
    imgs.each((i, img) => {
        let fullPath = $(img).attr("src");
        let datas = fullPath.split("_");
        let filePath = datas[0].split("=")[1].replace("/t", "");
        let fileUuid = datas[1];
        let fileName = datas[2];
        let fileSize = sizes[i];

        text += `
            <input type="hidden" name="files[${i}].filePath" value="${filePath}">
            <input type="hidden" name="files[${i}].fileUuid" value="${fileUuid}">
            <input type="hidden" name="files[${i}].fileName" value="${fileName}">
            <input type="hidden" name="files[${i}].fileSize" value="${fileSize}">
        `
    });
    $(writeForm).append(text);
    $(writeForm).submit();
});

$checkAgree.on("change", function(){
    let isChecked = $(this).prop("checked");
    isChecked ? checkedSaveId() : notCheckedSaveId();
});

function checkedSaveId(){
    $("#check-agree span.checkbox").css("border-color", "rgb(235 124 120)");
    $("#check-agree span.checkbox").css("background-color", "rgb(235 124 120)");
}

function notCheckedSaveId(){
    $("#check-agree span.checkbox").css("border-color", "");
    $("#check-agree span.checkbox").css("background-color", "");
}

/*정렬 이벤트 및 스타일 변경*/
const $orders = $("section.order a");
$orders.on("click", function(e){
    let i = $orders.index($(this));
});

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

function checkLength(textarea, max){
    let value = $(textarea).val();
    let length = value.length > max ? max : value.length;
    max = max.toLocaleString('ko-KR'); //한국 숫자 표기법(끝 3자리 마다 콤마 삽입)
    $(textarea).next().text(`${length}/${max}`);
}

function blockEnter(){
    if(event.keyCode == 13) {
        event.returnValue = false;
    }
}