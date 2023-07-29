window.addEventListener("scroll", function () {
    const navbar = document.getElementById("navbar");
    const scrollPosition = window.scrollY;
    const navbarHeight = navbar.offsetHeight;
    const headerHeight = 300;

    const opacity = Math.min(1, scrollPosition / (headerHeight - navbarHeight));
    if (scrollPosition > headerHeight) {
        navbar.classList.add("top-nav");
        navbar.classList.remove("navbar-interno_home")
    } else {
        navbar.classList.remove("top-nav");
        navbar.classList.add("navbar-interno_home")
    }
    navbar.style.backgroundColor = `rgba(0, 0, 0, ${opacity})`;
});


const { createApp } = Vue;

const app = createApp({
    data() {
        return {
        };
    },

    created() {
    },

    methods: {

    }
});

app.mount("#app");
