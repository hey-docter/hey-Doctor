$("a.change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    location.href = `/qna/admin?page=${page}`;
});

// $("ul.board-list").on("click", function(){
//     // e.preventDefault();
//     location.href = `/admin/admin-board-list`;
// });