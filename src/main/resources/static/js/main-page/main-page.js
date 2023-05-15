const $banner = $("#swiper-wrapper");
const $secondBanner = $("div.second-banner");
const $thirdBanner = $("div.third-banner");
const $fourthBanner = $("div.fourth-banner");

const $image_divs = $("div.swiper-slide");
const $second_divs = $("div.second-banner .swiper-slide");
const $third_divs = $("div.third-banner .swiper-slide");
const $fourth_divs = $("div.fourth-banner .swiper-slide");

const $first_div = $("#first-temp");
const $last_div = $("#last-temp");
const $prev = $("div.swiper-button-prev");
const $next = $("div.swiper-button-next");
const $dots = $("span.swiper-pagination-bullet");
const $worm = $("div.worm");
let count = 1;
let secondCount = 0;
let thirdCount = 0;
let fourthCount = 0;

let wormCount = 0;
let check = true;
let clickCheck = false;

$banner.css("transform", `translate(${-1432 * count}px)`);
$banner.css("transition", "transform 0s");

let slide = setInterval(() => {++count, changeBanner(0)}, 2000);

// $worm.css("--index",(0));
changeButtonStyle();


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

// 점을 누르면 해당 배너로 이동
function dotClick(n){
    count = n;
    changeBanner(0);
}



// 메인베너 이전/다음 버튼
$(".swiper-button-next").on("click", function(){
    if(!check) {return;}
    check = false;
    const arrow = {next: 0, prev: 1};
    let direction = 0;
    clearInterval(slide);
    count += direction ? -1 : 1;
    changeBanner(direction);
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});
$(".swiper-button-prev").on("click", function(){
    if(!check) {return;}
    if(count==1){
        $banner.css("transform", `translate(${-1432 * $image_divs.length}px)`);
        $banner.css("transition", "transform 0s");
    }
    check = false;
    const arrow = {next: 0, prev: 1};
    let direction = 1;
    clearInterval(slide);
    count += direction ? -1 : 1;
    changeBanner(direction);
    slide = setInterval(() => {++count, changeBanner(0)}, 2000);
});

// 정방향: 0, 역방향: 1
//메인 배너
function changeBanner(direction){
    console.log(count);
    check = false;
    const array = [[6, -1432, 1], [0, -1432 * $image_divs.length, $image_divs.length]];
    $banner.css("transform", `translate(${-1432 * count}px)`);
    $banner.css("transition", "transform 0.7s");

    if(direction==0 && count == array[direction][0]) {
        setTimeout(() => {
            console.log("worried")
            $banner.css("transform", `translate(${array[direction][1]}px)`);
            $banner.css("transition", "transform 0s");
        }, 700);
        count = array[direction][2];
    }
    changeButtonStyle();
    // $worm.css("--index",(count));
    setTimeout(() => {
        check = true;
    }, 700);
}

// 두번째 배너 이전/다음 버튼
$(".second-next").on("click", function(){
    if(secondCount < $second_divs.length-4){
        $secondBanner.css("transform", `translate(${-283*(++secondCount)}px)`);
        $secondBanner.css("transition", "transform 0.7s");
    }else if($(this).hasClass('swiper-button-disabled')){
    }else{
        $(".second-next").addClass('swiper-button-disabled');
    }

    console.log(secondCount);
    if(secondCount >= 1){
        $(".second-prev").removeClass('swiper-button-disabled')
    }
});

$(".second-prev").on("click", function(){
    if(secondCount > 0){
        $secondBanner.css("transform", `translate(${-283*(--secondCount)}px)`);
        $secondBanner.css("transition", "transform 0.7s");
        // console.log(secondCount);
    }else if($(this).hasClass('swiper-button-disabled')){
    }else{
        $(".second-prev").addClass('swiper-button-disabled');
    }
    if(secondCount < $second_divs.length-4){
        $(".second-next").removeClass('swiper-button-disabled')
    }
});


// 세번째 배너 이전/다음 버튼
$(".third-next").on("click", function(){
    if(thirdCount < $third_divs.length-2){
        $thirdBanner.css("transform", `translate(${-566*(++thirdCount)}px)`);
        $thirdBanner.css("transition", "transform 0.7s");
        // console.log(secondCount);
    }else if($(this).hasClass('swiper-button-disabled')){
    }else{
        $(".third-next").addClass('swiper-button-disabled');
    }
    if(thirdCount >= 1){
        $(".third-prev").removeClass('swiper-button-disabled')
    }
});

$(".third-prev").on("click", function(){
    if(thirdCount > 0){
        $thirdBanner.css("transform", `translate(${-566*(--thirdCount)}px)`);
        $thirdBanner.css("transition", "transform 0.7s");
        // console.log(secondCount);
    }else if($(this).hasClass('swiper-button-disabled')){
    }else{
        $(".third-prev").addClass('swiper-button-disabled');
    }
    if($thirdBanner < $third_divs.length-2){
        $(".third-next").removeClass('swiper-button-disabled')
    }
});
// 네번째 배너 이전/다음 버튼
$(".fourth-next").on("click", function(){
    if(fourthCount < $fourth_divs.length-4){
        $fourthBanner.css("transform", `translate(${-283*(++fourthCount)}px)`);
        $fourthBanner.css("transition", "transform 0.7s");
        // console.log(secondCount);
    }else if($(this).hasClass('swiper-button-disabled')){
    }else{
        $(".fourth-next").addClass('swiper-button-disabled');
    }
    if(fourthCount >= 1){
        $(".fourth-prev").removeClass('swiper-button-disabled')
    }
});

$(".fourth-prev").on("click", function(){
    if(fourthCount > 0){
        $fourthBanner.css("transform", `translate(${-283*(--fourthCount)}px)`);
        $fourthBanner.css("transition", "transform 0.7s");
        // console.log(secondCount);
    }else if($(this).hasClass('swiper-button-disabled')){
    }else{
        $(".fourth-prev").addClass('swiper-button-disabled');
    }
    if($fourthBanner < $fourth_divs.length-4){
        $(".fourth-next").removeClass('swiper-button-disabled')
    }
});


//알림 모달


const $modal= $("#noti-drawer");
const $background = $(".mask");

// 알림 버튼 누르면 모달창 오른쪽에서부터 슬라이드
$("#notification-btn").on("click",function(){
    $modal.css("right", "0px");
    $modal.css("transition", "transform 0.3s");
    $background.css("display","block");
    $background.css("background","#000");
    // $("#notification-btn").addClass("noti-active");
});

// 모달창 밖 누르면 없어짐
$(".mask").on("click",function(event){
    $modal.css("right", "-360px");
    $background.css("display","none");
    $background.css("background","none");

});
