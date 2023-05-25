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

$('div.request-box-cont').on('click', 'button.send-btn',function (e) {
    e.preventDefault();
    $('form.write-q').submit();
});