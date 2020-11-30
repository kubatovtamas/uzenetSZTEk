var ball = document.getElementById('ball');
let whiteMode = localStorage.getItem('whiteMode');

const whiteModeToggle = document.querySelector('#toggle-white-mode');

const enableWhiteMode = () => {
    document.body.classList.add('white')
    localStorage.setItem('whiteMode', 'enabled');
};

const disableWhiteMode = () => {
    document.body.classList.remove('white')
    localStorage.setItem('whiteMode', null);
};

if (whiteMode === 'enabled') {
    enableWhiteMode();
}

whiteModeToggle.addEventListener('click', () => {
    whiteMode = localStorage.getItem('whiteMode')
    if (whiteMode !== 'enabled') {
        enableWhiteMode();
        console.log(whiteMode);
    } else {
        disableWhiteMode();
        console.log(whiteMode);
    }
});


function dropDown() {
    let dropping = document.getElementById('drop');
    let btn = document.getElementById("dropDown")
    if (dropping.style.display === "none") {
        dropping.style.display = "block";
    } else {
        dropping.style.display = "none";
    }
}

function autoGrow(element) {
    element.style.height = 10;
    element.style.height = (element.scrollHeight + "px");
}

function posting(x) {
    x.width = 400
    x.height = 400
}

function goBack() {
    window.history.back();
}
