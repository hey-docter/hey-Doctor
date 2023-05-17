// 버튼 요소들을 가져옵니다.
const buttons = document.querySelectorAll('.c-tabs--menu-button button');

// 버튼 요소들에 클릭 이벤트를 추가합니다.
buttons.forEach(button => {
    button.addEventListener('click', function() {
        // 클릭한 버튼 요소에 active 클래스를 추가합니다.
        this.parentNode.classList.add('active');

        // 다른 버튼 요소들의 active 클래스를 제거합니다.
        buttons.forEach(otherButton => {
            if (otherButton !== button) {
                otherButton.parentNode.classList.remove('active');
            }
        });
    });
});
