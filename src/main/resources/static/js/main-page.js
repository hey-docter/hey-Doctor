const $banner = $("#swiper-wrapper");
const $image_divs = $("div.swiper-slide");
const $first_div = $("#first-temp");
const $last_div = $("#last-temp");
const $prev = $("div.swiper-button-prev");
const $next = $("div.swiper-button-next");
const $dots = $("span.swiper-pagination-bullet");
const $worm = $("div.worm");
let count = 1;
let wormCount = 0;
let check = true;
let clickCheck = false;

let slide = setInterval(() => {++count, changeBanner(0)}, 2000);

$worm.css("--index",(0));
// changeButtonStyle();

// document.getElementsByClassName('worm').style.getPropertyValue("index");

// $worm.style.setProperty("--index",count);

// .index-landing-hero-swiper-pagination-wrapper .worm-increase{
//     animation: worm-increase .8s;
// }


function changeButtonStyle(){
    $dots.css("background", "none");
    $dots.eq(count - 1).css("background-color", "white");
    clickCheck = true; //선택 버튼이 변경되는 순간 mouseout 이벤트 막기
}

$dots.hover(function(){
    clickCheck = $(this).css("background-color") == "white";
    $(this).css("background", "white");
}, function(){
    if(clickCheck){return;}
    $(this).css("background", "none");
});

$dots.on("click", function(){
    clickCheck = true;
    clearInterval(slide);
    count = parseInt($(this).prop("classList")[1]);
    console.log(count);
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
    const array = [[6, -1432, 1], [0, -1432 * $image_divs.length, $image_divs.length]];
    $banner.css("transform", `translate(${-1432 * count}px)`);
    $banner.css("transition", "transform 0.7s");

    if(count == array[direction][0]) {
        setTimeout(() => {
            $banner.css("transform", `translate(${array[direction][1]}px)`);
            $banner.css("transition", "transform 0s");
        }, 700);
        count = array[direction][2];
    }
    console.log(count);
    $worm.css("--index",(count-1));
    // changeButtonStyle();
    setTimeout(() => {
        check = true;
    }, 700);
}