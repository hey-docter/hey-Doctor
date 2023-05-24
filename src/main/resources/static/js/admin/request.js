function numberInput() {
	var number = document.getElementById("number").value.trim();
	var message = document.getElementById("message");
	var input = document.getElementById("number");

	if (number == "") {
		message.innerHTML = "회원번호를 <br>입력해주세요.";
		message.style.color = 'red';
		message.style.fontSize = '0.8rem';
		input.classList.add("is-invalid");
		input.classList.remove("is-valid");
		return false;
	} else {
		input.classList.remove("is-invalid");
		input.classList.add("is-valid");
		message.innerHTML = "";
	}
}
var numberboxInput = document.getElementById("number");
numberboxInput.addEventListener("blur", numberInput);

function requestInput() {
	var request = document.getElementById("request").value.trim();
	var message2 = document.getElementById("message2");
	var input = document.getElementById("request");

	if (request == "") {
		message2.innerHTML = "답변을 <br>입력해주세요.";
		message2.style.color = 'red';
		message2.style.fontSize = '0.8rem';
		input.classList.add("is-invalid");
		input.classList.remove("is-valid");
		return false;
	} else {
		input.classList.remove("is-invalid");
		input.classList.add("is-valid");
		message2.innerHTML = "";
	}
}

var requestBoxInput = document.getElementById("request");
requestBoxInput.addEventListener("blur", requestInput);

