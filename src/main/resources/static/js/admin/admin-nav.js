const $arrows = $('.arrow');
const $naviTitle = $('.nav-title');
const $boardList = $('.board-list li');
const $inquiriesList = $('.inquiries-list li');

// 사이드 바 이벤트 관련 코드
$arrows.eq(0).css('transform', 'rotate(180deg)')
$boardList.hide();

$naviTitle.eq(0).on('click', function() {
	const deg = $arrows[0].style.transform;
    $arrows.eq(0).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $boardList.slideToggle(300);
})

$naviTitle.eq(1).on('click', function() {
    const deg = $arrows[1].style.transform;
    $arrows.eq(1).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $inquiriesList.slideToggle(300);
})

$arrows.eq(0).on('click', function() {
    const deg = this.style.transform;
    $(this).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $boardList.slideToggle(300);
})

$arrows.eq(1).on('click', function() {
    const deg = this.style.transform;
    $(this).css('transform',deg === 'rotate(180deg)' ? 'rotate(0deg)' : 'rotate(180deg)');
    $inquiriesList.slideToggle(300);
})

$(".delete-btn").on("click", function(e){
    e.preventDefault();
    let qnaId =[];
    $('input:checked').not('.all').parents("tr").each(function() {
        qnaId.push($(this).find(".noticeId").html());
    });
    $.ajax({
        url: `/qna/delete?qnaId=${qnaId}`,
        type: "GET",
        success: function() {
            console.log("성공적으로 삭제되었습니다.");
        }, error: function(){
            console.log("삭제 실패하였습니다.");
            Location.reload();
        }
    });
    // location.href = `/admin/delete?questionId=${deleteList}`;
    location.reload(true);
});

// checkbox
$("#select-all").click(function() {
    if($("#select-all").is(":checked")) $("input[name=qnaId]").prop("checked", true);
    else $("input[name=qnaId]").prop("checked", false);
});

$("input.box").click(function() {
    console.log("ibn");
    var total = $("input[name=qnaId]").length;
    var checked = $("input[name=qnaId]:checked").length;

    if(total != checked) $("#select-all").prop("checked", false);
    else $("#select-all").prop("checked", true);
});