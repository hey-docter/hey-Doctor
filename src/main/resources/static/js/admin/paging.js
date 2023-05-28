$("a.change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    let type = $("select[name=type]").val();
    let keyword = $("input[name=keyword]").val();
    location.href = `/admin-page/admin?page=${page}`;
});

// $("ul.board-list").on("click", function(){
//     // e.preventDefault();
//     location.href = `/admin/admin-board-list`;
// });