$("#select-all").click(function() {
    if($("#select-all").is(":checked")) $("input[name=check]").prop("checked", true);
    else $("input[name=check]").prop("checked", false);
});

$("input[name=check]").click(function() {
    var total = $("input[name=check]").length;
    var checked = $("input[name=check]:checked").length;

    if(total != checked) $("#select-all").prop("checked", false);
    else $("#select-all").prop("checked", true);
});

const pageButton = $(".page-button");