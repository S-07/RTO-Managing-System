 let heroBg = document.querySelector('.hero');
        setInterval(() => {
            heroBg.style.backgroundImage = "url(Images/bg-light.png)"
            
            setTimeout(() => {
                heroBg.style.backgroundImage = "url(Images/bg.png)"
            }, 1000);
        }, 2200);