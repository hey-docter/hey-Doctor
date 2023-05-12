const $banner = $("div.banner");
const $image_divs = $("div.swiper-slide");
const $first_div = $("#first-temp");
const $last_div = $("#last-temp");
const $prev = $("div.swiper-button-prev");
const $next = $("div.swiper-button-next");
const $dots = $("span.swiper-pagination-bullet");
let count = 1;
let check = true;
let clickCheck = false;

let slide = setInterval(() => {++count, changeBanner(0)}, 2000);

changeButtonStyle();

function changeButtonStyle(){
    $dots.css("background", "none");
    $dots.eq(count - 1).css("background-color", "#313131");
    clickCheck = true; //선택 버튼이 변경되는 순간 mouseout 이벤트 막기
}


$dots.hover(function(){
    clickCheck = $(this).css("background-color") == "rgb(49, 49, 49)";
    $(this).css("background", "#313131");
}, function(){
    if(clickCheck){return;}
    $(this).css("background", "none");
});

$dots.on("click", function(){
    clickCheck = true;
    clearInterval(slide);
    count = parseInt($(this).prop("classList")[1]);
    changeBanner(0);
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});

$(".swiper-button").on("click", function(){
    if(!check) {return;}
    check = false;
    const arrow = {next: 0, prev: 1};
    let direction = arrow[$(this).prop("classList")[1]];
    clearInterval(slide);
    count += direction ? -1 : 1;
    changeBanner(direction);
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});

// 정방향: 0, 역방향: 1
function changeBanner(direction){
    check = false;
    const array = [[6, -1430, 1], [0, -1430 * $image_divs.length, $image_divs.length]];
    $banner.css("transform", `translate(${-1430 * count}px)`);
    $banner.css("transition", "transform 0.7s");

    if(count == array[direction][0]) {
        setTimeout(() => {
            $banner.css("transform", `translate(${array[direction][1]}px)`);
            $banner.css("transition", "transform 0s");
        }, 700);
        count = array[direction][2];
    }
    changeButtonStyle();
    setTimeout(() => {
        check = true;
    }, 700);
}