const $arrows = $('.arrow');
const $naviTitle = $('.nav-title');
const $boardList = $('.board-list li');
const $inquiriesList = $('.inquiries-list li');
const $deleteBtn = $('.delete-btn');

// public final QnaPageService QnaPageService;

// 사이드 바 이벤트 관련 코드
$arrows.eq(0).css('transform', 'rotate(180deg)')
$inquiriesList.hide();

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



function deleteRow() {
    document.querySelectorAll('input[name=check]:checked').forEach(e => {
        e.parentNode.parentNode.remove()
    });
}

//삭제

$(".delete-btn").on("click", function(e){
    // e.preventDefault();
    let questionId =[];
    $('input:checked').not('.all').parents("tr").each(function() {
        questionId.push($(this).find(".noticeId").html());
    });
    $.ajax({
        url: `/admin/delete?questionId=${questionId}`,
        type: "GET",
        success: function() {
            console.log("성공적으로 삭제되었습니다.");
        }, error: function(){
            console.log("삭제 실패하였습니다.");
            Location.reload();
        }
    });
    // history.go(0);
    // location.href = `/admin/delete?questionId=${deleteList}`;
    location.reload(true);
});

// checkbox

$("#select-all").click(function() {
    if($("#select-all").is(":checked")) $("input[name=check]").prop("checked", true);
    else $("input[name=check]").prop("checked", false);
});

$("input.box").click(function() {
    console.log("ibn");
    var total = $("input[name=check]").length;
    var checked = $("input[name=check]:checked").length;

    if(total != checked) $("#select-all").prop("checked", false);
    else $("#select-all").prop("checked", true);
});

const pageButton = $(".page-button");