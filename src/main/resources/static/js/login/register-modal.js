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

// 바깥 영역 클릭하면 모달창 꺼지기
modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modal.style.display = "none"
    }
})

// 모달창 켜진 상태에서 ESC 버튼 누르면 꺼지기
window.addEventListener("keyup", e => {
    if(modal.style.display === "flex" && e.key === "Escape") {
        modal.style.display = "none"
    }
})