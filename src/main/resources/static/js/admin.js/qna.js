function titleBoxInput() {
	var titleBox = document.getElementById("titleBox").value.trim();
	var message = document.getElementById("message");
	var input = document.getElementById("titleBox");

	if (titleBox == "") {
		message.innerHTML = "제목을 입력해주세요.";
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

var titleBoxboxInput = document.getElementById("titleBox");
titleBoxboxInput.addEventListener("blur", titleBoxInput);

function contentBoxInput() {
	var contentBox = document.getElementById("contentBox").value.trim();
	var message2 = document.getElementById("message2");
	var input = document.getElementById("contentBox");

	if (contentBox == "") {
		message2.innerHTML = "질문하실 내용을 입력해주세요.";
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

var contentBoxboxInput = document.getElementById("contentBox");
contentBoxboxInput.addEventListener("blur", contentBoxInput);

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




const checkbox = document.querySelector('#checkbox');
const btn = document.querySelector('#btn');
const errorMessage = document.querySelector('#error-message');

btn.addEventListener('click', function() {
  if (!checkbox.checked) {
    errorMessage.style.display = 'block';
  } else {
    errorMessage.style.display = 'none';
  }
});







