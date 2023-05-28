
//두번째 버

// 전체 동의 체크박스 변경 이벤트를 감지하는 함수
function handleCheckAllCheckbox() {
    const checkAllCheckbox = document.querySelector('input[name="checkAll"]');
    const requiredCheckboxes = document.querySelectorAll('input[name="check"].check');
    const button = document.getElementById("check-button");

    // 전체 동의 체크박스가 선택되었는지 확인
    const isCheckAllChecked = checkAllCheckbox.checked;

    // 필수 동의 체크박스의 상태 변경
    requiredCheckboxes.forEach(function (checkbox) {
        checkbox.checked = isCheckAllChecked;
    });

    // 버튼의 disabled 상태 설정
    if (isCheckAllChecked) {
        button.classList.remove("disabled"); // 버튼의 "disabled" 클래스 제거
        button.removeAttribute("disabled"); // 버튼의 "disabled" 속성 제거
    } else {
        button.classList.add("disabled"); // 버튼에 "disabled" 클래스 추가
        button.setAttribute("disabled", "disabled"); // 버튼의 "disabled" 속성 추가
    }
}

// 필수 동의 체크박스 변경 이벤트를 감지하는 함수
function handleRequiredCheckbox() {
    const requiredCheckboxes = document.querySelectorAll('input[name="check"].check');
    const button = document.getElementById("check-button");

    // 필수 동의 체크박스 중 하나라도 체크가 해제되었는지 확인
    let anyUnchecked = false;
    requiredCheckboxes.forEach(function (checkbox) {
        if (!checkbox.checked) {
            anyUnchecked = true;
        }
    });

    // 버튼의 disabled 상태 설정
    if (anyUnchecked) {
        button.classList.add("disabled"); // 버튼에 "disabled" 클래스 추가
        button.setAttribute("disabled", "disabled"); // 버튼의 "disabled" 속성 추가
    } else {
        button.classList.remove("disabled"); // 버튼의 "disabled" 클래스 제거
        button.removeAttribute("disabled"); // 버튼의 "disabled" 속성 제거
    }
}

// 전체 동의 체크박스의 변경 이벤트를 감지하여 처리하는 코드
document.querySelector('input[name="checkAll"]').addEventListener("change", function() {
    const checkAllCheckbox = document.querySelector('input[name="checkAll"]');
    const requiredCheckboxes = document.querySelectorAll('input[name="check"].check');

    // 전체 동의 체크박스가 선택되었는지 확인
    const isCheckAllChecked = checkAllCheckbox.checked;

    // 필수 동의 체크박스의 상태 변경
    requiredCheckboxes.forEach(function (checkbox) {
        checkbox.checked = isCheckAllChecked;
    });

    handleRequiredCheckbox(); // 필수 동의 체크박스 상태 업데이트
});

// 필수 동의 체크박스의 변경 이벤트를 감지하여 처리하는 코드
const requiredCheckboxes = document.querySelectorAll('input[name="check"].check');
requiredCheckboxes.forEach(function (checkbox) {
    checkbox.addEventListener("change", handleRequiredCheckbox);
});
