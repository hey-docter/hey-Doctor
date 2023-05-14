window.addEventListener('DOMContentLoaded', function() {
    var modal = document.querySelector('.modal');
    var modalContent = document.querySelector('.modal_content');
    var button = document.querySelector('.btn-modal');

    button.addEventListener('click', function() {
        modal.style.display = 'block';
    });

    modalContent.addEventListener('click', function() {
        modal.style.display = 'none';
    });
});