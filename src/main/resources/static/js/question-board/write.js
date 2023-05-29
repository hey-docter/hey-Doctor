function dropdownMenu() {
    let click = document.getElementById("choice");
    if(click.style.display === "none"){
        click.style.display = "block";
    }else{
        click.style.display = "none";
    }
}

$('div#select-bar').on('click', dropdownMenu);

$('div#choice>div').each((i, choice) => {
    $(choice).on('click', function () {
        let type = $(this).text().trim();
        $('input.dropdown-text').attr("value", type);
        dropdownMenu();
    });
});

$('textarea.request-textarea').on('keyup', function () {
    let length = $(this).val().length;
    $('span.length').text(length);
    if(length >= 500) $('.length-all').css('color', '#ee6767');
    else $('.length-all').css('color', '#adb5bd');
});

const $reqBtn = $('div.request-box-cont');
const $department = $('.q-department');
const $title = $('.q-title');
const $content = $('.q-content');

$reqBtn.on('click', 'button.send-btn', function (e) {
    e.preventDefault();
    console.log($('.q-department').val());
    if($department.val() === '병과') {showWarnModal("병과를 선택하세요."); return}
    if($title.val() === '') {showWarnModal("제목을 입력하세요."); return}
    if($content.val() === '') {showWarnModal("내용을 입력하세요."); return}

    let department = getDepartment($department.val());
    $department.val(department.eng);

    $('form.write-q').submit();
});