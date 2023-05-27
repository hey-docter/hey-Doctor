$("#select-all").click(function() {
    if($("#select-all").is(":checked")) $("input[name=qnaId]").prop("checked", true);
    else $("input[name=qnaId]").prop("checked", false);
});

$("input[name=qnaId]").click(function() {
    var total = $("input[name=qnaId]").length;
    var checked = $("input[name=qnaId]:checked").length;

    if(total != checked) $("#select-all").prop("checked", false);
    else $("#select-all").prop("checked", true);
});

const pageButton = $(".page-button");