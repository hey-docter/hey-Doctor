// 특정 input 요소에서만 Enter 키 입력 방지하는 함수
function preventEnter(event) {
    if (event.keyCode === 13) {
        event.preventDefault();
        return false;
    }
}