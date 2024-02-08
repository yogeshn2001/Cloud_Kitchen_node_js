// scripts.js
document.addEventListener('DOMContentLoaded', function () {
    // Add your JavaScript code here for styling and animations
    // Example: Change background color on hover
    const buttons = document.querySelectorAll('.btn');
    buttons.forEach(button => {
        button.addEventListener('mouseover', function () {
            this.style.backgroundColor = '#17a2b8';
        });
        button.addEventListener('mouseout', function () {
            this.style.backgroundColor = '';
        });
    });
});


