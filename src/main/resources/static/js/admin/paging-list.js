

$("a.change-page").on("click", function(e){
    e.preventDefault();
    let page = $(this).attr("href");
    location.href = `/admin/admin-board-list?page=${page}`;
});

// $("ul.inquiries-list").on("click", function(){
//     // e.preventDefault();
//     location.href = `/qna/admin`;
// });

