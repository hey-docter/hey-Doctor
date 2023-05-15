//nav이동
const marker=document.querySelector(".marker");

//nav의 marker의 길이와 위치를 설정하는 함수
//A function to set the length and position of the nav marker.
function setMarker(e) {
    marker.style.left = e.offsetLeft+"px";
    marker.style.width = e.offsetWidth+"px";
}

const sections = document.querySelectorAll("section");
const menus = document.querySelectorAll(".nav__menu > li > a")

//스크롤 위치에 따라 해당하는 menu의 색깔과 마커가 달라짐
//The color and marker of the corresponding menu change according to the scroll position

window.addEventListener("scroll",()=>{
    //현재 영역의 id값
    //id of the current section
    let current=""

    sections.forEach(section=>{
        //각 section의 top 위치(절대적 위치)
        // The top of each section (absolute)
        const sectionTop = window.scrollY + section.getBoundingClientRect().top;

        //누적된 스크롤이 section의 top위치에 도달했거나 section의 안에 위치할 경우
        //When the accumulated scroll reaches the top of the section or is located inside the section
        if(window.scrollY >= sectionTop) {
            current = section.getAttribute("id");
        }


        menus.forEach(menu=>{
            menu.classList.remove("nav__menu--foused");
            const href = menu.getAttribute("href").substring(1);
            if(href===current) {
                //현재 있는 영역의 id와 메뉴의 링크주소가 일치할때
                //When the Id of the current section matches the href of the menu
                menu.classList.add("nav__menu--foused");
                setMarker(menu);
            }
        })
    })
})


/* 예약 버튼 클릭 시 svg변경 */
// function handleClick(el) {
//     var items = document.querySelectorAll('.detail-side-box-schedule-list-item');
//     for (var i = 0; i < items.length; i++) {
//         var item = items[i];
//         if (item !== el.parentNode) {
//             item.querySelector('span').classList.remove('selected');
//             item.querySelector('span').classList.add('unselected');
//             item.querySelector('span').innerHTML = '<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="c-icon" style="fill: rgb(42, 125, 225);"><path fill-rule="evenodd" clip-rule="evenodd" d="M12 22C17.5228 22 22 17.5228 22 12C22 6.47715 17.5228 2 12 2C6.47715 2 2 6.47715 2 12C2 17.5228 6.47715 22 12 22ZM16.7071 10.7071C17.0976 10.3166 17.0976 9.68342 16.7071 9.29289C16.3166 8.90237 15.6834 8.90237 15.2929 9.29289L11 13.5858L8.70711 11.2929C8.31658 10.9024 7.68342 10.9024 7.29289 11.2929C6.90237 11.6834 6.90237 12.3166 7.29289 12.7071L10.2929 15.7071C10.6834 16.0976 11.3166 16.0976 11.7071 15.7071L16.7071 10.7071Z"stroke="white" stroke-linecap="round" stroke-linejoin="round"/></svg>';
//         }
//     }
//     el.classList.remove('unselected');
//     el.classList.add('selected');
//     el.innerHTML = '<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" class="c-icon" style="fill: rgb(42, 125, 225);"><path fill-rule="evenodd" clip-rule="evenodd" d="M12 22C17.5228 22 22 17.5228 22 12C22 6.47715 17.5228 2 12 2C6.47715 2 2 6.47715 2 12C2 17.5228 6.47715 22 12 22ZM16.7071 10.7071C17.0976 10.3166 17.0976 9.68342 16.7071 9.29289C16.3166 8.90237 15.6834 8.90237 15.2929 9.29289L11 13.5858L8.70711 11.2929C8.31658 10.9024 7.68342 10.9024 7.29289 11.2929C6.90237 11.6834 6.90237 12.3166 7.29289 12.7071L10.2929 15.7071C10.6834 16.0976 11.3166 16.0976 11.7071 15.7071L16.7071 10.7071Z"stroke="white" stroke-linecap="round" stroke-linejoin="round"/></svg>';
// }