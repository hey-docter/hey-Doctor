//특정 버튼 누르면 모달창 실행
const modal = document.getElementById("modal")
const btnModal = document.getElementById("btn-modal")
btnModal.addEventListener("click", e => {
modal.style.display = "flex"
})

//x 누르면 모달창 꺼지기
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
modal.style.display = "none"
})

// 모달창 켜진 상태에서 ESC 버튼 누르면 꺼지기
window.addEventListener("keyup", e => {
    if(modal.style.display === "flex" && e.key === "Escape") {
        modal.style.display = "none"
    }
})

//모달창 다음버튼 숨김
function showRemainingContent() {
    // 이메일, 닉네임, 패스워드가 있는 화면을 숨김 처리
    document.getElementById("mb-50").style.display = "none";
    // 숨겨져 있던 나머지 화면들을 보이게 처리
    document.getElementById("remainingContent").style.display = "block";
}
document.getElementById("nextButton").addEventListener("click", showRemainingContent);