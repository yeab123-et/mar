var navLinks = document.getElementById("navLinks");
var menuIcon = document.getElementById("menu-icon");
var closeIcon = document.getElementById("close-icon");


function showMenu() {
    var navLinks = document.getElementById("navLinks");
    var menuIcon = document.getElementById("menu-icon");

    if (navLinks) {
        navLinks.style.right = "0";
    }
    if (menuIcon) {
        // Hide the hamburger icon when the menu is open
        menuIcon.style.display = "none";
    }
}

function hideMenu() {
    var navLinks = document.getElementById("navLinks");
    var menuIcon = document.getElementById("menu-icon");

    if (navLinks) {
        // Move the menu off-screen to close it
        navLinks.style.right = "-200px"; 
    }
    if (menuIcon) {
        // Show the hamburger icon again
        menuIcon.style.display = "block"; 
    }
}