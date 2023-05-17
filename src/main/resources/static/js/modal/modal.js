let modalCheck;
const $closeOCRBtn = $("div.modal-close-btn");

function showOCRModal(){
    modalCheck = false;
    $("div.warn-modal.ocr").css("animation", "popUp 0.5s");
    $("div.modal.ocr").css("display", "flex").hide().fadeIn(500);
    setTimeout(function(){modalCheck = true;}, 500);
}

$closeOCRBtn.on("click", function(){
    if(modalCheck){
        $("div.warn-modal.ocr").css("animation", "popDown 0.5s");
        $("div.modal.ocr").fadeOut(500);
    }
});