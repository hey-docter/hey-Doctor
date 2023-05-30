let check = 0;
const btn = document.querySelector('#btn');

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
		check++;
		message.innerHTML = "";
		checkCondition();
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
		check++;
		message2.innerHTML = "";
		checkCondition();
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
		check++;
		message3.innerHTML = "";
		checkCondition();
	}
}

var emailBoxboxInput = document.getElementById("emailBox");
emailBoxboxInput.addEventListener("blur", emailBoxInput);

const checkbox = document.querySelector('#checkbox');
const errorMessage = document.querySelector('#error-message');

function checkCondition(){
	if(check==3){
		btn.classList.remove("btn-disabled");
	}
}

btn.addEventListener('click', function() {
  if (!checkbox.checked) {
    errorMessage.style.display = 'block';
  } else {
    errorMessage.style.display = 'none';
  }
});

$("button.ok-button").on("click", function(){
	// const imgs = $("img.thumbnail").filter((i, img) => $(img).attr("src"));
	// let text = ``;
	// imgs.each((i, img) => {
	// 	let fullPath = $(img).attr("src");
	// 	let datas = fullPath.split("_");
	// 	let filePath = datas[0].split("=")[1].replace("/t", "");
	// 	let fileUuid = datas[1];
	// 	let fileName = datas[2];
	// 	let fileSize = sizes[i];
	//
	// 	text += `
    //         <input type="hidden" name="files[${i}].filePath" value="${filePath}">
    //         <input type="hidden" name="files[${i}].fileUuid" value="${fileUuid}">
    //         <input type="hidden" name="files[${i}].fileName" value="${fileName}">
    //         <input type="hidden" name="files[${i}].fileSize" value="${fileSize}">
    //     `
	// });
	// $(writeForm).append(text);
	if(errorMessage.style.display == 'none' && !$(this).hasClass("btn-disabled")){
		console.log(!$(this).hasClass("btn-disabled"));
		$('form.write-form').submit();
		alert("성공적으로 문의를 접수했습니다. 최대한 빠른 시일 내에 연락드리겠습니다.");
	}

});






