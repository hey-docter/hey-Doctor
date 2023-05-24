function emailBoxInput() {
	var emailBox = document.getElementById("emailBox").value.trim();
	var message3 = document.getElementById("message3");
	var input = document.getElementById("emailBox");

	if (emailBox == "") {
		message3.innerHTML = "이메일을 입력해주세요.";
		message3.style.color = 'red';
		message3.style.fontSize = '0.8rem';
		input.classList.add("is-invalid");
		input.classList.remove("is-valid");
		return false;
	} else {
		input.classList.remove("is-invalid");
		input.classList.add("is-valid");
		message3.innerHTML = "";
	}
}

var emailBoxboxInput = document.getElementById("emailBox");
emailBoxboxInput.addEventListener("blur", emailBoxInput);