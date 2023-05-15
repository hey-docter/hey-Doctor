$(document).ready(function() {
    var modal = $('.modal');
    var modalContent = $('.modal_content');
    var button = $('.btn-modal');
    // 모달 보이기
    button.click(function() {
        modal.css('display', 'block');
    });
    // 모달 숨기기
    modalContent.click(function() {
        modal.css('display', 'none');
    });
});