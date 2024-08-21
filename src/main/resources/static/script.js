const wrapper = document.querySelector('.wrapper');
const signUpLink = document.querySelector('.signUp-link');
const signInLink = document.querySelector('.signIn-link');

const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[A-Za-z\d!@#$%^&*()_+]{8,}$/;

signUpLink.addEventListener('click', () => {
    wrapper.classList.add('animate-signIn');
    wrapper.classList.remove('animate-signUp');
});

signInLink.addEventListener('click', () => {
    wrapper.classList.add('animate-signUp');
    wrapper.classList.remove('animate-signIn');
});

document.querySelectorAll('form').forEach(form => {
    form.addEventListener('submit', (e) => {
        const passwordInput = form.querySelector('input[type="password"]');
        if (passwordInput) {
            const password = passwordInput.value;
            if (!passwordRegex.test(password)) {
                e.preventDefault();
                alert('Password must contain at least one capital letter, a number, a symbol, and be at least 8 characters long.');
            }
        }
    });
});
