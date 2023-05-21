//첫번째 input 버튼

// 이메일, 이름, 비밀번호 입력 필드를 모두 선택
var emailInput = document.querySelector('input[name="userEmail"]');
var nameInput = document.querySelector('input[name="userName"]');
var passwordInput = document.querySelector('input[name="userPassword"]');
var nextButton = document.getElementById("nextButton");

// 입력 필드가 변경될 때마다 유효성을 검사하고 다음 버튼의 활성화 상태를 업데이트
emailInput.addEventListener("input", validateInputs);
nameInput.addEventListener("input", validateInputs);
passwordInput.addEventListener("input", validateInputs);

// 입력 필드 유효성을 검사하고 다음 버튼의 활성화 상태 업데이트 함수
function validateInputs() {
    var emailValue = emailInput.value.trim();
    var nameValue = nameInput.value.trim();
    var passwordValue = passwordInput.value.trim();

    // 이메일, 이름, 비밀번호가 모두 작성되어 있는 경우 다음 버튼을 활성화
    if (emailValue !== "" && nameValue !== "" && passwordValue !== "") {
        nextButton.classList.remove("disabled"); // 버튼의 "disabled" 클래스 제거
        nextButton.removeAttribute("disabled"); // 버튼의 "disabled" 속성 제거
    } else {
        nextButton.classList.add("disabled"); // 버튼에 "disabled" 클래스 추가
        nextButton.setAttribute("disabled", "disabled"); // 버튼의 "disabled" 속성 추가
    }
}



//두번째 버

// 전체 동의 체크박스 변경 이벤트를 감지하는 함수
function handleCheckAllCheckbox() {
    var checkAllCheckbox = document.querySelector('input[name="checkAll"]');
    var requiredCheckboxes = document.querySelectorAll('input[name="check"].check');
    var button = document.getElementById("check-button");

    // 전체 동의 체크박스가 선택되었는지 확인
    var isCheckAllChecked = checkAllCheckbox.checked;

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
    var requiredCheckboxes = document.querySelectorAll('input[name="check"].check');
    var button = document.getElementById("check-button");

    // 모든 필수 동의 체크박스가 선택되었는지 확인
    var allChecked = true;
    requiredCheckboxes.forEach(function (checkbox) {
        if (!checkbox.checked) {
            allChecked = false;
        }
    });

    // 버튼의 disabled 상태 설정
    if (allChecked) {
        button.classList.remove("disabled"); // 버튼의 "disabled" 클래스 제거
        button.removeAttribute("disabled"); // 버튼의 "disabled" 속성 제거
    } else {
        button.classList.add("disabled"); // 버튼에 "disabled" 클래스 추가
        button.setAttribute("disabled", "disabled"); // 버튼의 "disabled" 속성 추가
    }
}

// 전체 동의 체크박스의 변경 이벤트를 감지하여 처리하는 코드
document.querySelector('input[name="checkAll"]').addEventListener("change", handleCheckAllCheckbox);

// 필수 동의 체크박스의 변경 이벤트를 감지하여 처리하는 코드
var requiredCheckboxes = document.querySelectorAll('input[name="check"].check');
requiredCheckboxes.forEach(function (checkbox) {
    checkbox.addEventListener("change", handleRequiredCheckbox);
});